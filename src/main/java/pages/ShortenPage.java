package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShortenPage extends BasePage {
    WebDriver driver;
    String webUrl = "https://qa-test.vagner.pro/shorten";
    public String pageTitle = "qa-test";

    public ShortenPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(text(),'Shorten another')][contains(@class, 'btn')]")
    private WebElement shortenAnotherBtn;

    public void openPage(){
        driver.get(webUrl);
    }

    public void checkShortenPageIsOpened() {
        assertThat("The shorten page is not opened", driver.getCurrentUrl(), equalTo(webUrl));
    }

    public void shortenAnotherBtnIsDisplayed() {
        assertThat("The shorten another button is not shown", shortenAnotherBtn.isDisplayed(), equalTo(Boolean.TRUE));
    }

    public void clickOnShortenAnotherButton() {
        shortenAnotherBtn.click();
    }

}