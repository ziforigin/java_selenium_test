package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import auxiliary.RegistratioFormFieldsEnum;
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
        registrationPage.checkRegistartionPageIsOpened();
    }

    @When("^I write '([^\"]*)' value to the '([^\"]*)' field$")
    public void iWriteComputerNameNewComputerPage(String inputText, RegistratioFormFieldsEnum fieldName){
        registrationPage.inputTextIntoField(inputText, fieldName);
    }

    @Then("I click Register button")
    public void clickSubmitBtn() {
        registrationPage.clickSubmitBtn();
    }
}

