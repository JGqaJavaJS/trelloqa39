package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class DeleteBoardHelper extends BaseHelper{

    By boardsOnWorkspacePage = By.xpath("//h3//..//ul[contains(@class, 'boards')]//li");
    // //h3//..//ul//li
    By btnBoardActionMenu = By.xpath("//button[@aria-label='Board actions menu']");
    By btnCloseBoard = By.xpath("//button[@aria-label='Close board']");
    By btnCloseBoardRed = By.xpath("//button[@title='Close']");
    By btnDeleteBoard = By.xpath("//button[@data-testid='close-board-delete-board-button']");
    By btnDeleteBoardRed = By.xpath("//button[@data-testid='close-board-delete-board-confirm-button']");

    public void deleteOneBoardByName(String name) {


    }

    public void deleteAllBoards() {
        List<WebElement> list = findElementsBase(boardsOnWorkspacePage);
        int sizeBoards = list.size()-1;
        for(int i = 0; i < sizeBoards; i++) {
            clickBase(boardsOnWorkspacePage);
            clickBase(btnBoardActionMenu);
            clickBase(btnCloseBoard);
            clickBase(btnCloseBoardRed);
            clickBase(btnDeleteBoard);
            clickBase(btnDeleteBoardRed);
        }
    }

    public boolean validateAllBoardsDeleted() {
        return false;
    }

    public boolean validateBoardByNameDeleted(String name) {
        return false;
    }
}
