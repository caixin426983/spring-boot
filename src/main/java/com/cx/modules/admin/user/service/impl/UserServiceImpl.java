package com.cx.modules.admin.user.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cx.modules.admin.user.dao.IUserDao;
import com.cx.modules.admin.user.entity.TUser;
import com.cx.modules.admin.user.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<IUserDao, TUser> implements IUserService {





}
