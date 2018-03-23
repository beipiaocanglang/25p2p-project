package study.shiro.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 角色表
 * author: canglang
 * create time: 2018/3/18 15:02
 */
@Entity
@Table(name = "t_roel")
public class Role {
    @Id
    @GeneratedValue
    private Integer id;
    private String roleName;//角色名称

    /**
     * 角色与用户多对多对应关系，有角色维护(不一定创建一个用户就要给权限 所以有角色维护)
     * @JoinTable 表关系映射
     * name：对应的中间表名称
     * joinColumns：描述本方在中间表中的对应关系
     *      name：本方在中间表中对应的映射字段
     *      referencedColumnName：本方的哪个字段与关联表中的name对应的字段对应映射
     *
     * inverseJoinColumns：描述对方再中间表中的对应关系
     *      name：对方在中间表中对应的映射字段
     *      referencedColumnName：对方的哪个字段与关联表中的name对应的字段对应映射
     */
    @ManyToMany
    @JoinTable(name = "u_r",joinColumns = {@JoinColumn(name = "r_id",referencedColumnName = "id")},inverseJoinColumns = {@JoinColumn(name = "u_id",referencedColumnName = "id")} )
    private Set<User> users = new HashSet<User>();

    /**
     * 角色与权限对应关系映射
     * mappedBy = "roles" 表示 关系有对方维护
     */
    @ManyToMany(mappedBy = "roles")
    private Set<Permission> ps = new HashSet<Permission>();

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public Set<User> getUsers() {
        return users;
    }
    public void setUsers(Set<User> users) {
        this.users = users;
    }
    public Set<Permission> getPs() {
        return ps;
    }
    public void setPs(Set<Permission> ps) {
        this.ps = ps;
    }
}
