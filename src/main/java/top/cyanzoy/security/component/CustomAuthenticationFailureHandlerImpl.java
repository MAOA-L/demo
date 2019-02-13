package top.cyanzoy.security.component;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author MAOA-L
 * @package top.cyanzoy.security.component
 * @create 2019-01-31 15:26
 * @description: ${DESCRIPTION}
 */
@Component
public class CustomAuthenticationFailureHandlerImpl extends AbstractAuthenticationTargetUrlRequestHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        //跳转至无权限页面，方法来自AbstractAuthenticationTargetUrlRequestHandler
        getRedirectStrategy().sendRedirect(request, response, "/403");


//        httpServletResponse.setContentType("application/json;charset=utf-8");
//        httpServletResponse.setCharacterEncoding("utf-8");
//        PrintWriter out = httpServletResponse.getWriter();
//        StringBuffer sb = new StringBuffer();
//        sb.append("{\"status\":\"error\",\"msg\":\"");
//        if (e instanceof UsernameNotFoundException || e instanceof BadCredentialsException) {
//            sb.append("用户名或密码输入错误，登录失败!");
//        } else if (e instanceof DisabledException) {
//            sb.append("账户被禁用，登录失败，请联系管理员!");
//        } else {
//            sb.append("登录失败!");
//        }
//        sb.append("\"}");
//        out.write(sb.toString());
//        out.flush();
//        out.close();
    }
}
