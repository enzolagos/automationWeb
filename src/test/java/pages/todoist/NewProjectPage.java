package pages.todoist;

import controlSelenium.Button;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class NewProjectPage {
    public TextBox nameProjectTextbox = new TextBox(By.id("edit_project_modal_field_name"));
    public Button addProjectButton = new Button(By.xpath("//*[text()=\"Add\"]"));
}
