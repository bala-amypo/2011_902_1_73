package com.example.demo.controller;

import com.example.demo.model.WorkflowStepConfig;
import com.example.demo.service.WorkflowStepConfigService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/steps")
public class WorkflowStepConfigController {

    private final WorkflowStepConfigService stepService;

    public WorkflowStepConfigController(WorkflowStepConfigService stepService) {
        this.stepService = stepService;
    }

    @Operation(summary = "Create workflow step")
    @PostMapping
    public WorkflowStepConfig createStep(@RequestBody WorkflowStepConfig step) {
        return stepService.createStep(step);
    }

    @Operation(summary = "Get steps by template ID")
    @GetMapping("/template/{templateId}")
    public List<WorkflowStepConfig> getStepsForTemplate(@PathVariable Long templateId) {
        return stepService.getStepsForTemplate(templateId);
    }
}
