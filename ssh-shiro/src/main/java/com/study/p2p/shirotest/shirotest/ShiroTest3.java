package com.study.p2p.shirotest.shirotest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * 认证
 * 主要演示shiro为我们提供的realn-----jdbcrealm
 * 默认访问的表是users
 * author: canglang
 * create time: 2018/3/11 11:33
 */
public class ShiroTest3 {
    public static void main(String[] args) {
        // 创建一个SecurityManager工厂，此处使用的是ini配置文件初始化SecurityManager
        //shiro框架默认访问的是对应数据库中的users表，可以查看JdbcRealm类中的源代码 再配置文件中配置的
        //protected static final String DEFAULT_AUTHENTICATION_QUERY = "select password from users where username = ?";
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro-jdbc-realm-test3.ini");
        // 通过工厂获取一个SecurityManager
        SecurityManager instance = factory.getInstance();
        // 绑定给SecurityUtils
        SecurityUtils.setSecurityManager(instance);
        // 获取一个Subject
        Subject subject = SecurityUtils.getSubject();
        // 创建用户名密码验证的token
        UsernamePasswordToken upt = new UsernamePasswordToken("tom", "123");
        try {
            // 登录
            subject.login(upt);//调用自定义的realms
            System.out.println("身份验证成功");
        } catch (AuthenticationException e) {
            System.out.println(e);
            System.out.println("身份验证失败");
        }
        // 退出
        subject.logout();
    }
}
