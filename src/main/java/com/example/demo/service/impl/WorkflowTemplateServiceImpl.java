// package com.example.demo.service.impl;

// import com.example.demo.model.WorkflowTemplate;
// import com.example.demo.repository.WorkflowTemplateRepository;
// import com.example.demo.service.WorkflowTemplateService;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import java.util.List;
// import java.util.Optional;

// @Service
// @Transactional
// public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {
//     private final WorkflowTemplateRepository templateRepository;

//     public WorkflowTemplateServiceImpl(WorkflowTemplateRepository templateRepository) {
//         this.templateRepository = templateRepository;
//     }

//     @Override
//     public WorkflowTemplate createTemplate(WorkflowTemplate t) {
//         return templateRepository.save(t);
//     }

//     @Override
//     public Optional<WorkflowTemplate> getTemplateById(Long id) {
//         return templateRepository.findById(id);
//     }

//     @Override
//     public List<WorkflowTemplate> getAllTemplates() {
//         return templateRepository.findAll();
//     }

//     @Override
//     public WorkflowTemplate updateTemplate(Long id, WorkflowTemplate t) {
//         WorkflowTemplate existing = templateRepository.findById(id).orElseThrow();
//         existing.setDescription(t.getDescription());
//         existing.setTemplateName(t.getTemplateName());
//         existing.setTotalLevels(t.getTotalLevels());
//         existing.setActive(t.getActive());
//         return templateRepository.save(existing);
//     }

//     @Override
//     public WorkflowTemplate activateTemplate(Long id, boolean active) {
//         WorkflowTemplate existing = templateRepository.findById(id).orElseThrow();
//         existing.setActive(active);
//         return templateRepository.save(existing);
//     }
// }//