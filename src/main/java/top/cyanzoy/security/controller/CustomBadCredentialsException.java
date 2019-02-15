package top.cyanzoy.security.controller;

import top.cyanzoy.core.AuthenticationException;

/**
 * @author MAOA-L
 * @package top.cyanzoy.security.controller
 * @create 2019-02-14 15:48
 * @description: 账号验证时的错误
 */
public class CustomBadCredentialsException extends AuthenticationException {
    public CustomBadCredentialsException(String msg, Throwable t) {
        super(msg, t);
    }

    public CustomBadCredentialsException(String msg) {
        super(msg);
    }
}
