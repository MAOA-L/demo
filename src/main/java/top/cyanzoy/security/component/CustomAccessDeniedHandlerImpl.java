package top.cyanzoy.security.component;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author MAOA-L
 * @package top.cyanzoy.security.component
 * @create 2019-01-30 16:28
 * @description: 403无权限
 */
@Component
public class CustomAccessDeniedHandlerImpl extends AbstractAuthenticationTargetUrlRequestHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {

        getRedirectStrategy().sendRedirect(request, response, "/403");

    }
}
