package cleanTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.todoLy.LoginModal;
import pages.todoLy.MainPage;
import pages.todoLy.MenuSection;
import pages.todoLy.SettingsPage;
import singletonSession.Session;

public class TestBaseTodoLy {
    public MainPage mainPage = new MainPage();
    public LoginModal loginModal = new LoginModal();
    public MenuSection menuSection = new MenuSection();
    public SettingsPage settingsPage = new SettingsPage();

    @BeforeEach
    public void setup(){
        // todo create properties file
        Session.getInstance().getBrowser().get("https://todo.ly/");
    }
    @AfterEach
    public void cleanup(){
        Session.getInstance().closeBrowser();
    }
}
