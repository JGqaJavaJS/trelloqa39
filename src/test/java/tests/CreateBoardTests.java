package tests;

import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateBoardTests extends BaseTest{

    @BeforeMethod
    public void preconditions() {
        //go to https://trello.com/u/juliagordyin/boards
        ApplicationManager.goToBoardPage((userDTO.getEmail().split("@"))[0]);
     //   System.out.println(((userDTO.getEmail().split("@"))[0]));
        if(!loginHelper.isElementWorkspaceExist()) {
            ApplicationManager.toMainPage();
            loginHelper.login(userDTO);
        }
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
