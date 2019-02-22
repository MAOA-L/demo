package top.cyanzoy.security.component;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author MAOA-L
 * @package top.cyanzoy.security.component
 * @create 2019-01-30 15:35
 * @description: 根据当前用户的信息authentication，和目标url涉及到的权限collection，判断用户是否可以访问
 */
@Component
public class CustomAccessDecisionManagerImpl implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        System.out.println("开始对比用户权限和访问所需权限");

        for (ConfigAttribute ca : collection) {
            String needRole = ca.getAttribute();
            if ("ROLE_login".equals(needRole)) {
                if (authentication instanceof AnonymousAuthenticationToken) {
                    System.out.println("用户未登录,抛出BadCredentialsException前往登录页");
                    throw new BadCredentialsException("未登录");
                } else{
                    System.out.println("用户已登录,可访问");
                    return;
                }
            }
            //遍历当前用户所具有的权限
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                if (authority.getAuthority().equals(needRole)) {
                    return;
                }
            }
        }
        //没有匹配到任何权限 抛出AccessDeniedException
        throw new AccessDeniedException("权限不足");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return false;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
