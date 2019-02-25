package com.lyq.service;

import com.lyq.model.MemPacka;
import com.lyq.model.Members;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

public interface MembersService {

    HashMap<String,Object> queryMemners(Integer page, Integer rows);

    List<Members> queryMem();

    String saveMem(MemPacka me, HttpSession session);

    Members queryBymId(Integer membersId);

    void upMem(MemPacka me, HttpSession session);
}
