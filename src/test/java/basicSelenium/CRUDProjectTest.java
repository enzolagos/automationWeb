package basicSelenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CRUDProjectTest {
    WebDriver driver;
    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://todo.ly/");
    }

    @AfterEach
    public void cleanup(){
        driver.quit();
    }


    @Test
    public void loginTodoLyTest() throws InterruptedException{
        Thread.sleep(1000);
        //login
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_PanelNotAuth\"]/div[2]/div[1]/div[2]/a")).click();
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("enzoenzo@gmail.com");
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("enzoenzo");
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();
        Thread.sleep(2000);
        //verification
        Assertions.assertTrue(driver.findElement(By.xpath("//a[text()='Logout']")).isDisplayed(),"ERROR, no se pudo logear");

        //creo proy
        driver.findElement(By.xpath("//*[@id=\"MainTable\"]/tbody/tr/td[1]/div[6]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"NewProjNameInput\"]")).sendKeys("prueba");
        driver.findElement(By.xpath("//*[@id=\"NewProjNameButton\"]")).click();
        //Assertions.assertTrue(driver.findElement(By.xpath("//td[@class=\"ProjItemContent\" and text()=\"prueba\"]")).isDisplayed(),"ERROR, no se pudo logear");
        Thread.sleep(3000);

        //lo edito
        driver.findElement(By.xpath("//td[@class=\"ProjItemContent\" and text()=\"prueba\"]")).click();
        driver.findElement(By.xpath("//*[@style='display: block;']/img")).click();
        driver.findElement(By.xpath("//*[@id=\"projectContextMenu\"]/li[1]/a")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"ItemEditTextbox\"]")).sendKeys("1\n");
        //driver.findElement(By.xpath("//*[@id=\"ItemEditSubmit\"]")).click();
        Thread.sleep(2000);

        //lo borro
        driver.findElement(By.xpath("//td[@class=\"ProjItemContent\" and text()='prueba1']")).click();
        driver.findElement(By.xpath("//*[@style='display: block;']/img")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"ProjShareMenuDel\"]")).click();
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
    }
}


