package com.shuai.hehe.api.repository;

import com.shuai.hehe.api.entity.Futures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 *
 */
public interface FuturesRepository extends JpaRepository<Futures, Long> {
    @Query(value = "select o from Futures o where o.name like %?1% or o.title like %?1% limit 10")
    List<Futures> searchFutures(String key);

    @Query(value = "select o from Futures o where o.name like %:key% or o.title like %:key% limit 10")
    List<Futures> searchFutures2(String key);
}
