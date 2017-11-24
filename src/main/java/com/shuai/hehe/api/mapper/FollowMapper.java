package com.shuai.hehe.api.mapper;

import com.shuai.hehe.api.entity.Futures;
import com.shuai.hehe.api.response.ResponseInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *
 */
@Mapper
public interface FollowMapper {
    @Insert("REPLACE INTO followed(uid,futuresId) VALUES(#{userId},#{futuresId})")
    void addFollowedFutures(@Param("userId") long userId,
                            @Param("futuresId") int futuresId);

    @Delete("DELETE FROM followed WHERE uid=#{userId} AND futuresId=#{futuresId}")
    void removeFollowedFutures(@Param("userId") long userId,
                               @Param("futuresId") int futuresId);


    @Select("SELECT f.id as id,f.name as name,f.title as title " +
            "FROM futures as f LEFT JOIN followed ON f.id=followed.futuresId" +
            " WHERE followed.uid=#{userId}")
    List<Futures> getFollowedFutures(@Param("userId") long userId);
}
