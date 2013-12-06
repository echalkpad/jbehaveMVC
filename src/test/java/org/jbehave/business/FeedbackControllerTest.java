package org.jbehave.business;

import org.jbehave.web.FeedbackController;
import org.jbehave.web.FeedbackForm;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class FeedbackControllerTest {

    @Mock
    FeedbackService feedbackService;
    @InjectMocks
    FeedbackController feedbackController = new FeedbackController();
    private Model model;
    private FeedbackForm feedbackForm;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        model = new ExtendedModelMap();
        feedbackForm = new FeedbackForm()
                .setFeedbackMessage("some message")
                .setMyName("some sender")
                .setRecipientName("some receiver");
    }

    @Test
    public void shouldAddFeedbackAfterSubmitting() throws Exception {
        feedbackController.submitForm(feedbackForm, model);
        verify(feedbackService).addFeedback(any(Feedback.class));
    }

    @Test
    public void shouldDisplayFeedbackAfterSubmitting() {
        feedbackController.submitForm(feedbackForm, model);
        assertThat(model.containsAttribute("feedbackServiceL"), is(true));
    }
}
