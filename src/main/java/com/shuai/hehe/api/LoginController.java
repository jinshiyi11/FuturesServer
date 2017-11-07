package com.shuai.hehe.api;

import com.google.gson.Gson;
import com.shuai.hehe.api.entity.User;
import com.shuai.hehe.api.mapper.UserMapper;
import com.shuai.hehe.api.response.ErrorCode;
import com.shuai.hehe.api.response.ResponseInfo;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 */
@RestController
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;
//    @Autowired
//    private SessionAuthenticationStrategy sas;

    @Autowired
    private UserMapper mUserMapper;
    private final OkHttpClient mClient = new OkHttpClient();

    public static class TokenInfo {
        public String token;
        public int expiresIn;
        public String uid;
    }

    private static class OAuth2AccessToken {
        public String access_token;
        public String token_type;
        public int expires_in;
        public String scope;
    }

    public void setUserRepository(UserMapper userMapper) {
        mUserMapper = userMapper;
    }

    @PostMapping("/api/login")
    @ResponseBody
    public ResponseInfo<TokenInfo> login(
            @RequestParam("username") String phone,
            @RequestParam("password") String password,
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {

//        UsernamePasswordAuthenticationToken authToken=new UsernamePasswordAuthenticationToken(phone, password);
//        Authentication authentication=authenticationManager.authenticate(authToken);
////        sas.onAuthentication(authentication, request, response);
//        SecurityContextHolder.getContext().setAuthentication(authentication);

        RequestBody formBody = new FormBody.Builder()
                .add("username", phone)
                .add("password", password)
                .add("grant_type", "password")
                .build();

        String credential = Credentials.basic("ClientId", "secret");
        Request httpRequest = new Request.Builder()
                .url("http://" + request.getServerName() + ":"
                        + request.getServerPort() + "/oauth/token")
                .header("Authorization", credential)
                .post(formBody)
                .build();
        Response httpResponse = mClient.newCall(httpRequest).execute();
        if (httpResponse.code() == HttpServletResponse.SC_OK) {
            String body = httpResponse.body().string();
            Gson gson = new Gson();
            OAuth2AccessToken token = gson.fromJson(body, OAuth2AccessToken.class);

            ResponseInfo<TokenInfo> result = new ResponseInfo<>();
            TokenInfo tokenInfo = new TokenInfo();
            tokenInfo.token = token.access_token;
            tokenInfo.expiresIn = token.expires_in;
            User user = mUserMapper.getByPhone(phone);
            tokenInfo.uid = String.valueOf(user.getId());
            result.setData(tokenInfo);
            return result;
        }

        return new ResponseInfo<TokenInfo>(ErrorCode.ERROR_ACCESS_DENY);
    }
}
