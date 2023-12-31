package tests;

import data.ProviderDataLogin;
import dto.UserDtoLombok;
import dto.UserDtoWith;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestsDTOLombok extends BaseTest {

    UserDtoLombok userDtoWith = UserDtoLombok.builder()
            .email("juliagordyin@gmail.com")
            .password("123456Aa$")
            .build();

    @BeforeMethod
    public void preconditions() {
        if(loginHelper.isElementWorkspaceExist()) {
            logoutHelper.logout();
        } else {
            ApplicationManager.toMainPage();
        }
    }

    @Test (groups = {"smoke"})//(priority = 1)
    public void loginPositive() {
        loginHelper.loginLombok(userDtoWith);
        Assert.assertTrue(loginHelper.isTextWorkspaceDisplays());
    }

    @Test (dataProvider = "usersPositiveData", dataProviderClass = ProviderDataLogin.class)
    public void loginPositiveDataProvider(UserDtoLombok user) {
        loginHelper.loginLombok(user);
        Assert.assertTrue(loginHelper.isTextWorkspaceDisplays());
    }

    @Test
    public void loginNegativePasswordErrorMessage() {
        UserDtoLombok userDtoWithNegative = UserDtoLombok.builder()
                .email("juliagordyin@gmail.com")
                .password("1256Aa$")
                .build();
        loginHelper.loginLombok(userDtoWithNegative);
        Assert.assertTrue(loginHelper.isWrongPasswordTextDisplays());
    }

    @Test(dataProvider = "loginCSV", dataProviderClass = ProviderDataLogin.class)
    public void loginWithWrongEmail(UserDtoLombok user1) {
        loginHelper.clickLoginBtn();
        loginHelper.fillEmailInput(user1.getEmail());
        Assert.assertTrue(loginHelper.validateSignUpTextOnBtnDisplays());
    }

}
