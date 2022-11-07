package cleanTest.todoLy;

import io.qameta.allure.Attachment;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.todoLy.*;
import singletonSession.Session;
import utils.GetProperties;

public class TestBaseTodoLy {
    public MainPage mainPage = new MainPage();
    public LoginModal loginModal = new LoginModal();
    public MenuSection menuSection = new MenuSection();
    public SettingsPage settingsPage = new SettingsPage();
    public HomeModal homeModal = new HomeModal();

    @BeforeEach
    public void setup(){
        Session.getInstance().getBrowser().get(GetProperties.getInstance().getHost());
    }
    @AfterEach
    public void cleanup(){
        attach();
        Session.getInstance().closeBrowser();
    }


    @Attachment(value = "screenshot",type = "image/png")
    private byte[] attach(){
        //todo EJ1
        // tomar captura de pantalla - adjuntarlo en el reporte
        return ((TakesScreenshot) Session.getInstance().getBrowser()).getScreenshotAs(OutputType.BYTES);
    }
}