package top.cyanzoy.security.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import top.cyanzoy.security.bean.Resource;
import top.cyanzoy.security.bean.Role;
import top.cyanzoy.security.service.ResourceService;

import java.util.Collection;
import java.util.List;

/**
 * @author MAOA-L
 * @package top.cyanzoy.security.component
 * @create 2019-01-21 14:32
 * @description: 接收用户请求的地址，返回访问该地址需要的所有权限
 */
@Component
public class CustomFilterInvocationSecurityMetadataSourceImpl implements FilterInvocationSecurityMetadataSource {

    private ResourceService resourceService;

    @Autowired
    public void setResourceService(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //得到用户的请求地址,控制台输出一下
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        System.out.println("用户请求的地址是：" + requestUrl);

        //如果登录页面就不需要权限
        if ("/login".equals(requestUrl)) {
            return null;
        }

        // 根据url获取此url的权限信息
        Resource resource = resourceService.getResourceByUrl(requestUrl);

        //如果该url没有匹配则登录后即可访问
        if(resource == null) {
            return SecurityConfig.createList("ROLE_login");
        }

        //将resource所需要到的roles按框架要求封装返回（ResourceService里面的getRoles方法是基于RoleImpl实现的）
        List<Role> roles = resourceService.getRoles(resource.getId());
        int size = roles.size();
        String[] values = new String[size];
        for (int i = 0; i < size; i++) {
            values[i] = roles.get(i).getRoleName();
        }
        System.out.print(requestUrl+"所需要的权限为");
        for (String s:values) {
            System.out.println(s);
        }
        return SecurityConfig.createList(values);
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
