package com.shuai.hehe;

import com.shuai.hehe.api.entity.User;
import com.shuai.hehe.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by as on 2017/9/22.
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository mUserRepository;

    @GetMapping("/user_list")
    public List<User> getUserList(HttpServletRequest request) {
        //request.getRequestDispatcher("").include();
        return mUserRepository.findAll();
    }

    @PostMapping("/add_user")
    public User addUser(@RequestParam(name = "phone") String phone,
                        @RequestParam(name = "password") String password) {
        User user = new User();
        user.setPhone(phone);
        user.setPassword(password);
        return mUserRepository.save(user);
    }
}
