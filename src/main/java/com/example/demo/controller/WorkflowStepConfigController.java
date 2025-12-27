package com.example.demo.controller;

import com.example.demo.model.WorkflowStepConfig;
import com.example.demo.service.WorkflowStepConfigService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/steps")
public class WorkflowStepConfigController {
    private final WorkflowStepConfigService stepService;

    public WorkflowStepConfigController(WorkflowStepConfigService stepService) {
        this.stepService = stepService;
    }

    @PostMapping
    public ResponseEntity<WorkflowStepConfig> create(@RequestBody WorkflowStepConfig step) {
        return ResponseEntity.ok(stepService.createStep(step));
    }

    @GetMapping("/template/{templateId}")
    public ResponseEntity<List<WorkflowStepConfig>> getForTemplate(@PathVariable Long templateId) {
        return ResponseEntity.ok(stepService.getStepsForTemplate(templateId));
    }
}
