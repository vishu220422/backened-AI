package com.example.loganalyzer.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.loganalyzer.service.LogService;

@RestController
@RequestMapping("/logs")
public class LogController {

    @Autowired
    private LogService logService;

    @PostMapping("/analyze")
    public String analyzeLog(@RequestBody String log) {
        return logService.processLog(log);
    }
}
