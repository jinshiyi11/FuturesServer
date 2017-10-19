package com.shuai.hehe.api;

import com.shuai.hehe.api.entity.Comment;
import com.shuai.hehe.api.repository.CommentRepository;
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
    private CommentRepository mRepository;

    public static class CommentInfo {

    }

    @GetMapping("api/getCommentList")
    @ResponseBody
    public ResponseInfo<List<CommentInfo>> getCommentList(
            @RequestParam("futuresId") long futuresId,
            @RequestParam(value = "startCommentId", defaultValue = "" + Long.MAX_VALUE) long startCommentId) {
        if (startCommentId <= 0) {
            startCommentId = Long.MAX_VALUE;
        }
//        List<Comment> commentList = mRepository.getCommentList(futuresId, startCommentId);
//        ResponseInfo<List<Comment>> result = new ResponseInfo<>();
//        result.setData(commentList);
//        return result;

        return null;
    }

    @PostMapping("api/addComment")
    @ResponseBody
    public ResponseInfo addComment(
            @RequestParam("pid") long pid,
            @RequestParam("ppid") long ppid,
            @RequestParam("futuresId") long futuresId,
            @RequestParam("userId") long userId,
            @RequestParam("content") String content) {
        Comment comment = new Comment();
        comment.setPid(pid);
        comment.setPpid(ppid);
        comment.setUserId(userId);
        comment.setContent(content);
        comment.setDate(new Date().getTime());
        mRepository.save(comment);
        return new ResponseInfo(ErrorCode.ERROR_SUCCESS);
    }

}
