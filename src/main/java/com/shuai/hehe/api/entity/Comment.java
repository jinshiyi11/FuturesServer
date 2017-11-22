package com.shuai.hehe.api.entity;

/**
 * 评论
 */
public class Comment {
    /**
     * 评论id
     */
    private long id;


    private long pid;
    private long ppid;

    /**
     * 期货id
     */
    private long futuresId;

    /**
     * 评论者
     */
    private User user;

    /**
     * 评论内容
     */
    private String content;

    //点赞数
    private int likeCount;

    //评论时间
    private long date;

    /**
     * 被回复的评论,如果不存在,则为null
     */
    private Comment originalComment;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public Comment getOriginalComment() {
        return originalComment;
    }

    public void setOriginalComment(Comment originalComment) {
        this.originalComment = originalComment;
    }
}
