package top.cyanzoy.security.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * top.cyanzoy.demo.bean
 * Create By 10993 on 2019/1/17 22:42
 */
@Entity
@Table(name = "role")
@Setter
@Getter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //角色名
    private String roleName;

    //角色注释
    private String roleAnnotation;


}
