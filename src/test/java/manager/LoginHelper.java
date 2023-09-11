package manager;

import com.fasterxml.jackson.databind.ser.Serializers;
import dto.UserDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHelper extends BaseHelper {
    public LoginHelper(WebDriver driver) {
        super(driver);
    }

    By byBtnLogin = By.xpath("//a[@data-testid='login']");
    By byInputEmail = By.xpath("//input[@id='user']");
    By byBtnConfirmEmail = By.xpath("//input[@id='login']");
    By byInputPassword = By.xpath("//input[@id='password']");
    By byBtnConfirmPassword = By.xpath("//button[@id='login-submit']");
    By byTextWorkSpace = By.xpath("//span[@data-testid='home-team-tab-name']");
    By byErrorPassword = By.xpath("//div[@data-testid='form-error--content']//span//span");

    public void clickLoginBtn() {
        clickBase(byBtnLogin);
    }

    public void fillEmailInput(String email) {
        sendTextBase(byInputEmail, email);
        clickBase(byBtnConfirmEmail);
    }

    public void fillPasswordInput(String password) {
        sendTextBase(byInputPassword, password);
        clickBase(byBtnConfirmPassword);
    }

    public boolean isTextWorkspaceDisplays() {
        String actualRes = getTextBase(byTextWorkSpace);
        return isElementContainsText("workspace".toUpperCase(), actualRes);
    }

    public boolean isElementWorkspaceExist() {
        return isElementExist(byTextWorkSpace);
    }

    public boolean isWrongPasswordTextDisplays() {
        String actualRes = getTextBase(byErrorPassword);
        return isElementContainsText("Incorrect email address and / or password.".toUpperCase(), actualRes);
    }

    public void login(UserDTO userDTO) {
        clickLoginBtn();
        fillEmailInput(userDTO.getEmail());
        pause(5000);
        fillPasswordInput(userDTO.getPassword());
    }
}
