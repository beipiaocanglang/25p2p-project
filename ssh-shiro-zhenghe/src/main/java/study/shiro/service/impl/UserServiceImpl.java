package study.shiro.service.impl;

import org.springframework.stereotype.Service;
import study.shiro.dao.IUserDao;
import study.shiro.domain.Permission;
import study.shiro.domain.Role;
import study.shiro.domain.User;
import study.shiro.service.IUserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * author: canglang
 * create time: 2018/3/18 16:44
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    /**
     * 认证操作时根据 用户名和密码查询用户表数据
     * author: canglang
     * create time: 2018/3/25 12:57
     */
    public User login(String username, String password) {
        return userDao.findUserByUsernameAndPassword(username,password);
    }

    /**
     * 授权操作时 - 根据用户信查询对应的角色表数据
     * author: canglang
     * create time: 2018/3/25 12:49
     */
    public List<Role> findRoleByUser(User user) {
        return userDao.findRoleByUser(user);
    }

    /**
     * 授权操作时 - 根据角色查询角色对应的权限表数据
     * author: canglang
     * create time: 2018/3/25 12:55
     */
    public List<Permission> findPermissionByRole(Role role) {
        return userDao.findPermissionByRole(role);
    }
}
