package com.shuai.hehe.api;

import com.shuai.hehe.api.entity.User;
import com.shuai.hehe.api.mapper.UserMapper;
import com.shuai.hehe.api.response.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class UserController {
    @Autowired
    private UserMapper mUserMapper;

    @RequestMapping("/api/user/profile")
    @ResponseBody
    ResponseInfo<User> getUserInfo() {
        ResponseInfo<User> result = new ResponseInfo<>();
        long uid = Utils.getUserId();
        User user = mUserMapper.getUser(uid);
        //删掉密码
        user.setPassword(null);
        result.setData(user);
        return result;
    }
}
