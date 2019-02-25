package com.lyq.service;

import com.lyq.mapper.TreeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.annotation.Resource;
import java.util.TreeMap;

@Service
public class ProductServiceImpl implements  ProductService {
     @Resource
     private TreeMapper treeMapper;
    @Override
    public String say() {
        return treeMapper.queryTreeList(-1).toString();
    }
}
