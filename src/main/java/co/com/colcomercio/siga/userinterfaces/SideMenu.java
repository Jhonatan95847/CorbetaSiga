package co.com.colcomercio.siga.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SideMenu extends PageObject {
    public static final Target MENU_OPTION =Target.the("Select opcion de menu").locatedBy("//li[@title=\" {0}\"]");
    public static final Target SUBMENU_OPTION =Target.the("Select opcion de submenu").locatedBy("//li[@class=\"active current\"]//span[text()='{0}']");
    public static final Target BUTTON_MENU =Target.the("Boton abrir menu").located(By.xpath("//button[@id=\"btnCerrarMenu\"]"));


}
