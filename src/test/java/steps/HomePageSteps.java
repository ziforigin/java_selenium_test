package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.TestContext;

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
        homePage.warningMessageHasTitle(title);
        homePage.warningMessageHasText(text);
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
}