package top.cyanzoy.security.controller;

import top.cyanzoy.core.AuthenticationException;

/**
 * @author MAOA-L
 * @package top.cyanzoy.security.controller
 * @create 2019-02-20 14:50
 * @description: ${DESCRIPTION}
 */
public class CustomBadUserException extends AuthenticationException {
    public CustomBadUserException(String msg, Throwable t) {
        super(msg, t);
    }

    public CustomBadUserException(String msg) {
        super(msg);
    }
}
