package tests;

import dto.UserDTO;
import dto.UserDtoWith;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestsDTOWith extends BaseTest {

    UserDtoWith userDtoWith = new UserDtoWith()
            .withEmail("juliagordyin@gmail.com")
            .withPassword("123456Aa$");

    @BeforeMethod
    public void preconditions() {
        if(loginHelper.isElementWorkspaceExist()) {
            logoutHelper.logout();
        } else {
            ApplicationManager.toMainPage();
        }
    }

    @Test //(priority = 1)
    public void loginPositive() {
        loginHelper.loginWith(userDtoWith);
        Assert.assertTrue(loginHelper.isTextWorkspaceDisplays());
    }

    @Test
    public void loginNegativePasswordErrorMessage() throws InterruptedException {
        UserDtoWith wrongPasswordUserDto = new UserDtoWith()
                .withEmail("juliagordyin@gmail.com")
                .withPassword("1256Aa$");
        loginHelper.loginWith(wrongPasswordUserDto);
        Assert.assertTrue(loginHelper.isWrongPasswordTextDisplays());
    }

}
