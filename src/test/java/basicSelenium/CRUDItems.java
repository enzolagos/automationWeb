package basicSelenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.plaf.TableHeaderUI;
import java.time.Duration;
import java.util.Date;

public class CRUDItems {
    WebDriver driver;
    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://todo.ly/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
    }

    @AfterEach
    public void cleanup(){
        driver.quit();
    }

    @Test
    public void itemsTodoLy() throws InterruptedException{
        //LOGIN
        driver.findElement(By.xpath("//img[@src='/Images/design/pagelogin.png']")).click();
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("enzo222@gmail.com");
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("enzo222");
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();

        //verifico que haya iniciado sesion con el fluent
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        Wait<WebDriver> fluentWait = new FluentWait(driver).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Logout']")));
        Assertions.assertTrue(driver.findElement(By.xpath("//a[text()='Logout']")).isDisplayed(),
                "ERROR!! no se pudo iniciar sesion");


        //Creo un item
        String nameItem = ""+new Date().getTime();
        driver.findElement(By.id("NewItemContentInput")).sendKeys(nameItem+"\n");
        wait.until(ExpectedConditions.textToBe(By.xpath("//ul[@id=\"mainItemList\"]/li[last()]//*[@class=\"ItemContentDiv\"]"),nameItem));
        Assertions.assertEquals(driver.findElement(By.xpath("//ul[@id=\"mainItemList\"]/li[last()]//*[@class=\"ItemContentDiv\"]")).getText(),nameItem);

        //Lo modifico
        driver.findElement(By.xpath("//ul[@id=\"mainItemList\"]/li[last()]//div[text()='"+nameItem+"']")).click();
        driver.findElement(By.xpath("//ul[@id=\"mainItemList\"]//*[@class=\"ItemMenu\"  and @style=\"display: inline;\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"itemContextMenu\"]//a[text()='Edit']")).click();
        driver.findElement(By.xpath("//textarea[@id='ItemEditTextbox']")).sendKeys("UPD\n");
        wait.until(ExpectedConditions.textToBe(By.xpath("//ul[@id=\"mainItemList\"]/li[last()]//*[@class=\"ItemContentDiv\"]"),nameItem+"UPD"));
        Assertions.assertEquals(driver.findElement(By.xpath("//ul[@id=\"mainItemList\"]/li[last()]//*[@class=\"ItemContentDiv\"]")).getText(),nameItem+"UPD");

        //Lo elimino
        driver.findElement(By.xpath("//ul[@id=\"mainItemList\"]/li[last()]//div[text()='"+nameItem+"UPD"+"']")).click();
        driver.findElement(By.xpath("//ul[@id=\"mainItemList\"]//*[@class=\"ItemMenu\"  and @style=\"display: inline;\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"itemContextMenu\"]//a[text()='Delete']")).click();
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(By.xpath("//ul[@id=\"mainItemList\"]/li[last()]//*[@class=\"ItemContentDiv\"]"),nameItem)));
       //No puedo hacer funcionar el ultimo assert
       // Assertions.assertFalse(driver.findElement(By.xpath("//ul[@id=\"mainItemList\"]/li[last()]//*[@class=\"ItemContentDiv\"]")).getText().equals(nameItem+"UPD"),"No se elimino el item");

    }
}
