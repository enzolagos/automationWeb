package singletonSession;

import factoryBrowser.FactoryBrowser;
import org.openqa.selenium.WebDriver;

public class Session {
    private static Session session=null;
    private WebDriver browser;

    private Session(){
        //todo --> create properties file - browser
        browser = FactoryBrowser.make("chrome").create();
    }

    public static Session getInstance(){
        if(session==null){
            session = new Session();
        }
        return session;
    }
    public void closeBrowser(){
        browser.quit();
        session=null;
    }

    public WebDriver getBrowser() {
        return browser;
    }


}
