package co.com.colcomercio.siga.tasks;

import co.com.colcomercio.siga.interactions.ClickOnElement;
import co.com.colcomercio.siga.interactions.EnterText;
import co.com.colcomercio.siga.interactions.Wait;
import co.com.colcomercio.siga.utils.ExecuteSQLQuery;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static co.com.colcomercio.siga.userinterfaces.BusquedaVehiculoPage.BUTTON_BUSCAR_VEHICULO;
import static co.com.colcomercio.siga.userinterfaces.BusquedaVehiculoPage.TEXTBOX_SERIE_CHASIS;
import static co.com.colcomercio.siga.userinterfaces.SideMenu.BUTTON_MENU;
import static co.com.colcomercio.siga.utils.WaitingTime.LOW_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BuscarChasis implements Task {
    private static final Logger logger = LogManager.getLogger(BuscarChasis.class);
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TEXTBOX_SERIE_CHASIS, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                EnterText.intoField("9G4B2MBV4GPC00142",TEXTBOX_SERIE_CHASIS),
                ClickOnElement.on(BUTTON_BUSCAR_VEHICULO) //button[@class="btn-close"]

        );
    }
    public static BuscarChasis buscar(){return Tasks.instrumented(BuscarChasis.class);
    }
}
