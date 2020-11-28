package com.example.demo.aop;


import com.example.demo.domain.Customer;
import com.example.demo.domain.Log;
import com.example.demo.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;

@Aspect
@Component
public class LogAOP {
    @Autowired
    private LogService logService;

//    create / update
    @Around("execution(public void saveCustomer(..))")
    public void createOrUpdate(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Customer customer = (Customer) proceedingJoinPoint.getArgs()[0];
        boolean exists = logService.exists(customer.getId());

        //until here @Before
        proceedingJoinPoint.proceed();
        // since here @After

        Log log;
        if(!exists){
            log = new Log(customer.getId(), new Timestamp(System.currentTimeMillis()),"Create");
        } else {
            log = new Log(customer.getId(), new Timestamp(System.currentTimeMillis()),"Update");
        }

        logService.saveLog(log);
    }

//    delete
    @Before("execution(public void deleteCustomer(..))")
    public void delete(JoinPoint joinPoint){
        Long customerId = (Long) joinPoint.getArgs()[0];
        Log log = new Log(customerId, new Timestamp(System.currentTimeMillis()),"Delete");
        logService.saveLog(log);
    }
}
