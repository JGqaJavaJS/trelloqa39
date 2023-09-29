package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

   // Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    //WebDriver driver;
    static EventFiringWebDriver driver;
//    LoginHelper loginHelper;
//    LogoutHelper logoutHelper;
//    CreateBoardHelper createBoardHelper;

    public static void init() {
        //driver = new ChromeDriver();
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new WDListener());
      //  logger.info("navigate to the page: " + "https://trello.com/");
        driver.navigate().to("https://trello.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        loginHelper = new LoginHelper();
//        logoutHelper = new LogoutHelper();
//        createBoardHelper = new CreateBoardHelper();
    }

    public static void tearDown() {
       // logger.info("tear down");
        driver.quit();
    }

    public static EventFiringWebDriver getDriver() {
        if(driver == null) {
            init();
        }
        return driver;
    } // better to comment - or to leave and to use only in the src/test/java/start/BaseTest.java


//    public LoginHelper getLoginHelper() {
//        return loginHelper;
//    }
//
//    public LogoutHelper getLogoutHelper() {
//        return logoutHelper;
//    }
//
//    public CreateBoardHelper getCreateBoardHelper() {
//        return createBoardHelper;
//    }

    public static void toMainPage() {
     //   logger.info("navigate to the page: " + "https://trello.com/");
        driver.navigate().to("https://trello.com/");
    }

    public static void goToBoardPage(String emailBeforeDog) {
        // https://trello.com/u/juliagordyin/boards
       // logger.info("navigate to the page: " + "https://trello.com/u/" + emailBeforeDog + "/boards");
        driver.navigate().to("https://trello.com/u/" + emailBeforeDog + "/boards");
    }
}
