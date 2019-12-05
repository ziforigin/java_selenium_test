package utils;

import org.openqa.selenium.WebDriver;
import pages.HomePage;


public class PageObjectFactory {
    private WebDriver driver;
    private HomePage homePage;

    public PageObjectFactory(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage(){
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

}