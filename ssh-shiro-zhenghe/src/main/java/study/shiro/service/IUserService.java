package study.shiro.service;

import study.shiro.domain.Permission;
import study.shiro.domain.Role;
import study.shiro.domain.User;

import java.util.List;

/**
 * author: canglang
 * create time: 2018/3/18 16:41
 */
public interface IUserService {
    /**
     * 认证操作时根据 用户名和密码查询用户表数据
     * author: canglang
     * create time: 2018/3/25 12:57
     */
    User login(String username, String password);

    /**
     * 授权操作时 - 根据用户信查询对应的角色表数据
     * author: canglang
     * create time: 2018/3/25 12:49
     */
    List<Role> findRoleByUser(User user);

    /**
     * 授权操作时 - 根据角色查询角色对应的权限表数据
     * author: canglang
     * create time: 2018/3/25 12:55
     */
    List<Permission> findPermissionByRole(Role role);
}
