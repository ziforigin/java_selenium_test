package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".toast")
    protected WebElement warningMessage;

    static protected String warningMessageTitle = ".toast-title";
    static protected String warningMessageText = ".toast-message";

    @FindBy(xpath = "//input[contains(@type, 'url')]")
    protected WebElement inputTextField;

    @FindBy(css = ".navbar-brand")
    private WebElement label;

    @FindBy(xpath = "//*[text()='About']")
    private WebElement aboutBtn;

    @FindBy(xpath = "//ul[@id='navbar'][@class='nav pull-right navbar-nav hidden-xs']/li/a[text()='Sign Up']")
    private WebElement signUpBtn;

    @FindBy(xpath = "//*[text()='Sign In']")
    private WebElement signInBtn;

    public void openPageByUrl(String webUrl) {
        driver.get(webUrl);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void warningMessageIsDisplayed() {
        assertThat("Warning message is not displayed", warningMessage.isDisplayed(), equalTo(Boolean.TRUE));
    }

    public void warningMessageHasTitle(String title) {
//        String displayedTitleText = warningMessageTitle.getText();
        WebElement displayedTitle = warningMessage.findElement(By.cssSelector(warningMessageTitle));
        String displayedTitleText = displayedTitle.getText();
        assertThat("Warning message has wrong title", displayedTitleText, equalTo(title));
    }

    public void warningMessageHasText(String text) {
        WebElement displayedMessageTextElement = warningMessage.findElement(By.cssSelector(warningMessageText));
        String displayedMessageText = displayedMessageTextElement.getText();
        assertThat("Warning message has wrong title", displayedMessageText, equalTo(text));
    }

    public void enterTextIntoInputField(String text) {
        inputTextField.sendKeys(text);
    }

    public void clickOnLabel(){
        label.click();
    }

    public void clickOnAbout(){
        aboutBtn.click();
    }

    public void clickOnSignUp(){
        signUpBtn.click();
    }

    public void clickOnSignIn(){
        signInBtn.click();
    }

}
