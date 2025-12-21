package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.WorkflowTemplate;
import com.example.demo.repository.WorkflowTemplateRepository;
import com.example.demo.service.WorkflowTemplateService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {

    private final WorkflowTemplateRepository workflowTemplateRepository;

    public WorkflowTemplateServiceImpl(
            WorkflowTemplateRepository workflowTemplateRepository
    ) {
        this.workflowTemplateRepository = workflowTemplateRepository;
    }

    @Override
    public WorkflowTemplate createTemplate(WorkflowTemplate template) {
        if (template.getActive() == null) {
            template.setActive(false);
        }
        return workflowTemplateRepository.save(template);
    }

    @Override
    public Optional<WorkflowTemplate> getTemplateById(Long id) {
        return workflowTemplateRepository.findById(id);
    }

    @Override
    public List<WorkflowTemplate> getAllTemplates() {
        return workflowTemplateRepository.findAll();
    }

    @Override
    public WorkflowTemplate updateTemplate(Long id, WorkflowTemplate template) {
        WorkflowTemplate existing = workflowTemplateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Template not found"));

        existing.setTemplateName(template.getTemplateName());
        existing.setDescription(template.getDescription());
        existing.setTotalLevels(template.getTotalLevels());

        return workflowTemplateRepository.save(existing);
    }

    @Override
    public WorkflowTemplate activateTemplate(Long id, boolean active) {
        WorkflowTemplate template = workflowTemplateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Template not found"));

        template.setActive(active);
        return workflowTemplateRepository.save(template);
    }
}
