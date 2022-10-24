package pages.todoist;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class DeleteTabPage {
    public Button delete = new Button(By.xpath("//*[text()='Delete']"));
}
