package controlSelenium;

import org.openqa.selenium.By;

public class CheckBox extends Control{
    public CheckBox(By locator) {
        super(locator);
    }
    public CheckBox(By locator, String controlName) {
        super(locator, controlName);
    }

    public void check(){
        this.findControl();
        if (!this.control.isSelected()){
            control.click();
        }
    }
    public void uncheck(){
        this.findControl();
        if (this.control.isSelected()){
            control.click();
        }
    }
}
