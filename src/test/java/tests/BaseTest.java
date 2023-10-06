package tests;

import dto.UserDTO;
import manager.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import utils.RandomUtils;

import java.lang.reflect.Method;
import java.util.Arrays;

@Listeners(TestNgListener.class)
public class BaseTest {

    RandomUtils randomUtils = new RandomUtils();
    Logger logger = LoggerFactory.getLogger(BaseTest.class);

    // static ApplicationManager app = new ApplicationManager();

    LoginHelper loginHelper = new LoginHelper();
    LogoutHelper logoutHelper = new LogoutHelper();
    CreateBoardHelper createBoardHelper = new CreateBoardHelper();

    UserDTO userDTO = new UserDTO("123456Aa$", "juliagordyin@gmail.com");

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

    @BeforeSuite(alwaysRun = true)
    public void preConditions() {
        ApplicationManager.init();
    }

    @AfterSuite(alwaysRun = true)
    public void postConditions() {
        ApplicationManager.tearDown();
    }

}
