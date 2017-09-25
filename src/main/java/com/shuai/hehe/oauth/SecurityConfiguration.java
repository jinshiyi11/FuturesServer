package com.shuai.hehe.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().
//        auth.inMemoryAuthentication()
//                .withUser("user_1").password("123456").authorities("USER")
//                .and()
//                .withUser("user_2").password("123456").authorities("USER");

        auth
                .inMemoryAuthentication()
                .withUser("aa")
                .password("aa")
                .roles("USER");
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
                .antMatchers("/api/sendVerificationCode","/login", "/oauth/authorize").permitAll()
                .anyRequest().authenticated()
//                .and().formLogin()
                ;
    }
}
