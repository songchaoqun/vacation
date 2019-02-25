package com.lyq.controller;

import com.lyq.model.MemPacka;
import com.lyq.model.Members;
import com.lyq.model.Staff;
import com.lyq.service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("members")
public class MembersController {

   @Autowired
    private MembersService membersService;


    @RequestMapping("queryMemners")
    @ResponseBody
    public HashMap<String,Object> queryMemners(Integer  page , Integer rows){

     return   membersService.queryMemners(page,rows);
    }

    @RequestMapping("queryMem")
    @ResponseBody
    public List<Members> queryMem(){

     return   membersService.queryMem();
    }

    @RequestMapping("queryBymId")
    @ResponseBody
    public Members queryBymId(Integer membersId){
     System.out.println(membersId);
     return   membersService.queryBymId(membersId);
    }

    @RequestMapping("saveMem")
    @ResponseBody
    public String saveMem(HttpSession session, MemPacka me){
     return membersService.saveMem(me,session);
    }

    @RequestMapping("upMem")
    @ResponseBody
    public void upMem(HttpSession session, MemPacka me){
      membersService.upMem(me,session);
    }

}
