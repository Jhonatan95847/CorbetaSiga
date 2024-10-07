package co.com.colcomercio.siga.tasks.formularios;

import co.com.colcomercio.siga.interactions.ClickOnElement;
import co.com.colcomercio.siga.interactions.EnterText;
import co.com.colcomercio.siga.interactions.ScrollToElement;
import co.com.colcomercio.siga.interactions.Wait;
import co.com.colcomercio.siga.userinterfaces.RegistrarRecepcionPage;
import co.com.colcomercio.siga.utils.SwitchIframe;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static co.com.colcomercio.siga.userinterfaces.EstadoEntregaPage.BUTTON_CONFIRMAR;
import static co.com.colcomercio.siga.userinterfaces.EstadoEntregaPage.TEXTBOX_MOTIVO_INGRESO;
import static co.com.colcomercio.siga.userinterfaces.ProcesarEjecucionPage.*;
import static co.com.colcomercio.siga.userinterfaces.RegistrarRecepcionPage.*;
import static co.com.colcomercio.siga.utils.WaitingTime.LOW_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IniciarEjecucion implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SwitchIframe.to(IFRAME_REGISTRAR_RECEPCION),
                WaitUntil.the(BUTTON_INICIAR_EJECUCION, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                ClickOnElement.on(BUTTON_INICIAR_EJECUCION),
                Wait.withDuration(5),
                Switch.toDefaultContext(),
                ClickOnElement.on(BUTTON_CONFIRMAR),
                Wait.withDuration(5),
                SwitchIframe.to(IFRAME_REGISTRAR_RECEPCION),
                ClickOnElement.on(BUTTON_EJECUTAR_ACCION),
                ClickOnElement.on(BUTTON_SELECT_CREAR_NOVEDAD_TP),
                Wait.withDuration(10),
                Switch.toDefaultContext(),
                SwitchIframe.to(IFRAME_DOS),
                Wait.withDuration(2),
                ClickOnElement.on(TEXTBOX_AGREGAR_TECICO),
                EnterText.intoField("Torres Jorge",TEXTBOX_AGREGAR_TECICO),
                Hit.the(Keys.ENTER).into(TEXTBOX_AGREGAR_TECICO),
                ClickOnElement.on(TAP_PARTES),
                Wait.withDuration(10),
                SelectFromOptions.byValue("False").from(SELECT_COTIZACION),
                Wait.withDuration(5),
                ClickOnElement.on(TEXTBOX_TIPO_DE_ORDEN),
                Wait.withDuration(2),
                EnterText.intoField("Repuesto",TEXTBOX_TIPO_DE_ORDEN),
                Wait.withDuration(2),
                Hit.the(Keys.ENTER).into(TEXTBOX_TIPO_DE_ORDEN),
                Wait.withDuration(2),
                ClickOnElement.on(TEXTBOX_AGREGAR_PARTE),
                EnterText.intoField("7701023119092",TEXTBOX_AGREGAR_PARTE),
                Wait.withDuration(2),
                Hit.the(Keys.ARROW_DOWN).into(TEXTBOX_AGREGAR_PARTE),
                Hit.the(Keys.ENTER).into(TEXTBOX_AGREGAR_PARTE),
                EnterText.intoField("2",TEXTBOX_CANTIDAD),
                Wait.withDuration(2),
                WaitUntil.the(BUTTON_CONSULTAR_DESCUENTO, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                ScrollToElement.to(BUTTON_CONSULTAR_DESCUENTO),
                ClickOnElement.on(BUTTON_CONSULTAR_DESCUENTO),
                WaitUntil.the(BUTTON_CREAR_NOVEDAD_TP, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                Wait.withDuration(10),
                ClickOnElement.on(BUTTON_CREAR_NOVEDAD_TP),
                Switch.toDefaultContext(),
                ClickOnElement.on(BUTTON_CONFIRMAR),
                Wait.withDuration(10),
                JavaScriptClick.on(BUTTON_CERRAR_POPUP),
                SwitchIframe.to(IFRAME_DOS),
                ClickOnElement.on(TEXTBOX_MOTIVO_DETENCION),
                EnterText.intoField("fin de jornada",TEXTBOX_MOTIVO_DETENCION),
                Wait.withDuration(5),
                Hit.the(Keys.ARROW_DOWN).into(TEXTBOX_MOTIVO_DETENCION),
                Hit.the(Keys.ENTER).into(TEXTBOX_MOTIVO_DETENCION),
                ClickOnElement.on(BUTTON_DETENET_EJECUCION),
                Switch.toDefaultContext(),
                ClickOnElement.on(BUTTON_CONFIRMAR),
                Wait.withDuration(20)




        );
    }
    public static IniciarEjecucion iniciar(){return Tasks.instrumented(IniciarEjecucion.class);
    }
}
