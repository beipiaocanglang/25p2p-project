package com.study.p2p.shirotest.shirotest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * 认证
 * 主要演示subject与securityManager使用
 * author: canglang
 * create time: 2018/3/11 11:24
 */
public class ShiroTest1 {
    public static void main(String[] args) {
        // 创建一个SecurityManager工厂，此处使用的是ini配置文件初始化SecurityManager
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro-test1.ini");
        // 通过工厂获取一个SecurityManager
        SecurityManager instance = factory.getInstance();
        // 绑定给SecurityUtils
        SecurityUtils.setSecurityManager(instance);
        // 获取一个Subject
        Subject subject = SecurityUtils.getSubject();
        // 创建用户名密码验证的token
        UsernamePasswordToken upt = new UsernamePasswordToken("tom", "456");
        try {
            // 登录
            subject.login(upt);//调用默认的realms
            System.out.println("身份验证成功");
        } catch (AuthenticationException e) {
            System.out.println(e);
            System.out.println("身份验证失败");
        }
        // 退出
        subject.logout();
    }
}
