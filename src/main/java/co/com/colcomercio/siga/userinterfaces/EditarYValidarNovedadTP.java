package co.com.colcomercio.siga.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EditarYValidarNovedadTP extends PageObject {
    public static final Target BUTTON_EDITAR_VALIDAR =Target.the("Boton editar y validar novedad TP").located(By.xpath("//a[contains(text(),'Editar y Validar')]"));
    public static final Target BUTTON_PARTES =Target.the("Boton partes").located(By.xpath("//*[@id=\"encabezadoTabs\"]/li[2]/a"));
    public static final Target BUTTON_CONTINUAR_DESCUENTOS_COMPROMETIDOS =Target.the("Boton consultar descuentos y comprometidos").located(By.xpath("//button[@id=\"ctl00_cprPrincipal_btnConsultar\"]"));
    public static final Target BUTTON_EDITAR_VALIDAR_FINAL =Target.the("Boton editar y validar novedad TP final").located(By.xpath("//button[@id=\"btnEjecutarAccion\"]"));
    //estan dentro de in iframe loclizado por //iframe

}
