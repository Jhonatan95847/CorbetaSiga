package co.com.colcomercio.siga.tasks.formularios;

import co.com.colcomercio.siga.interactions.*;
import co.com.colcomercio.siga.models.users.Negocio;
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
import static co.com.colcomercio.siga.utils.Constantes.MOTIVO_DETENCION;
import static co.com.colcomercio.siga.utils.Constantes.TECNICO_TALLER;
import static co.com.colcomercio.siga.utils.WaitingTime.LOW_TIME;
import static co.com.colcomercio.siga.utils.WaitingTime.MICRO_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CrearNovedadTP implements Task {
    private final Negocio negocio;

    public CrearNovedadTP(Negocio negocio) {
        this.negocio = negocio;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Wait.withDuration(MICRO_TIME),
                WaitUntil.the(IFRAME_DOS, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                Wait.withDuration(MICRO_TIME),
                SwitchIframe.to(IFRAME_DOS),
                Wait.withDuration(MICRO_TIME),
                ClickOnElement.on(TEXTBOX_AGREGAR_TECICO),
                EnterText.intoField(negocio.getDataNegocio().getTecnico(),TEXTBOX_AGREGAR_TECICO),
                Hit.the(Keys.ENTER).into(TEXTBOX_AGREGAR_TECICO),
                Wait.withDuration(MICRO_TIME),
                ClickOnElement.on(TAP_PARTES),
                WaitUntil.the(SELECT_COTIZACION, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                SelectFromOptions.byValue("False").from(SELECT_COTIZACION),
                AgregarPartes.agrgar("Repuesto",negocio.getDataNegocio().getRepuesto(),"2","0"),
                ClickOnElement.on(BUTTON_AGREGAR_PARTE),
                Wait.withDuration(MICRO_TIME),
                AgregarPartes.agrgar("Sustituto",negocio.getDataNegocio().getSustituto(),"3","1"),
                ClickOnElement.on(BUTTON_AGREGAR_PARTE),
                Wait.withDuration(MICRO_TIME),
                AgregarPartes.agrgar("Servicio",negocio.getDataNegocio().getServicio(),"400","2"),
                WaitUntil.the(BUTTON_CONSULTAR_DESCUENTO, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                ScrollToElement.to(BUTTON_CONSULTAR_DESCUENTO),
                ClickOnElement.on(BUTTON_CONSULTAR_DESCUENTO),
                Wait.withDuration(MICRO_TIME),
                WaitUntil.the(BUTTON_CREAR_NOVEDAD_TP, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                Wait.withDuration(5),
                ScrollToElement.to(BUTTON_CREAR_NOVEDAD_TP),
                ClickOnElement.on(BUTTON_CREAR_NOVEDAD_TP),
                Wait.withDuration(5),
                Switch.toDefaultContext(),
                ClickOnElement.on(BUTTON_CONFIRMAR),
                Wait.withDuration(3),
                GetText.ofElement(TEXTO_NUMERO_NOVEDADTP,"NovedadTP"),
                JavaScriptClick.on(BUTTON_CERRAR_POPUP),
                WaitUntil.the(IFRAME_DOS, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                SwitchIframe.to(IFRAME_DOS),
                ClickOnElement.on(TEXTBOX_MOTIVO_DETENCION),
                EnterText.intoField(MOTIVO_DETENCION,TEXTBOX_MOTIVO_DETENCION),
                Wait.withDuration(3),
                Hit.the(Keys.ARROW_DOWN).into(TEXTBOX_MOTIVO_DETENCION),
                Hit.the(Keys.ENTER).into(TEXTBOX_MOTIVO_DETENCION),
                Wait.withDuration(MICRO_TIME),
                ClickOnElement.on(BUTTON_DETENET_EJECUCION),
                Switch.toDefaultContext(),
                ClickOnElement.on(BUTTON_CONFIRMAR)
        );
    }

    public static CrearNovedadTP crear(Negocio negocio){return Tasks.instrumented(CrearNovedadTP.class, negocio);
    }
}
