package org.jbehave.business;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: thoughtworker
 * Date: 12/5/13
 * Time: 4:33 PM
 * To change this template use File | Settings | File Templates.
 */
public interface FeedbackService {
    public void addFeedback(Feedback feedback);
    public ArrayList<Feedback> getFeedbackList();
}
