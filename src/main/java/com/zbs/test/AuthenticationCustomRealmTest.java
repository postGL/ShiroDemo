package com.zbs.test;

import com.zbs.test.beans.CustomRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * description: AuthenticationCustomRalmTest
 * date: 2021/8/5 11:33
 * author: zhangbs
 * version: 1.0
 */
public class AuthenticationCustomRealmTest {

    @Test
    public void testAuthentication() {

        // 实现自己的 Realm 实例
        CustomRealm myRealm = new CustomRealm();

        // 1.构建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(myRealm);

        // 2.主体提交认证请求
        // 设置SecurityManager环境
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        // 获取当前主体
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("wmyskxz", "123456");
        // 登录
        subject.login(token);

        // subject.isAuthenticated()方法返回一个boolean值,用于判断用户是否认证成功
        System.out.println("isAuthenticated:" + subject.isAuthenticated()); // 输出true
        // 判断subject是否具有admin和user两个角色权限,如没有则会报错
        subject.checkRoles("admin", "user");
        //  subject.checkRole("xxx"); // 报错
        // 判断subject是否具有user:add权限
        subject.checkPermission("user:add");
    }

}
