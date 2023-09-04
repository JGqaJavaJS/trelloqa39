package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver driver;

    public void init() {
        driver = new ChromeDriver();
        driver.navigate().to("https://trello.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    public void tearDown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }


}
