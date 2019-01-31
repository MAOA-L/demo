package top.cyanzoy.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import top.cyanzoy.demo.component.CustomAccessDecisionManagerImpl;
import top.cyanzoy.demo.component.CustomAccessDeniedHandlerImpl;
import top.cyanzoy.demo.component.CustomFilterInvocationSecurityMetadataSourceImpl;
import top.cyanzoy.demo.security.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author MAOA-L
 * @package top.cyanzoy.demo.config
 * @create 2019-01-30 16:35
 * @description: ${DESCRIPTION}
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserService userService;
    //接收用户请求的地址，返回访问该地址需要的所有权限
    private final CustomFilterInvocationSecurityMetadataSourceImpl customFilterInvocationSecurityMetadataSourceImpl;
    //比对用户的权限和url所需要的权限
    private final CustomAccessDecisionManagerImpl customAccessDecisionManagerImpl;
    //403处理
    private final CustomAccessDeniedHandlerImpl customAccessDeniedHandlerImpl;

    @Autowired
    public WebSecurityConfig(UserService userService,
                             CustomFilterInvocationSecurityMetadataSourceImpl customFilterInvocationSecurityMetadataSourceImpl,
                             CustomAccessDecisionManagerImpl customAccessDecisionManagerImpl,
                             CustomAccessDeniedHandlerImpl customAccessDeniedHandlerImpl) {
        this.userService = userService;
        this.customFilterInvocationSecurityMetadataSourceImpl = customFilterInvocationSecurityMetadataSourceImpl;
        this.customAccessDecisionManagerImpl = customAccessDecisionManagerImpl;
        this.customAccessDeniedHandlerImpl = customAccessDeniedHandlerImpl;
    }

    /**
     * 定义认证用户信息获取来源，密码校验规则等
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());

    }

    /**
     * 配置不需要认证的页面
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/", "/noAuthenticate");
    }

    /**
     * 定义安全策略
     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests()       //配置安全策略
//                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
//                    @Override
//                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
//                        o.setSecurityMetadataSource(customFilterInvocationSecurityMetadataSourceImpl);
//                        o.setAccessDecisionManager(customAccessDecisionManagerImpl);
//                        return o;
//                    }
//                })
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .permitAll()
//                .failureHandler((HttpServletRequest httpServletRequest,
//                                 HttpServletResponse httpServletResponse,
//                                 AuthenticationException e) -> {
////                    @Override
////                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
//                        httpServletResponse.setContentType("application/json;charset=utf-8");
//                        PrintWriter out = httpServletResponse.getWriter();
//                        StringBuffer sb = new StringBuffer();
//                        sb.append("{\"status\":\"error\",\"msg\":\"");
//                        if (e instanceof UsernameNotFoundException || e instanceof BadCredentialsException) {
//                            sb.append("用户名或密码输入错误，登录失败!");
//                        } else if (e instanceof DisabledException) {
//                            sb.append("账户被禁用，登录失败，请联系管理员!");
//                        } else {
//                            sb.append("登录失败!");
//                        }
//                        sb.append("\"}");
//                        out.write(sb.toString());
//                        out.flush();
//                        out.close();
////                    }
//                })
//                .successHandler(new AuthenticationSuccessHandler() {
//                    @Override
//                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
//                        httpServletResponse.setContentType("application/json;charset=utf-8");
//                        PrintWriter out = httpServletResponse.getWriter();
////                        ObjectMapper objectMapper = new ObjectMapper();
//                        String s = "{\"status\":\"success\",\"msg\":"  + "}";
//                        out.write(s);
//                        out.flush();
//                        out.close();
//                    }
//                })
//                .and()
//                .logout()
//                .permitAll()
//                .and()
//                .csrf()
//                .disable()
//                .exceptionHandling()
//                .accessDeniedHandler(customAccessDeniedHandlerImpl);
//
//    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()                    //  定义当需要用户登录时候，转到的登录页面。
                .and()
                .authorizeRequests()        // 定义哪些URL需要被保护、哪些不需要被保护
                .anyRequest()               // 任何请求,登录后可以访问
                .authenticated();
    }

}
