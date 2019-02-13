package top.cyanzoy.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;
import java.util.regex.Pattern;

/**
 * @author MAOA-L
 * @package top.cyanzoy.utils
 * @create 2019-02-13 11:48
 * @description: 加解密
 */
public class CustomBCrypt {
    private Pattern BCRYPT_PATTERN;
    private final int strength;
    private final SecureRandom random;

    public CustomBCrypt() {
        this(-1);
    }

    public CustomBCrypt(int strength) {
        this(strength, (SecureRandom)null);
    }

    public CustomBCrypt(int strength, SecureRandom random) {
        this.BCRYPT_PATTERN = Pattern.compile("\\A\\$2a?\\$\\d\\d\\$[./0-9A-Za-z]{53}");
        if (strength == -1 || strength >= 4 && strength <= 31) {
            this.strength = strength;
            this.random = random;
        } else {
            throw new IllegalArgumentException("加密盐值强度设置错误!");
        }
    }

    public String encode(CharSequence rawPassword){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, random);
        return bCryptPasswordEncoder.encode(rawPassword);
    }

}
