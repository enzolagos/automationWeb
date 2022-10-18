package basicSelenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.Assertion;

public class LoginTest {
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
        Thread.sleep(5000);
        //click en el boton login
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_PanelNotAuth\"]/div[2]/div[1]/div[2]/a")).click();
        //set email
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("selenium@selenium2022.com");
        //set pasword
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("12345");
        //click login
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();
        Thread.sleep(2000);
        //verification
        Assertions.assertTrue(driver.findElement(By.xpath("//a[text()='Logout']")).isDisplayed(),"ERROR, no se pudo logear");

        //driver.switchTo().alert().accept();
    }

}
/*
* click boton login --> //img[@src='/Images/design/pagelogin.png']
* email ---> ctl00_MainContent_LoginControl1_TextBoxEmail
* pwd ---> ctl00_MainContent_LoginControl1_TextBoxPassword
* login --> ctl00_MainContent_LoginControl1_ButtonLogin

* logout --> //a[text()='Logout']   ---> Assertions

selenium@selenium2022.com
12345*/