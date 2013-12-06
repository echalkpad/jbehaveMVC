package org.jbehave.business;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created with IntelliJ IDEA.
 * User: thoughtworker
 * Date: 12/6/13
 * Time: 8:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class FeedbackServiceImplTest {
    @Test
    public void testAddFeedback() throws Exception {
        FeedbackServiceImpl feedbackService = new FeedbackServiceImpl();
        Feedback feedback = new Feedback("my name", "your name", "your feedback");
        feedbackService.addFeedback(feedback);
        assertThat(feedbackService.feedbackList.get(0).getFeedbackMessage(), is(feedback.getFeedbackMessage()));
    }

    @Test
    public void testGetAllFeedback() throws Exception {

    }
}
