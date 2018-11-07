package com.cx.springboot.service.impl;

import com.cx.springboot.service.IDemoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DemoServiceImpl implements IDemoService {


    @Override
    public String testCache(String key) {
        System.out.println("testCache" + key);
        return key;
    }
}
