package top.cyanzoy.security.bean;

import javax.persistence.*;

/**
 * top.cyanzoy.demo.bean
 * Create By 10993 on 2019/1/17 22:44
 */
@Entity
@Table(name = "user_role")
public class User_Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private Integer rid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }
}
