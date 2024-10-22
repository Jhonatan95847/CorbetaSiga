package co.com.colcomercio.siga.interactions.RegistrarRecepcion;

import co.com.colcomercio.siga.interactions.ClickOnElement;
import co.com.colcomercio.siga.interactions.EnterText;
import co.com.colcomercio.siga.interactions.ScrollToElement;
import co.com.colcomercio.siga.interactions.Wait;
import co.com.colcomercio.siga.utils.SwitchIframe;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static co.com.colcomercio.siga.userinterfaces.RegistrarRecepcionPage.*;
import static co.com.colcomercio.siga.utils.WaitingTime.LOW_TIME;
import static co.com.colcomercio.siga.utils.WaitingTime.MICRO_TIME;
import static co.com.colcomercio.siga.utils.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DatosVehiculo implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Wait.withDuration(MICRO_TIME),
                WaitUntil.the(IFRAME_REGISTRAR_RECEPCION, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                SwitchIframe.to(IFRAME_REGISTRAR_RECEPCION),
                ClickOnElement.on(TEXTBOX_TALLER_CLICK),
                ScrollToElement.to(TEXTBOX_TALLER),
                EnterText.intoField(TALLER,TEXTBOX_TALLER),
                Hit.the(Keys.ENTER).into(TEXTBOX_TALLER),
                Wait.withDuration(MICRO_TIME),
                EnterText.intoField(KILOMETRAJE,TEXTBOX_KILOMETRAJE),
                ClickOnElement.on(TEXTBOX_HORAS),
                Wait.withDuration(MICRO_TIME),
                EnterText.intoField(HORAS,TEXTBOX_HORAS)
        );
    }
    public static DatosVehiculo addData(){return Tasks.instrumented(DatosVehiculo.class);
    }
}
