package top.cyanzoy.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.cyanzoy.demo.bean.ProjectConstant;
import top.cyanzoy.security.bean.User;
import top.cyanzoy.utils.CustomBCrypt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.SecureRandom;

/**
 * @author MAOA-L
 * @package top.cyanzoy.security.controller
 * @create 2019-02-14 14:20
 * @description: 注册Controller
 */
@Controller
public class RegisterController {

    private final ProjectConstant projectConstant;

    @Autowired
    public RegisterController(ProjectConstant projectConstant) {
        this.projectConstant = projectConstant;
    }

    /**
     * 注册信息提交
     * @param user 注册信息分装为User对象
     * @return ···
     */
    @RequestMapping(value = {"/register", "/register.html"}, method = RequestMethod.POST)
    @ResponseBody
    public String register(User user, HttpServletRequest request, HttpServletResponse response){
        CustomBCrypt customBCrypt = new CustomBCrypt(projectConstant.getStrength(), new SecureRandom());
        System.out.println("输出一下加密后的密码"+customBCrypt.encode(user.getPassword()));

        return "register OK!";
    }

    /**
     * 请求注册页面
     * @return register页面
     */
    @RequestMapping(value = {"/register", "/register.html"}, method = RequestMethod.GET)
    public String registerftl(HttpServletRequest request, HttpServletResponse response){
        return "register";
    }

}
