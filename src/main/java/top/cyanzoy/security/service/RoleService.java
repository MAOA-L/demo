package top.cyanzoy.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.cyanzoy.security.bean.Role;
import top.cyanzoy.security.dao.RoleMapper;

import java.util.List;

/**
 * top.cyanzoy.demo.service
 * Create By 10993 on 2019/1/17 23:07
 */

@Service
public class RoleService {

    private RoleMapper roleMapper;

    @Autowired
    public void RoleService(RoleMapper roleImpl){
        this.roleMapper = roleImpl;
    }


    public List<Role> roleFindAll(String username){
        return roleMapper.findAll();
    }


    public List<Role> getRolesOfUser(String username) {
        return roleMapper.findRolesOfUser(username);
    }

    public List<Role> getRolesOfResource(int id){
        return roleMapper.findRolesOfResource(id);
    }

    public List<Role> getRoles(int id){
        return roleMapper.findRolesOfResource(id);
    }
}
