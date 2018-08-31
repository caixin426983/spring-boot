package com.cx.modules.admin.user.service;

import com.baomidou.mybatisplus.service.IService;
import com.cx.modules.admin.user.entity.TUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface IUserService extends IService<TUser> {



}
