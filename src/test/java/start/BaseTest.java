package start;

import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.util.List;

public class BaseTest {

//    static ApplicationManager app = new ApplicationManager();
//    WebDriver driver;
//
//    @BeforeSuite
//    public void preConditions() {
//        app.init();
//        driver = app.getDriver();
//    }
//
//    @AfterSuite
//    public void postConditions() {
//        app.tearDown();
//    }
//
//    //--------------------------------------------
//
//    public WebElement findElementBase(By by) {
//        return driver.findElement(by);
//    }
//
//    public List<WebElement> findElementsBase(By by) {
//        return driver.findElements(by);
//    }
//
//    public void clickBase(WebElement element) {
//        element.click();
//    }
//
//    public void sendTextBase(WebElement element, String text) {
//        clickBase(element);
//        element.clear();
//        element.sendKeys(text);
//    }
//
//    public String getTextBase(WebElement element) {
//        return element.getText().trim().toUpperCase();
//    }
//
//    public boolean isElementContainsText(String expectedResult, String actualResult) {
//       // return actualResult.contains(expectedResult);
//        if(actualResult.contains(expectedResult)) {
//            return true;
//        } else {
//            System.out.println("actual result: " + actualResult +
//                    " expected result " + expectedResult);
//            return false;
//        }
//    }

}
