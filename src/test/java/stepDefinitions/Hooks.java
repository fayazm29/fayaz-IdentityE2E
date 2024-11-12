package stepDefinitions;

import base.Browser;
import base.DriverContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before()
    public void setup() {
        Browser.launchBrowser();
    }

    @After
    public void tearDown() {
        DriverContext.driver.quit();
    }
}
