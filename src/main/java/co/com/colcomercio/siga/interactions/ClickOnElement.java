package co.com.colcomercio.siga.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static co.com.colcomercio.siga.userinterfaces.EstadoEntregaPage.BUTTON_CONFIRMAR;
import static co.com.colcomercio.siga.utils.WaitingTime.LOW_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class ClickOnElement implements Interaction {
    private final Target element;
    private static final Logger logger = LogManager.getLogger(ClickOnElement.class);

    public ClickOnElement(Target element) {
        this.element = element;
    }

    public static ClickOnElement on(Target element) {
        return Tasks.instrumented(ClickOnElement.class, element);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        if (element.isVisibleFor(actor)){
            logger.info("Hacer click en: " + element);
            actor.attemptsTo(
                    WaitUntil.the(element, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                    Click.on(element)
            );
        } else {
            logger.error("No se encontro el elemento: " + element);
        }

    }
}