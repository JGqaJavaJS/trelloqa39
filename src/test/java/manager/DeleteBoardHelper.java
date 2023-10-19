package manager;

import dto.UserDTO;
import dto.UserDtoLombok;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class DeleteBoardHelper extends BaseHelper{

    By boardsOnWorkspacePage = By.xpath("//h3//..//ul[contains(@class, 'boards')]//li[not(@data-testid='create-board-tile')]");
    // //h3//..//ul//li
    By btnBoardActionMenu = By.xpath("//button[@aria-label='Board actions menu']");
    By btnCloseBoard = By.xpath("//button[@aria-label='Close board']");
    By btnCloseBoardRed = By.xpath("//button[@title='Close']");
    By btnDeleteBoard = By.xpath("//button[@data-testid='close-board-delete-board-button']");
    By btnDeleteBoardRed = By.xpath("//button[@data-testid='close-board-delete-board-confirm-button']");
    String btnBoardActionMenuStr = "document.querySelector('[aria-label=\"Board actions menu\"]').click();";
    String btnBoardActionMenuStrName = "document.querySelector('[aria-label=\"Board actions menu\"]').click();";
    String boardName = ""; // [aria-label='VtHg1 (currently active)']::parent
    // [aria-label='VtHg1 (currently active)']/following-sibling::div
    By titleBoardNameBoardsPage = By.xpath(String.format("//a[contains(@title,'%s')]", boardName));
    By btnBoardActionMenuWithNAme = By.xpath(
            String.format("//a[contains(@aria-label,'%s')]/..//button[@aria-label='Board actions menu']", boardName));
    By btnShowMenuBoardPage = By.xpath("//button[@aria-label='Show menu']");
    By btnBoardNameOnBoardPage = By.xpath(String.format("//a[contains(@title, '%s')]", boardName));
    By btnCloseBoardMenu = By.xpath("//a[contains(@class, 'close-board')]");
    By btnCloseBoardFromMenu = By.xpath("//input[@value='Close']");
    By wokrspacePageBoarName = By.xpath(String.format("//a[contains(@href, '%s')]", boardName));

    public void deleteOneBoardByName(String name, UserDTO user) {
        ApplicationManager.goToBoardPage((user.getEmail().split("@"))[0]);
        boardName = name;
        clickBase(boardsOnWorkspacePage);
//        if(!getAttribute(btnBoardNameOnBoardPage, "title").contains("currently active")) {
//            System.out.println("attr: " + getAttribute(btnBoardNameOnBoardPage, "title"));
//            clickBase(btnBoardNameOnBoardPage);
//        }
        clickBase(btnShowMenuBoardPage);
        clickBase(btnCloseBoardMenu);
        clickBase(btnCloseBoardFromMenu);
        clickBase(btnDeleteBoard);
        clickBase(btnDeleteBoardRed);
    }

    public void deleteAllBoards(UserDTO user) {
        ApplicationManager.goToBoardPage((user.getEmail().split("@"))[0]);
        List<WebElement> list = findElementsBase(boardsOnWorkspacePage);
        int sizeBoards = list.size();
        for(int i = 0; i < sizeBoards; i++) {
            clickBase(boardsOnWorkspacePage);
            //clickBase(btnBoardActionMenu);
            jsClick(btnBoardActionMenuStr);
            clickBase(btnCloseBoard);
            clickBase(btnCloseBoardRed);
            clickBase(btnDeleteBoard);
            clickBase(btnDeleteBoardRed);
        }
    }

    public boolean validateAllBoardsDeleted() {
        return isElementExist(boardsOnWorkspacePage, 60);
    }

    public boolean validateBoardByNameDeleted(String name, UserDTO user) {
        ApplicationManager.goToBoardPage((user.getEmail().split("@"))[0]);
        boardName = name;
        return isElementExist(wokrspacePageBoarName, 60);
    }
}
