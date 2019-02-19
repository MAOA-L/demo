package top.cyanzoy.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.cyanzoy.security.bean.UserRole;

/**
 * top.cyanzoy.demo.dao
 * Create By 10993 on 2019/1/17 22:58
 */
public interface UserRoleMapper extends JpaRepository<UserRole, Integer> {
}
