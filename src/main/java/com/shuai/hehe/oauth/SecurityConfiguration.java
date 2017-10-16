package com.shuai.hehe.oauth;

import com.shuai.hehe.api.entity.User;
import com.shuai.hehe.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().
//        auth.inMemoryAuthentication()
//                .withUser("user_1").password("123456").authorities("USER")
//                .and()
//                .withUser("user_2").password("123456").authorities("USER");

//        auth
//                .inMemoryAuthentication()
//                .withUser("aa")
//                .password("aa")
//                .roles("USER");

        auth.userDetailsService(userDetailsService)
        .passwordEncoder(new Md5PasswordEncoder());

//        auth.jdbcAuthentication().dataSource(dataSource).withUser("dave")
//                .password("secret").roles("USER");
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        AuthenticationManager manager = super.authenticationManagerBean();
        return manager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/**").authenticated();
//                .authorizeRequests()
//                .anyRequest().permitAll();

        http.authorizeRequests()
                .antMatchers("/api/sendVerificationCode", "/api/login", "/api/registerByPhone", "/oauth/authorize").permitAll()
                .anyRequest().authenticated()
        //.and().formLogin()
        ;

        http.csrf().disable();


    }


//    @Bean
//    AccessDeniedHandler accessDeniedHandler() {
//        AccessDeniedHandlerImpl accessDeniedHandler = new AccessDeniedHandlerImpl();
//        accessDeniedHandler.setErrorPage("/securityException/accessDenied");
//        return accessDeniedHandler;
//    }
//
//    @Bean
//    AuthenticationSuccessHandler authenticationSuccessHandler(){
//        SimpleUrlAuthenticationSuccessHandler handler=new SimpleUrlAuthenticationSuccessHandler();
//        return handler;
//    }

    @Component("userDetailsService")
    public static class MyUserDetailsService implements UserDetailsService {
        @Autowired
        private UserRepository mUserRepository;

        private List<SimpleGrantedAuthority> mAuthorities = new ArrayList<>();

        public MyUserDetailsService() {
            mAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }

        @Override
        public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
            User user = mUserRepository.findByPhone(phone);
            return new org.springframework.security.core.userdetails.User(user.getPhone(), user.getPassword(), mAuthorities);
        }
    }
}
