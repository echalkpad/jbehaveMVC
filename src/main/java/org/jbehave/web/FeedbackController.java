package org.jbehave.web;

import org.jbehave.business.Feedback;
import org.jbehave.business.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @RequestMapping(value="/feedback", method=RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("feedbackForm", new FeedbackForm());
        return "feedback";
    }

    @RequestMapping(value="/feedback", method=RequestMethod.POST )
    public String submitForm(@ModelAttribute("feedbackForm")FeedbackForm feedbackForm, Model model) {
        Feedback feedback = new Feedback(feedbackForm.getMyName(), feedbackForm.getRecipientName(), feedbackForm.getFeedbackMessage());
        feedbackService.addFeedback(feedback);
        model.addAttribute("feedbackServiceL", feedbackService.getFeedbackList());
        return "feedback";
    }



}

