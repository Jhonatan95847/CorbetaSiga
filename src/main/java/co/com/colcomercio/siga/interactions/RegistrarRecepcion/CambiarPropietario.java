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
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static co.com.colcomercio.siga.userinterfaces.RegistrarRecepcionPage.*;
import static co.com.colcomercio.siga.utils.Constantes.PROPIETARIO_CAMBIAR;
import static co.com.colcomercio.siga.utils.WaitingTime.LOW_TIME;
import static co.com.colcomercio.siga.utils.WaitingTime.MICRO_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CambiarPropietario implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
                actor.attemptsTo(
                        WaitUntil.the(BUTTON_CAMBIAR_PROPIETARIO, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                        Wait.withDuration(MICRO_TIME),
                        ScrollToElement.to(BUTTON_CAMBIAR_PROPIETARIO),
                        ClickOnElement.on(BUTTON_CAMBIAR_PROPIETARIO),
                        WaitUntil.the(IFRAME_REGISTRAR_RECEPCION, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                        Wait.withDuration(3),
                        Switch.toDefaultContext(),
                        WaitUntil.the(IFRAME_REGISTRAR_RECEPCION, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                        SwitchIframe.to(IFRAME_REGISTRAR_RECEPCION),
                        Wait.withDuration(3),
                        WaitUntil.the(IFRAME_REGISTRAR_RECEPCION, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                        SwitchIframe.to(IFRAME_REGISTRAR_RECEPCION),
                        WaitUntil.the(BUTTON_CREAR_REGISTRO, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                        ScrollToElement.to(BUTTON_CREAR_REGISTRO),
                        ClickOnElement.on(BUTTON_CREAR_REGISTRO),
                        Wait.withDuration(MICRO_TIME),
                        Switch.toDefaultContext(),
                        WaitUntil.the(IFRAME_REGISTRAR_RECEPCION, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                        SwitchIframe.to(IFRAME_REGISTRAR_RECEPCION),
                        SwitchIframe.to(IFRAME_REGISTRAR_RECEPCIONDOS),
                        ScrollToElement.to(BUTTON_AGREGAR_CLIENTE),
                        ClickOnElement.on(BUTTON_AGREGAR_CLIENTE),
                        Wait.withDuration(MICRO_TIME),
                        Switch.toDefaultContext(),
                        WaitUntil.the(IFRAME_REGISTRAR_RECEPCION, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                        SwitchIframe.to(IFRAME_REGISTRAR_RECEPCION),
                        SwitchIframe.to(IFRAME_REGISTRAR_RECEPCIONDOS),
                        WaitUntil.the(TEXTBOX_NOMBRE, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                        ScrollToElement.to(TEXTBOX_NOMBRE),
                        EnterText.intoField(PROPIETARIO_CAMBIAR,TEXTBOX_NOMBRE),
                        Hit.the(Keys.ENTER).into(TEXTBOX_NOMBRE),
                        Wait.withDuration(MICRO_TIME),
                        Switch.toDefaultContext(),
                        WaitUntil.the(IFRAME_REGISTRAR_RECEPCION, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                        SwitchIframe.to(IFRAME_REGISTRAR_RECEPCION),
                        SwitchIframe.to(IFRAME_REGISTRAR_RECEPCIONDOS),
                        WaitUntil.the(CHECKBOX_AUTOGRUAS, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                        ScrollToElement.to(CHECKBOX_AUTOGRUAS),
                        ClickOnElement.on(CHECKBOX_AUTOGRUAS),
                        ClickOnElement.on(BUTTON_AGREGAR),
                        Switch.toDefaultContext(),
                        WaitUntil.the(IFRAME_REGISTRAR_RECEPCION, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                        SwitchIframe.to(IFRAME_REGISTRAR_RECEPCION),
                        SwitchIframe.to(IFRAME_REGISTRAR_RECEPCIONDOS),
                        EnterText.intoField("15/10/2024",TEXTBOX_FECHAVIGENCIA),
                        Hit.the(Keys.ENTER).into(TEXTBOX_FECHAVIGENCIA),
                        ClickOnElement.on(BUTTON_GUARDAR_REGISTRO),
                        Switch.toDefaultContext(),
                        ClickOnElement.on(BUTTON_CONFIRMAR),
                        Wait.withDuration(5),
                        WaitUntil.the(BUTTON_CERRAR_POPUP, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                        JavaScriptClick.on(BUTTON_CERRAR_POPUP),
                        WaitUntil.the(IFRAME_REGISTRAR_RECEPCION, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                        SwitchIframe.to(IFRAME_REGISTRAR_RECEPCION),
                        SwitchIframe.to(IFRAME_REGISTRAR_RECEPCIONDOS),
                        ClickOnElement.on(BUTTON_VOLVER),
                        Wait.withDuration(5)
                );
    }
    public static CambiarPropietario cambiar(){return Tasks.instrumented(CambiarPropietario.class);}
}
