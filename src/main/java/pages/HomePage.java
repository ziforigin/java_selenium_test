package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
        assertThat("The home page is not opened", driver.getCurrentUrl(), equalTo(webUrl));
    }
}