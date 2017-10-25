package com.shuai.hehe.api;

import com.shuai.hehe.api.entity.Comment;
import com.shuai.hehe.api.entity.User;
import com.shuai.hehe.api.mapper.CommentMapper;
import com.shuai.hehe.api.response.ErrorCode;
import com.shuai.hehe.api.response.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 *
 */
@RestController
public class CommentController {
    @Autowired
    private CommentMapper mMapper;

    public static class CommentInfo extends Comment {
        User commentUser;
        //CommentInfo originalComment;
    }

    @GetMapping("api/getCommentList")
    @ResponseBody
    public ResponseInfo<List<Comment>> getCommentList(
            @RequestParam("futuresId") int futuresId,
            @RequestParam(value = "startCommentId", defaultValue = "" + Long.MAX_VALUE) long startCommentId) {
        if (startCommentId <= 0) {
            startCommentId = Long.MAX_VALUE;
        }
        List<Comment> commentList = mMapper.getCommentList(futuresId, startCommentId);
        ResponseInfo<List<Comment>> result = new ResponseInfo<>();
        result.setData(commentList);
        return result;
    }

    @PostMapping("api/addComment")
    @ResponseBody
    public ResponseInfo addComment(
            @RequestParam(value = "pid",defaultValue = "-1") long pid,
            @RequestParam(value = "ppid",defaultValue = "-1") long ppid,
            @RequestParam("futuresId") long futuresId,
            @RequestParam("userId") long userId,
            @RequestParam("content") String content) {
        Comment comment = new Comment();
        comment.setPid(pid);
        comment.setPpid(ppid);
        comment.setUserId(userId);
        comment.setContent(content);
        comment.setDate(new Date().getTime());
        mMapper.addComment(comment);
        return new ResponseInfo(ErrorCode.ERROR_SUCCESS);
    }

}
