package com.shuai.hehe.api;

import com.shuai.hehe.api.entity.AuthenticatedUser;
import com.shuai.hehe.api.entity.Comment;
import com.shuai.hehe.api.entity.User;
import com.shuai.hehe.api.mapper.CommentMapper;
import com.shuai.hehe.api.response.ErrorCode;
import com.shuai.hehe.api.response.ResponseInfo;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 *
 */
@RestController
@Validated
public class CommentController {
    @Autowired
    private CommentMapper mMapper;

    @GetMapping("api/getAllCommentList")
    @ResponseBody
    public ResponseInfo<List<Comment>> getAllCommentList(
            @RequestParam(value = "startCommentId", defaultValue = "" + Long.MAX_VALUE)
                    long startCommentId,
            @RequestParam(value = "count", defaultValue = "20")
            @Range(min = 10, max = 100, message = "count param invalid") int count,
            @RequestParam(value = "after", defaultValue = "0") int after) {
        if (startCommentId <= 0) {
            startCommentId = Long.MAX_VALUE;
        }
        List<Comment> commentList = mMapper.getAllCommentList(startCommentId, count, after);
        ResponseInfo<List<Comment>> result = new ResponseInfo<>();
        result.setData(commentList);
        return result;
    }

    @GetMapping("api/getCommentList")
    @ResponseBody
    public ResponseInfo<List<Comment>> getCommentList(
            @RequestParam("futuresId") int futuresId,
            @RequestParam(value = "startCommentId", defaultValue = "" + Long.MAX_VALUE)
                    long startCommentId,
            @RequestParam(value = "count", defaultValue = "20")
            @Range(min = 10, max = 100, message = "count param invalid") int count,
            @RequestParam(value = "after", defaultValue = "0") int after) {
        if (startCommentId <= 0) {
            startCommentId = Long.MAX_VALUE;
        }
        List<Comment> commentList = mMapper.getCommentList(futuresId, startCommentId, count, after);
        ResponseInfo<List<Comment>> result = new ResponseInfo<>();
        result.setData(commentList);
        return result;
    }

    @PostMapping("api/addComment")
    @ResponseBody
    public ResponseInfo addComment(
            @RequestParam(value = "pid", defaultValue = "-1") long pid,
            @RequestParam(value = "ppid", defaultValue = "-1") long ppid,
            @RequestParam("futuresId") long futuresId,
            @RequestParam("content") String content) {
        long uid=Utils.getUserId();
        mMapper.addComment(pid, ppid, futuresId, uid, content, new Date().getTime());
        return new ResponseInfo(ErrorCode.ERROR_SUCCESS);
    }

}
