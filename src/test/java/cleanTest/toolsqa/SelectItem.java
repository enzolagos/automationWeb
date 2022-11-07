package cleanTest.toolsqa;

import org.junit.jupiter.api.Test;
import singletonSession.Session;

public class SelectItem extends TestBasetoolsQA{
    @Test
    public void verifyItemIsSelected(){
        home.selectableButton.click();
        Session.getInstance().waitURLToChange("https://demoqa.com/selectable");
    }
}
