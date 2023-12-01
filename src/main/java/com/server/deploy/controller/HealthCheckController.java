package com.server.deploy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthCheckController {

    @Value("${serverName}")
    private String serverName;
    @Value("${server.env}")
    private String env;
    private Integer visitedCount = 0;

    @GetMapping("/hc")
    public ResponseEntity<?> healthCheck() {
        visitedCount++; // 메소드 실행될때마다 무조건 1씩 증가

        Map<String, Object> healthCheckData = new HashMap<>();

        healthCheckData.put("actor", "박지영");
        healthCheckData.put("servername", serverName);
        healthCheckData.put("env", env);
        healthCheckData.put("visitedCount", visitedCount);

        return ResponseEntity.ok(healthCheckData);
    }

    @GetMapping("/env")
    public ResponseEntity<String> getEnv() {
        return ResponseEntity.ok(env);
    }

}