package co.com.colcomercio.siga.tasks;

import co.com.colcomercio.siga.interactions.ClickOnElement;
import co.com.colcomercio.siga.interactions.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.colcomercio.siga.userinterfaces.OpcionesTuercaPage.BUTTON_TUERCA;
import static co.com.colcomercio.siga.userinterfaces.OpcionesTuercaPage.SELECT_OPCIONES_TUERCA;
import static co.com.colcomercio.siga.utils.WaitingTime.LOW_TIME;
import static co.com.colcomercio.siga.utils.WaitingTime.MICRO_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AccionVehiculo implements Task {
    private final String accion;

    public AccionVehiculo(String accion) {
        this.accion = accion;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BUTTON_TUERCA, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                ClickOnElement.on(BUTTON_TUERCA),
                ClickOnElement.on(SELECT_OPCIONES_TUERCA.of(accion)),
                Wait.withDuration(MICRO_TIME)
        );
    }
    public static AccionVehiculo accion(String accion){return Tasks.instrumented(AccionVehiculo.class, accion);
    }
}
