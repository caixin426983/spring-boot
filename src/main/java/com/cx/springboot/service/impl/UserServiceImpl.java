package com.cx.springboot.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cx.springboot.entity.TUser;
import com.cx.springboot.mapper.IUserMapper;
import com.cx.springboot.service.IUserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<IUserMapper, TUser> implements IUserService {

    @Autowired
    private StringRedisTemplate template;
    @Autowired
    private RedisTemplate redisTemplate;

    private final String BIG_USER_REDIS_KEY = "CM:CHANNELCUSTOMER";

    @Override
//    @Cacheable(value = "test", key = "#page")
    public List<TUser> getAllUser(String page) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("allUser", this.baseMapper.selectList(null));
        try {
            redisTemplate.opsForHash().putAll(BIG_USER_REDIS_KEY, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        simulateSlowService();
        return this.baseMapper.selectList(null);
    }





    @Override
    @Cacheable(value = "test", key = "#id")
    public TUser getUserById(Long id) {
        return this.baseMapper.selectById(id);
    }

    @Override
    public List<TUser> page(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return this.baseMapper.selectList(null);
    }

    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
