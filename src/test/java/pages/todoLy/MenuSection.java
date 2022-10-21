
package pages.todoLy;

import controlSelenium.Button;
import org.openqa.selenium.By;

public class MenuSection {
    public Button settings = new Button(By.xpath("//a[text()='Settings']"));
    public Button logout = new Button(By.xpath("//a[text()='Logout']"));
}

