package top.cyanzoy.demo.test_static;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;

/**
 * @author MAOA-L
 * @package top.cyanzoy.demo.test_static
 * @create 2019-01-31 14:44
 * @description: ${DESCRIPTION}
 */
public class BCrypt {

    public static void main(String[] args) {
//        byte[] salt = new byte[12];
        SecureRandom secureRandom = new SecureRandom();
//        secureRandom.nextBytes(salt);
//        System.out.println(salt);

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12, secureRandom);
        String n = bCryptPasswordEncoder.encode("123456");
        System.out.println(n);

        Boolean i = bCryptPasswordEncoder.matches("123456","$2a$12$f/Xdyz2a.SZnxRtedbupMO4hrSHsEVoMaqRNz1uV9p.CZ1yhVk19G");
        System.out.println(i);

    }

}
