package top.cyanzoy.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Configuration
@SpringBootApplication
public class DemoApplication {


    @RequestMapping("/index")
    @ResponseBody
    String index(){
        System.out.println("in");
        return "Hello World!!0.0.";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

