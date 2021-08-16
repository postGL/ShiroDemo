package com.zbs.dao;

import com.zbs.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * description: UserInfoDao
 * date: 2021/8/5 14:15
 * author: zhangbs
 * version: 1.0
 */
public interface UserInfoDao extends JpaRepository<UserInfo, Long> {
    /** 通过username查找用户信息*/
    public UserInfo findByUsername(String username);
}
