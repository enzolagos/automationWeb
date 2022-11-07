package pages.phptravels;

import controlSelenium.*;
import org.openqa.selenium.By;

public class HomePage {
    public Button signUpButton = new Button(By.xpath("//a[@data-name =\"signup\" and contains(@class,\"menuListLink\")]"),"signUpButton");

}
