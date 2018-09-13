package com.cx.springboot.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cx.springboot.entity.TUser;
import com.cx.springboot.mapper.IUserMapper;
import com.cx.springboot.service.IUserService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<IUserMapper, TUser> implements IUserService {



    @Override
    public List<TUser> getAllUser() {
        return this.baseMapper.selectList(null);
    }

    @Override
    public TUser getUserById(Long id) {
        return this.baseMapper.selectById(id);
    }

    @Override
    public List<TUser> page(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return this.baseMapper.selectList(null);
    }
}
