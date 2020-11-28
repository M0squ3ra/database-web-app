package com.example.demo.service;

import com.example.demo.domain.Log;

import java.util.List;

public interface LogService {
    public void saveLog(Log log);
    public boolean exists(long id);
    public List<Log> getLogs();
}
