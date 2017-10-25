package com.shuai.hehe.api.mapper;

import com.shuai.hehe.api.entity.Futures;
import com.shuai.hehe.api.response.ResponseInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

/**
 *
 */
@Mapper
public interface FuturesMapper {
    @Select("SELECT * FROM futures")
    List<Futures> getFuturesList();

    @Select("SELECT * FROM futures WHERE id=#{id}")
    Futures getFutures(int id);

    @Select("SELECT * FROM futures WHERE name LIKE concat('%',#{key},'%') OR title LIKE concat('%',#{key},'%')")
    List<Futures> searchFutures(String key);

    @Insert("INSERT INTO futures(name,title) VALUES(#{name},#{title})")
    void addFutures(Futures futures);

    //TODO:
//    @Update("UPDATE futures SET " +
//            "<if test='name != null'>name = #{name},</if>" +
//            "<if test='title != null'>title = #{title}</if>" +
//            " WHERE id=#{id}")
    @UpdateProvider(type = SqlBuilder.class, method = "buildUpdateSql")
    void updateFutures(Futures futures);

    @Delete("DELETE FROM futures WHERE id=#{id}")
    void deleteFutures(int id);

    class SqlBuilder {
        public String buildUpdateSql(final Futures futures) {
            return new SQL() {{
                UPDATE("futures");
                if (futures.getName() != null) {
                    SET("name = #{name}");
                }
                if (futures.getTitle() != null) {
                    SET("title = #{title}");
                }
                WHERE("id=#{id}");
            }}.toString();
        }
    }
}
