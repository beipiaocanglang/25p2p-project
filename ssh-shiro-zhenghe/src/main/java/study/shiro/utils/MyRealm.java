package study.shiro.utils;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import study.shiro.domain.User;
import study.shiro.service.IUserService;

import javax.annotation.Resource;

/**
 * 测试的时候 implements Realm 但是实现接口中的方法太多 且没有用
 * 所以 继承 Realm 的子类 extends AuthorizingRealm
 * 正好有需要的两个方法
 *
 * author: canglang
 * create time: 2018/3/18 14:19
 */
public class MyRealm extends AuthorizingRealm{

    @Resource
    private IUserService userService;

    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        User user  = userService.login(username,password);

        if (user != null){
            return new SimpleAuthenticationInfo(user, user.getPassword(),this.getName());
        }

        return null;
    }
}
