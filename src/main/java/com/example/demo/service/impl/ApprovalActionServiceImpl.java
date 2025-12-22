package com.example.demo.service.impl;

import com.example.demo.model.ApprovalAction;
import com.example.demo.model.ApprovalRequest;
import com.example.demo.repository.ApprovalActionRepository;
import com.example.demo.repository.ApprovalRequestRepository;
import com.example.demo.service.ApprovalActionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ApprovalActionServiceImpl implements ApprovalActionService {

    private final ApprovalActionRepository approvalActionRepository;
    private final ApprovalRequestRepository approvalRequestRepository;

    public ApprovalActionServiceImpl(
            ApprovalActionRepository approvalActionRepository,
            ApprovalRequestRepository approvalRequestRepository
    ) {
        this.approvalActionRepository = approvalActionRepository;
        this.approvalRequestRepository = approvalRequestRepository;
    }

    @Override
    public ApprovalAction recordAction(ApprovalAction action) {
        action.setActionDate(LocalDateTime.now());

        ApprovalAction savedAction = approvalActionRepository.save(action);

        approvalRequestRepository.findById(action.getRequestId())
                .ifPresent(request -> {
                    if ("APPROVED".equalsIgnoreCase(action.getAction())) {
                        request.setCurrentLevel(request.getCurrentLevel() + 1);
                    } else if ("REJECTED".equalsIgnoreCase(action.getAction())) {
                        request.setStatus("REJECTED");
                    }
                    approvalRequestRepository.save(request);
                });

        return savedAction;
    }
}
