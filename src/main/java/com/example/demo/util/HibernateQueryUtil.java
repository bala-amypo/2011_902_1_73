package com.example.demo.util;

import com.example.demo.model.ApprovalAction;
import com.example.demo.repository.ApprovalActionRepository;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class HibernateQueryUtil {
    private final ApprovalActionRepository actionRepository;

    public HibernateQueryUtil(ApprovalActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }

    public List<ApprovalAction> findActionsByApproverUsingCriteria(Long approverId) {
        if (approverId == null) return Collections.emptyList();
        return actionRepository.findByApproverId(approverId);
    }
}
