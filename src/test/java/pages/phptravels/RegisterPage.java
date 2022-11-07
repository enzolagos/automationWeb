package pages.phptravels;

import controlSelenium.*;
import org.openqa.selenium.By;

public class RegisterPage {
    public TextBox firstNameTB = new TextBox(By.id("inputFirstName"),"firstNameTextBox");
    public TextBox lastNameTB = new TextBox(By.id("inputLastName"),"lastNameTextBox");
    public TextBox emailTB = new TextBox(By.id("inputEmail"),"emailTextBox");
    public TextBox phoneTB = new TextBox(By.id("inputPhone"),"phoneTextBox");
    public TextBox addressTB = new TextBox(By.id("inputAddress1"),"inputAddress1");
    public TextBox address2TB = new TextBox(By.id("inputAddress2"),"inputAddress2");
    public TextBox stateTB = new TextBox(By.id("stateinput"),"inputState");
    public TextBox postcodeTB = new TextBox(By.id("inputPostcode"),"inputPostCode");
    public TextBox cityTB = new TextBox(By.id("inputCity"),"inputCity");
    public Control countryOptions = new Control(By.id("inputCountry"),"inputCountry");
    public Button countrySelect = new Button(By.xpath("//*[text()=\"Argentina\"]"),"argentinaOption");
    public TextBox wppNumber = new TextBox(By.id("customfield2"),"whatsappNumber");
    public TextBox passwordTB = new TextBox(By.id("inputNewPassword1"),"inputNewPassword1");
    public TextBox passwordRepeatTB = new TextBox(By.id("inputNewPassword2"),"repeatPassword");
    public Control captchaFrame = new Control(By.xpath("//iframe[@title=\"reCAPTCHA\"]"), "captchaFrame");
    public Button captchaButton = new Button(By.xpath("//div[@class=\"recaptcha-checkbox-border\"]"),"captchaBox");
    public Button registerButton = new Button(By.xpath("//*[@value=\"Register\"]"),"registerButton");

}
