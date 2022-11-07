package pages.todoLy;

import controlSelenium.Button;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class SettingsPage {
    public TextBox fullName = new TextBox(By.id("FullNameInput"),"fullnameTextbox");
    public Button okButton = new Button(By.xpath("//span[text()='Ok']"),"okButton");
}
