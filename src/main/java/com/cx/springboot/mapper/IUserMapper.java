package com.cx.springboot.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import com.cx.springboot.entity.TUser;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserMapper extends BaseMapper<TUser> {

}
