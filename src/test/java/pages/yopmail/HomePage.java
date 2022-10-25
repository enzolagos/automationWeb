package pages.yopmail;

import controlSelenium.Button;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class HomePage {
    public TextBox nameMailTextbox = new TextBox(By.xpath("//*[@class=\"ycptinput\"]"));
    public Button createEmailButton = new Button(By.xpath("//*[@title=\"Check Inbox @yopmail.com\"]"));
}
