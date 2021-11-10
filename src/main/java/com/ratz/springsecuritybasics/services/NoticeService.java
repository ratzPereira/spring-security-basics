package com.ratz.springsecuritybasics.services;

import com.ratz.springsecuritybasics.Entity.Notice;

import java.util.List;

public interface NoticeService {

    List<Notice> findAllActiveNotices();
}
