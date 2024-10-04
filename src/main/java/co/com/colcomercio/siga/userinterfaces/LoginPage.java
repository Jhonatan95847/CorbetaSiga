package co.com.colcomercio.siga.userinterfaces;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {
    public static final Target TEXTBOX_USER =Target.the("Campo de texto usuario").located(By.xpath("//input[@id=\"tbxIdentificacion\"]"));
    public static final Target TEXTBOX_PASS =Target.the("Campo de texto contraseña").located(By.xpath("//input[@id=\"tbxClave\"]"));
    public static final Target BUTTON_LOGIN =Target.the("Boton Login").located(By.xpath("//input[@id=\"btnAutenticar\"]"));
    //////////////////////////////////////////////
    public static final Target SELECT_UNIDAD_NEGOCIO =Target.the("Select unidad de negocio").located(By.xpath("//select[@name=\"ctl00$ddlUnidadNegocioId\"]"));
    public static final Target BUTTON_CERRAR_SESION =Target.the("Boton cerrar sesion").located(By.xpath("//span[contains(text(),'Cerrar sesi')]"));
    //public static final Target SELECT_UNIDAD =Target.the("Select unidad").located(By.xpath("//select[@name=\"ctl00$ddlUnidadNegocioId\"]"));


}
