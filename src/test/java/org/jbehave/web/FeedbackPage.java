package org.jbehave.web;

import org.springframework.beans.factory.annotation.Autowired;


public class FeedbackPage {

    private static final String GIVER_NAME_FIELD = "myName";
    private static final String RECIPIENT_NAME_FIELD = "recipientName";
    private static final String FEEDBACK_MESSAGE_FIELD = "feedbackMessage";

    private static final String GIVER_NAME_VIEW = "myNameView";
    private static final String RECIPIENT_NAME_VIEW = "recipientNameView";
    private static final String FEEDBACK_MESSAGE_VIEW = "feedbackMessageView";

    private static final String SUBMIT_FEEDBACK_FORM_ID = "submitFeedback";

    private String feedbackPageUrl;

    @Autowired
    private PageUtils pageUtils;

    public void open() {
        pageUtils.open(this.feedbackPageUrl);
    }

    public void fillForm(String giverName, String recipientName, String feedback) {
        pageUtils.fillFormField(GIVER_NAME_FIELD, giverName);
        pageUtils.fillFormField(RECIPIENT_NAME_FIELD, recipientName);
        pageUtils.fillFormField(FEEDBACK_MESSAGE_FIELD, feedback);
    }

    public void submitForm() {
        pageUtils.submitForm(SUBMIT_FEEDBACK_FORM_ID);
    }

    public void setFeedbackPageUrl(String url) {
        this.feedbackPageUrl = url;
    }

    public boolean checkFeedbackExists(String feedback) {
        return false;
    }

    public String getFeedbackMessage() {
        return pageUtils.getElementText(FEEDBACK_MESSAGE_VIEW);

    }

    public String getRecipientName() {

        return pageUtils.getElementText(RECIPIENT_NAME_VIEW);
    }

    public String getMyName() {
        return pageUtils.getElementText(GIVER_NAME_VIEW);
    }


    public void close() {
      pageUtils.close();
    }
}
