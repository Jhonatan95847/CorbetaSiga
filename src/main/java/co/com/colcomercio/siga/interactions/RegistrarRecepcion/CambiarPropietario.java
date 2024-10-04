package co.com.colcomercio.siga.interactions.RegistrarRecepcion;

import co.com.colcomercio.siga.interactions.ClickOnElement;
import co.com.colcomercio.siga.interactions.EnterText;
import co.com.colcomercio.siga.interactions.ScrollToElement;
import co.com.colcomercio.siga.interactions.Wait;
import co.com.colcomercio.siga.utils.SwitchIframe;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Switch;
import org.openqa.selenium.Keys;

import static co.com.colcomercio.siga.userinterfaces.EstadoEntregaPage.TEXTBOX_MOTIVO_INGRESO;
import static co.com.colcomercio.siga.userinterfaces.RegistrarRecepcionPage.*;

public class CambiarPropietario implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Wait.withDuration(10),
                ScrollToElement.to(BUTTON_CAMBIAR_PROPIETARIO),
                ClickOnElement.on(BUTTON_CAMBIAR_PROPIETARIO),
                Wait.withDuration(10),
                Switch.toDefaultContext(),
                SwitchIframe.to(IFRAME_REGISTRAR_RECEPCION),
                SwitchIframe.to(IFRAME_REGISTRAR_RECEPCION),
                ClickOnElement.on(BUTTON_CREAR_REGISTRO),
                //Switch.toDefaultContext(),
                Wait.withDuration(10),
                Switch.toDefaultContext(),
                SwitchIframe.to(IFRAME_REGISTRAR_RECEPCION),
                SwitchIframe.to(IFRAME_REGISTRAR_RECEPCIONDOS),
                ClickOnElement.on(BUTTON_AGREGAR_CLIENTE),
                Wait.withDuration(10),
                Switch.toDefaultContext(),
                SwitchIframe.to(IFRAME_REGISTRAR_RECEPCION),
                SwitchIframe.to(IFRAME_REGISTRAR_RECEPCIONDOS),
                EnterText.intoField("autogruas",TEXTBOX_NOMBRE),
                Hit.the(Keys.ENTER).into(TEXTBOX_NOMBRE),
                Wait.withDuration(10),
                Switch.toDefaultContext(),
                SwitchIframe.to(IFRAME_REGISTRAR_RECEPCION),
                SwitchIframe.to(IFRAME_REGISTRAR_RECEPCIONDOS),
                ClickOnElement.on(CHECKBOX_AUTOGRUAS),
                ClickOnElement.on(BUTTON_AGREGAR),
                Switch.toDefaultContext(),
                SwitchIframe.to(IFRAME_REGISTRAR_RECEPCION),
                SwitchIframe.to(IFRAME_REGISTRAR_RECEPCIONDOS),
                EnterText.intoField("2/10/2024",TEXTBOX_FECHAVIGENCIA),
                Hit.the(Keys.ENTER).into(TEXTBOX_FECHAVIGENCIA),
                ClickOnElement.on(BUTTON_GUARDAR_REGISTRO),
                Switch.toDefaultContext(),
                ClickOnElement.on(BUTTON_CONFIRMAR),
                Wait.withDuration(10),
                JavaScriptClick.on(BUTTON_CERRAR_POPUP),
                SwitchIframe.to(IFRAME_REGISTRAR_RECEPCION),
                SwitchIframe.to(IFRAME_REGISTRAR_RECEPCIONDOS),
                ClickOnElement.on(BUTTON_VOLVER),
                Wait.withDuration(5)
        );
    }
    public static CambiarPropietario cambiar(){return Tasks.instrumented(CambiarPropietario.class);
    }
}
