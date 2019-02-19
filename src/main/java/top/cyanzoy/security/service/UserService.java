package top.cyanzoy.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.cyanzoy.security.bean.User;
import top.cyanzoy.security.dao.UserMapper;
import top.cyanzoy.security.component.UserDetailsImpl;

import java.util.List;

/**
 * top.cyanzoy.demo.service.security
 * Create By 10993 on 2019/1/18 9:38
 */
@Service
public class UserService implements UserDetailsService {

    private UserMapper userMapper;

    private RoleService roleService;

    @Autowired
    public UserService(UserMapper userImpl, RoleService roleService) {
        this.userMapper = userImpl;
        this.roleService = roleService;
    }

    @Transactional
    public List<User> getAllUser(){
        return userMapper.findAll();
    }

    private User getByUsername(String username){
        return userMapper.findByUsername(username);
    }

    //重写UserDetailsService接口里面的抽象方法
    //根据用户名 返回一个UserDetails的实现类的实例
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("查找用户:"+s);
        User user = getByUsername(s);
        if(user == null){
            throw new UsernameNotFoundException("NO Such User");
        }
        //查到User后将其封装为UserDetails的实现类的实例供程序调用
        //用该User和它对应的Role实体们构造UserDetails的实现类
        System.out.println("输出用户的角色信息:");
        roleService.getRolesOfUser(user.getUsername()).forEach(e -> System.out.println(e.getRoleName()
                + "," + e.getRoleAnnotation()));
        return new UserDetailsImpl(user, roleService.getRolesOfUser(user.getUsername()));
    }
}
