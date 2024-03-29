package pages;

import auxiliary.RegistratioFormFieldsEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BasePage{

    WebDriver driver;
    String webUrl = "https://qa-test.vagner.pro/signup";
    public String pageTitle = "qa-test";

    public RegistrationPage(WebDriver driver) {
        super(driver);
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

    public void inputWrapperClickAndSend(WebElement webElement, String textToSend) {
        webElement.click();
        webElement.sendKeys(textToSend);
    }

    public void inputTextIntoField(String text, RegistratioFormFieldsEnum field) {
        switch (field) {
            case USERNAME:
                inputWrapperClickAndSend(loginInput, text);
                break;
            case PASSWORD:
                inputWrapperClickAndSend(passwordInput, text);
                break;
            case EMAIL:
                inputWrapperClickAndSend(emailInput, text);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + field);
        }
    }

    public void clickSubmitBtn() {
        submitBtn.click();
    }

    public void checkRegistartionPageIsOpened() {
        waitAndCheckIfPageIsOpened(webUrl);
    }

}

