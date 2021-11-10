package com.ratz.springsecuritybasics.repository;

import com.ratz.springsecuritybasics.Entity.Notice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends CrudRepository<Notice, Integer> {

    @Query(value = "SELECT * FROM notice_details", nativeQuery = true)
    List<Notice> findAllActiveNotices();
}
