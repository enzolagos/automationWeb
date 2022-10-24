package pages.todoist;

import controlSelenium.Button;
import controlSelenium.Control;
import org.openqa.selenium.By;
import singletonSession.Session;

public class MainPage {
    public Button loginButton = new Button(By.xpath("//a[contains(text(),'Iniciar') and @class='Z2j5FoeQ_umI7vX0SmxF Y5eL4cjJHcHaCQ8EbL7V']"));
    public Button lastProjectCreated = new Button(By.xpath("//ul[@id=\"projects_list\"]/li[last()]"));
    public Button menuProjectButton = new Button(By.xpath("//li[last()]//div[@class=\"fgALZGUA6SZg9blSarq2hg== _7DCqR7o3BYjme7edphDp8A== f9408a0e _0e4ff085\"]"));
    public Button editMenuOptionButton = new Button(By.xpath("//*[@class = \"icon_menu_item__content\" and text()=\"Edit project\"]"));
    public Button deleteMenuOptionButton = new Button(By.xpath("//*[@class = 'icon_menu_item__content' and text()='Delete project']"));
  //  public int cantProjCreados = Integer.parseInt(new Control(By.xpath("//*[@id=\"projects_list\"]")).getAttribute("childElementCount"));
}
