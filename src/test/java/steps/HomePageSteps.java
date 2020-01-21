package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.TestContext;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class HomePageSteps {
    TestContext testContext;
    HomePage homePage;

    public HomePageSteps(TestContext context) {
        testContext = context;
        homePage = testContext.getPageObjectFactory().getHomePage();
    }

    @Given("I open the Home Page")
    public void openHomePage() {
        homePage.openPage();
    }

    @When("I click on '([^\"]*)' button on home page")
    public void clickOnAbutton(String button) {
        switch(button){
            case "shorten":
                homePage.clickOnShortenBtn();
                break;
            case "link options":
                homePage.clickOnShowLinkOptionsBtn();
                break;
        }
    }

    @Then("I get warning message with '([^\"]*)' title and '([^\"]*)' text")
    public void receivedWarningMessageWithText(String title, String text) {
        homePage.warningMessageIsDisplayed();
        assertThat("Warning message has wrong title", homePage.warningMessageHasTitle(), equalTo(title));
        assertThat("Warning message has wrong text", homePage.warningMessageHasText(), equalTo(text));
    }

    @When("I enter '([^\"]*)' URL into a text box")
    public void enterURLintoInputField(String url) {
        homePage.enterTextIntoInputField(url);

    }

    @Then("Home page is opened")
    public void checkHomePageIsOpened() {
        homePage.checkHomePageIsOpened();
    }

    @When("I click on 'Sign Up' button in the navigation panel")
    public void clickSignUp() {
        homePage.clickOnSignUp();
    }

    @When("I click on 'shorten another' button on shorten page")
    public void clickOnShortenAnotherButton() {
        homePage.clickOnShortenAnotherButton();
    }

    @Then("I open the page using the shortened link and verify it's the same page '([^\"]*)'")
    public void openShortenedLink(String fullPageUrl) {
        String pageShortenedUrl = homePage.copyResultedShortenedUrl();
        homePage.openPageByUrl(pageShortenedUrl);
        String openedPageUrl = homePage.getCurrentUrl();
        assertThat("Initial page is not opened", openedPageUrl, equalTo(fullPageUrl));
    }
}