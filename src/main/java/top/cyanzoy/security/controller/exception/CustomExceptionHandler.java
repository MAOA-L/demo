package top.cyanzoy.security.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;
import top.cyanzoy.core.AuthenticationException;
import top.cyanzoy.security.controller.CustomBadCredentialsException;

/**
 * @author MAOA-L
 * @package top.cyanzoy.security.controller.exception
 * @create 2019-02-14 14:56
 * @description: 自定义异常处理类
 */
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomBadCredentialsException.class)
    @ResponseStatus(HttpStatus.OK)
    public String badException(CustomBadCredentialsException be, Model model){
        model.addAttribute("class", "error");
        model.addAttribute("msg", be.getMessage());
        return "login";
    }
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.OK)
    public String noHandlerFoundException (CustomBadCredentialsException be, Model model){
        System.out.println("========捕获404异常");
        return "/_404";
    }



}
