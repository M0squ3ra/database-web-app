package com.example.demo.service;

import com.example.demo.domain.Log;

public interface LogService {
    public void saveLog(Log log);
    public boolean exists(long id);
}
