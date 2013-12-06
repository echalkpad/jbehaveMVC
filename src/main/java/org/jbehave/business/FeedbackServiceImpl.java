package org.jbehave.business;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: thoughtworker
 * Date: 12/5/13
 * Time: 4:36 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class FeedbackServiceImpl implements FeedbackService {
    ArrayList<Feedback> feedbackList;

    public FeedbackServiceImpl() {
        feedbackList = new ArrayList<Feedback>();
    }

    @Override
    public void addFeedback(Feedback feedback) {
        feedbackList.add(feedback);
    }

    @Override
    public ArrayList<Feedback> getFeedbackList() {
        return this.feedbackList;
    }
}
