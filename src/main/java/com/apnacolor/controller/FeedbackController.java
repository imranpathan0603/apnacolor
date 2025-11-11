package com.apnacolor.controller;

import com.apnacolor.entity.Feedback;
import com.apnacolor.request.FeedbackDto;
import com.apnacolor.services.FeedbackService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    // Add Feedback
    @PostMapping("/add")
    public Feedback addFeedback(@RequestParam Long userId,
                                @RequestParam String message,
                                @RequestParam(required = true) Long productId) {
        // You might want to handle productId in your service layer if you add product association
        // For now, just passing userId and message with date
        return feedbackService.add(userId, productId, message, new Date());
    }

    // Get all Feedback DTOs
    @GetMapping("/all")
    public List<FeedbackDto> getAll() {
        return feedbackService.getAllFeedback().stream()
            .map(fb -> new FeedbackDto(
                fb.getId(),
                fb.getUser().getId(),
                fb.getUser().getUsername(),
                fb.getMessage(),
                fb.getDate(),
                fb.getProduct().getId()
                , fb.getProduct().getName(),
                fb.getProduct().getId()
            ))
            .toList();
    }

    // Get Feedback by userId
    @GetMapping("/user/{userId}")
    public List<Feedback> getFeedbackByUser(@PathVariable Long userId) {
        return feedbackService.getFeedback(userId);
    }

//    // Get Feedback by productId
//    @GetMapping("/product/{productId}")
//    public List<Feedback> getFeedbackByProduct(@PathVariable Long productId) {
//        return feedbackService.getFeedbackByProduct(productId);
//    }
    
    @GetMapping("/product/{productId}")
    public List<FeedbackDto> getFeedbackByProduct(@PathVariable Long productId) {
        return feedbackService.getFeedbackByProduct(productId).stream()
            .map(fb -> new FeedbackDto(
                fb.getId(),
                fb.getUser().getId(),
                fb.getUser().getUsername(),
                fb.getMessage(),
                fb.getDate(),
                fb.getProduct().getId()
              , fb.getProduct().getName(),
              fb.getProduct().getId()
            ))
            .toList();
    }

    // Update Feedback Message
    @PutMapping("/update/{id}")
    public Feedback updateMessage(@PathVariable Long id,
                                  @RequestParam String message) {
        return feedbackService.updateMessage(id, message);
    }

    // Delete Feedback
    @DeleteMapping("/delete/{id}")
    public boolean deleteFeedback(@PathVariable Long id) {
        return feedbackService.removeFeedback(id);
    }
}
