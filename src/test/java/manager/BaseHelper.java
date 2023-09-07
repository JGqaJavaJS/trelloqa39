package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BaseHelper {

    WebDriver driver;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement findElementBase(By by) {
        return driver.findElement(by);
    }

    private List<WebElement> findElementsBase(By by) {
        return driver.findElements(by);
    }

    public boolean isElementExist(By by) {
        return (findElementsBase(by).size() > 0);
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
        if(actualResult.contains(expectedResult)) {
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

}
