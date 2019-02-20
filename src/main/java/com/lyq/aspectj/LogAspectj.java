package com.lyq.aspectj;

import com.lyq.model.Log;
import com.lyq.model.Staff;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Component
@Aspect //	在切面类（为切点服务的类）前用@Aspect注释修饰，声明为一个切面类。
public class LogAspectj {

    @Autowired
    private MongoTemplate mongoTemplate;

    //定义切点"execution(* com.jk.lyq.service.*..*Impl.*(..))"
    @Pointcut("execution(* com.lyq.service..*Impl.*(..))")
    public void logPointCut(){}

    //请求正常返回后通知
    @AfterReturning(value="logPointCut()", returning="rtv")
    public void saveLogAdvice(JoinPoint joinPoint, Object rtv){
        Object[] args = joinPoint.getArgs();
        if(args == null){
            return;
        }
        Log log = new Log();
        // 设置当前时间
        log.setCreateTime(new Date());

        // 获取类文件名称
        String claname = joinPoint.getTarget().getClass().getSimpleName();
        log.setClassName(claname);

        //获取方法名
        String name = joinPoint.getSignature().getName();
        log.setMethod(name);

        // 获取参数，并拼接
        StringBuffer sb = new StringBuffer();
        sb.append("参数{");
        for (Object param : args) {
            sb.append(param + ", ");
        }
        sb.append("}");
        log.setReqParam(sb.toString());

        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        if(sra != null){
            // 获取request对象
            HttpServletRequest request = sra.getRequest();
            HttpSession session = request.getSession();
            Staff staff = (Staff)session.getAttribute("staff");
            if(staff != null) {
                // 设置用户id
                log.setUserId(staff.getId());
                // 设置用户名
                log.setUserName(staff.getStaffName());
                //设置请求的地址
                log.setUrl(request.getRequestURL().toString());

                log.setIp(getIp(request));
                //将log日志对象保存到MongoDB数据库中
                mongoTemplate.save(log);
            }
        }
    }

    //获取客户端ip
    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if(!StringUtils.isEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if(index != -1){
                return ip.substring(0,index);
            }else{
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if(!StringUtils.isEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            return ip;
        }
        return request.getRemoteAddr();
    }
}
