package pages.todoist;

import controlSelenium.Button;
import controlSelenium.Control;
import org.openqa.selenium.By;

public class HomePage {
    public Button inboxButton = new Button(By.xpath("//*[text()=\"Inbox\" and @class=\"FnFY2YlPR10DcnOkjvMMmA==\"]"));
    public Button createProjButton = new Button(By.xpath("//*[@aria-label=\"Add project\"]"));
}
