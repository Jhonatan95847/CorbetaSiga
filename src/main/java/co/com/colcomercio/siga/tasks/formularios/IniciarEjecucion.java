package co.com.colcomercio.siga.tasks.formularios;

import co.com.colcomercio.siga.interactions.ClickOnElement;
import co.com.colcomercio.siga.interactions.Wait;
import co.com.colcomercio.siga.utils.SwitchIframe;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.colcomercio.siga.userinterfaces.EstadoEntregaPage.BUTTON_CONFIRMAR;
import static co.com.colcomercio.siga.userinterfaces.ProcesarEjecucionPage.*;
import static co.com.colcomercio.siga.userinterfaces.RegistrarRecepcionPage.*;
import static co.com.colcomercio.siga.utils.WaitingTime.LOW_TIME;
import static co.com.colcomercio.siga.utils.WaitingTime.MICRO_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IniciarEjecucion implements Task {
    private final String accion;

    public IniciarEjecucion(String accion) {
        this.accion = accion;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Wait.withDuration(MICRO_TIME),
                WaitUntil.the(IFRAME_REGISTRAR_RECEPCION, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                Wait.withDuration(MICRO_TIME),
                SwitchIframe.to(IFRAME_REGISTRAR_RECEPCION),
                ClickOnElement.on(BUTTON_INICIAR_EJECUCION),
                Wait.withDuration(MICRO_TIME),
                Switch.toDefaultContext(),
                ClickOnElement.on(BUTTON_CONFIRMAR),
                WaitUntil.the(IFRAME_REGISTRAR_RECEPCION, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                Wait.withDuration(MICRO_TIME),
                SwitchIframe.to(IFRAME_REGISTRAR_RECEPCION),
                ClickOnElement.on(BUTTON_EJECUTAR_ACCION),
                ClickOnElement.on(BUTTON_SELECT_CREAR_NOVEDAD_TP.of(accion)),
                Wait.withDuration(MICRO_TIME),
                Switch.toDefaultContext()

        );
    }
    public static IniciarEjecucion iniciar(String accion){return Tasks.instrumented(IniciarEjecucion.class, accion);
    }
}
