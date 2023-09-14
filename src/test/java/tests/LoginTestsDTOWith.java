package tests;

import dto.UserDTO;
import dto.UserDtoWith;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestsDTOWith extends BaseTest {

    UserDtoWith userDtoWith = new UserDtoWith()
            .withEmail("juliagordyin@gmail.com")
            .withPassword("123456Aa$");

    @BeforeMethod
    public void preconditions() {
        if(app.getLoginHelper().isElementWorkspaceExist()) {
            app.getLogoutHelper().logout();
        } else {
            app.toMainPage();
        }
    }

    @Test //(priority = 1)
    public void loginPositive() {
        app.getLoginHelper().loginWith(userDtoWith);
        Assert.assertTrue(app.getLoginHelper().isTextWorkspaceDisplays());
    }

    @Test
    public void loginNegativePasswordErrorMessage() throws InterruptedException {
        UserDtoWith wrongPasswordUserDto = new UserDtoWith()
                .withEmail("juliagordyin@gmail.com")
                .withPassword("1256Aa$");
        app.getLoginHelper().loginWith(wrongPasswordUserDto);
        Assert.assertTrue(app.getLoginHelper().isWrongPasswordTextDisplays());
    }

}
