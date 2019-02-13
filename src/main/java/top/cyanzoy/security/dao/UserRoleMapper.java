package top.cyanzoy.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.cyanzoy.security.bean.User_Role;

/**
 * top.cyanzoy.demo.dao
 * Create By 10993 on 2019/1/17 22:58
 */
public interface UserRoleMapper extends JpaRepository<User_Role, Integer> {
}
