package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.RegistrationPage;
import utils.TestContext;

public class RegistrationPageSteps {
    TestContext testContext;
    RegistrationPage registrationPage;

    public RegistrationPageSteps(TestContext context) {
        testContext = context;
        registrationPage = testContext.getPageObjectFactory().getRegistrationPage();
    }

    @Then("Registration page is opened")
    public void checkRegistrationPageIsOpened() {
        registrationPage.checkRegistrationPageIsOpened();
    }

    @When("^I write '([^\"]*)' value to the '(Username|Password|Email)' field$")
    public void iWriteComputerNameNewComputerPage(String inputText, String fieldName){
        registrationPage.inputTextIntoField(inputText, fieldName);
    }

    @Then("I click Register button")
    public void clickSubmitBtn() {
        registrationPage.clickSubmitBtn();
    }
}

