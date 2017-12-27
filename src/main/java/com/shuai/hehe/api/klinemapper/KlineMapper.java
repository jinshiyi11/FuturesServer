package com.shuai.hehe.api.klinemapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *
 */
@Mapper
public interface KlineMapper {
    @Select("select title from hot_video")
    List<String> getList();
}
