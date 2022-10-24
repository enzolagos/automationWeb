package cleanTest.todoLy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class ItemFlow extends TestBaseTodoLy{
    @Test
    public void itemFlow() {
        mainPage.loginButton.click();
        loginModal.login("enzo222@gmail.com","enzo222");

        String nameItem = ""+new Date().getTime();
        homeModal.createItem.setText(nameItem+'\n');
        homeModal.lastItemCreated.waitTextToBe(nameItem);
        Assertions.assertEquals(homeModal.lastItemCreated.getText(),nameItem);

        homeModal.lastItemCreated.click();
        homeModal.lastItemForEdition.setText("editado\n");
        homeModal.lastItemCreated.waitTextToBe("editado");
        Assertions.assertEquals(homeModal.lastItemCreated.getText(),"editado");

        homeModal.lastItemCreated.click();
        homeModal.itemMenu.waitClickable();
        homeModal.itemMenu.click();
        homeModal.deleteButton.waitClickable();
        homeModal.deleteButton.click();
        Assertions.assertTrue(homeModal.lastItemCreated.getText() != "editado", "Error no se elimino");


    }
}
