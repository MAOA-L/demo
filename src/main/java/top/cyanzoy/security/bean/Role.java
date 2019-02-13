package top.cyanzoy.security.bean;

import javax.persistence.*;

/**
 * top.cyanzoy.demo.bean
 * Create By 10993 on 2019/1/17 22:42
 */
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String role_user;

    private String role_admin;

    public String getRole_user() {
        return role_user;
    }

    public void setRole_user(String role_user) {
        this.role_user = role_user;
    }

    public String getRole_admin() {
        return role_admin;
    }

    public void setRole_admin(String role_admin) {
        this.role_admin = role_admin;
    }
}
