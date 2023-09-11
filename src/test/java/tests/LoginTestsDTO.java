package tests;

import com.fasterxml.jackson.databind.ser.Serializers;
import dto.UserDTO;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestsDTO extends BaseTest {

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
        app.getLoginHelper().login(userDTO);
//        app.getLoginHelper().clickLoginBtn();
//        app.getLoginHelper().fillEmailInput("juliagordyin@gmail.com");
//        app.getLoginHelper().pause(5000);
//        app.getLoginHelper().fillPasswordInput("123456Aa$");
        Assert.assertTrue(app.getLoginHelper().isTextWorkspaceDisplays());
    }

//    @Test //(priority = 2)
//    public void loginNegativePassword() {
//        UserDTO wrongPasswordUserDto = new UserDTO("123496Aa$", userDTO.getEmail());
//        app.getLoginHelper().login(wrongPasswordUserDto);
////        app.getLoginHelper().clickLoginBtn();
////        app.getLoginHelper().fillEmailInput("juliagordyin@gmail.com");
////        app.getLoginHelper().pause(5000);
////        app.getLoginHelper().fillPasswordInput("123496Aa$");
//        Assert.assertFalse(app.getLoginHelper().isElementWorkspaceExist());
//    }

    @Test
    public void loginNegativePasswordErrorMessage() {
        UserDTO wrongPasswordUserDto = new UserDTO("123496Aa$", "juliagordyin@gmail.com");
        app.getLoginHelper().login(wrongPasswordUserDto);
//        app.getLoginHelper().clickLoginBtn();
//        app.getLoginHelper().fillEmailInput("juliagordyin@gmail.com");
//        app.getLoginHelper().pause(5000);
//        app.getLoginHelper().fillPasswordInput("123496Aa$");
        Assert.assertTrue(app.getLoginHelper().isWrongPasswordTextDisplays());
    }

}
