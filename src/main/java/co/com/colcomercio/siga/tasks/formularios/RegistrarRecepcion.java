package co.com.colcomercio.siga.tasks.formularios;

import co.com.colcomercio.siga.interactions.ClickOnElement;
import co.com.colcomercio.siga.interactions.RegistrarRecepcion.CambiarPropietario;
import co.com.colcomercio.siga.interactions.RegistrarRecepcion.DatosConductor;
import co.com.colcomercio.siga.interactions.RegistrarRecepcion.DatosVehiculo;
import co.com.colcomercio.siga.interactions.RegistrarRecepcion.FechaRegistro;
import co.com.colcomercio.siga.interactions.ScrollToElement;
import co.com.colcomercio.siga.interactions.Wait;
import co.com.colcomercio.siga.questions.ElementPresent;
import co.com.colcomercio.siga.utils.SwitchIframe;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Switch;

import static co.com.colcomercio.siga.userinterfaces.RegistrarRecepcionPage.*;
import static co.com.colcomercio.siga.userinterfaces.RegistrarRecepcionPage.CHECK_MISMO_PROPIETARIO;
import static co.com.colcomercio.siga.utils.WaitingTime.MICRO_TIME;

public class RegistrarRecepcion implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
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
                //DatosConductor.addConductor(),
                Wait.withDuration(5),
                ScrollToElement.to(BUTTON_REGISTRAR_RECEPCION),
                ClickOnElement.on(BUTTON_REGISTRAR_RECEPCION),
                Wait.withDuration(10),
                Switch.toDefaultContext(),
                ClickOnElement.on(BUTTON_CONFIRMAR),
                Wait.withDuration(10)
        );
    }
    public static RegistrarRecepcion registrar(){return Tasks.instrumented(RegistrarRecepcion.class);
    }
}
