package tests;

import manager.ApplicationManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteBoardsTests extends BaseTest {

    @BeforeMethod
    public void preconditions() {
        //go to https://trello.com/u/juliagordyin/boards
        ApplicationManager.goToBoardPage((userDTO.getEmail().split("@"))[0]);
        //   System.out.println(((userDTO.getEmail().split("@"))[0]));
        if(!loginHelper.isElementWorkspaceExist()) {
            ApplicationManager.toMainPage();
            loginHelper.login(userDTO);
        }

        // add minimum one board
    }

    @Test
    public void deleteAllBoards() {
        deleteBoardHelper.deleteAllBoards();
    }


}
