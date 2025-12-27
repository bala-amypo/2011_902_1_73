// package com.example.demo.service.impl;

// import com.example.demo.model.ApprovalAction;
// import com.example.demo.repository.ApprovalActionRepository;
// import com.example.demo.service.ApprovalActionService;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// @Service
// @Transactional
// public class ApprovalActionServiceImpl implements ApprovalActionService {
//     private final ApprovalActionRepository actionRepository;

//     public ApprovalActionServiceImpl(ApprovalActionRepository actionRepository) {
//         this.actionRepository = actionRepository;
//     }

//     @Override
//     public ApprovalAction recordAction(ApprovalAction action) {
//         return actionRepository.save(action);
//     }
// }//
