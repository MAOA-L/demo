package top.cyanzoy.security.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * top.cyanzoy.demo.bean
 * Create By 10993 on 2019/1/17 22:45
 */

@Entity
@Table(name = "role_resource")
@Setter
@Getter
public class RoleResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer roleId;

    private Integer roleResourceId;
}
