package cleanTest.yopmail;

import controlSelenium.Control;
import factoryBrowser.Chrome;
import factoryBrowser.FactoryBrowser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.devtools.v85.tracing.model.TraceConfig;
import singletonSession.Session;

import java.util.Date;

public class CRUDMail extends TestBaseYopmail{
    @Test
    public void verifyCRUD() throws InterruptedException {
        //CREACION CUENTA
        String email = ""+new Date().getTime()+"@yopmail.com";
        homePage.nameMailTextbox.setText(email);
        homePage.createEmailButton.click();
        inboxPage.newMailButton.waitURLToChange("https://yopmail.com/en/wm");
        Assertions.assertTrue(inboxPage.newMailButton.isControlDisplayed(), "Error no se ha creado");

        //MANDADO DE MAIL
        inboxPage.newMailButton.click();
        inboxPage.iframeMail.waitUntilChangeState("state","full");

        Session.getInstance().changeIFrame("ifmail");
        inboxPage.mailToTextbox.setText(email);
        inboxPage.subjectTextbox.setText("This is a test.");
        inboxPage.mailBodyTextbox.setText(email);
        inboxPage.sendMailButton.click();
        inboxPage.popMessage.waitClickable();
        Assertions.assertTrue(inboxPage.popMessage.isControlDisplayed(),"Error el mail no se envio");
        Session.getInstance().leaveIFrame();

        inboxPage.refreshButton.waitClickable();
        inboxPage.refreshButton.click();
        inboxPage.iframeInbox.waitUntilChangeState("state","full");

        Session.getInstance().changeIFrame("ifinbox");
        System.out.println(inboxPage.lastMailSpan.getAttribute("textContent"));
        System.out.println(email);
        Assertions.assertEquals(inboxPage.lastMailSpan.getAttribute("textContent"), email,"Error el mail no se envio");
    }
}
