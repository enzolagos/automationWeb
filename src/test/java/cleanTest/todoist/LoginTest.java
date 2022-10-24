package cleanTest.todoist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class LoginTest extends TestBaseTodoist{
    @Test
    @Order(1)
    public void verifyLoginSuccessfully() throws InterruptedException {
        mainPage.loginButton.click();
        loginModal.userLoginTextbox.setText("enzo.lagos@nybblegroup.com");
        loginModal.passwordLoginTextbox.setText("nybbletesting");
        loginModal.loginButton.click();

        homePage.inboxButton.waitClickable();
        Assertions.assertTrue(homePage.inboxButton.isControlDisplayed(),"Error no se cargo la pagina");

    }
}
