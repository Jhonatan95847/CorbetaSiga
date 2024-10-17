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
import static co.com.colcomercio.siga.utils.constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DatosVehiculo implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Wait.withDuration(MICRO_TIME),
                SwitchIframe.to(IFRAME_REGISTRAR_RECEPCION),
                WaitUntil.the(TEXTBOX_TALLER_CLICK, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                ClickOnElement.on(TEXTBOX_TALLER_CLICK),
                ScrollToElement.to(TEXTBOX_TALLER),
                EnterText.intoField(taller,TEXTBOX_TALLER),
                Hit.the(Keys.ENTER).into(TEXTBOX_TALLER),
                //Wait.withDuration(MICRO_TIME),
                //EnterText.intoField("AS",TEXTBOX_PLACA),
                WaitUntil.the(TEXTBOX_KILOMETRAJE, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                Wait.withDuration(MICRO_TIME),
                EnterText.intoField(kilometraje,TEXTBOX_KILOMETRAJE),
                WaitUntil.the(TEXTBOX_HORAS, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                ClickOnElement.on(TEXTBOX_HORAS),
                Wait.withDuration(MICRO_TIME),
                EnterText.intoField(horas,TEXTBOX_HORAS)
        );
    }
    public static DatosVehiculo addData(){return Tasks.instrumented(DatosVehiculo.class);
    }
}
