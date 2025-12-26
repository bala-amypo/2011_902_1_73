package com.example.demo.util;

import com.example.demo.model.ApprovalAction;
import com.example.demo.repository.ApprovalActionRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import java.util.List;

@Component
@Transactional
public class HibernateQueryUtil {
    
    @Autowired
    private EntityManager entityManager;
    
    public List<ApprovalAction> findActionsByApproverUsingCriteria(Long approverId) {
        if (approverId == null) {
            return List.of();
        }
        
        Session session = entityManager.unwrap(Session.class);
        Query<ApprovalAction> query = session.createQuery(
            "FROM ApprovalAction a WHERE a.approverId = :approverId", 
            ApprovalAction.class);
        query.setParameter("approverId", approverId);
        return query.getResultList();
    }
}
