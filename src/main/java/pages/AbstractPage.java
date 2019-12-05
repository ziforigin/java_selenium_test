package pages;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.equalTo;

public class AbstractPage {

    private WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void checkOpened(String pageTitle){
        MatcherAssert.assertThat("Expected page was not opened", driver.getTitle(), equalTo(pageTitle));
    }

    public void clickOnWebElement(WebElement button) {
        button.click();
    }
}
