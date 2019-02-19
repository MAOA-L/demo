package top.cyanzoy.security.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * top.cyanzoy.demo.bean
 * Create By 10993 on 2019/1/17 22:44
 */
@Entity
@Table(name = "user_role")
@Setter
@Getter
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userName;

    private Integer roleId;

}
