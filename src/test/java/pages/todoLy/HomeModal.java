package pages.todoLy;

import controlSelenium.Button;
import controlSelenium.Control;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class HomeModal {
    public Button createProject = new Button(By.xpath("//*[text()=\"Add New Project\"]"));
    public TextBox createItem = new TextBox(By.id("NewItemContentInput"));
    public Control lastItemCreated = new Control(By.xpath("//ul[@id=\"mainItemList\"]/li[last()]//*[@class=\"ItemContentDiv\"]"));
    public Control itemMenu = new Control(By.xpath("//ul[@id='mainItemList']//*[@class='ItemMenu'  and @style='display: inline;']"));
    public TextBox lastItemForEdition = new TextBox(By.xpath("//textarea[@id='ItemEditTextbox']"));
    public Button deleteButton = new Button(By.xpath("//*[@id=\"itemContextMenu\"]//a[text()='Delete']"));
}
