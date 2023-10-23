package com.shopping.shop.security;

import com.shopping.shop.model.User;
import com.shopping.shop.service.IUserService;
import com.shopping.shop.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {


    private IUserService userService;

    public CustomUserDetailsService(@Lazy IUserService userService){
        super();
        this.userService = userService;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userService.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException(username));
       Set<GrantedAuthority> authoritySet = Set.of(SecurityUtils.convertToAuthority(user.getRole().name()));
       return UserPrincipal.builder().user(user).id(user.getId())
               .username(username)
               .password(user.getPassword())
               .authoritySet(authoritySet).build();
    }
}
