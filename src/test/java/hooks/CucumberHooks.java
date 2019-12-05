package hooks;

import cucumber.api.java.After;
import utils.TestContext;

public class CucumberHooks {
    TestContext testContext;

    public CucumberHooks(TestContext context) {
        testContext = context;
    }

    @After
    public void tearDown() {
        testContext.getWebDriverManager().quitWebDriver();
    }

//    before test is handled by testng runner
}
