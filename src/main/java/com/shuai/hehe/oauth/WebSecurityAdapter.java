//package com.shuai.hehe.oauth;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//import javax.sql.DataSource;
//
///**
// * web页安全配置
// */
//@Configuration
//public class WebSecurityAdapter extends WebSecurityConfigurerAdapter {
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        super.configure(web);
//        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
////        http.authorizeRequests()
////                .antMatchers("/").permitAll()
////                .anyRequest().authenticated()
////        .and().formLogin()
//////                .loginPage("/login.html").permitAll()
//////                .defaultSuccessUrl("/")
//////                .failureUrl("/login.html?error=true")
//////                .and()
//////                .logout().logoutSuccessUrl("/login.html");
////        ;
////
////        http.csrf().disable();
//    }
//}
