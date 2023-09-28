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
import java.util.List;

import java.util.concurrent.TimeUnit;

public class LoginTestStart extends BaseTest{

    By byBtnLogin = By.xpath("//a[@data-testid='login']");
    By byInputEmail = By.xpath("//input[@id='user']");
    By byBtnConfirmEmail = By.xpath("//input[@id='login']");
    By byInputPassword = By.xpath("//input[@id='password']");
    By byBtnConfirmPassword = By.xpath("//button[@id='login-submit']");
    By byTextWorkSpace = By.xpath("//span[@data-testid='home-team-tab-name']");

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

//    @Test
//    public void loginPositive() {
//        WebElement btnLogin = findElementBase(byBtnLogin);
//        //WebElement btnLogin = driver.findElement(By.xpath("//a[@data-testid='login']"));
//        clickBase(btnLogin);
//        //btnLogin.click();
//
//
//        WebElement inputEmail = findElementBase(byInputEmail);
//       // WebElement inputEmail = driver.findElement(By.xpath("//input[@id='user']"));
//        sendTextBase(inputEmail, "juliagordyin@gmail.com");
////        inputEmail.click();
////        inputEmail.clear();
////        inputEmail.sendKeys("juliagordyin@gmail.com");
//
//        WebElement btnConfirmEmail = findElementBase(byBtnConfirmEmail);
//        clickBase(btnConfirmEmail);
//        //driver.findElement(By.xpath("//input[@id='login']")).click();
//
//        WebElement inputPassword = findElementBase(byInputPassword);
//        //WebElement inputPassword = driver.findElement(By.xpath("//input[@id='password']"));
//        sendTextBase(inputPassword, "123456Aa$");
////        inputPassword.click();
////        inputPassword.clear();
////        inputPassword.sendKeys("123456Aa$");
//
//
//        WebElement btnConfirmPassword = findElementBase(byBtnConfirmPassword);
//       clickBase(btnConfirmPassword);
//        //driver.findElement(By.xpath("//button[@id='login-submit']")).click();
//
//
//        WebElement textWorkSpace = findElementBase(byTextWorkSpace);
////        WebElement textWorkspaceElement =
////                driver.findElement(By.xpath("//span[@data-testid='home-team-tab-name']"));
//
//        String textWorkspace = getTextBase(textWorkSpace);
//        //String textWorkspace = textWorkspaceElement.getText().toUpperCase();
//
//        Assert.assertTrue(isElementContainsText("workspace".toUpperCase(), textWorkspace));
//        //Assert.assertTrue(textWorkspace.contains("workspace".toUpperCase()));
//
//    }
//
//    @Test
//    public void loginNegativePassword() {
//        WebElement btnLogin = findElementBase(byBtnLogin);
//        clickBase(btnLogin);
//
//        WebElement inputEmail = findElementBase(byInputEmail);
//        sendTextBase(inputEmail, "juliagordyin@gmail.com");
//
//        WebElement btnConfirmEmail = findElementBase(byBtnConfirmEmail);
//        clickBase(btnConfirmEmail);
//
//        WebElement inputPassword = findElementBase(byInputPassword);
//        sendTextBase(inputPassword, "123457Aa$");
//
//        WebElement btnConfirmPassword = findElementBase(byBtnConfirmPassword);
//        clickBase(btnConfirmPassword);
//
//List<WebElement> listWithWorkspaceText = findElementsBase(byTextWorkSpace);
//Assert.assertFalse(listWithWorkspaceText.size() > 0); // true =
//
////        WebElement textWorkSpace = findElementBase(byTextWorkSpace);
////        String textWorkspace = getTextBase(textWorkSpace);
////        Assert.assertTrue(isElementContainsText("workspace".toUpperCase(), textWorkspace));
//
//    }
//
////    @AfterClass
////    public void postConditions() {
////        driver.quit();
////    }


}

// Allow by setting MOZ_REMOTE_SETTINGS_DEVTOOLS=1 in the environment
// line 31: WEBGL_debug_renderer_info is deprecated in Firefox and will be removed. Please use RENDERER.
