package top.cyanzoy.security.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

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
@Setter
@Getter
@ToString
public class User{

    @Id
    private String username;

    @Column(name = "pwd")
    private String password;

}
