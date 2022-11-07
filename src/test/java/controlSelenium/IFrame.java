package controlSelenium;

import org.openqa.selenium.By;

public class IFrame extends Control{
    public IFrame(By locator) {
        super(locator);
    }

    public IFrame(By locator, String controlName) {
        super(locator, controlName);
    }
}
