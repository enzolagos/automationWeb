package pages.phptravels;

import controlSelenium.Button;
import controlSelenium.Control;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class LoginPage {
    public TextBox emailLogin = new TextBox(By.id("inputEmail"),"inputEmail");
    public TextBox passwordLogin = new TextBox(By.id("inputPassword"),"inputPassword");
    public Control captchaFrame = new Control(By.xpath("//iframe[@title=\"reCAPTCHA\"]"), "captchaFrame");
    public Button captchaButton = new Button(By.xpath("//div[@class=\"recaptcha-checkbox-border\"]"),"captchaBox");
    public Button loginButton = new Button(By.id("login"), "loginButton");
}
