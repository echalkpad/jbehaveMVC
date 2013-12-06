package org.jbehave.business;

/**
 * Created with IntelliJ IDEA.
 * User: thoughtworker
 * Date: 12/5/13
 * Time: 4:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class Feedback {

    private final String feedbackMessage;
    private final String giversName;
    private final String recipientName;

    public Feedback(String myName, String recipientName, String feedbackMessage) {
        this.giversName = myName;
        this.recipientName = recipientName;
        this.feedbackMessage = feedbackMessage;

    }

    public String getFeedbackMessage() {
        return feedbackMessage;
    }

    public String getGiversName() {
        return giversName;
    }

    public String getRecipientName() {
        return recipientName;
    }
}
