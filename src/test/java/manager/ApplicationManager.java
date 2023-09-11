package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver driver;
    LoginHelper loginHelper;
    LogoutHelper logoutHelper;

    public void init() {
        driver = new ChromeDriver();
        driver.navigate().to("https://trello.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        loginHelper = new LoginHelper(driver);
        logoutHelper = new LogoutHelper(driver);
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

    public LogoutHelper getLogoutHelper() {
        return logoutHelper;
    }

    public void toMainPage() {
        driver.navigate().to("https://trello.com/");
    }
}
