package com.shuai.hehe.api.mapper;

import com.shuai.hehe.api.entity.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *
 */
@Mapper
public interface CommentMapper {
    @Select("SELECT * FROM comment WHERE futuresId=#{futuresId} AND id<#{startCommentId} ORDER BY date LIMIT 5")
    List<Comment> getCommentList(int futuresId,long startCommentId);

    @Select("SELECT * FROM comment WHERE id=#{id}")
    Comment getComment(long id);

    @Insert("INSERT INTO comment(pid,ppid,futuresId,userId,content,date)" +
            " VALUES(#{pid},#{ppid},#{futuresId},#{userId},#{content},#{date})")
    void addComment(Comment Comment);

    @Delete("DELETE FROM comment WHERE id=#{id}")
    void deleteComment(int id);
}
