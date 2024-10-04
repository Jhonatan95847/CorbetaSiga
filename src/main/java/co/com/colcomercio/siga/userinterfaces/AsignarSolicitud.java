package co.com.colcomercio.siga.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AsignarSolicitud extends PageObject {
    public static final Target ITEMDRAG_OT =Target.the("elemento a mover orden de trabajo").located(By.xpath("//div[@id=\"dvItemDrag\"]"));
    public static final Target DRAG_OT =Target.the("Destino del elemento").located(By.xpath("//*[@id=\"dvTimeline\"]/div/div[4]/div[1]/div/div[2]/div[1]"));
    public static final Target BUTTON_ASIGNAR_OT =Target.the("Boton asignar OT").located(By.xpath("//button[@id=\"btnEjecutarAccion\"]"));
    public static final Target SCROLL =Target.the("Boton asignar OT").located(By.xpath("//*[@id=\"dvTimeline\"]/div/div[4]/div[1]/div/div[2]/div[1]/div[5]/div[1]/div"));
    public static final Target INPUT_CELL = Target.the("Campo para definir la celda de trabajo").locatedBy("//input[@id='hfdGroup']");
    public static final Target INPUT_MINIMUM_TIME = Target.the("Campo para definir el tiempo minimo de la celda de orden de trabajo").locatedBy("//input[@id='hfdMin']");
    public static final Target INPUT_MAXIMUM_TIME = Target.the("Campo para definir el tiempo maximo de la celda de orden de trabajo").locatedBy("//input[@id='hfdMax']");
    public static final Target CHECK_EVENT = Target.the("Check para habilitar el evento del boton de asignación de OT").locatedBy("//input[@id='ctl00_cprPrincipal_tbxCheck']");

}
