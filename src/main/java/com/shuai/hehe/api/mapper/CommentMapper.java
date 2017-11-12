package com.shuai.hehe.api.mapper;

import com.shuai.hehe.api.entity.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *
 */
@Mapper
public interface CommentMapper {
    List<Comment> getCommentList(
            @Param("futuresId") int futuresId,
            @Param("startCommentId") long startCommentId,
            @Param("count") int count,
            @Param("after") int after);

    @Select("SELECT * FROM comment WHERE id=#{id}")
    Comment getComment(long id);

    @Insert("INSERT INTO comment(pid,ppid,futuresId,userId,content,date)" +
            " VALUES(#{pid},#{ppid},#{futuresId},#{uid},#{content},#{time})")
    void addComment(@Param("pid") long pid,
                    @Param("ppid") long ppid,
                    @Param("futuresId") long futuresId,
                    @Param("uid") long uid,
                    @Param("content") String content,
                    @Param("time") long time);

    @Delete("DELETE FROM comment WHERE id=#{id}")
    void deleteComment(int id);
}
