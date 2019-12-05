package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

public class WebDriverFactory {

    private WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null) driver = createDriver();
        return driver;
    }

    private WebDriver createDriver() {
        WebDriverManager.getInstance(CHROME).setup();
        return initChrome();
    }

    private WebDriver initChrome() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public void quitWebDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}






