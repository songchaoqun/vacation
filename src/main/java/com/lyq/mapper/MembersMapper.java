package com.lyq.mapper;

import com.lyq.model.MemPacka;
import com.lyq.model.Members;
import com.lyq.model.SitesUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MembersMapper {
    //查询总条数
    Long queryMemners();
   //查询
    List<Members> queryMemnersPage(@Param("start") int start,@Param("rows") Integer rows);

    List<Members> queryMem();

    void saveMem(@Param("me") MemPacka me);

    MemPacka queryMemPackByuid(@Param("uid")Integer uid);

    Members queryBymId(Integer membersId);

   // SitesUser queryRoleId(@Param("id") Integer id);

    void upMem(@Param("me")MemPacka me);
}
