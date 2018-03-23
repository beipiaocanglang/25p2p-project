package com.study.p2p.shirotest.shirotest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * 授权
 *
 * [users]
 * 有一个用户 其权限是role1
 * tom=123,role1
 * [roles]
 * 以下是两个权限分别对应着不同的操作
 * role1=admin:add,admin:update,admin:delete,admin:select
 * roles=user:select
 *
 * author: canglang
 * create time: 2018/3/11 11:33
 */
public class ShiroTest4 {
    public static void main(String[] args) {
        // 创建一个SecurityManager工厂，此处使用的是ini配置文件初始化SecurityManager
        //shiro框架默认访问的是对应数据库中的users表，可以查看JdbcRealm类中的源代码 再配置文件中配置的
        //protected static final String DEFAULT_AUTHENTICATION_QUERY = "select password from users where username = ?";
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro-role-test4.ini");
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

            //是否认证
            boolean authenticated = subject.isAuthenticated();
            System.out.println(authenticated);

            //判断当前用户是否有 相应的角色
            boolean role1 = subject.hasRole("role1");
            System.out.println(role1);

            //判断当前用户是否有 所有的 相应的 角色
            ArrayList<String> strings = new ArrayList<>();
            strings.add("role1");//true
            //strings.add("role2");//false
            boolean b = subject.hasAllRoles(strings);
            System.out.println(b);

            //判断当前用户的角色是否有相应的权限
            boolean permitted = subject.isPermitted("admin:add");
            System.out.println(permitted);

            //判断当前用户的角色是否有相应的所有权限
            boolean permittedAll = subject.isPermittedAll("admin:add,admin:update,admin:delete");//false
            System.out.println(permittedAll);

        } catch (AuthenticationException e) {
            System.out.println(e);
            System.out.println("身份验证失败");
        }
        // 退出
        subject.logout();
    }
}
