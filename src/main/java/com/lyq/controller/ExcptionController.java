package com.lyq.controller;

import com.lyq.model.ExcptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//异常控制层
@Controller
@RequestMapping("excption")
public class ExcptionController {

    @Autowired
    private MongoTemplate mongoTemplate;

    //查询所有异常
    @ResponseBody
    @RequestMapping("queryExcption")
    public Map<String , Object> queryExcption(Integer page, Integer rows){
        Map<String, Object> logMap = new HashMap<String, Object>();
        Query query = new Query();
        query.skip((page - 1) * rows);
        query.limit(rows);
        List<ExcptionHandler> find = mongoTemplate.find(query, ExcptionHandler.class);
        long count = mongoTemplate.count(query, ExcptionHandler.class);
        logMap.put("total", count);
        logMap.put("rows", find);
        return logMap;
    }

    //删除日志
    @ResponseBody
    @RequestMapping("deleteExcptionById")
    public void deleteExcptionById(ExcptionHandler ec) {
        String[] split = ec.getId().split(",");
        for (int i=0;i<split.length;i++){
            Query query = Query.query(Criteria.where("id").in(split[i]));
            mongoTemplate.remove(query,ExcptionHandler.class);
        }
    }
}
