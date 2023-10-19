package tests;

import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteBoardsTests extends BaseTest {

    @BeforeClass
    public void preconditions() {
        //go to https://trello.com/u/juliagordyin/boards
        ApplicationManager.goToBoardPage((userDTO.getEmail().split("@"))[0]);
        //   System.out.println(((userDTO.getEmail().split("@"))[0]));
        if(!loginHelper.isElementWorkspaceExist()) {
            ApplicationManager.toMainPage();
            loginHelper.login(userDTO);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        deleteBoardHelper.deleteAllBoards(userDTO);
        // add minimum one board
    }

//    @Test
//    public void deleteAllBoards() {
//        deleteBoardHelper.deleteAllBoards();
//        Assert.assertTrue(deleteBoardHelper.validateAllBoardsDeleted());
//    }

    @Test
    public void deleteOneBoardByName() {
        String boardName = randomUtils.createString(5);
        createBoardHelper.createNewBoard(boardName);
        deleteBoardHelper.deleteOneBoardByName(boardName, userDTO);
        Assert.assertTrue(deleteBoardHelper.validateBoardByNameDeleted(boardName, userDTO));
    }


}
