package top.cyanzoy.core;

/**
 * @author MAOA-L
 * @package top.cyanzoy.core
 * @create 2019-02-14 14:40
 * @description: ${DESCRIPTION}
 */
public abstract class AuthenticationException extends RuntimeException{
    public AuthenticationException(String msg, Throwable t) {
        super(msg, t);
    }

    public AuthenticationException(String msg) {
        super(msg);
    }
}
