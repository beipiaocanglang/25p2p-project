package study.shiro.domain;

import javax.naming.Name;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户表
 * author: canglang
 * create time: 2018/3/18 14:54
 */
@Entity
@Table(name = "t_users")
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String password;

    /**
     * 用户与角色多对多对应关系
     * mappedBy = "users" ：表示 关系有对方维护
     */
    @ManyToMany(mappedBy = "users")
    private Set<Role> roles = new HashSet<Role>();

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
