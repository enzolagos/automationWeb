package cleanTest.todoLy;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.GetProperties;

public class LoginParameterTest extends TestBaseTodoLy{
    @ParameterizedTest
    @CsvSource({
            "enzo222@gmail.com,enzo222",
            "fhr@fhr.com,12345",
            "usertodoly@gmail.com,danger1234"
    })
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
    @Tag("testSuite")
    public void verifyLoginSuccessfully(String user, String password){
        mainPage.loginButton.click();
        loginModal.emailTextBox.setText(user);
        loginModal.passwordTextBox.setText(password);
        loginModal.loginButton.click();
        Assertions.assertTrue(menuSection.logout.isControlDisplayed(),"Error login was not successfully");
    }
}

