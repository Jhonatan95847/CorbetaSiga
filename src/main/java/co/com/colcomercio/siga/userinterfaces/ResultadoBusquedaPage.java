package co.com.colcomercio.siga.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ResultadoBusquedaPage extends PageObject {
    public static final Target BUTTON_TUERCA=Target.the("Boton tuerca").located(By.xpath("//a[@class=\"fa fa-cog\"]"));

}
