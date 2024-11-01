package co.com.colcomercio.siga.interactions.RegistrarRecepcion;

import co.com.colcomercio.siga.interactions.ClickOnElement;
import co.com.colcomercio.siga.interactions.EnterText;
import co.com.colcomercio.siga.interactions.ScrollToElement;
import co.com.colcomercio.siga.interactions.Wait;
import co.com.colcomercio.siga.models.users.Negocio;
import co.com.colcomercio.siga.utils.SwitchIframe;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static co.com.colcomercio.siga.userinterfaces.RegistrarRecepcionPage.*;
import static co.com.colcomercio.siga.utils.DataGenerator.DataGeneratorDate;
import static co.com.colcomercio.siga.utils.WaitingTime.LOW_TIME;
import static co.com.colcomercio.siga.utils.WaitingTime.MICRO_TIME;
import static co.com.colcomercio.siga.utils.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DatosVehiculo implements Interaction {
    private final String taller;
    private final Negocio negocio;
    String idKey = DataGeneratorDate();
    String numeroPlaca = idKey.substring(idKey.length() - 4);

    public DatosVehiculo( Negocio negocio, String taller) {
        this.negocio = negocio;
        this.taller = taller;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Wait.withDuration(MICRO_TIME),
                WaitUntil.the(IFRAME_REGISTRAR_RECEPCION, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                SwitchIframe.to(IFRAME_REGISTRAR_RECEPCION),
                ClickOnElement.on(TEXTBOX_TALLER_CLICK),
                ScrollToElement.to(TEXTBOX_TALLER),
                EnterText.intoField(negocio.getDataNegocio().getTaller(),TEXTBOX_TALLER),
                Hit.the(Keys.ENTER).into(TEXTBOX_TALLER),
                Wait.withDuration(MICRO_TIME)
        );
        if (taller.equals("akt")){
            actor.attemptsTo(
                    Switch.toDefaultContext(),
                    Wait.withDuration(MICRO_TIME),
                    WaitUntil.the(BUTTON_CERRAR_ADVERTENCIA, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                    JavaScriptClick.on(BUTTON_CERRAR_ADVERTENCIA),
                    Wait.withDuration(MICRO_TIME),
                    SwitchIframe.to(IFRAME_REGISTRAR_RECEPCION)
            );
        }
        actor.attemptsTo(
                Clear.field(TEXTBOX_PLACA),
                Wait.withDuration(MICRO_TIME),
                EnterText.intoField("UWY"+numeroPlaca,TEXTBOX_PLACA),
                Wait.withDuration(MICRO_TIME),
                EnterText.intoField(KILOMETRAJE,TEXTBOX_KILOMETRAJE),
                Wait.withDuration(MICRO_TIME)
        );
        if (taller.equals("corautos")){
            actor.attemptsTo(
                    Wait.withDuration(MICRO_TIME),
                    ClickOnElement.on(TEXTBOX_HORAS),
                    Wait.withDuration(MICRO_TIME),
                    EnterText.intoField(HORAS,TEXTBOX_HORAS),
                    Wait.withDuration(5)
            );
        }
    }
    public static DatosVehiculo addData(Negocio negocio, String taller){return Tasks.instrumented(DatosVehiculo.class, negocio, taller);
    }
}
