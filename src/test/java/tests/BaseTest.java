package tests;

import dto.UserDTO;
import manager.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    static ApplicationManager app = new ApplicationManager();
    UserDTO userDTO = new UserDTO("123456Aa$", "juliagordyin@gmail.com");

    @BeforeSuite
    public void preConditions() {
        app.init();
    }

    @AfterSuite
    public void postConditions() {
        app.tearDown();
    }

}
