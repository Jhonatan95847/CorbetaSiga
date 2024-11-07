package co.com.colcomercio.siga.tasks.formularios;

import co.com.colcomercio.siga.interactions.*;
import co.com.colcomercio.siga.interactions.ClickOnElement;
import co.com.colcomercio.siga.models.users.Negocio;
import co.com.colcomercio.siga.utils.SwitchIframe;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import static co.com.colcomercio.siga.userinterfaces.AsignarSolicitud.*;
import static co.com.colcomercio.siga.userinterfaces.OpcionesTuercaPage.TEXT_ORDEN_TRABAJO;
import static co.com.colcomercio.siga.userinterfaces.RegistrarRecepcionPage.BUTTON_CONFIRMAR;
import static co.com.colcomercio.siga.userinterfaces.RegistrarRecepcionPage.IFRAME_REGISTRAR_RECEPCION;
import static co.com.colcomercio.siga.utils.WaitingTime.LOW_TIME;
import static co.com.colcomercio.siga.utils.WaitingTime.MICRO_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AsignarOT implements Task {
    private static final Logger logger = LogManager.getLogger(AsignarOT.class);
    private final Negocio negocio;

    public AsignarOT(Negocio negocio) {
        this.negocio = negocio;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        logger.info("#####################################ASIGNAR ORDEN DE TRABAJO########################");
        actor.attemptsTo(
                Wait.withDuration(MICRO_TIME),
                WaitUntil.the(IFRAME_REGISTRAR_RECEPCION, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                SwitchIframe.to(IFRAME_REGISTRAR_RECEPCION),
                Wait.withDuration(MICRO_TIME),
                DefineWorkCell.on(negocio.getDataNegocio().getCelda(), "23:30", "00:00"),
                Wait.withDuration(MICRO_TIME),
                ClickOnElement.on(BUTTON_ASIGNAR_OT),
                Switch.toDefaultContext(),
                ClickOnElement.on(BUTTON_CONFIRMAR)
        );
    }
    public static AsignarOT asignar(Negocio negocio){return Tasks.instrumented(AsignarOT.class, negocio);
    }
}
