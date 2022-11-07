package cleanTest.todoLy;

import io.qameta.allure.*;

import org.junit.jupiter.api.*;
import utils.GetProperties;

@Tag("SmokeTest")
public class LoginTest extends TestBaseTodoLy{
    @Test
    @Order(1)
    @DisplayName("Verify user can login successfully")
    @Description("This test case is to verify user can login in the page with a preset user and password")
    @Owner("Enzodado")
    @Link("www.jira.com/doc01")
    @Issue("www.jira.com/bug01")
    @Epic("Login")
    @Feature("Authentication")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Story login")

    public void verifyLoginSuccessfully(){
        mainPage.loginButton.click();
        loginModal.emailTextBox.setText(GetProperties.getInstance().getUser());
        loginModal.passwordTextBox.setText(GetProperties.getInstance().getPwd());
        loginModal.loginButton.click();
        Assertions.assertTrue(menuSection.logout.isControlDisplayed(),"Error login was not successfully");
    }
}

