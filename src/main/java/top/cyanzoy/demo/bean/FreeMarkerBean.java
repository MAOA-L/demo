package top.cyanzoy.demo.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author MAOA-L
 * @package top.cyanzoy.demo.bean
 * @create 2019-02-13 10:58
 * @description: 此Bean为模板提供全局变量 加载freemarker.properties配置文件自动注入至Bean中
 */
@Component
@PropertySource(value = {"classpath:freemarker.properties"})
@ConfigurationProperties(prefix = "freemarker")
public class FreeMarkerBean {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
            this.name = name;
        }

}
