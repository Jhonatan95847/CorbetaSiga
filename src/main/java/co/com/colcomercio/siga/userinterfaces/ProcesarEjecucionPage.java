package co.com.colcomercio.siga.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProcesarEjecucionPage extends PageObject {
    public static final Target BUTTON_INICIAR_EJECUCION=Target.the("Boton iniciar ejecucion").located(By.xpath("//button[@id=\"btnIniciarAccion\"]"));
    public static final Target BUTTON_EJECUTAR_ACCION=Target.the("Boton Ejecutar accion").located(By.xpath("//div[@class=\"dropdown dropdown-btn list--inline\"]//a[@id=\"lbnEjecutarAccion\"]"));
    public static final Target BUTTON_SELECT_CREAR_NOVEDAD_TP=Target.the("Boton Crear novedad TP").locatedBy("//a[contains(text(),'{0}')]");
    public static final Target TEXTBOX_AGREGAR_TECICO=Target.the("Campo de texto agregar tecnico al taller").located(By.xpath("//input[@placeholder=\"Agregar un Técnico de Taller\"]"));
    public static final Target TAP_PARTES=Target.the("Tap partes").located(By.xpath("//a[contains(text(),'Partes')]"));
    public static final Target SELECT_COTIZACION=Target.the("Select cotizacion").located(By.xpath("//select[@id=\"ddlAsociarCotizacion\"]"));
    public static final Target TEXTBOX_TIPO_DE_ORDEN=Target.the("Campo de texto agregar tipo de orden").located(By.xpath("//div[@id='ddlTipoOrdenId_0_chosen']/ul/li/input"));
    public static final Target TEXTBOX_AGREGAR_PARTE=Target.the("Campo de texto agregar parte").located(By.xpath("//input[@placeholder=\"Agregar una Parte\"]"));
    public static final Target TEXTBOX_CANTIDAD=Target.the("Campo de texto cantidad").located(By.xpath("//input[@id=\"tbxCantidadSolicitada_0\"]"));
    public static final Target BUTTON_AGREGAR_PARTE=Target.the("Boton agregar parte").located(By.xpath("(//a[@class=\"fa fa-plus-circle oprn\"])[3]"));
    public static final Target BUTTON_CONSULTAR_DESCUENTO=Target.the("Boton consultar descuentos").located(By.xpath("//button[@value=\"Consultar Descuentos\"]"));
        public static final Target BUTTON_CREAR_NOVEDAD_TP=Target.the("Boton Crear novedad TP").located(By.xpath("//button[@id=\"btnEjecutarAccion\"]"));
    public static final Target TEXTBOX_MOTIVO_DETENCION=Target.the("Campo de texto motivo de detencion").located(By.xpath("//input[@placeholder=\"Agregar un Motivo de Detención\"]"));
    public static final Target BUTTON_DETENET_EJECUCION=Target.the("Boton detener ejecucion").located(By.xpath("//button[@id=\"btnDetenerAccion\"]"));

}
