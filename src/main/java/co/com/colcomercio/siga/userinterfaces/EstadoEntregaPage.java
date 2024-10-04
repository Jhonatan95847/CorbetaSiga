package co.com.colcomercio.siga.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EstadoEntregaPage extends PageObject {
    public static final Target TEXTBOX_MOTIVO_INGRESO =Target.the("Campo de texto motivo de ingreso").located(By.xpath("//input[@placeholder=\"Agregar un Motivo de Ingreso\"]"));
    public static final Target CHECK_NIVEL_GAS =Target.the("Check nivel de combustible").located(By.xpath("//div[@class=\"slider-track\"]//div[@style=\"left: 75%;\"]"));
    public static final Target CHECK_TODOS_ACCESORIOS =Target.the("Check todos los accesorios").located(By.xpath("//input[@id=\"cbxAllAplicacion\"]"));
    public static final Target TEXTBOX_OBSERVACIONES =Target.the("Campo de texto observaciones").located(By.xpath("//textarea[@name=\"ctl00$cprPrincipal$tbxObservacionesOT\"]"));
    public static final Target CAMPO_FIRMA =Target.the("Campo firma").located(By.xpath("//canvas[@id=\"canvas\"]"));
    public static final Target BUTTON_CONFIRM_FIRMA =Target.the("Button confirmar firma").located(By.xpath("//button[@id=\"btnEstablecerFirma\"]"));
    public static final Target BUTTON_REGISTRAR_OT =Target.the("Button registrar OT").located(By.xpath("//button[@value=\"Registrar Orden de Trabajo\"]"));
    public static final Target BUTTON_CONFIRMAR =Target.the("Button confirmar").located(By.xpath("//button[contains(text(),'Confirmar')]"));

}
