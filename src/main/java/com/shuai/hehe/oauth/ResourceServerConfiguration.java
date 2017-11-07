package com.shuai.hehe.oauth;

import com.google.gson.Gson;
import com.shuai.hehe.api.LoginController;
import com.shuai.hehe.api.response.ErrorCode;
import com.shuai.hehe.api.response.ResponseInfo;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
//    @Autowired
//    private AuthenticationManager authenticationManager;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        super.configure(resources);
        resources
                .accessDeniedHandler(new OAuth2AccessDeniedHandler() {
                    @Override
                    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException authException) throws IOException, ServletException {
                        //super.handle(request, response, authException);

                        Gson gson = new Gson();
                        ResponseInfo<LoginController.TokenInfo> result = new ResponseInfo<LoginController.TokenInfo>(ErrorCode.ERROR_ACCESS_DENY);
                        String json = gson.toJson(result);
                        response.setContentType("application/json; charset=UTF-8");
                        response.getWriter().print(json);
                    }
                })
                .authenticationEntryPoint(new OAuth2AuthenticationEntryPoint() {
                    @Override
                    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
                        //super.commence(request, response, authException);

                        Gson gson = new Gson();
                        ResponseInfo<LoginController.TokenInfo> result = new ResponseInfo<LoginController.TokenInfo>(ErrorCode.ERROR_ACCESS_DENY);
                        String json = gson.toJson(result);
                        response.setContentType("application/json; charset=UTF-8");
                        response.getWriter().print(json);
                    }
                });
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
//        super.configure(http);

        http.authorizeRequests()
                .antMatchers("/api/sendVerificationCode",
                        "/api/login",
                        "/api/registerByPhone",
                        "/oauth/authorize",
                        "/**"
                ).permitAll()
                .anyRequest().authenticated()
        //.and().formLogin()
        ;

        http.csrf().disable();

        http.exceptionHandling()
                //TODO:下面为什么没作用?
                .accessDeniedHandler(new OAuth2AccessDeniedHandler() {
                    @Override
                    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException authException) throws IOException, ServletException {
                        //super.handle(request, response, authException);

                        Gson gson = new Gson();
                        ResponseInfo<LoginController.TokenInfo> result = new ResponseInfo<LoginController.TokenInfo>(ErrorCode.ERROR_ACCESS_DENY);
                        String json = gson.toJson(result);
                        response.setContentType("application/json; charset=UTF-8");
                        response.getWriter().print(json);
                    }
                })
                .authenticationEntryPoint(new OAuth2AuthenticationEntryPoint() {
                    @Override
                    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
                        //super.commence(request, response, authException);

                        Gson gson = new Gson();
                        ResponseInfo<LoginController.TokenInfo> result = new ResponseInfo<LoginController.TokenInfo>(ErrorCode.ERROR_ACCESS_DENY);
                        String json = gson.toJson(result);
                        response.setContentType("application/json; charset=UTF-8");
                        response.getWriter().print(json);
                    }
                });

//
////        http
//                // Since we want the protected resources to be accessible in the UI as well we need
//                // session creation to be allowed (it's disabled by default in 2.0.6)
////                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
////                .and()
////                .authorizeRequests().antMatchers("/**").authenticated()
//                //.authorizeRequests().anyRequest().permitAll()
////                .and()
////                .anonymous()
////                .and().authorizeRequests()
////                .antMatchers("/oauth/**").permitAll()
////                .and()
////                .authorizeRequests()
//////                    .antMatchers("/product/**").access("#oauth2.hasScope('select') and hasRole('ROLE_USER')")
////                .antMatchers("/order/**").authenticated()
////                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());;//配置order访问控制，必须认证过后才可以访问
//        ;
//
//        http.authorizeRequests()
////                .antMatchers("/user_list","/login", "/oauth/authorize").permitAll()
//                .anyRequest().authenticated()
//        .and().formLogin()
//        ;
    }


}
