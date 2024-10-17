package co.com.colcomercio.siga.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static co.com.colcomercio.siga.userinterfaces.ProcesarEjecucionPage.*;
import static co.com.colcomercio.siga.utils.WaitingTime.LOW_TIME;
import static co.com.colcomercio.siga.utils.WaitingTime.MICRO_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AgregarPartes implements Interaction {
    private final String tipoParte;
    private final String parte;
    private final String cantidad;
    private final String position;

    public AgregarPartes(String tipoParte, String parte, String cantidad, String position) {
        this.tipoParte = tipoParte;
        this.parte = parte;
        this.cantidad = cantidad;
        this.position = position;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TEXTBOX_TIPO_DE_ORDEN.of(position), isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                Wait.withDuration(MICRO_TIME),
                ClickOnElement.on(TEXTBOX_TIPO_DE_ORDEN.of(position)),
                Wait.withDuration(MICRO_TIME),
                EnterText.intoField(tipoParte,TEXTBOX_TIPO_DE_ORDEN.of(position)),
                Wait.withDuration(5),
                Hit.the(Keys.ENTER).into(TEXTBOX_TIPO_DE_ORDEN.of(position)),
                Wait.withDuration(MICRO_TIME),
                ClickOnElement.on(TEXTBOX_AGREGAR_PARTE.of(position)),
                EnterText.intoField(parte,TEXTBOX_AGREGAR_PARTE.of(position)),
                Wait.withDuration(5),
                Hit.the(Keys.ARROW_DOWN).into(TEXTBOX_AGREGAR_PARTE.of(position)),
                Hit.the(Keys.ENTER).into(TEXTBOX_AGREGAR_PARTE.of(position))

        );
        if (tipoParte.equals("Servicio")){
            actor.attemptsTo(
                    Wait.withDuration(MICRO_TIME),
                    EnterText.intoField(cantidad,TEXTBOX_CANTIDAD_SERVICIO.of(position)),
                    Wait.withDuration(MICRO_TIME)
            );
        }else{
            actor.attemptsTo(
                    Wait.withDuration(MICRO_TIME),
                    EnterText.intoField(cantidad,TEXTBOX_CANTIDAD.of(position)),
                    Wait.withDuration(MICRO_TIME)
            );
        }

    }

    public static AgregarPartes agrgar(String tipoParte, String parte, String cantidad, String position){return Tasks.instrumented(AgregarPartes.class, tipoParte, parte, cantidad, position);
    }
}
