package top.cyanzoy.demo.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author MAOA-L
 * @package top.cyanzoy.demo.bean
 * @create 2019-02-13 12:04
 * @description: 项目中需要用到的全局变量
 */
@Component
@PropertySource(value = {"classpath:config.properties"})
@ConfigurationProperties(prefix = "bcrypt")
public class ProjectConstant {

    private Integer strength;

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }
}
