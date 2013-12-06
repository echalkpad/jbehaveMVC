package org.jbehave.web;

public class  FeedbackForm {

    private String myName;

    private String recipientName;
    private String feedbackMessage;

    public String getMyName() {
        return myName;
    }

    public FeedbackForm setMyName(String myName) {
        this.myName = myName;
        return this;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public FeedbackForm setRecipientName(String recipientName) {
        this.recipientName = recipientName;
        return this;
    }

    public String getFeedbackMessage() {
        return feedbackMessage;
    }

    public FeedbackForm setFeedbackMessage(String feedbackMessage) {
        this.feedbackMessage = feedbackMessage;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FeedbackForm that = (FeedbackForm) o;

        if (!myName.equals(that.myName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return myName.hashCode();
    }
}
