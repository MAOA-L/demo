package top.cyanzoy.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.cyanzoy.security.bean.User;

/**
 * top.cyanzoy.demo.dao
 * Create By 10993 on 2019/1/17 22:51
 */
public interface UserMapper extends JpaRepository<User, String> {
    User findByUsername(String username);
}
