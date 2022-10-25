package pages.yopmail;

import controlSelenium.Button;
import controlSelenium.Control;
import controlSelenium.IFrame;
import controlSelenium.TextBox;
import org.openqa.selenium.By;

public class InboxPage {
    public Button newMailButton = new Button(By.id("newmail"));
    public Button refreshButton = new Button(By.id("refresh"));
    public IFrame iframeMail = new IFrame(By.xpath("//iframe[@name=\"ifmail\"]"));
    public IFrame iframeInbox = new IFrame(By.xpath("//iframe[@name=\"ifinbox\"]"));


    //iframe enviar email
    public TextBox mailToTextbox = new TextBox(By.id("msgto"));
    public TextBox subjectTextbox = new TextBox(By.id("msgsubject"));
    public TextBox mailBodyTextbox = new TextBox(By.id("msgbody"));
    public Button sendMailButton = new Button(By.id("msgsend"));
    public Control popMessage = new Control(By.id("msgpopmsg"));

    //iframe leftInbox
    public Control lastMailSpan = new Control(By.xpath("//*[@class =\"mctn\"]/*[@class=\"m\"]//span[@class=\"lmf\"]"));

}
