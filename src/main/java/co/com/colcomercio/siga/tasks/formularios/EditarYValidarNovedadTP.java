package co.com.colcomercio.siga.tasks.formularios;

import co.com.colcomercio.siga.interactions.ClickOnElement;
import co.com.colcomercio.siga.interactions.ScrollToElement;
import co.com.colcomercio.siga.interactions.Wait;
import co.com.colcomercio.siga.utils.SwitchIframe;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.colcomercio.siga.userinterfaces.EditarYValidarNovedadTP.*;
import static co.com.colcomercio.siga.userinterfaces.RegistrarRecepcionPage.BUTTON_CONFIRMAR;
import static co.com.colcomercio.siga.userinterfaces.RegistrarRecepcionPage.IFRAME_REGISTRAR_RECEPCION;
import static co.com.colcomercio.siga.utils.WaitingTime.LOW_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EditarYValidarNovedadTP implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickOnElement.on(BUTTON_EDITAR_VALIDAR),
                SwitchIframe.to(IFRAME_REGISTRAR_RECEPCION),
                WaitUntil.the(BUTTON_PARTES, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                ClickOnElement.on(BUTTON_PARTES),
                WaitUntil.the(BUTTON_CONTINUAR_DESCUENTOS_COMPROMETIDOS, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                Wait.withDuration(5),
                ScrollToElement.to(BUTTON_CONTINUAR_DESCUENTOS_COMPROMETIDOS),
                ClickOnElement.on(BUTTON_CONTINUAR_DESCUENTOS_COMPROMETIDOS),
                WaitUntil.the(BUTTON_EDITAR_VALIDAR_FINAL, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                Wait.withDuration(5),
                ScrollToElement.to(BUTTON_EDITAR_VALIDAR_FINAL),
                ClickOnElement.on(BUTTON_EDITAR_VALIDAR_FINAL),
                Switch.toDefaultContext(),
                ClickOnElement.on(BUTTON_CONFIRMAR),
                Wait.withDuration(3)
        );
    }

    public static EditarYValidarNovedadTP editar(){return Tasks.instrumented(EditarYValidarNovedadTP.class);
    }
}
