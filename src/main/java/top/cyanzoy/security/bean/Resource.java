package top.cyanzoy.security.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * top.cyanzoy.demo.bean
 * Create By 10993 on 2019/1/17 22:49
 */
@Entity
@Table(name = "resource")
@Setter
@Getter
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String url;

    private String roleName;

}
