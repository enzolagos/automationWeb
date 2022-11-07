package cleanTest.toolsqa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.toolsQA.Home;
import singletonSession.Session;

public class TestBasetoolsQA {
    public Home home = new Home();

    @BeforeEach
    public void setup(){
        // todo create properties file
        Session.getInstance().getBrowser().get("https://demoqa.com/interaction");
    }
    @AfterEach
    public void cleanup(){
        Session.getInstance().closeBrowser();
    }
}
