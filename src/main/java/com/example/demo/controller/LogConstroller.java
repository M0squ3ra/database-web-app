package com.example.demo.controller;

import com.example.demo.data.LogRepository;
import com.example.demo.domain.Log;
import com.example.demo.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class LogConstroller {

    @Autowired
    private LogService logService;

    @GetMapping("/logs")
    public String showLogs(Model model){
        List<Log> logs = logService.getLogs();

        model.addAttribute("logs",logs);

        return "list-logs";
    }
}
