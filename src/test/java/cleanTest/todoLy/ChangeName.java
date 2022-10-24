package cleanTest.todoLy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class ChangeName extends TestBaseTodoLy{
    @Test
    public void changeName(){
        mainPage.loginButton.click();
        loginModal.login("enzo222@gmail.com","enzo222");
        String newName = ""+new Date().getTime();

        menuSection.settings.click();
        settingsPage.fullName.setText(newName);
        settingsPage.okButton.click();

        menuSection.settings.click();
        Assertions.assertEquals(newName,settingsPage.fullName.getAttribute("value"),"Error no se ha cambiado el nombre");
    }
}
