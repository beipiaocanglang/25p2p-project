package com.study.p2p.shirotest.myrealm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * author: canglang
 * create time: 2018/3/11 11:29
 */
public class CustomRealm implements Realm{
    @Override
    public String getName() {
        //配置文件中包对应的名字
        return "customRealm";
    }

    @Override
    //指定token的类型是UsernamePasswordToken
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户名
        Object principal = token.getPrincipal();
        //获取密码
        char[] credentials = (char[])token.getCredentials();

        //模拟认证  实际是调用service dao 数据库
        if ("tom".equals(principal) && "456".equals(new String(credentials))) {
            //响应
            return new SimpleAuthenticationInfo(principal,credentials,getName());
        }
        return null;
    }
}
