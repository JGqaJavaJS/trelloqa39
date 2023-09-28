package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutHelper extends BaseHelper{
//    public LogoutHelper(WebDriver driver) {
//        super(driver);
//    }

    By openMemberMenuBtn = By.xpath("//button[@data-testid='header-member-menu-button']");
    By inMenuLogoutBtn = By.xpath("//button[@data-testid='account-menu-logout']");
    By logoutBtn = By.xpath("//button[@data-testid='logout-button']");

    public void logout() {
        clickBase(openMemberMenuBtn);
        clickBase(inMenuLogoutBtn);
        clickBase(logoutBtn);
    }
}
