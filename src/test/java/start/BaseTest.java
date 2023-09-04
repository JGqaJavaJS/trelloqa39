package start;

import manager.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    static ApplicationManager app = new ApplicationManager();
    WebDriver driver;

    @BeforeSuite
    public void preConditions() {
        app.init();
        driver = app.getDriver();
    }

    @AfterSuite
    public void postConditions() {
        app.tearDown();
    }

}
