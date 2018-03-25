package study.shiro.utils;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import study.shiro.domain.Permission;
import study.shiro.domain.Role;
import study.shiro.domain.User;
import study.shiro.service.IUserService;

import javax.annotation.Resource;
import java.util.List;

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
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
        SimpleAuthorizationInfo aif = new SimpleAuthorizationInfo();
        //study.shiro.domain.User@2df338b8
        //这里获取的就是 在下面认证方法中存到session中的用户信息
        User user = (User) pc.getPrimaryPrincipal();
        if (user != null){
            List<Role> roles = userService.findRoleByUser(user);
            if (roles!= null) {
                for (Role role : roles) {
                    aif.addRole(role.getRoleName());
                    List<Permission> permissions= userService.findPermissionByRole(role);
                    if (permissions != null) {
                        for (Permission permission : permissions) {
                            System.out.println(user.getUsername()+"用户具有"+role.getRoleName()+"角色,具有"+ permission.getPermissionName()+"权限");
                            aif.addStringPermission(permission.getPermissionName());
                        }
                    }
                }
            }
            return aif;
        }
        return null;
    }

    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        User user  = userService.login(username,password);

        if (user != null){
            //第一个参数就是在这一步登录后存到session中的用户信息
            return new SimpleAuthenticationInfo(user, user.getPassword(),this.getName());
        }

        return null;
    }
}
