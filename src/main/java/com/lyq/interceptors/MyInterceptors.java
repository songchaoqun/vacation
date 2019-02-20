package com.lyq.interceptors;


import com.lyq.model.Staff;
import com.lyq.model.Way;
import com.lyq.service.WayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Component
public class MyInterceptors implements HandlerInterceptor {
    @Autowired
    private WayService wayService;
    //这个方法是在访问接口之前执行的，我们只需要在这里写验证登陆状态的业务逻辑，就可以在用户调用指定接口之前验证登陆状态了
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        //这里的User是登陆时放入session的
        Staff user = (Staff) session.getAttribute("staff");
        List<Way> urlList= new ArrayList<>();
        urlList= wayService.queryWayList(user.getId());
        //获取当前请求的路径
         String requestUrl= request.getRequestURI();
             for (Way  string:urlList){
                 if(requestUrl.contains(string.getUrl())){
                     return true;
                 }

         }
        //转发到登录请求
        request.getRequestDispatcher("/nopower.jsp").forward(request, response);
        return false;

    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }

}
