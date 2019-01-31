package top.cyanzoy.demo.test_static;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author MAOA-L
 * @package top.cyanzoy.demo.test_static
 * @create 2019-01-31 14:44
 * @description: ${DESCRIPTION}
 */
public class BCrypt {

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String n = bCryptPasswordEncoder.encode("123456");
        System.out.println(n);
    }

}
