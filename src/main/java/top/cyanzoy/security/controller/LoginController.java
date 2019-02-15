package top.cyanzoy.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.cyanzoy.security.bean.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author MAOA-L
 * @package top.cyanzoy.security.controller
 * @create 2019-02-14 12:49
 * @description: ${DESCRIPTION}
 */
@Controller
public class LoginController {
//
    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String logins(){
        System.out.println("登陆页面");
        return "/login";
    }

    @RequestMapping(value = "/userLogin")
    public String userLogin(User user, HttpServletRequest request, Model model) {

        UsernamePasswordAuthenticationToken uPT = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

        try {
            Authentication authentication = authenticationManager.authenticate(uPT);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            HttpSession session = request.getSession();
            session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());

            model.addAttribute("User", authentication);

        }catch (BadCredentialsException e){
            throw new CustomBadCredentialsException("密码错误");
        }
        return "redirect:/index";

    }

}
