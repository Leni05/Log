package com.blog.JavaSpringBoot.log.service.impl;

import java.util.Date;

import com.blog.JavaSpringBoot.log.dto.request.SystemLogRequestDto;
import com.blog.JavaSpringBoot.log.exception.InternalServerErrorException;
import com.blog.JavaSpringBoot.log.model.SystemLog;
import com.blog.JavaSpringBoot.log.repository.SystemLogRepository;
import com.blog.JavaSpringBoot.log.service.SlmService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SlmServiceImpl implements SlmService {

    @Autowired
    private SystemLogRepository systemLogRepository;

    @Override
    public Boolean createLog(SystemLogRequestDto dataLog) {
        try {

            SystemLog log = new SystemLog();

            log.setModule(dataLog.getModule());
            log.setType(dataLog.getType());
            log.setMethod(dataLog.getMethod());
            log.setCode(dataLog.getCode());
            log.setMessage(dataLog.getMessage());
            log.setDescription(dataLog.getDescription());
            log.setTime(dataLog.getTime());
            log.setUser(dataLog.getUser());
            log.setUsername(dataLog.getUsername());
            log.setCreateTime(new Date());
            log.setUpdateTime(new Date());
            log.setDeleteTime(null);
            log.setIsDeleted(0);

            systemLogRepository.save(log);

        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage());
        }

        return true;
    }

    @Override
    public String getMessage() {
        return "Message From SLM";
    }
    
}