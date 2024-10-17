package co.com.colcomercio.siga.stepdefinitions;

import co.com.colcomercio.siga.interactions.ClickOnElement;
import co.com.colcomercio.siga.interactions.Wait;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.colcomercio.siga.userinterfaces.LoginPage.BUTTON_CERRAR_SESION;
import static co.com.colcomercio.siga.utils.WaitingTime.LOW_TIME;
import static co.com.colcomercio.siga.utils.WaitingTime.MICRO_TIME;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ResultadosStepDefinitions {
    @Entonces("Genera el numero de la otden de trabajo")
    public void queUnAsesorPqrDeseaAccederAlCrmAlkomprar() {
        theActorCalled("actor").wasAbleTo(
                Switch.toDefaultContext(),
                Wait.withDuration(5),
                WaitUntil.the(BUTTON_CERRAR_SESION, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                ClickOnElement.on(BUTTON_CERRAR_SESION),
                Wait.withDuration(MICRO_TIME)
        );
    }

    @Entonces("la orden de trabajo pasa a estado En ejecucion")
    public void laOrdenDeTrabajoPasaAEstadoEnEjecucion() {
        theActorCalled("actor").wasAbleTo(
                Switch.toDefaultContext(),
                Wait.withDuration(5),
                WaitUntil.the(BUTTON_CERRAR_SESION, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                ClickOnElement.on(BUTTON_CERRAR_SESION),
                Wait.withDuration(MICRO_TIME)
        );
    }

    @Entonces("se crea la novedad TP")
    public void seCreaLaNovedadTP() {
        theActorCalled("actor").wasAbleTo(
                Switch.toDefaultContext(),
                Wait.withDuration(5),
                WaitUntil.the(BUTTON_CERRAR_SESION, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                ClickOnElement.on(BUTTON_CERRAR_SESION),
                Wait.withDuration(MICRO_TIME)
        );
    }

    @Entonces("la novedad TP queda en estado validada")
    public void laNovedadTPQuedaEnEstadoValidada() {
        theActorCalled("actor").wasAbleTo(
                Switch.toDefaultContext(),
                Wait.withDuration(5)
        );
    }
}
