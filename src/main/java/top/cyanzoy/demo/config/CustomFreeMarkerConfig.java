package top.cyanzoy.demo.config;

import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import top.cyanzoy.demo.bean.FreeMarkerBean;

import javax.annotation.PostConstruct;

/**
 * @author MAOA-L
 * @package top.cyanzoy.demo.config
 * @create 2019-02-13 9:48
 * @description: ${DESCRIPTION}
 */

@Configuration
public class CustomFreeMarkerConfig {
    @Autowired
    private freemarker.template.Configuration configuration;

    @Autowired
    private FreeMarkerBean freeMarkerBean;


    @PostConstruct
    public void afterPropertiesSet() throws TemplateModelException {
        this.configuration.setSharedVariable("freemarker", freeMarkerBean);
    }

}
