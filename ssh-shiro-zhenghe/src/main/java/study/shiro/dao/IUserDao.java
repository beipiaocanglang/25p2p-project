package study.shiro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import study.shiro.domain.User;

/**
 * author: canglang
 * create time: 2018/3/18 16:41
 */
public interface IUserDao extends JpaRepository<User,Integer>{
    User findUserByUsernameAndPassword(String username, String password);
}
