//package com.shuai.hehe.oauth;
//
//import com.google.gson.Gson;
//import com.shuai.hehe.api.LoginController;
//import com.shuai.hehe.api.entity.AuthenticatedUser;
//import com.shuai.hehe.api.entity.User;
//import com.shuai.hehe.api.mapper.UserMapper;
//import com.shuai.hehe.api.response.ErrorCode;
//import com.shuai.hehe.api.response.ResponseInfo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
//import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.sql.DataSource;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * api接口安全配置
// */
//@Configuration
//@Order(1)
//public class ApiSecurityAdapter extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        http.authorizeRequests().antMatchers("/**").authenticated();
////                .authorizeRequests()
////                .anyRequest().permitAll();
//
//        http.antMatcher("/api/**")
//                .authorizeRequests()
//                .antMatchers(
//                        "/api/login",
//                        "/api/sendVerificationCode",
//                        "/api/registerByPhone",
//                        "/api/getFuturesList",
//                        "/api/getFutures",
//                        "/api/searchFutures",
//                        "/api/getCommentList"
//                ).permitAll()
//                .antMatchers("/api/**").authenticated()
//        ;
//
//        http.csrf().disable();
//
//        http.exceptionHandling()
//                .accessDeniedHandler(new OAuth2AccessDeniedHandler() {
//                    @Override
//                    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException authException) throws IOException, ServletException {
//                        //super.handle(request, response, authException);
//
//                        Gson gson = new Gson();
//                        ResponseInfo<LoginController.TokenInfo> result = new ResponseInfo<LoginController.TokenInfo>(ErrorCode.ERROR_ACCESS_DENY);
//                        String json = gson.toJson(result);
//                        response.setContentType("application/json; charset=UTF-8");
//                        response.getWriter().print(json);
//                    }
//                })
//                .authenticationEntryPoint(new OAuth2AuthenticationEntryPoint() {
//                    @Override
//                    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
//                        //super.commence(request, response, authException);
//
//                        Gson gson = new Gson();
//                        ResponseInfo<LoginController.TokenInfo> result = new ResponseInfo<LoginController.TokenInfo>(ErrorCode.ERROR_ACCESS_DENY);
//                        String json = gson.toJson(result);
//                        response.setContentType("application/json; charset=UTF-8");
//                        response.getWriter().print(json);
//                    }
//                });
//    }
//
//
////    @Bean
////    AccessDeniedHandler accessDeniedHandler() {
////        AccessDeniedHandlerImpl accessDeniedHandler = new AccessDeniedHandlerImpl();
////        accessDeniedHandler.setErrorPage("/securityException/accessDenied");
////        return accessDeniedHandler;
////    }
////
////    @Bean
////    AuthenticationSuccessHandler authenticationSuccessHandler(){
////        SimpleUrlAuthenticationSuccessHandler handler=new SimpleUrlAuthenticationSuccessHandler();
////        return handler;
////    }
//}
