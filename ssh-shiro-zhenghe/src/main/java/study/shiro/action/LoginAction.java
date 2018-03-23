package study.shiro.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;
import study.shiro.domain.User;

/**
 * author: canglang
 * create time: 2018/3/18 16:04
 */
@Controller
public class LoginAction extends ActionSupport implements ModelDriven<User>{

    private User user = new User();

    public User getModel() {
        return user;
    }

    @Action(value = "/login",results = { @Result(name = "success", location = "/success.jsp"),
            @Result(name = "error", location = "/error.jsp")})
    public String login(){
        System.out.println("username:"+user.getUsername()+"**************"+"password:"+user.getPassword());

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken upt = new UsernamePasswordToken(user.getUsername(),user.getPassword());
        try {
            subject.login(upt);
            System.out.println("登陆成功");
            return "success";
        } catch (AuthenticationException e) {
            this.addActionError("用户名或密码错误");
            System.out.println("登陆失败");
        }
        return "error";
    }
}
