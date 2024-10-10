package co.com.colcomercio.siga.tasks.formularios;

import co.com.colcomercio.siga.interactions.ClickOnElement;
import co.com.colcomercio.siga.interactions.EnterText;
import co.com.colcomercio.siga.interactions.ScrollToElement;
import co.com.colcomercio.siga.interactions.Wait;
import co.com.colcomercio.siga.utils.SwitchIframe;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static co.com.colcomercio.siga.userinterfaces.EstadoEntregaPage.BUTTON_CONFIRMAR;
import static co.com.colcomercio.siga.userinterfaces.ProcesarEjecucionPage.*;
import static co.com.colcomercio.siga.userinterfaces.RegistrarRecepcionPage.BUTTON_CERRAR_POPUP;
import static co.com.colcomercio.siga.userinterfaces.RegistrarRecepcionPage.IFRAME_DOS;
import static co.com.colcomercio.siga.utils.WaitingTime.LOW_TIME;
import static co.com.colcomercio.siga.utils.WaitingTime.MICRO_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CrearNovedadTP implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SwitchIframe.to(IFRAME_DOS),
                WaitUntil.the(TEXTBOX_AGREGAR_TECICO, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                Wait.withDuration(MICRO_TIME),
                ClickOnElement.on(TEXTBOX_AGREGAR_TECICO),
                EnterText.intoField("Torres Jorge",TEXTBOX_AGREGAR_TECICO),
                Hit.the(Keys.ENTER).into(TEXTBOX_AGREGAR_TECICO),
                ClickOnElement.on(TAP_PARTES),
                WaitUntil.the(SELECT_COTIZACION, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                SelectFromOptions.byValue("False").from(SELECT_COTIZACION),
                WaitUntil.the(TEXTBOX_TIPO_DE_ORDEN, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                Wait.withDuration(MICRO_TIME),
                ClickOnElement.on(TEXTBOX_TIPO_DE_ORDEN),
                Wait.withDuration(MICRO_TIME),
                EnterText.intoField("Repuesto",TEXTBOX_TIPO_DE_ORDEN),
                Wait.withDuration(5),
                Hit.the(Keys.ENTER).into(TEXTBOX_TIPO_DE_ORDEN),
                Wait.withDuration(MICRO_TIME),
                ClickOnElement.on(TEXTBOX_AGREGAR_PARTE),
                EnterText.intoField("7701023119092",TEXTBOX_AGREGAR_PARTE),
                Wait.withDuration(5),
                Hit.the(Keys.ARROW_DOWN).into(TEXTBOX_AGREGAR_PARTE),
                Hit.the(Keys.ENTER).into(TEXTBOX_AGREGAR_PARTE),
                EnterText.intoField("2",TEXTBOX_CANTIDAD),
                Wait.withDuration(MICRO_TIME),
                WaitUntil.the(BUTTON_CONSULTAR_DESCUENTO, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                ScrollToElement.to(BUTTON_CONSULTAR_DESCUENTO),
                ClickOnElement.on(BUTTON_CONSULTAR_DESCUENTO),
                WaitUntil.the(BUTTON_CREAR_NOVEDAD_TP, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                Wait.withDuration(10),
                ClickOnElement.on(BUTTON_CREAR_NOVEDAD_TP),
                Wait.withDuration(5),
                Switch.toDefaultContext(),
                ClickOnElement.on(BUTTON_CONFIRMAR),
                Wait.withDuration(5),
                JavaScriptClick.on(BUTTON_CERRAR_POPUP),
                SwitchIframe.to(IFRAME_DOS),
                WaitUntil.the(TEXTBOX_MOTIVO_DETENCION, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                ClickOnElement.on(TEXTBOX_MOTIVO_DETENCION),
                EnterText.intoField("fin de jornada",TEXTBOX_MOTIVO_DETENCION),
                Wait.withDuration(5),
                Hit.the(Keys.ARROW_DOWN).into(TEXTBOX_MOTIVO_DETENCION),
                Hit.the(Keys.ENTER).into(TEXTBOX_MOTIVO_DETENCION),
                Wait.withDuration(MICRO_TIME),
                ClickOnElement.on(BUTTON_DETENET_EJECUCION),
                Switch.toDefaultContext(),
                ClickOnElement.on(BUTTON_CONFIRMAR)
        );
    }

    public static CrearNovedadTP crear(){return Tasks.instrumented(CrearNovedadTP.class);
    }
}
