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
    public void loginTodoLyTest() throws InterruptedException{/*
        Thread.sleep(1000);
        //login
        driver.findElement(By.xpath("//*[@class=\"HPHeaderLogin\"]")).click();
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("enzoenzo@gmail.com");
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("enzoenzo");
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();
        Thread.sleep(2000);
        //verification
        Assertions.assertTrue(driver.findElement(By.xpath("//a[text()='Logout']")).isDisplayed(),"ERROR, no se pudo logear");

        //creo proy
        driver.findElement(By.xpath("//td[text()=\"Add New Project\"]")).click();
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
        Thread.sleep(3000);*/

            // click login
            driver.findElement(By.xpath("//img[@src='/Images/design/pagelogin.png']")).click();
            // set email
            driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("selenium@selenium2022.com");
            // set pwd
            driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("12345");
            // click login
            driver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();
            //Thread.sleep(2000);
            // Explicit Wait --- Button -> Logout

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Logout']")));

            Assertions.assertTrue(driver.findElement(By.xpath("//a[text()='Logout']")).isDisplayed(),
                    "ERROR!! no se pudo iniciar sesion");

            /*
             * CREATE
             * */
            String nameProj="AUTO"+new Date().getTime();

            driver.findElement(By.xpath("//td[text()='Add New Project']")).click();
            driver.findElement(By.id("NewProjNameInput")).sendKeys(nameProj);
            driver.findElement(By.id("NewProjNameButton")).click();
            //Thread.sleep(2000);
            wait.until(ExpectedConditions.textToBe(By.xpath("//li[last()]//td[text()='"+nameProj+"']"),nameProj));
            String actualResult= driver.findElement(By.xpath("//li[last()]//td[text()='"+nameProj+"']")).getText();
            String expectedResult=nameProj;
            Assertions.assertEquals(expectedResult,actualResult,"ERROR no se creo el project");


            /*
             * UPDATE
             * */
            String newNameProj="UPDATE"+new Date().getTime();
            driver.findElement(By.xpath("//li[last()]//td[text()='"+nameProj+"']")).click();
            driver.findElement(By.xpath("//div[contains(@style,'block')]/img")).click();
            driver.findElement(By.xpath(" //ul[@id=\"projectContextMenu\"]//a[text()='Edit']")).click();
            driver.findElement(By.id("ItemEditTextbox")).clear();
            driver.findElement(By.id("ItemEditTextbox")).sendKeys(newNameProj);
            driver.findElement(By.xpath("//td/div[@id=\"ProjectEditDiv\"]/img[@id='ItemEditSubmit']")).click();
            //Thread.sleep(2000);
            wait.until(ExpectedConditions.textToBe(By.xpath("//li[last()]//td[text()='"+newNameProj+"']"),newNameProj));
            actualResult= driver.findElement(By.xpath("//li[last()]//td[text()='"+newNameProj+"']")).getText();
            expectedResult=newNameProj;
            Assertions.assertEquals(expectedResult,actualResult,"ERROR no se actualizo el project");

            /*
             * DELETE
             * */
            driver.findElement(By.xpath("//li[last()]//td[text()='"+newNameProj+"']")).click();
            driver.findElement(By.xpath("//div[contains(@style,'block')]/img")).click();
            driver.findElement(By.id("ProjShareMenuDel")).click();
            driver.switchTo().alert().accept();
            //Thread.sleep(2000);
            wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(By.xpath("//li[last()]//td"),newNameProj)));
            actualResult= driver.findElement(By.xpath("//li[last()]//td")).getText();
            expectedResult=newNameProj;
            Assertions.assertNotEquals(expectedResult,actualResult,"ERROR no se elimino el project");
        }

    }



