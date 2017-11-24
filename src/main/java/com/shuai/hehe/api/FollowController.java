package com.shuai.hehe.api;

import com.shuai.hehe.api.entity.Futures;
import com.shuai.hehe.api.mapper.FollowMapper;
import com.shuai.hehe.api.response.ErrorCode;
import com.shuai.hehe.api.response.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */
@RestController
public class FollowController {
    @Autowired
    private FollowMapper mMapper;

    @PostMapping("/api/follow/add")
    @ResponseBody
    public ResponseInfo addFollowedFutures(int futuresId) {
        long userId = Utils.getUserId();
        mMapper.addFollowedFutures(userId, futuresId);
        return new ResponseInfo(ErrorCode.ERROR_SUCCESS);
    }

    @RequestMapping("/api/follow/remove")
    @ResponseBody
    public ResponseInfo removeFollowedFutures(int futuresId) {
        long userId = Utils.getUserId();
        mMapper.removeFollowedFutures(userId, futuresId);
        return new ResponseInfo(ErrorCode.ERROR_SUCCESS);
    }

    @RequestMapping("api/follow/getAll")
    public ResponseInfo<List<Futures>> getFollowedFutures() {
        long userId = Utils.getUserId();
        List<Futures> data = mMapper.getFollowedFutures(userId);

        ResponseInfo<List<Futures>> result = new ResponseInfo<>();
        result.setData(data);
        return result;
    }
}
