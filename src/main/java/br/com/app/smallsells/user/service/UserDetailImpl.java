package br.com.app.smallsells.user.service;

import br.com.app.smallsells.user.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDetailImpl implements UserDetails {

    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> grantedAuthorities;

    public UserDetailImpl(Long id, String name, String username, String password, String email, Collection<? extends GrantedAuthority> grantedAuthorities) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.grantedAuthorities = grantedAuthorities;
    }

    public static UserDetailImpl build(UserEntity userEntity) {
        return new UserDetailImpl(userEntity.getId(),
                userEntity.getName(),
                userEntity.getLogin(),
                userEntity.getPassword(),
                userEntity.getEmail(),
                List.of());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
