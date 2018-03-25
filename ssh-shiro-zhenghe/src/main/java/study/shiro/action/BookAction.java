package study.shiro.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.shiro.authz.annotation.*;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.stereotype.Controller;
import study.shiro.service.IBookService;

import javax.annotation.Resource;

/**
 * 细粒度权限(可以精确到action、service 或 某一个方法 和 属性)
 * 细粒度权限使用注解的方式来完成
 * 要想使用shiro的注解需要再spring整合shiro的配置文件中开启注解的使用 在applicationContext-shiro.xml
 * shiro中常用注解
 *      @RequiresRoles
 *          访问对应方法时 判断用户是否有此角色
 *          例如：@RequiresRoles("admin") 当用户有admin角色时才可以访问此方法 如果用户没有此角色 会抛出异常 AuthorizationException
 *      @RequiresPermissions
 *          访问对应方法时 判断用户是否有此
 *          例如：@RequiresPermissions("delete") 当用户有delete权限时才可以访问此方法 如果用户没有此权限 会抛出异常 AuthorizationException
 *      @RequiresAuthentication
 *          验证用户是否登录 等同于 subject.isAuthenticated() 结果为true时
 *      @RequiresUser
 *          验证用户是否被记忆，user有两种含义：
 *              一种是成功登录的(subject.isAuthenticated() 结果为true时)
 *              一种是被记忆的(subject.isRemembered() 结果为true时)
 *      @RequiresGuest
 *          验证是否是一个guest请求 与 RequiresUser相反  换言之 RequiresUser != RequiresGuest 此时 subject.getPrincipal() == null
 * author: canglang
 * create time: 2018/3/25 11:20
 */
@Controller
@Namespace("/book")
public class BookAction extends ActionSupport {

    @Resource
    private IBookService bookService;

    @RequiresRoles("admin")
    //注意 此处路径上不能加 /
    @Action("update")
    public void update(){
        System.out.println("执行了action 的 update方法。。。。。。");
        bookService.update();
    }

    @RequiresPermissions("delete")
    @Action("delete")
    public void delete(){
        System.out.println("执行了action 的 delete方法。。。。。。");
        bookService.delete();
    }

    @RequiresRoles("admin")
    @Action("add")
    public void add(){
        System.out.println("执行了action 的 add方法。。。。。。");
        bookService.add();
    }

    @RequiresPermissions("find")
    @Action("find")
    public void find(){
        System.out.println("执行了action 的 find方法。。。。。。");
        bookService.find();
    }
}
