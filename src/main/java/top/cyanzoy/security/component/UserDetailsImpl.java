package top.cyanzoy.security.component;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import top.cyanzoy.security.bean.Role;
import top.cyanzoy.security.bean.User;
import top.cyanzoy.security.service.RoleService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * top.cyanzoy.demo.service.security
 * Create By 10993 on 2019/1/17 23:17
 */


//一定要有一个类，实现UserDetails接口，供程序调用
@Component
@Setter
@Getter
public class UserDetailsImpl implements UserDetails {

//    private static final long serialVersionUID =

    private String username;

    private String password;

    private Boolean active;

    private Boolean superuser;

    //包含着用户对应的所有Role，在使用时调用者给对象注入roles
    private List<Role> roles;

    //无参构造
    public UserDetailsImpl() {
    }

    //用User构造
    public UserDetailsImpl(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
    }

    //用User和List<Role>构造
    public UserDetailsImpl(User user, List<Role> roles) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.active = user.getActive();
        this.superuser = user.getSuperuser();
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for(Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorities;
    }

    /**
     * 判断账号是否已经过期，默认没有过期
     * @return true
     */
    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    /**
     * 判断账号是否被锁定，默认没有锁定
     * @return true
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 判断信用凭证是否过期，默认没有过期
     * @return true
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 判断账号是否可用，默认可用
     * @return true
     */
    @Override
    public boolean isEnabled() {
        return this.getActive();
    }
}
