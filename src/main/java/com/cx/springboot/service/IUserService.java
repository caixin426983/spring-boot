package com.cx.springboot.service;

import com.baomidou.mybatisplus.service.IService;
import com.cx.springboot.entity.TUser;

import java.util.List;

public interface IUserService extends IService<TUser> {


    List<TUser> getAllUser();

    TUser getUserById(Long id);

    List<TUser> page(Integer pageNum,Integer pageSize);
}
