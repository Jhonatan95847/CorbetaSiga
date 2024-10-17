package co.com.colcomercio.siga.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class OpcionesTuercaPage extends PageObject {
    public static final Target BUTTON_TUERCA=Target.the("Boton tuerca").located(By.xpath("(//a[@class=\"fa fa-cog\"])[1]"));
    public static final Target SELECT_OPCIONES_TUERCA=Target.the("Select opciones tuerca").locatedBy("//a[contains(text(),'{0}')]");
    public static final Target TEXT_SERIE_CHASIS=Target.the("texto serie de chasis").locatedBy("//tbody/tr/td[4]");

}
