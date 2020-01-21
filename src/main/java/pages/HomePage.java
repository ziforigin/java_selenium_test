package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    WebDriver driver;
    String webUrl = "https://qa-test.vagner.pro/";
    public String pageTitle = "qa-test";

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#shorten")
    private WebElement shortenBtn;

    @FindBy(css = "#show-link-options")
    private WebElement showLinkOptionsBtn;

    private static String resultTextFieldCssLocator = ".result-box";

    private static String shortenAnotherBtnXpathLocator = "//*[contains(text(),'Shorten another')][contains(@class, 'btn')]";

    public void openPage(){
        driver.get(webUrl);
    }

    public void clickOnShortenBtn() {
        shortenBtn.click();
    }

    public void clickOnShowLinkOptionsBtn() {
        showLinkOptionsBtn.click();
    }

    public void checkHomePageIsOpened() {
        waitAndCheckIfPageIsOpened(webUrl);
    }

    public void clickOnShortenAnotherButton() {
        waitDisplayedAndReturnElement("xpath", shortenAnotherBtnXpathLocator).click();
    }

    public String copyResultedShortenedUrl() {
        WebElement resultTextField = waitDisplayedAndReturnElement("css", resultTextFieldCssLocator);
        return resultTextField.getAttribute("Value");
    }


}
