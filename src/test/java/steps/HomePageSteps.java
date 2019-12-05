package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
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
        homePage.checkOpened(homePage.pageTitle);
    }

    @When("I click on '([^\"]*)' button")
    public void clickOnAbutton(String button) {
        switch(button){
            case "shorten":
                homePage.clickOnWebElement(homePage.shortenBtn);
                break;
            case "link options":
                homePage.clickOnWebElement(homePage.showLinkOptions);
                break;
        }
    }
}