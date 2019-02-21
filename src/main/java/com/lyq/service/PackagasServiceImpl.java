package com.lyq.service;

import com.lyq.mapper.PackagasMapper;
import com.lyq.model.Packages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackagasServiceImpl implements  PackagasService {


    @Autowired
    private PackagasMapper packagasMapper;


    @Override
    public List<Packages> queryPackages() {

        return packagasMapper.queryPackages();
    }
}
