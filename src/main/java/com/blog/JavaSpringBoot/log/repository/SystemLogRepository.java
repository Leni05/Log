package com.blog.JavaSpringBoot.log.repository;

import com.blog.JavaSpringBoot.log.model.SystemLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemLogRepository extends JpaRepository<SystemLog, Long> {
    
}