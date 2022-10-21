package cleanTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.todoLy.MainPage;

public class ChangeName extends TestBaseTodoLy{
    @Test
    public void changeName(){
        mainPage.loginButton.click();
        loginModal.login("enzo222@gmail.com","enzo222");

        menuSection.settings.click();
        settingsPage.fullName.setText("nuevoNombre");
        settingsPage.okButton.click();

        menuSection.settings.click();
        Assertions.assertEquals("nuevoNombre",settingsPage.fullName.getAttribute("value"),"Error no se ha cambiado el nombre");
    }
}
