package pages.todoist;

import controlSelenium.Button;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class Login {
    public TextBox userLoginTextbox = new TextBox(By.id("element-0"));
    public TextBox passwordLoginTextbox = new TextBox(By.id("element-3"));
    public Button loginButton = new Button(By.xpath("//button[@data-gtm-id=\"start-email-login\"]"));

    public void login(String user,String pwd){
        userLoginTextbox.setText(user);
        passwordLoginTextbox.setText(pwd);
        loginButton.click();
    }
}
