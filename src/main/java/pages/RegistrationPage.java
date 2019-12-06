package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RegistrationPage {

    WebDriver driver;
    String webUrl = "https://qa-test.vagner.pro/signup";
    public String pageTitle = "qa-test";

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[contains(@name, 'username')][contains(@class, 'form-control form-field')]")
    private WebElement loginInput;

    @FindBy(xpath = "//input[contains(@name, 'password')][contains(@class, 'form-control form-field')]")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[contains(@name, 'email')][contains(@class, 'form-control form-field')]")
    private WebElement emailInput;

    @FindBy(css = ".btn.btn-default.btn-success")
    private WebElement submitBtn;

    public void checkRegistrationPageIsOpened() {
        assertThat("The registration page is not opened", driver.getCurrentUrl(), equalTo(webUrl));
    }

    public void inputTextIntoField(String text, String field) {
        switch (field) {
            case ("Username"):
                loginInput.click();
                loginInput.sendKeys(text);
                break;
            case ("Password"):
                passwordInput.click();
                passwordInput.sendKeys(text);
                break;
            case ("Email"):
                emailInput.click();
                emailInput.sendKeys(text);
                break;
        }
    }

    public void clickSubmitBtn() {
        submitBtn.click();
    }
}

