package com.apnacolor.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apnacolor.entity.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    
    List<Feedback> findByUserId(Long userId);

    // 💡 New method to get feedback by product
    List<Feedback> findByProductId(Long productId);

    // 💡 Optional: filter by both user and product
    List<Feedback> findByUserIdAndProductId(Long userId, Long productId);
}
