package com.apnacolor.services;
import java.util.Date;
import java.util.List;

import com.apnacolor.entity.Feedback;

public interface FeedbackService {
    Feedback add(Long userId, Long productId, String message, Date date); // updated

    List<Feedback> getFeedback(Long userId);

    List<Feedback> getFeedbackByProduct(Long productId); // new

    List<Feedback> getAllFeedback();

    Feedback updateMessage(Long id, String message);

    boolean removeFeedback(Long id);
}
