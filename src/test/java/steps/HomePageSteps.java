package steps;

import cucumber.api.java.en.Given;
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
}