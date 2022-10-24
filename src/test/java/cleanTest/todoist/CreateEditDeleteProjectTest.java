package cleanTest.todoist;

import cleanTest.todoist.TestBaseTodoist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import singletonSession.Session;

import java.util.Date;

public class CreateEditDeleteProjectTest extends TestBaseTodoist {
    @Test
    public void createEditDeleteProject() throws InterruptedException {
        //LOGIN
        mainPage.loginButton.click();
        loginModal.userLoginTextbox.setText("enzo.lagos@nybblegroup.com");
        loginModal.passwordLoginTextbox.setText("nybbletesting");
        loginModal.loginButton.click();
        homePage.inboxButton.waitClickable();
        Assertions.assertTrue(homePage.inboxButton.isControlDisplayed(),"Error no se cargo la pagina");

        //CREATE PROJECT
        homePage.createProjButton.click();
        String projName = ""+new Date().getTime();
        newProjectPage.nameProjectTextbox.setText(projName);
        newProjectPage.addProjectButton.waitClickable();
        newProjectPage.addProjectButton.click();
        homePage.inboxButton.waitClickable();
        Assertions.assertEquals(projName,mainPage.lastProjectCreated.getAttribute("textContent"),"Error no se creo el projecto");

        //EDIT PROJECT
        mainPage.menuProjectButton.click();
        mainPage.editMenuOptionButton.click();
        editProjectPage.projectNameEditionTextBox.addText("EDIT");
        editProjectPage.saveChangesButton.click();
        homePage.inboxButton.waitClickable();
        Assertions.assertEquals(projName+"EDIT",mainPage.lastProjectCreated.getAttribute("textContent"),"Error no se edito el projecto");

        //DELETE PROJECT
        mainPage.menuProjectButton.click();
        Thread.sleep(1000); //cambiar
        mainPage.deleteMenuOptionButton.waitClickable();
        mainPage.deleteMenuOptionButton.click();
        deleteTabPage.delete.click();
        homePage.inboxButton.waitClickable();
        /*Falla ultimo assertion*/

    }
}
