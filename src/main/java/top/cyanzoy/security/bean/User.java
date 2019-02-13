package top.cyanzoy.security.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * top.cyanzoy.demo.bean
 * Create By 10993 on 2019/1/17 22:26
 */

@Entity
@Table(name = "users")
public class User{

    @Id
    private String username;

    @Column(name = "pwd")
    private String password;

    public User(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
