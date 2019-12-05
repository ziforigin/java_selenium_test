//This testContent is managed by Picocontainer module for Cucumber

package utils;

public class TestContext {
    private WebDriverFactory webDriverFactory;
    private PageObjectFactory pageObjectFactory;

    public TestContext(){
        webDriverFactory = new WebDriverFactory();
        pageObjectFactory = new PageObjectFactory(webDriverFactory.getDriver());
    }

    public WebDriverFactory getWebDriverManager() {
        return webDriverFactory;
    }

    public PageObjectFactory getPageObjectFactory() {
        return pageObjectFactory;
    }

}