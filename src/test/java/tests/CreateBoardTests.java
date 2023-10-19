package tests;

import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateBoardTests extends BaseTest{

    @BeforeClass
    public void preconditions() {
        //go to https://trello.com/u/juliagordyin/boards
        ApplicationManager.goToBoardPage((userDTO.getEmail().split("@"))[0]);
     //   System.out.println(((userDTO.getEmail().split("@"))[0]));
        if(!loginHelper.isElementWorkspaceExist()) {
            ApplicationManager.toMainPage();
            loginHelper.login(userDTO);
        }
        deleteBoardHelper.deleteAllBoards(userDTO);
    }

    @Test
    public void createBoardPositive() {
        String boardName = randomUtils.createString(5);
        createBoardHelper.createNewBoard(boardName);
        Assert.assertTrue(createBoardHelper.validateTitleBoardName(boardName));
    }

    @AfterMethod
    public void postConditions() {
        ApplicationManager.goToBoardPage((userDTO.getEmail().split("@"))[0]);
    }
}
