package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateBoardHelper extends BaseHelper{
  //  public CreateBoardHelper(WebDriver driver) {
//        super(driver);
//    }

    By createNewBoardBtn = By.xpath("//div[@class='board-tile mod-add']");
    By inputBoardName = By.xpath("//input[@data-testid='create-board-title-input']");
    By btnCreateBoardAfterEnteringName = By.xpath("//button[@data-testid='create-board-submit-button']");
    By titleBoardName = By.xpath("//h1[@data-testid='board-name-display']");


    public void createNewBoard(String boardName) {
        clickBase(createNewBoardBtn);
        sendTextBase(inputBoardName, boardName);
        clickBase(btnCreateBoardAfterEnteringName);
        /*
        1. click on createNewBoardBtn
        2. inputBoardName type board name
        3. click btnCreateBoardAfterEnteringName
         */
    }

    public boolean validateTitleBoardName(String boardName) {
       return isElementContainsText(boardName.toUpperCase(), getTextBase(titleBoardName));
    }
}
