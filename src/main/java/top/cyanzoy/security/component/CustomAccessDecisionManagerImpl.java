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
import java.util.Iterator;

/**
 * @author MAOA-L
 * @package top.cyanzoy.security.component
 * @create 2019-01-30 15:35
 * @description: 根据当前用户的信息collection，和目标url涉及到的权限authentication，判断用户是否可以访问
 */
@Component
public class CustomAccessDecisionManagerImpl implements AccessDecisionManager {
    private Boolean isAuth = false;
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        System.out.println("开始对比用户权限和访问所需权限");

        collection.iterator().forEachRemaining(e -> {
            String needRole = e.getAttribute();
            if ("ROLE_login".equals(needRole)) {
                // needRole为role_login时表示url在登录后即可访问,所以判断身份是否为匿名用户
                if (authentication instanceof AnonymousAuthenticationToken) {
                    throw new BadCredentialsException("未登录");
                } else{
                    System.out.println("登录即可,已登录");
                    isAuth = true;
                    return;
                }
            }

            // 遍历当前用户所具有的权限
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority: authorities) {
                if(authority.getAuthority().equals(needRole)){
                    System.out.println("拥有权限");
                    isAuth = true;
                    return;
                }
            }
        });

//        for(Iterator<ConfigAttribute> iterator = collection.iterator();iterator.hasNext();){
//            ConfigAttribute ca = iterator.next();
//            String needRole = ca.getAttribute();
//            if ("ROLE_LOGIN".equals(needRole)) {
//                if (authentication instanceof AnonymousAuthenticationToken) {
//                    throw new BadCredentialsException("未登录");
//                } else
//                    return;
//            }
//            //遍历当前用户所具有的权限
//            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//            for (GrantedAuthority authority: authorities) {
//                if(authority.getAuthority().equals(needRole)){
//                    return;
//                }
//            }
//        }
        //没有匹配到任何权限 抛出AccessDeniedException
        if(!isAuth){
            throw new AccessDeniedException("权限不足");
        }
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
