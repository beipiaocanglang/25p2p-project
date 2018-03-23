package study.shiro.service.impl;

import org.springframework.stereotype.Service;
import study.shiro.dao.IUserDao;
import study.shiro.domain.User;
import study.shiro.service.IUserService;

import javax.annotation.Resource;

/**
 * author: canglang
 * create time: 2018/3/18 16:44
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    public User login(String username, String password) {
        return userDao.findUserByUsernameAndPassword(username,password);
    }
}
