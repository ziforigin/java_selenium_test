package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.util.concurrent.TimeUnit;

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

    public void warningMessageIsDisplayed () {
        waitDisplayed(warningMessage);
    }

    public String warningMessageHasTitle() {
        WebElement displayedTitle = warningMessage.findElement(By.cssSelector(warningMessageTitle));
        String displayedTitleText = displayedTitle.getText();
        return displayedTitleText;
    }

    public String warningMessageHasText() {
        WebElement displayedMessageTextElement = warningMessage.findElement(By.cssSelector(warningMessageText));
        String displayedMessageText = displayedMessageTextElement.getText();
        return displayedMessageText;
    }

    public void enterTextIntoInputField(String text) {
        inputTextField.sendKeys(text);
    }

    public void clickOnLabel() {
        label.click();
    }

    public void clickOnAbout() {
        aboutBtn.click();
    }

    public void clickOnSignUp() {
        signUpBtn.click();
    }

    public void clickOnSignIn() {
        signInBtn.click();
    }

    public void waitDisplayedByLocator(String locatorMethod, String locator) {
        Wait wait = new FluentWait(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        switch (locatorMethod) {
            case "css":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
                break;
            case "xpath":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
                break;
        }
    }

    public void waitDisplayed(WebElement webElement) {
        Wait wait = new FluentWait(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public WebElement waitDisplayedAndReturnElement(String locatorMethod, String locator) {
        waitDisplayedByLocator(locatorMethod, locator);
        WebElement webElement;
        switch (locatorMethod) {
            case "css":
                webElement = driver.findElement(By.cssSelector(locator));
                break;
            case "xpath":
                webElement =  driver.findElement(By.xpath(locator));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + locatorMethod);
        }
        return webElement;
    }

    public void waitAndCheckIfPageIsOpened(String pageUrl) {
        Wait wait = new FluentWait(driver)
            .withTimeout(30, TimeUnit.SECONDS)
            .pollingEvery(5, TimeUnit.SECONDS)
            .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.urlMatches(pageUrl));
    }


}
