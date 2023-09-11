package tests;

import org.testng.annotations.BeforeMethod;

public class CreateBoardTests extends BaseTest{

    @BeforeMethod
    public void preconditions() {
        //go to https://trello.com/u/juliagordyin/boards
     //   app.goToBoardPage((userDTO.getEmail().split("@"))[0]);
        if(!app.getLoginHelper().isElementWorkspaceExist()) {
            app.toMainPage();
            app.getLoginHelper().login(userDTO);
        }
    }
}
