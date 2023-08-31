package start;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTestStart {

    WebDriver driver;

    @BeforeClass
    public void preconditions() {
        driver = WebDriverManager.firefoxdriver().create();
        driver.navigate().to("https://trello.com/");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Test
    public void loginPositive() {

    }

    @AfterClass
    public void postConditions() {
      //  driver.quit();
    }


}
