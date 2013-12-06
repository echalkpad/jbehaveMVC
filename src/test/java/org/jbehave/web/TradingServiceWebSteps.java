package org.jbehave.web;

import org.jbehave.business.Steps;
import org.jbehave.business.StockAlertStatus;
import org.jbehave.core.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@Steps
public class TradingServiceWebSteps {

	@Autowired
	@Qualifier("insertStockPage")
	private InsertStockPage insertStockPage;
	@Autowired
	@Qualifier("showStatusStockPage")
	private ShowStockStatusPage showStockStatusPage;
    @Autowired
    @Qualifier("feedbackPage")
    private FeedbackPage feedbackPage;

    @AfterScenario
    public void tearDown(){
        insertStockPage.close();
        feedbackPage.close();
        showStockStatusPage.close();
    }

    @When("I submit a feedback with my name, '$recipientName' and '$feedback'")
    public void newFeedbackSubmitted(@Named("recipientName") String recipientName, @Named("feedback") String feedback) {
        feedbackPage.open();
        feedbackPage.fillForm("my name", recipientName, feedback);
        feedbackPage.submitForm();
    }

    @Then("I should see '$recipientName'")
    public void shouldDisplayRecipientName(@Named("recipientName") String recipientName) {
        assertThat(feedbackPage.getRecipientName(), is(recipientName));
    }

    @Then("I should see the message '$feedback'")
    public void shouldDisplayFeedback(@Named("feedback") String feedback) {
        assertThat(feedbackPage.getFeedbackMessage(),is(feedback));
    }

    @Then("I should see my '$myName'")
    public void shouldDisplayMyName(@Named("myName") String myName) {
        assertThat(feedbackPage.getMyName(), is(myName));
    }

	@Given("trader starts web application")
	public void aNewStockCreated() {
		insertStockPage.open();
	}
	@When("trader inserts stock <symbol> with threshold <threshold> and trade at <tradeAt>")
	public void newStockDataIsProvided(@Named("symbol")String symbol, @Named("threshold")double threshold, @Named("tradeAt")double tradeAt) {
		insertStockPage.fillForm(symbol, Double.toString(threshold), Double.toString(tradeAt));
		insertStockPage.submitForm();
	}
	@Then("web page should show an <status> message")
	public void stockStatusShouldBeShowed(@Named("status")StockAlertStatus status) {
		assertThat(showStockStatusPage.getStockStatusMessage(), is(status.name()));
	}
}
