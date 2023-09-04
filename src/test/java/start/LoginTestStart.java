package start;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTestStart extends BaseTest{

  //  WebDriver driver;

//    @BeforeClass
//    public void preconditions() {
//        driver = new ChromeDriver();
//        //driver = WebDriverManager.firefoxdriver().create();
//        //driver = WebDriverManager.chromedriver().create();
//        driver.navigate().to("https://trello.com/");
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//    }

    @Test
    public void loginPositive() throws InterruptedException {
        WebElement btnLogin = driver.findElement(By.xpath("//a[@data-testid='login']"));
        btnLogin.click();

        WebElement inputEmail = driver.findElement(By.xpath("//input[@id='user']"));
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys("juliagordyin@gmail.com");
        driver.findElement(By.xpath("//input[@id='login']")).click();

        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='password']"));

        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys("123456Aa$");
        driver.findElement(By.xpath("//button[@id='login-submit']")).click();

        WebElement textWorkspaceElement =
                driver.findElement(By.xpath("//span[@data-testid='home-team-tab-name']"));
        String textWorkspace = textWorkspaceElement.getText().toUpperCase();

        Assert.assertTrue(textWorkspace.contains("workspace".toUpperCase()));

    }

//    @AfterClass
//    public void postConditions() {
//        driver.quit();
//    }


}

// Allow by setting MOZ_REMOTE_SETTINGS_DEVTOOLS=1 in the environment
// line 31: WEBGL_debug_renderer_info is deprecated in Firefox and will be removed. Please use RENDERER.
