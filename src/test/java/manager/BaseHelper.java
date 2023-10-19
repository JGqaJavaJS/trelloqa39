package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseHelper {
    ApplicationManager app = new ApplicationManager();

//    WebDriver driver;
//
//    public BaseHelper(WebDriver driver) {
//        this.driver = driver;
//    }

    private WebElement findElementBase(By by) {
        return app.getDriver().findElement(by);
    }

    protected List<WebElement> findElementsBase(By by) {
        return app.getDriver().findElements(by);
    }

    public boolean isElementExist(By by, int timeout) {
        List<WebElement> list = new ArrayList<>();
        if(timeout == 60) {
            list = findElementsBase(by);
        } else {
            try {
                ApplicationManager.getDriver().manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
                list = findElementsBase(by);
            } catch (Exception e) {
                e.getMessage();
            } finally {
                ApplicationManager.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            }
        }
        return (list.size() > 0);
    }

    public String getAttribute(By locator, String value) {
        return findElementBase(locator).getAttribute(value);
    }

    public void clickBase(By by) {
        WebElement element = findElementBase(by);
        element.click();
    }

    public void sendTextBase(By by, String text) {
        WebElement element = findElementBase(by);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public String getTextBase(By by) {
        WebElement element = findElementBase(by);
        return element.getText().trim().toUpperCase();
    }

    public boolean isElementContainsText(String expectedResult, String actualResult) {
        // return actualResult.contains(expectedResult);
        if (actualResult.contains(expectedResult)) {
            return true;
        } else {
            System.out.println("actual result: " + actualResult +
                    " expected result " + expectedResult);
            return false;
        }
    }

    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void jsClick(String str) {
        JavascriptExecutor js = (JavascriptExecutor) ApplicationManager.getDriver();
        js.executeScript(str);
    }

    public void moveMouseOnElement(By locator) {
        Actions action = new Actions(ApplicationManager.getDriver());
        action.moveToElement(findElementBase(locator)).perform();
    }

}
