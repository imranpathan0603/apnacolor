package com.apnacolor.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apnacolor.entity.Feedback;
import com.apnacolor.entity.User;
import com.apnacolor.entity.Product;
import com.apnacolor.repository.FeedbackRepository;
import com.apnacolor.repository.UserRepository;
import com.apnacolor.repository.ProductRepository;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepo;
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Feedback add(Long userId, Long productId, String message, Date date) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Feedback feedback = new Feedback();
        feedback.setUser(user);
        feedback.setProduct(product);
        feedback.setMessage(message);
        feedback.setDate(date);

        return feedbackRepo.save(feedback);
    }

    @Override
    public List<Feedback> getFeedback(Long userId) {
        return feedbackRepo.findByUserId(userId);
    }

    @Override
    public List<Feedback> getAllFeedback() {
        return feedbackRepo.findAll();
    }

    @Override
    public Feedback updateMessage(Long id, String newMessage) {
        Optional<Feedback> optionalFeedback = feedbackRepo.findById(id);
        if (optionalFeedback.isPresent()) {
            Feedback feedback = optionalFeedback.get();
            feedback.setMessage(newMessage);
            return feedbackRepo.save(feedback);
        }
        return null;
    }

    @Override
    public boolean removeFeedback(Long id) {
        if (feedbackRepo.existsById(id)) {
            feedbackRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Feedback> getFeedbackByProduct(Long productId) {
        return feedbackRepo.findByProductId(productId);
    }


}
