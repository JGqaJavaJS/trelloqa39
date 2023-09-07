package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver driver;
    LoginHelper loginHelper;

    public void init() {
        driver = new ChromeDriver();
        driver.navigate().to("https://trello.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        loginHelper = new LoginHelper(driver);
    }

    public void tearDown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    } // better to comment - or to leave and to use only in the src/test/java/start/BaseTest.java


    public LoginHelper getLoginHelper() {
        return loginHelper;
    }
}
