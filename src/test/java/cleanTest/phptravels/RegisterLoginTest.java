package cleanTest.phptravels;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import singletonSession.Session;

public class RegisterLoginTest extends TestBase{
    @Test
    public void registerLoginTest() throws InterruptedException {
        //Data
        String firstName = "Enzo";
        String lastName = "Lagos";
        String email = getAlphaNumericString(7)+"@gmail.com";
        String phone = "123456789";
        String address1 = "Calle blabla";
        String address2 = "Calle segunda blabla";
        String state = "Neuquen";
        String postcode = "8305";
        String city = "Neuquen";
        String wppNumber = "123456789";
        String password = getAlphaNumericString(7);

        //Test
        homePage.signUpButton.click();
        Session.getInstance().moveToNextTab();
        Assertions.assertTrue(registerPage.firstNameTB.isControlDisplayed(), "No cambio de tab");

        Session.getInstance().waitURLToChange("https://phptravels.org/register.php");
        registerPage.firstNameTB.setText(firstName);
        registerPage.lastNameTB.setText(lastName);
        registerPage.emailTB.setText(email);
        registerPage.phoneTB.setText(phone);
        registerPage.addressTB.setText(address1);
        registerPage.address2TB.setText(address2);
        registerPage.stateTB.setText(state);
        registerPage.postcodeTB.setText(postcode);
        registerPage.cityTB.setText(city);
        registerPage.wppNumber.setText(wppNumber);
        registerPage.passwordTB.setText(password);
        registerPage.passwordRepeatTB.setText(password);
        Session.getInstance().changeIFrame(registerPage.captchaFrame.getAttribute("name"));
        registerPage.captchaButton.doubleClick();
        Thread.sleep(10000); //captcha
        Session.getInstance().leaveIFrame();
        registerPage.registerButton.click();
        Assertions.assertEquals(Session.getInstance().urlIs(),"https://phptravels.org/clientarea.php", "Error el usuario no s registro");

        mainPage.logoutButton.click();
        Session.getInstance().waitURLToChange("https://phptravels.org/login");
        loginPage.emailLogin.setText(email);
        loginPage.passwordLogin.setText(password);
        Session.getInstance().changeIFrame(loginPage.captchaFrame.getAttribute("name"));
        loginPage.captchaButton.click();
        Thread.sleep(5000); //captcha
        Session.getInstance().leaveIFrame();
        loginPage.loginButton.click();
        Assertions.assertEquals(Session.getInstance().urlIs(),"https://phptravels.org/clientarea.php","El usuario no ha ingresado a la pagina principal");


    }
}
