package study.shiro.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 权限表
 * author: canglang
 * create time: 2018/3/18 15:06
 */
@Entity
@Table(name = "t_permission")
public class Permission {

    @Id
    @GeneratedValue
    private Integer id;
    private String permissionName;//权限名称

    /**
     * 权限与角色多对多对应关系，由权限维护(创建一个角色不一定要给权限 所以由权限维护)
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
    @JoinTable(name = "r_p",joinColumns = {@JoinColumn(name = "p_id",referencedColumnName = "id")},inverseJoinColumns = {@JoinColumn(name = "r_id",referencedColumnName = "id")} )
    private Set<Role> roles = new HashSet<Role>();

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getPermissionName() {
        return permissionName;
    }
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }
    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
