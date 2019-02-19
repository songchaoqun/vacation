package com.lyq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
@RequestMapping("/testController")
public class UploadImage {

    //读取本地图片并显示
    @RequestMapping("/displayImg")
    @ResponseBody
    public void doPost(HttpServletRequest request, HttpServletResponse response,String img)
            throws ServletException, IOException {
        //读取本地图片输入流
        FileInputStream inputStream = new FileInputStream("D:/picture/" + img);
        int i = inputStream.available();
        //byte数组用于存放图片字节数据
        byte[] buff = new byte[i];
        inputStream.read(buff);
        //记得关闭输入流
        inputStream.close();
        //设置发送到客户端的响应内容类型
        response.setContentType("image/*");
        OutputStream out = response.getOutputStream();
        out.write(buff);
        //关闭响应输出流
        out.close();
    }

    @RequestMapping("/uploadImg")
    @ResponseBody
    public String uploadImg(MultipartFile file[]) throws Exception {
//        System.out.println("得到的areaName:"+areaName);
        // 设置上传的路径是D盘下的picture
        String imgPath = "D:/picture/";
        //用来将路径写到数据库
        String imgDb = "";
        for (MultipartFile f : file) {
            // 图片的名字用毫秒数+图片原来的名字拼接
//            System.out.println(f.getSize());
//            System.out.println(f.getBytes());
            String imgName = System.currentTimeMillis() + f.getOriginalFilename();
            imgDb += imgDb == ""?imgName:","+imgName;
            //上传文件
            uploadFileUtil(f.getBytes(), imgPath, imgName);
        }
        return imgDb;
    }
    /**
    * 上传文件的方法
    * @param file：文件的字节
    * @param imgPath：文件的路径
    * @param imgName：文件的名字
    * @throws Exception
    */
    public void uploadFileUtil(byte[] file, String imgPath, String imgName) throws Exception {
        File targetFile = new File(imgPath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(imgPath + imgName);
        out.write(file);
        out.flush();
        out.close();
    }
}