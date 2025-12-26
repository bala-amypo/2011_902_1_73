package com.example.demo.service;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.repository.WorkflowTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class WorkflowTemplateService {
    
    @Autowired
    private WorkflowTemplateRepository templateRepository;
    
    public WorkflowTemplate createTemplate(WorkflowTemplate template) {
        return templateRepository.save(template);
    }
    
    public Optional<WorkflowTemplate> getTemplateById(Long id) {
        return templateRepository.findById(id);
    }
    
    public WorkflowTemplate updateTemplate(Long id, WorkflowTemplate template) {
        Optional<WorkflowTemplate> existing = templateRepository.findById(id);
        if (existing.isPresent()) {
            template.setId(id);
            return templateRepository.save(template);
        }
        return null;
    }
    
    public WorkflowTemplate activateTemplate(Long id, boolean active) {
        Optional<WorkflowTemplate> existing = templateRepository.findById(id);
        if (existing.isPresent()) {
            WorkflowTemplate template = existing.get();
            template.setActive(active);
            return templateRepository.save(template);
        }
        return null;
    }
    
    public List<WorkflowTemplate> getAllTemplates() {
        return templateRepository.findAll();
    }
}
