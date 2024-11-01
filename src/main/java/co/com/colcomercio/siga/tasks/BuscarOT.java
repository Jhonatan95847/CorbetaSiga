package co.com.colcomercio.siga.tasks;

import co.com.colcomercio.siga.interactions.ClickOnElement;
import co.com.colcomercio.siga.interactions.EnterText;
import co.com.colcomercio.siga.interactions.GetText;
import co.com.colcomercio.siga.interactions.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;

import static co.com.colcomercio.siga.userinterfaces.BusquedaVehiculoPage.*;
import static co.com.colcomercio.siga.userinterfaces.OpcionesTuercaPage.TEXT_ORDEN_TRABAJO;
import static co.com.colcomercio.siga.utils.WaitingTime.LOW_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BuscarOT implements Task {

    private static final Logger logger = LogManager.getLogger(BuscarOT.class);
    @Override
    public <T extends Actor> void performAs(T actor) {
        String queryResult = actor.recall("queryResult");
        logger.info("##########################BUSCAR ORDEN DE TRABAJO##########################");
        actor.attemptsTo(
                WaitUntil.the(TEXTBOX_OT_CHASIS, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                EnterText.intoField(queryResult,TEXTBOX_OT_CHASIS),
                Wait.withDuration(5),
                Hit.the(Keys.ARROW_DOWN).into("//body"),
                Wait.withDuration(5),
                Hit.the(Keys.ENTER).into("//body"),
                ClickOnElement.on(BUTTON_BUSCAR_OT)
        );
    }
    public static BuscarOT buscar(){return Tasks.instrumented(BuscarOT.class);
    }
}
