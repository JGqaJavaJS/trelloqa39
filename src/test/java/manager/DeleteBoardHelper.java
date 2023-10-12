package manager;

import org.openqa.selenium.By;

public class DeleteBoardHelper extends BaseHelper{

    By listWithAllBoards = By.xpath("//h3//..//ul[contains(@class, 'boards')]//li");
    // //h3//..//ul//li

    public void deleteOneBoardByName(String name) {

    }

    public void deleteAllBoards() {

    }

    public boolean validateAllBoardsDeleted() {
        return false;
    }

    public boolean validateBoardByNameDeleted(String name) {
        return false;
    }
}
