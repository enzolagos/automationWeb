package pages.toolsQA;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class Home {
    public Button ineractionsButton = new Button(By.xpath("//*[text()=\"Interactions\"]/../../.."));
    public Button selectableButton = new Button(By.xpath("//*[text()=\"Selectable\"]"));


}
