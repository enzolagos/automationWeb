package controlSelenium;

import org.openqa.selenium.By;

public class UnorderedList extends Control{
    public UnorderedList(By locator) {
        super(locator);
    }

    public UnorderedList(By locator, String controlName) {
        super(locator, controlName);
    }

    public boolean hayElementos(){
        return Integer.parseInt(this.getAttribute("childElementCount"))>0;
    }
}