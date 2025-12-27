package com.example.demo.controller;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.service.WorkflowTemplateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/templates")
public class WorkflowTemplateController {

    private final WorkflowTemplateService templateService;

    public WorkflowTemplateController(WorkflowTemplateService templateService) {
        this.templateService = templateService;
    }

    @PostMapping
    public ResponseEntity<WorkflowTemplate> create(@RequestBody WorkflowTemplate template) {
        WorkflowTemplate saved = templateService.createTemplate(template);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkflowTemplate> getById(@PathVariable Long id) {
        return templateService.getTemplateById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkflowTemplate> update(@PathVariable Long id, @RequestBody WorkflowTemplate t) {
        WorkflowTemplate updated = templateService.updateTemplate(id, t);
        return ResponseEntity.ok(updated);
    }

    @GetMapping
    public ResponseEntity<List<WorkflowTemplate>> listAll() {
        return ResponseEntity.ok(templateService.getAllTemplates());
    }
}
