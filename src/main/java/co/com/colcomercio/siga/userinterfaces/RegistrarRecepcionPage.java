package co.com.colcomercio.siga.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegistrarRecepcionPage extends PageObject {
    public static final Target IFRAME_REGISTRAR_RECEPCION =Target.the("Iframe regitrar recepcion").locatedBy("//iframe");
    public static final Target IFRAME_DOS =Target.the("Iframe dos").locatedBy("//div[@class=\"carousel-item active\"]//iframe");
    public static final Target IFRAME_REGISTRAR_RECEPCIONDOS =Target.the("Iframe regitrar recepcion").locatedBy("//div[@class=\"nav carousel-inner\"]//div[@class=\"carousel-item active\"]//iframe");
    public static final Target IFRAME_REGISTRAR_RECEPCIONTRES =Target.the("Iframe regitrar recepcion").locatedBy("//div[@class=\"nav carousel-inner\"]//div[@class=\"carousel-item active\"]//iframe");
    public static final Target BUTTON_REGISTRAR_RECEPCION =Target.the("Boton regitrar recepcion").located(By.xpath("//button[@id=\"btnEjecutarAccion\"]"));
    public static final Target BUTTON_CONFIRMAR =Target.the("Boton confirmar").located(By.xpath("//button[contains(text(),'Confirmar')]"));
    public static final Target TEXTBOX_FECHAVIGENCIA =Target.the("Campo de texto vigencia").located(By.xpath("//input[@id=\"txtVehiculoClienteFechaVigenciaInicial\"]"));
    public static final Target BUTTON_GUARDAR_REGISTRO =Target.the("Boton guardar registro").located(By.xpath("//div[@id=\"uplOperaciones\"]//button[@id=\"btnAdicionar\"]"));
    public static final Target BUTTON_CERRAR_POPUP =Target.the("Boton cerrar pop up").located(By.xpath("/html/body/div[5]/div/div/div[1]/button"));
        public static final Target BUTTON_VOLVER =Target.the("Boton volver").located(By.xpath("//button[@id=\"btnCancelar\"]"));

    //Datos vehiculo
    public static final Target TEXTBOX_TALLER =Target.the("Campo de texto taller").located(By.xpath("//div[@id=\"ddlTallerId_chosen\"]//input"));
    public static final Target TEXTBOX_TALLER_CLICK =Target.the("Campo de texto taller click").located(By.xpath("//div[@id=\"ddlTallerId_chosen\"]"));
    public static final Target TEXTBOX_KILOMETRAJE =Target.the("Campo de texto kilometraje").located(By.xpath("//input[@id=\"tbxRecepcionVehiculoTallerKilometrajeActual\"]"));
    public static final Target TEXTBOX_HORAS =Target.the("Campo de texto horas").located(By.xpath("//input[@id=\"tbxRecepcionVehiculoTallerHoras\"]"));
    //Datos de cliente
    public static final Target BUTTON_CAMBIAR_PROPIETARIO =Target.the("Boton cambiar propietario").located(By.xpath("//a[contains(text(),'Cambiar Propietario')]"));
    public static final Target BUTTON_CREAR_REGISTRO =Target.the("Boton Crear registro").located(By.xpath("//div[@class=\"operaciones\"]//button[contains(text(),'Crear Registro')]"));
    public static final Target BUTTON_AGREGAR_CLIENTE =Target.the("Boton agregar cliente").located(By.xpath("//a[@id=\"lbnClienteId\"]"));
    public static final Target TEXTBOX_NOMBRE =Target.the("Campo de texto nombre").located(By.xpath("//input[@name=\"ctl00$cprBusqueda$tbxClienteNombres\"]"));
    public static final Target CHECKBOX_AUTOGRUAS =Target.the("Check box autogruas").located(By.xpath("(//input[@id=\"cbxSeleccionar\"])[2]"));
    public static final Target BUTTON_AGREGAR =Target.the("Boton Agregar").located(By.xpath("//button[@id=\"btnAdicionarSeleccion\"]"));
    public static final Target TEXTBOX_NOMBRE_VALIDAR =Target.the("Campo de texto validar si ya esta autogruas").located(By.xpath("//input[@value=\"AUTOGRUAS DE\"]"));
    //fecha registro recepcion
    public static final Target TEXTBOX_FECHA_ENTREGA =Target.the("Campo de texto fecha de entrega").located(By.xpath("//input[@id=\"tbxRecepcionVehiculoTallerFechaEstimadaEntrega\"]"));
    public static final Target TEXTBOX_CONDICION =Target.the("Campo de texto Condicion").located(By.xpath("//textarea[@id=\"tbxRecepcionVehiculoTallerObservaciones\"]"));
    //Datos del conductor
    public static final Target CHECK_MISMO_PROPIETARIO =Target.the("Check mismo propietario").located(By.xpath("//input[@id=\"cprPrincipal_cbxMismoPropietario\"]"));


}
