package com.shuai.hehe.api.repository;

import com.shuai.hehe.api.entity.Comment;
import com.shuai.hehe.api.entity.Futures;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 */
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
