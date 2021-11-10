package com.ratz.springsecuritybasics.services;


import com.ratz.springsecuritybasics.Entity.Notice;
import com.ratz.springsecuritybasics.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService{


    @Autowired
    private NoticeRepository repository;

    @Override
    public List<Notice> findAllActiveNotices() {
        return repository.findAllActiveNotices();
    }
}
