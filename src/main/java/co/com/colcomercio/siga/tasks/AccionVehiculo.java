package co.com.colcomercio.siga.tasks;

import co.com.colcomercio.siga.interactions.ClickOnElement;
import co.com.colcomercio.siga.interactions.GetText;
import co.com.colcomercio.siga.interactions.Wait;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.colcomercio.siga.userinterfaces.OpcionesTuercaPage.*;
import static co.com.colcomercio.siga.utils.WaitingTime.LOW_TIME;
import static co.com.colcomercio.siga.utils.WaitingTime.MICRO_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AccionVehiculo implements Task {
    private final String accion;

    public AccionVehiculo(String accion) {
        this.accion = accion;
    }

    @Override
    @Step("Seleccionando accion")
    public <T extends Actor> void performAs(T actor) {
        if (accion.equals("Asignar OT a Celda")){
            actor.attemptsTo(
                    GetText.ofElement(TEXT_ORDEN_TRABAJO,"Orden_de_trabajo")
            );
        }
        actor.attemptsTo(
                Wait.withDuration(7),
                ClickOnElement.on(BUTTON_TUERCA),
                ClickOnElement.on(SELECT_OPCIONES_TUERCA.of(accion)),
                Wait.withDuration(MICRO_TIME)
        );

    }
    public static AccionVehiculo accion(String accion){return Tasks.instrumented(AccionVehiculo.class, accion);
    }
}
