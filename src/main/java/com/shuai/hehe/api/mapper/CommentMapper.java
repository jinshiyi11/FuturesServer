package com.shuai.hehe.api.mapper;

import com.shuai.hehe.api.entity.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *
 */
@Mapper
public interface CommentMapper {
    List<Comment> getCommentList(@Param("futuresId") int futuresId, @Param("startCommentId") long startCommentId);

    @Select("SELECT * FROM comment WHERE id=#{id}")
    Comment getComment(long id);

    @Insert("INSERT INTO comment(pid,ppid,futuresId,userId,content,date)" +
            " VALUES(#{pid},#{ppid},#{futuresId},#{userId},#{content},#{date})")
    void addComment(long pid, long ppid, long futuresId, long userId, String content, long time);

    @Delete("DELETE FROM comment WHERE id=#{id}")
    void deleteComment(int id);
}
