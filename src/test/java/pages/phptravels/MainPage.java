package pages.phptravels;

import controlSelenium.Button;
import controlSelenium.Label;
import org.openqa.selenium.By;

public class MainPage {
    public Label infoLabel = new Label(By.xpath("//*[@class=\"card-body\"]/em"),"infoLabel");
    public Button logoutButton = new Button(By.xpath("//*[@id=\"Secondary_Sidebar-Client_Shortcuts-Logout\"]"),"logoutButton");

}
