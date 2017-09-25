package com.shuai.hehe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by as on 2017/9/22.
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository mUserRepository;

    @GetMapping("/user_list")
    public List<User> getUserList() {
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
