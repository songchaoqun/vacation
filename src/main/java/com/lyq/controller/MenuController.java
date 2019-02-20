package com.lyq.controller;

import com.lyq.utils.RandomValidateCodeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//跳转路径
@Controller
@RequestMapping("menu")
public class MenuController {

    //验证码错误时显示
    private final static Logger LOGGER = LoggerFactory.getLogger(RandomValidateCodeUtil.class);

    //跳转到报表 柱
    @RequestMapping("pillar")
    public String pillar(){
        return "reports/pillar";
    }

    //跳转到报表 饼
    @RequestMapping("reportsCake")
    public String reportsCake(){
        return "reports/reportsCake";
    }

    //跳转到报表 折
    @RequestMapping("reportsPillar")
    public String reportsPillar(){
        return "reports/reportsPillar";
    }
    //跳转到报表 环
    @RequestMapping("circle")
    public String circle(){
        return "reports/circle";
    }

    //跳转到轮播图
    @RequestMapping("imgList")
    public String imgList(){
        return "img/imgList";
    }

    //跳转到答案页面
    @RequestMapping("answerList")
    public String answerList(Integer id, Model model){
        model.addAttribute("problem",id);
        return "answer/answerList";
    }

    //跳转到问题页面
    @RequestMapping("problemList")
    public String problemList(){
        return "problem/problemList";
    }

    //跳转到评论页面
    @RequestMapping("commentList")
    public String commentList(){
        return "comment/commentList";
    }

    //跳转到用户回收站
    @RequestMapping("recycle")
    public String recycle(){
        return "sitesUser/recycle";
    }

    //跳转到网站用户管理页面
    @RequestMapping("sitesUserList")
    public String sitesUserList(){
        return "sitesUser/sitesUserList";
    }

    //跳转到目录管理页面
    @RequestMapping("catalogList")
    public String catalogList(){
        return "catalog/catalogList";
    }

    //跳转到课程管理页面
    @RequestMapping("courseList")
    public String courseList(){
        return "course/courseList";
    }

    //跳转到类型管理页面
    @RequestMapping("moldList")
    public String moldList(){
        return "mold/moldList";
    }

    //跳转到main页面
    @RequestMapping("main")
    public String main(){
        return "main";
    }

    //跳转到staffList员工页面
    @RequestMapping("staffList")
    public String staffList(){
        return "staff/staffList";
    }

    //跳转到员工角色页面
    @RequestMapping("staffRoleList")
    public String staffRoleList(){
        return "role/staffRoleList";
    }

    /**
     * 前台获取验证码
     * 生成验证码
     */
    @RequestMapping("verificationCode")
    public void getVerify(HttpServletRequest request, HttpServletResponse response){
        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
            randomValidateCode.getRandcode(request, response);//输出验证码图片方法
        } catch (Exception e) {
            LOGGER.error("获取验证码失败");
            e.printStackTrace();
        }
    }

}
