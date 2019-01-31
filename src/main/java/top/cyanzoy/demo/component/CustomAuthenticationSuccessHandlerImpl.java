package top.cyanzoy.demo.component;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author MAOA-L
 * @package top.cyanzoy.demo.component
 * @create 2019-01-31 15:21
 * @description: ${DESCRIPTION}
 */
@Component
public class CustomAuthenticationSuccessHandlerImpl extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //登陆成功后会进入此函数进一步跳转页面，判断权限，或者在相应页面的controller上使用权限注解
        //跳转到目标url上
        String targetUrlParameter = this.getTargetUrlParameter();
        System.out.println("成功登陆后,看看要跳到那个url==="+targetUrlParameter);
        getRedirectStrategy().sendRedirect(request, response, "/index");

    }
}
