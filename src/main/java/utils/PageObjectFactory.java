package utils;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.RegistrationPage;
import pages.ShortenPage;


public class PageObjectFactory {
    private WebDriver driver;
    private HomePage homePage;
    private ShortenPage shortenPage;
    private RegistrationPage registrationPage;

    public PageObjectFactory(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage(){
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    public ShortenPage getShortenPage(){
        return (shortenPage == null) ? shortenPage = new ShortenPage(driver) : shortenPage;
    }

    public RegistrationPage getRegistrationPage(){
        return (registrationPage == null) ? registrationPage = new RegistrationPage(driver) : registrationPage;
    }

}