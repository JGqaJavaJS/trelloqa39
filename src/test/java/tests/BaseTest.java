package tests;

import dto.UserDTO;
import manager.ApplicationManager;
import manager.CreateBoardHelper;
import manager.LoginHelper;
import manager.LogoutHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.RandomUtils;

import java.lang.reflect.Method;
import java.util.Arrays;

public class BaseTest {

    RandomUtils randomUtils = new RandomUtils();

    static ApplicationManager app = new ApplicationManager();

    Logger logger = LoggerFactory.getLogger(BaseTest.class);

    LoginHelper loginHelper = new LoginHelper();
    LogoutHelper logoutHelper = new LogoutHelper();
    CreateBoardHelper createBoardHelper = new CreateBoardHelper();

//    @BeforeMethod(alwaysRun = true)
//    public void startTest(Method method){
//        logger.info("Started test ----> " + method.getName());
//    }
//
//    @AfterMethod(alwaysRun = true)
//    public void stopTest(Method method){
//        logger.info("Finished test ----> " + method.getName());
//    }

    @BeforeMethod(alwaysRun = true)
    public void beforeEachMethod(Method method) {
        logger.info("started method: " + method.getName());
        logger.info("started method with params: " + Arrays.toString(method.getParameters()));
    }

    @AfterMethod(alwaysRun = true)
    public void afterEachMethod(Method method) {
        logger.info("stopped method: " + method.getName());
        logger.info("stopped method with params: " + Arrays.toString(method.getParameters()));
    }


    UserDTO userDTO = new UserDTO("123456Aa$", "juliagordyin@gmail.com");

    @BeforeSuite
    public void preConditions() {
        app.init();
    }

    @AfterSuite
    public void postConditions() {
        app.tearDown();
    }

}
