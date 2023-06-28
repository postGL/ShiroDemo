package com.zbs.service;

import com.zbs.entity.UserInfo;

/**
 * description: UserInfoService
 * date: 2021/8/5 14:17
 * author: zhangbs
 * version: 1.0
 */
public interface UserInfoService {
    /** 通过username查找用户信息；*/
    public UserInfo findByUsername(String username);
}
