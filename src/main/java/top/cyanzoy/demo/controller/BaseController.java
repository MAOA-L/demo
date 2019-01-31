package top.cyanzoy.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author MAOA-L
 * @package top.cyanzoy.demo.controller
 * @create 2019-01-30 23:08
 * @description: ${DESCRIPTION}
 */
@Controller
public class BaseController {

    @RequestMapping("/login")
    public String login(){
        System.out.println("登陆页面");
        return "/login";
    }

    @RequestMapping("/indexs")
    @ResponseBody
    public String indexs(){
        System.out.println("ins");
        return "indexs页面";
    }

    @RequestMapping("/index")
    public String index(HttpServletRequest request, HttpServletResponse response, Model model){
        System.out.println("fuck");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("User", authentication);
        System.out.println("输出一下authentication中有什么"+authentication);
        return "index";
    }

    /**
     * 403无权限页面
     * @return 403.ftl
     */
    @RequestMapping("/403")
    public String _403(){
        return "_403";
    }

}
