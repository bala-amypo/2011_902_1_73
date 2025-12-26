// package com.example.demo.controller;

// import com.example.demo.model.ApprovalRequest;
// import com.example.demo.service.ApprovalRequestService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/requests")
// public class ApprovalRequestController {
//     private final ApprovalRequestService requestService;

//     public ApprovalRequestController(ApprovalRequestService requestService) {
//         this.requestService = requestService;
//     }

//     @PostMapping
//     public ResponseEntity<ApprovalRequest> create(@RequestBody ApprovalRequest req) {
//         return ResponseEntity.ok(requestService.createRequest(req));
//     }

//     @GetMapping
//     public ResponseEntity<List<ApprovalRequest>> list(@RequestParam(required = false) Long requesterId) {
//         if (requesterId != null) {
//             return ResponseEntity.ok(requestService.getRequestsByRequester(requesterId));
//         }
//         return ResponseEntity.ok(requestService.getAllRequests());
//     }
// }//
