package co.com.colcomercio.siga.tasks.formularios;

import co.com.colcomercio.siga.interactions.ClickOnElement;
import co.com.colcomercio.siga.interactions.RegistrarRecepcion.CambiarPropietario;
import co.com.colcomercio.siga.interactions.RegistrarRecepcion.DatosVehiculo;
import co.com.colcomercio.siga.interactions.RegistrarRecepcion.FechaRegistro;
import co.com.colcomercio.siga.interactions.ScrollToElement;
import co.com.colcomercio.siga.interactions.Wait;
import co.com.colcomercio.siga.utils.SwitchIframe;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static co.com.colcomercio.siga.userinterfaces.RegistrarRecepcionPage.*;
import static co.com.colcomercio.siga.userinterfaces.RegistrarRecepcionPage.CHECK_MISMO_PROPIETARIO;
import static co.com.colcomercio.siga.utils.WaitingTime.LOW_TIME;
import static co.com.colcomercio.siga.utils.WaitingTime.MICRO_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RegistrarRecepcion implements Task {
    private static final Logger logger = LogManager.getLogger(RegistrarRecepcion.class);

    @Override
    public <T extends Actor> void performAs(T actor) {
        logger.info("#################DILIGENCIANDO FORMULARIO REGISTRAR RECEPCION###############");
        actor.attemptsTo(
                DatosVehiculo.addData(),
                Wait.withDuration(MICRO_TIME)
        );
        if (TEXTBOX_NOMBRE_VALIDAR.isVisibleFor(actor)) {
            actor.attemptsTo(
                    FechaRegistro.addFecha()
            );
        }else {
            actor.attemptsTo(
                    CambiarPropietario.cambiar(),
                    Switch.toDefaultContext(),
                    SwitchIframe.to(IFRAME_REGISTRAR_RECEPCION),
                    FechaRegistro.addFecha()
            );
        }
        actor.attemptsTo(
                ScrollToElement.to(CHECK_MISMO_PROPIETARIO),
                ClickOnElement.on(CHECK_MISMO_PROPIETARIO),
                Wait.withDuration(MICRO_TIME),
                ScrollToElement.to(BUTTON_REGISTRAR_RECEPCION),
                ClickOnElement.on(BUTTON_REGISTRAR_RECEPCION),
                Wait.withDuration(MICRO_TIME),
                Switch.toDefaultContext(),
                WaitUntil.the(BUTTON_CONFIRMAR, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                ClickOnElement.on(BUTTON_CONFIRMAR)
        );
    }
    public static RegistrarRecepcion registrar(){return Tasks.instrumented(RegistrarRecepcion.class);
    }
}
