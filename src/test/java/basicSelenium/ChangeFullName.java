package basicSelenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChangeFullName {
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

        //Cambio el nombre
        driver.findElement(By.xpath("//a[text()='Settings']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("FullNameInput")));
        driver.findElement(By.id("FullNameInput")).clear();
        driver.findElement(By.id("FullNameInput")).sendKeys("nuevoNombre\n");
        driver.findElement(By.xpath("//span[text()='Ok']")).click();

        //verifico que se cambio
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Settings']")));
        driver.findElement(By.xpath("//a[text()='Settings']")).click();
        //Assertions.assertTrue(driver.findElement(By.id("FullNameInput")).getAttribute("value")== "nuevoNombre");

    }

}
