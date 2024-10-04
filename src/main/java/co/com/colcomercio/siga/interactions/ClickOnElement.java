package co.com.colcomercio.siga.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


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
                    Click.on(element)
            );
        } else {
            logger.error("No se encontro el elemento: " + element);
        }

    }
}