package basicSelenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Date;

public class RegisterTest {
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
    public void registerTodoLyTest() throws InterruptedException{
    Thread.sleep(1000);
    //REGISTER
    driver.findElement(By.xpath("//*[@class=\"HPHeaderSignup\"]")).click();
    Thread.sleep(1000);
    String mailName="mail"+new Date().getTime()+"@mail.com";
    driver.findElement(By.id("ctl00_MainContent_SignupControl1_TextBoxFullName")).sendKeys("Enzo Lagos");
    driver.findElement(By.id("ctl00_MainContent_SignupControl1_TextBoxEmail")).sendKeys(mailName);
    driver.findElement(By.id("ctl00_MainContent_SignupControl1_TextBoxPassword")).sendKeys("contrasena");
    driver.findElement(By.id("ctl00_MainContent_SignupControl1_CheckBoxTerms")).click();
    driver.findElement(By.id("ctl00_MainContent_SignupControl1_ButtonSignup")).click();
    //Thread.sleep(5000);
    //Explicit wait con el boton logout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Logout']")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Logout']")));

    //verification
    Assertions.assertTrue(driver.findElement(By.xpath("//a[text()='Logout']")).isDisplayed(),"ERROR, no se pudo registrar");

    //CAMBIO CONTRASENA
    driver.findElement(By.xpath("//a[text()='Settings']")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("TextPwOld")).sendKeys("contrasena");
    driver.findElement(By.id("TextPwNew")).sendKeys("nuevacontrasena");
    driver.findElement(By.xpath("//span[text()='Ok']")).click();
    //verification


    //DESLOGUEO Y VUELVO A LOGUEAR
    driver.findElement(By.xpath("//*[@id=\"ctl00_HeaderTopControl1_PanelHeaderButtons\"]/a[text()='Logout']")).click();
    driver.findElement(By.xpath("//*[@class=\"HPHeaderLogin\"]")).click();
    driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys(mailName);
    driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("nuevacontrasena");
    driver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();
    Thread.sleep(2000);
    //verification
    Assertions.assertFalse(driver.findElements(By.xpath("//a[text()='Logout']")).isEmpty(),"ERROR, no se pudo logear con contrasena nueva");

    /*//ELIMINO CUENTA PARA VOLVER A CORRER CON NORMALIDAD
    driver.findElement(By.xpath("//*[@id=\"ctl00_HeaderTopControl1_PanelHeaderButtons\"]/a[text()='Settings']")).click();
    driver.findElement(By.xpath("//*[@id=\"settings_tabs\"]/li/a[text()='Account']")).click();
    driver.findElement(By.id("DeleteAccountBtn")).click();
    driver.switchTo().alert().accept();*/
    //cambie por crear siempre uno nuevo
    }

}
