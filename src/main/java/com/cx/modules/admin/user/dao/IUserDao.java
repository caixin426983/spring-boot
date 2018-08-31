package com.cx.modules.admin.user.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import com.cx.modules.admin.user.entity.TUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface IUserDao extends BaseMapper<TUser> {

}
