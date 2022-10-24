package cleanTest.todoLy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends TestBaseTodoLy{
    @Test
    public void verifyLoginSuccessfully(){
        mainPage.loginButton.click();
        loginModal.emailTextBox.setText("enzo222@gmail.com");
        loginModal.passwordTextBox.setText("enzo222");
        loginModal.loginButton.click();

        Assertions.assertTrue(menuSection.logout.isControlDisplayed(),"Error login was not successfully");
    }
}

