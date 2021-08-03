package com.zbs;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

/**
 * description: Test
 * date: 2021/8/3 10:19
 * author: zhangbs
 * version: 1.0
 */
public class AuthenticationRoleTest {

    SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

    /**
     * 在方法开始前添加一个用户,让它具备admin和user两个角色
     */
    @Before
    public void addUser() {
        simpleAccountRealm.addAccount("admin", "123456", "admin", "user");
    }

    @Test
    public void testAuthentication() {
        // 1.构建SecurityManager环境
        DefaultSecurityManager securityManager = new DefaultSecurityManager(simpleAccountRealm);

        // 2.主体提交认证请求
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("admin", "123456");
        // 登陆
        subject.login(token);
        subject.checkRoles("admin", "user");

        // subject.isAuthenticated()方法返回一个boolean值,用于判断用户是否认证成功
        System.out.println(subject.isAuthenticated());
        subject.logout();
        System.out.println(subject.isAuthenticated());
        // 判断subject是否具有admin和user两个角色权限,如没有则会报错
        subject.checkRoles("admin", "user");

    }

}
