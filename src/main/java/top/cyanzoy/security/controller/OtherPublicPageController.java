package top.cyanzoy.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author MAOA-L
 * @package top.cyanzoy.security.controller
 * @create 2019-02-14 14:22
 * @description: ${DESCRIPTION}
 */
@Controller
public class OtherPublicPageController {

    /**
     * 403无权限页面
     * @return 403.ftl
     */
    @RequestMapping("/403")
    public String _403(){
        return "_403";
    }

}
