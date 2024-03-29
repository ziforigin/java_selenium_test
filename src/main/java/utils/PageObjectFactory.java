package utils;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.RegistrationPage;


public class PageObjectFactory {
    private WebDriver driver;
    private HomePage homePage;
    private RegistrationPage registrationPage;

    public PageObjectFactory(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage(){
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    public RegistrationPage getRegistrationPage(){
        return (registrationPage == null) ? registrationPage = new RegistrationPage(driver) : registrationPage;
    }

}