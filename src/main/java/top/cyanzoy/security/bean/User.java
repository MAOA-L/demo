package top.cyanzoy.security.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

/**
 * top.cyanzoy.demo.bean
 * Create By 10993 on 2019/1/17 22:26
 */

@Entity
@Table(name = "auth_user")
@Setter
@Getter
@ToString
public class User{
    // GenerationType.AUTO 可以主动适应数据库中id自增的策略 或者使用 IDENTITY 替代 AUTO
    // .yml文件中 hibernate.id.new_generator_mappings=true 时 GenerationType.AUTO 将失效

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint unsigned")
    private Long id;

    @Column(nullable = false, columnDefinition = "datetime")
    private Date gmtCreate; //创建时间

    @Column(columnDefinition = "datetime")
    private Date gmtModified; //被动更新时间

    @Column(nullable = false, unique = true, name = "ukUsername")
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, columnDefinition = "char(20)")
    private String phoneNumber;

    @Column(name = "isActive", columnDefinition = "tinyint(1)")
    private Boolean active = true;

    @Column(columnDefinition = "datetime")
    private Date lastLogin;

    @Column(name = "isSuperuser", columnDefinition = "tinyint(1)")
    private Boolean superuser = false;


}

