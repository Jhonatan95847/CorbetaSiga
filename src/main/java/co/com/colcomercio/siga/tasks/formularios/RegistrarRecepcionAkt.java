package co.com.colcomercio.siga.tasks.formularios;


import co.com.colcomercio.siga.interactions.ClickOnElement;
import co.com.colcomercio.siga.interactions.EnterText;
import co.com.colcomercio.siga.interactions.RegistrarRecepcion.CambiarPropietario;
import co.com.colcomercio.siga.interactions.RegistrarRecepcion.DatosVehiculo;
import co.com.colcomercio.siga.interactions.ScrollToElement;
import co.com.colcomercio.siga.interactions.Wait;
import co.com.colcomercio.siga.models.users.Negocio;
import co.com.colcomercio.siga.utils.SwitchIframe;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static co.com.colcomercio.siga.userinterfaces.RegistrarRecepcionPage.*;
import static co.com.colcomercio.siga.userinterfaces.RegistrarRecepcionPage.CHECK_MISMO_PROPIETARIO;
import static co.com.colcomercio.siga.utils.Constantes.CONDICION_VEHICULO;
import static co.com.colcomercio.siga.utils.WaitingTime.LOW_TIME;
import static co.com.colcomercio.siga.utils.WaitingTime.MICRO_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RegistrarRecepcionAkt implements Task {
    private static final Logger logger = LogManager.getLogger(RegistrarRecepcionAkt.class);
     private final Negocio negocio;

    public RegistrarRecepcionAkt(Negocio negocio) {
        this.negocio = negocio;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        logger.info("#################DILIGENCIANDO FORMULARIO REGISTRAR RECEPCION###############");
        actor.attemptsTo(
                DatosVehiculo.addData(negocio, "akt"),
                Wait.withDuration(MICRO_TIME)
        );
        if (TEXTBOX_NOMBRE_VALIDAR.isVisibleFor(actor)) {
            actor.attemptsTo(
                    EnterText.intoField(CONDICION_VEHICULO,TEXTBOX_CONDICION)
            );
        }else {
            actor.attemptsTo(
                    CambiarPropietario.cambiar(negocio),
                    Switch.toDefaultContext(),
                    WaitUntil.the(IFRAME_REGISTRAR_RECEPCION, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                    SwitchIframe.to(IFRAME_REGISTRAR_RECEPCION),
                    WaitUntil.the(TEXTBOX_CONDICION, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                    ScrollToElement.to(TEXTBOX_CONDICION),
                    Wait.withDuration(MICRO_TIME),
                    EnterText.intoField(CONDICION_VEHICULO,TEXTBOX_CONDICION),
                    WaitUntil.the(SELECT_ACEITE_AKT, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                    Wait.withDuration(MICRO_TIME),
                    EnterText.intoField(CONDICION_VEHICULO,TEXTBOX_CONDICION),
                    SelectFromOptions.byVisibleText("No").from(SELECT_ACEITE_AKT)
            );
        }
        actor.attemptsTo(
                Wait.withDuration(5),
                ScrollToElement.to(CHECK_MISMO_PROPIETARIO),
                ClickOnElement.on(CHECK_MISMO_PROPIETARIO),
                Wait.withDuration(5),
                ScrollToElement.to(BUTTON_REGISTRAR_RECEPCION),
                ClickOnElement.on(BUTTON_REGISTRAR_RECEPCION),
                Wait.withDuration(MICRO_TIME),
                Switch.toDefaultContext(),
                ClickOnElement.on(BUTTON_CONFIRMAR)
        );
    }
    public static RegistrarRecepcionAkt registrar(Negocio negocio){return Tasks.instrumented(RegistrarRecepcionAkt.class, negocio);
    }
}

