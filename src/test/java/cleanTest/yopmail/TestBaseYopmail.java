package cleanTest.yopmail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.yopmail.HomePage;
import pages.yopmail.InboxPage;
import singletonSession.Session;

public class TestBaseYopmail {
    public HomePage homePage = new HomePage();
    public InboxPage inboxPage = new InboxPage();

    @BeforeEach
    public void setup(){
        // todo create properties file
        Session.getInstance().getBrowser().get("https://yopmail.com/en/");
    }
    @AfterEach
    public void cleanup(){
        Session.getInstance().closeBrowser();
    }
}
