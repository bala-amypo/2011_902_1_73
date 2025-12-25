package com.example.demo.service;

import com.example.demo.model.ApprovalRequest;

import java.util.List;

public interface ApprovalRequestService {
    ApprovalRequest createRequest(ApprovalRequest req);
    List<ApprovalRequest> getRequestsByRequester(Long userId);
    List<ApprovalRequest> getAllRequests();
}
