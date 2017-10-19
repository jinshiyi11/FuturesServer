package com.shuai.hehe.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 评论
 */
@Entity
public class Comment {
    @Id
    @GeneratedValue
    private long id;
    private long pid;
    private long ppid;

    //期货id
    private long futuresId;

    //评论者id
    private long userId;

    //评论内容
    private String content;

    //点赞数
    private int likeCount;

    //评论时间
    private long commentDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public long getPpid() {
        return ppid;
    }

    public void setPpid(long ppid) {
        this.ppid = ppid;
    }

    public long getFuturesId() {
        return futuresId;
    }

    public void setFuturesId(long futuresId) {
        this.futuresId = futuresId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public long getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(long commentDate) {
        this.commentDate = commentDate;
    }
}
