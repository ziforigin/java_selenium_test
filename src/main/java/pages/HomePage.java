package pages;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.equalTo;

public class HomePage extends AbstractPage{
    WebDriver driver;
    String webUrl = "https://qa-test.vagner.pro";
    public String pageTitle = "qa-test";

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#shorten")
    public WebElement shortenBtn;

    @FindBy(css = "#show-link-options")
    public WebElement showLinkOptions;

    public void openPage(){
        driver.get(webUrl);
    }

}