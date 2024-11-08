package co.com.colcomercio.siga.tasks;

import co.com.colcomercio.siga.interactions.ClickOnElement;
import co.com.colcomercio.siga.interactions.EnterText;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static co.com.colcomercio.siga.userinterfaces.BusquedaVehiculoPage.BUTTON_BUSCAR_VEHICULO;
import static co.com.colcomercio.siga.userinterfaces.BusquedaVehiculoPage.TEXTBOX_SERIE_CHASIS;

public class BuscarChasis implements Task {
    private static final Logger logger = LogManager.getLogger(BuscarChasis.class);
    @Override
    @Step("Buscando chasis")
    public <T extends Actor> void performAs(T actor) {
        String queryResult = actor.recall("queryResult");
        logger.info("###########################BUSCANDO CHASIS##################################");
        actor.attemptsTo(
                EnterText.intoField(queryResult,TEXTBOX_SERIE_CHASIS),
                ClickOnElement.on(BUTTON_BUSCAR_VEHICULO)
        );
    }
    public static BuscarChasis buscar(){return Tasks.instrumented(BuscarChasis.class);
    }
}
