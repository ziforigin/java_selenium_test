package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ShortenPage;
import utils.TestContext;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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

    @Then("I open the page using the shortened link and verify it's the same page '([^\"]*)'")
    public void openShortenedLink(String fullPageUrl) {
        String pageShortenedUrl = shortenPage.copyResultedShortenedUrl();
        shortenPage.openPageByUrl(pageShortenedUrl);
        String openedPageUrl = shortenPage.getCurrentUrl();
        assertThat("Initial page is not opened", openedPageUrl, equalTo(fullPageUrl));
    }
}





