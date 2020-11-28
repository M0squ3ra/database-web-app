package com.example.demo.service;

import com.example.demo.data.CustomerRepository;
import com.example.demo.data.LogRepository;
import com.example.demo.domain.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService{
    @Autowired
    private LogRepository logRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void saveLog(Log log) {
        logRepository.save(log);
    }

    @Override
    public boolean exists(long id) {
        return customerRepository.existsById(id);
    }
}
