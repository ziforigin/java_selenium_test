package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ShortenPage;
import utils.TestContext;

public class ShortenPageSteps {TestContext testContext;
    ShortenPage shortenPage;

    public ShortenPageSteps(TestContext context) {
        testContext = context;
        shortenPage = testContext.getPageObjectFactory().getShortenPage();
    }

    @Then("Shorten page is opened")
    public void checkShortenPageIsOpened() {
        shortenPage.checkShortenPageIsOpened();
    }

    @And("Shorten another button is shown")
    public void shortenAnotherBtnIsDisplayed() {
        shortenPage.shortenAnotherBtnIsDisplayed();
    }

    @When("I click on 'shorten another' button on shorten page")
    public void clickOnShortenAnotherButton() {
        shortenPage.clickOnShortenAnotherButton();
    }
}





