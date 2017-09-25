package com.shuai.hehe.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

/**
 *
 */
//@Configuration
//@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
//    @Autowired
//    private AuthenticationManager authenticationManager;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        super.configure(resources);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
//        super.configure(http);

//        http
                // Since we want the protected resources to be accessible in the UI as well we need
                // session creation to be allowed (it's disabled by default in 2.0.6)
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//                .and()
//                .authorizeRequests().antMatchers("/**").authenticated()
                //.authorizeRequests().anyRequest().permitAll()
//                .and()
//                .anonymous()
//                .and().authorizeRequests()
//                .antMatchers("/oauth/**").permitAll()
//                .and()
//                .authorizeRequests()
////                    .antMatchers("/product/**").access("#oauth2.hasScope('select') and hasRole('ROLE_USER')")
//                .antMatchers("/order/**").authenticated()
//                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());;//配置order访问控制，必须认证过后才可以访问
        ;

        http.authorizeRequests()
//                .antMatchers("/user_list","/login", "/oauth/authorize").permitAll()
                .anyRequest().authenticated()
        .and().formLogin()
        ;
    }


}
