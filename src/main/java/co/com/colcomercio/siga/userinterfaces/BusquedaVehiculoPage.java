package co.com.colcomercio.siga.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BusquedaVehiculoPage extends PageObject {
    public static final Target TEXTBOX_SERIE_CHASIS =Target.the("Campo de texto serie chasis").located(By.xpath("//input[@id=\"tbxVehiculoSerieChasis\"]"));
    public static final Target BUTTON_BUSCAR_VEHICULO =Target.the("Boton buscar vehiculo").located(By.xpath("(//input[@value=\"Buscar\"])[1]"));
    //BUSCAR 0T
    public static final Target TEXTBOX_OT_CHASIS =Target.the("Campo de texto serie chasis OT").located(By.xpath("(//div[@class=\"bootstrap-tagsinput form-control\"]//input[@placeholder=\"Agregar un Vehículo\"])[2]"));
    public static final Target BUTTON_BUSCAR_OT =Target.the("Boton buscar OT").located(By.xpath("(//input[@value=\"Buscar\"])[1]"));

}