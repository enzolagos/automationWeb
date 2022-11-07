package cleanTest.phptravels;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.phptravels.HomePage;
import pages.phptravels.LoginPage;
import pages.phptravels.MainPage;
import pages.phptravels.RegisterPage;
import singletonSession.Session;

public class TestBase {
    public RegisterPage registerPage = new RegisterPage();
    public HomePage homePage = new HomePage();
    public MainPage mainPage = new MainPage();
    public LoginPage loginPage = new LoginPage();
    @BeforeEach
    public void setup(){
        // todo create properties file
        Session.getInstance().getBrowser().get("https://phptravels.com/demo/");
    }
    @AfterEach
    public void cleanup(){
        Session.getInstance().closeBrowser();
    }
    static String getAlphaNumericString(int n)
    {
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }
}

