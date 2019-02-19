package top.cyanzoy.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.cyanzoy.security.bean.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author MAOA-L
 * @package top.cyanzoy.security.controller
 * @create 2019-02-14 12:49
 * @description: ${DESCRIPTION}
 */
@Controller
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * 登录Controller
     * @return 未登录则返回登录页，已登录用户请求登录页则直接跳转至首页
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String logins(){
        System.out.println("登陆Controller");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("输出一下authentication="+authentication);
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            // 表示用户身份为非匿名用户。
            return "/index";
        }

        return "/login";
    }

    /**
     * 登录验证Controller
     * @param user 账号密码封装为User
     * @param request ·
     * @param model ·
     * @return 页面
     */
    @RequestMapping(value = "/userLogin")
    public String userLogin(User user, HttpServletRequest request, HttpServletResponse response, Model model) {

        UsernamePasswordAuthenticationToken uPT = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        String target = "index";
        try {
            Authentication authentication = authenticationManager.authenticate(uPT);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            HttpSession session = request.getSession();
            session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());

            HttpSessionRequestCache httpSessionRequestCache = new HttpSessionRequestCache();
            try{
                target = httpSessionRequestCache.getRequest(request, response).getRedirectUrl()
                        .replace("error", "index");
            }catch (Exception e){
                System.out.println("没有获取跳转地址");
            }
            model.addAttribute("User", authentication);

        }catch (BadCredentialsException e){
            throw new CustomBadCredentialsException("密码错误");
        }
        // 返回请求的页面
        return "redirect:/" + target;

    }

}
