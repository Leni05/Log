package com.blog.JavaSpringBoot.log.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.JavaSpringBoot.log.dto.request.SystemLogRequestDto;
import com.blog.JavaSpringBoot.log.exception.InternalServerErrorException;
import com.blog.JavaSpringBoot.log.model.SystemLog;
import com.blog.JavaSpringBoot.log.repository.SystemLogRepository;
import com.blog.JavaSpringBoot.log.service.SlmService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/tests")
public class TestController {

    @Autowired
    private SlmService slmService;
    
    @PostMapping("create")
    public String postCreateLog() {
        SystemLogRequestDto dataLog = new SystemLogRequestDto();
        
        try {
            dataLog.setModule("SLM");
            dataLog.setMethod("postCreateLog");
            dataLog.setType("test");
            dataLog.setCode("200");
            dataLog.setMessage("Test Create Log");
            dataLog.setDescription("Test create log from controller");
            dataLog.setTime("0 ms");
            dataLog.setUser(null);
            dataLog.setUsername(null);

            slmService.createLog(dataLog);

            return "Log Create";
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage());
        }
        
    }
    
}