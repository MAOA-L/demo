package top.cyanzoy.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
 * @package top.cyanzoy.demo.controller
 * @create 2019-01-30 23:08
 * @description: 登陆注册首页controller
 */
@Controller
public class BaseController {

    @Autowired
    private ProjectConstant projectConstant;

    @RequestMapping("/index")
    public String index(HttpServletRequest request, HttpServletResponse response, Model model){
        System.out.println("进入首页");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("User", authentication);
        System.out.println("输出一下authentication中有什么"+authentication);
        return "index";
    }

}
