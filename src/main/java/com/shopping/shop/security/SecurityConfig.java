package com.shopping.shop.security;

import com.shopping.shop.model.Role;
import com.shopping.shop.security.jwt.JwtAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("${authentication.internal.api-key}")
    private String internalApiKey;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;


   @Bean
    public PasswordEncoder passwordEncoder(){
       BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    return encoder;
   }

     @Bean
     public JwtAuthorizationFilter jwtAuthorizationFilter()
     {
         return new JwtAuthorizationFilter();
     }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable());
                /*.securityMatcher("api/authentication/sign-up")
                .authorizeRequests((authorizeRequests) ->
                        authorizeRequests
                                .anyRequest().permitAll()
                );*/

        http.authorizeHttpRequests(
                        auth -> auth.requestMatchers("api/authentication/sign-up", "api/authentication/sign-in" , "api/authentication/deneme").permitAll()
                                .requestMatchers("/api/internal/**").hasRole(Role.SYSTEM_MANAGER.name())
                                .requestMatchers(HttpMethod.GET,"/api/book/**").permitAll()
                                .requestMatchers(HttpMethod.POST,"/api/book/**").hasRole(Role.ADMIN.name())
                                .anyRequest().authenticated()
                )
                .formLogin(withDefaults());







        http.addFilterBefore(jwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(internalApiAuthenticationFilter(), JwtAuthorizationFilter.class);


        return http.build();
    }

    @Bean
    public InternalApiAuthenticationFilter internalApiAuthenticationFilter()
    {
        return new InternalApiAuthenticationFilter(internalApiKey);
    }



}
