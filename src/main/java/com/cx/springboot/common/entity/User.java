package com.cx.springboot.common.entity;

import java.security.Principal;

/**
 * @Description TODO
 * @Author cx
 * @Date 2018/9/11 16:11
 **/
public class User implements Principal {

    private final String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
