package top.cyanzoy.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.cyanzoy.demo.bean.User;

import java.util.List;

/**
 * top.cyanzoy.demo.dao
 * Create By 10993 on 2019/1/17 22:51
 */
public interface UserMapper extends JpaRepository<User, String> {
    User findByUsername(String username);
}
