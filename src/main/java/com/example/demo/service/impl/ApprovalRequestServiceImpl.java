// package com.example.demo.service.impl;

// import com.example.demo.model.ApprovalRequest;
// import com.example.demo.repository.ApprovalRequestRepository;
// import com.example.demo.service.ApprovalRequestService;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import java.util.List;

// @Service
// @Transactional
// public class ApprovalRequestServiceImpl implements ApprovalRequestService {
//     private final ApprovalRequestRepository requestRepository;

//     public ApprovalRequestServiceImpl(ApprovalRequestRepository requestRepository) {
//         this.requestRepository = requestRepository;
//     }

//     @Override
//     public ApprovalRequest createRequest(ApprovalRequest req) {
//         if (req.getStatus() == null) req.setStatus("PENDING");
//         return requestRepository.save(req);
//     }

//     @Override
//     public List<ApprovalRequest> getRequestsByRequester(Long userId) {
//         return requestRepository.findByRequesterId(userId);
//     }

//     @Override
//     public List<ApprovalRequest> getAllRequests() {
//         return requestRepository.findAll();
//     }
// }//
