package study.shiro.service;

import study.shiro.domain.User;

/**
 * author: canglang
 * create time: 2018/3/18 16:41
 */
public interface IUserService {
    User login(String username, String password);
}
