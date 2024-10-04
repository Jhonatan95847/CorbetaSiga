package co.com.colcomercio.siga.interactions.RegistrarRecepcion;

import co.com.colcomercio.siga.interactions.ClickOnElement;
import co.com.colcomercio.siga.interactions.ScrollToElement;
import co.com.colcomercio.siga.interactions.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import static co.com.colcomercio.siga.userinterfaces.RegistrarRecepcionPage.CHECK_MISMO_PROPIETARIO;

public class DatosConductor implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                //Wait.withDuration(10),
                ScrollToElement.to(CHECK_MISMO_PROPIETARIO),
                ClickOnElement.on(CHECK_MISMO_PROPIETARIO)
        );
    }
    public static DatosVehiculo addConductor(){return Tasks.instrumented(DatosVehiculo.class);
    }
}
