package pages.todoist;

import controlSelenium.Button;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class EditProjectPage {
    public TextBox projectNameEditionTextBox = new TextBox(By.id("edit_project_modal_field_name"));
    public Button saveChangesButton = new Button(By.xpath("//button[ text()=\"Save\"]"));
}
