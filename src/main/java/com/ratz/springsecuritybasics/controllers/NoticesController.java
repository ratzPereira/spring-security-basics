package com.ratz.springsecuritybasics.controllers;

import com.ratz.springsecuritybasics.Entity.Notice;
import com.ratz.springsecuritybasics.services.NoticeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoticesController {

    @Autowired
    private NoticeServiceImpl service;

    @GetMapping("/notices")
    public List<Notice> getNotices() {
        List<Notice> notices = service.findAllActiveNotices();
        if (notices != null ) {
            return notices;
        }else {
            return null;
        }
    }
}
