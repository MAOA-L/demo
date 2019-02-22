package top.cyanzoy.security.bean;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.cyanzoy.security.dao.UserMapper;
import top.cyanzoy.utils.CustomBCrypt;

import java.security.SecureRandom;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author MAOA-L
 * @package top.cyanzoy.security.bean
 * @create 2019-02-20 10:54
 * @description: ${DESCRIPTION}
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void createUser(){
        CustomBCrypt customBCrypt = new CustomBCrypt(12, new SecureRandom());
        User user = new User();
        user.setUsername("bad");
        user.setPassword(customBCrypt.encode("123456"));
        user.setPhoneNumber("13857483192");
        user.setActive(false);
        user.setSuperuser(false);
        // 日期
        user.setGmtCreate(new Date());
        userMapper.save(user);
    }
    @Test
    public void getUser(){
        User user = userMapper.findByUsername("admin");
        System.out.println(user.getGmtCreate());

    }

    @Test
    public void updateUser(){
        User user = userMapper.findByUsername("admin");
        user.setSuperuser(false);
        userMapper.saveAndFlush(user);

    }

}