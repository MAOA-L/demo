package top.cyanzoy.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import top.cyanzoy.demo.bean.Role;

import java.util.List;

/**
 * top.cyanzoy.demo.dao
 * Create By 10993 on 2019/1/17 22:56
 */
public interface RoleMapper extends JpaRepository<Role, Integer> {

    //自定义sql语句并且开启本地sql
    //根据用户名查找该用户所有权限
    @Query(value = "select r.* from role r,user_role ur where ur.username = ?1 and ur.rid = r.id", nativeQuery = true)
    List<Role> findRolesOfUser(String username);

    //根据resource的主键查找resource允许的所有权限
    @Query(value = "select r.* from role r, role_resource rr where rr.resid = ?1 and rr.rid = r.id", nativeQuery = true)
    List<Role> findRolesOfResource(long resourceId);

}
