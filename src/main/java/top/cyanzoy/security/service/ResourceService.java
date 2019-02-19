package top.cyanzoy.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.cyanzoy.security.bean.Resource;
import top.cyanzoy.security.bean.Role;
import top.cyanzoy.security.dao.ResourceMapper;
import top.cyanzoy.security.dao.RoleMapper;

import java.util.List;

/**
 * @author MAOA-L
 * @package top.cyanzoy.demo.service
 * @create 2019-01-21 14:44
 * @description: 处理Resouce类的业务
 */
@Service
public class ResourceService {
    private ResourceMapper resourceMapper;
    private RoleMapper roleMapper;

    @Autowired
    public ResourceService(ResourceMapper resourceMapper, RoleMapper roleMapper) {
        this.resourceMapper = resourceMapper;
        this.roleMapper = roleMapper;
    }

    public List<Resource> findByUrl(String url) {
        return resourceMapper.findByUrl(url);
    }

    public Resource getResourceByUrl(String url){
        return resourceMapper.getResourceByUrl(url);
    }


    public List<Role> getRoles(Integer id) {
        return roleMapper.findRolesOfResource(id);
    }

}
