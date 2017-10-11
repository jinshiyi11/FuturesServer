package com.shuai.hehe.api;

import com.shuai.hehe.api.entity.User;
import com.shuai.hehe.api.entity.VerificationCodeManager;
import com.shuai.hehe.api.repository.UserRepository;
import com.shuai.hehe.api.response.ErrorCode;
import com.shuai.hehe.api.response.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class Register {
    @Autowired
    private UserRepository mUserRepository;

    @Transactional
    @PostMapping("/api/registerByPhone")
    @ResponseBody
    public ResponseInfo register(@RequestParam("phone") String phone,
                                 @RequestParam("password") String password,
                                 @RequestParam("verificationCode") String verificationCode) {
        if (!VerificationCodeManager.getInstance().isValid(phone, verificationCode)) {
            return new ResponseInfo(ErrorCode.ERROR_INVALID_VERIFICATION_CODE);
        }

        User user = mUserRepository.findByPhone(phone);
        if (user == null) {
            user = new User();
            user.setPhone(phone);
            user.setPassword(password);
            mUserRepository.save(user);
            return new ResponseInfo(ErrorCode.ERROR_SUCCESS);
        }

        return new ResponseInfo(ErrorCode.ERROR_USER_ALREADY_EXIST);
    }
}
