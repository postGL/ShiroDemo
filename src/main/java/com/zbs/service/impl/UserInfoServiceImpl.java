package com.zbs.service.impl;

import com.zbs.dao.UserInfoDao;
import com.zbs.entity.UserInfo;
import com.zbs.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * description: UserInfoServiceImpl
 * date: 2021/8/5 14:17
 * author: zhangbs
 * version: 1.0
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    UserInfoDao userInfoDao;

    @Override
    public UserInfo findByUsername(String username) {
        return userInfoDao.findByUsername(username);
    }
}
