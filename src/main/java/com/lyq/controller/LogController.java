package com.lyq.controller;

import com.lyq.model.Log;
import com.lyq.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//日志控制层
@Controller
@RequestMapping("log")
public class LogController {

    @Autowired
    private MongoTemplate mongoTemplate;

    //查询所有日志
    @ResponseBody
    @RequestMapping("queryLog")
    public Map<String , Object> queryLog(Integer page, Integer rows, HttpSession session){
        Staff staff = (Staff)session.getAttribute("staff");
        Map<String, Object> logMap = new HashMap<String, Object>();
        Query query = new Query();
        if(staff.getId() != null) {
            query.addCriteria(Criteria.where("userId").is(staff.getId()));
        }
        query.skip((page - 1) * rows);
        query.limit(rows);
        List<Log> find = mongoTemplate.find(query, Log.class);
        long count = mongoTemplate.count(query, Log.class);
        logMap.put("total", count);
        logMap.put("rows", find);
        return logMap;
    }

    //删除日志
    @ResponseBody
    @RequestMapping("deleteLogById")
    public void deleteLogById(Log log) {
        String[] split = log.getId().split(",");
        for (int i=0;i<split.length;i++){
            Query query = Query.query(Criteria.where("id").in(split[i]));
            mongoTemplate.remove(query,Log.class);
        }
    }
}
