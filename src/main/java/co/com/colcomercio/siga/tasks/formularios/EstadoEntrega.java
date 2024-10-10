package co.com.colcomercio.siga.tasks.formularios;

import co.com.colcomercio.siga.interactions.ClickOnElement;
import co.com.colcomercio.siga.interactions.EnterText;
import co.com.colcomercio.siga.interactions.ScrollToElement;
import co.com.colcomercio.siga.interactions.Wait;
import co.com.colcomercio.siga.utils.SwitchIframe;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;

import static co.com.colcomercio.siga.userinterfaces.EstadoEntregaPage.*;
import static co.com.colcomercio.siga.userinterfaces.EstadoEntregaPage.BUTTON_CONFIRMAR;
import static co.com.colcomercio.siga.userinterfaces.RegistrarRecepcionPage.*;
import static co.com.colcomercio.siga.userinterfaces.RegistrarRecepcionPage.TEXTBOX_TALLER;
import static co.com.colcomercio.siga.utils.WaitingTime.LOW_TIME;
import static co.com.colcomercio.siga.utils.WaitingTime.MICRO_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EstadoEntrega implements Task {
    private static final Logger logger = LogManager.getLogger(EstadoEntrega.class);

    @Override
    public <T extends Actor> void performAs(T actor) {
        logger.info("#########################DILIGENCIANDO FORMULARIO ESTADO DE ENTREGA#################");
        actor.attemptsTo(
                Wait.withDuration(MICRO_TIME),
                SwitchIframe.to(IFRAME_REGISTRAR_RECEPCION),
                WaitUntil.the(TEXTBOX_MOTIVO_INGRESO, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                ClickOnElement.on(TEXTBOX_MOTIVO_INGRESO),
                ScrollToElement.to(TEXTBOX_MOTIVO_INGRESO),
                EnterText.intoField("mantenimiento preventivo",TEXTBOX_MOTIVO_INGRESO),
                Hit.the(Keys.ENTER).into(TEXTBOX_MOTIVO_INGRESO),
                Wait.withDuration(MICRO_TIME),
                JavaScriptClick.on(CHECK_NIVEL_GAS),
                //ClickOnElement.on(CHECK_NIVEL_GAS),
                ClickOnElement.on(CHECK_TODOS_ACCESORIOS),
                ScrollToElement.to(TEXTBOX_OBSERVACIONES),
                EnterText.intoField("Vehiculo para mantenimiento autoamtizacion",TEXTBOX_OBSERVACIONES),
                ClickOnElement.on(CAMPO_FIRMA),
                ClickOnElement.on(BUTTON_CONFIRM_FIRMA),
                ScrollToElement.to(BUTTON_REGISTRAR_OT),
                ClickOnElement.on(BUTTON_REGISTRAR_OT),
                Switch.toDefaultContext(),
                ClickOnElement.on(BUTTON_CONFIRMAR)
                //Wait.withDuration(30)
        );
    }
    public static EstadoEntrega estado(){return Tasks.instrumented(EstadoEntrega.class);
    }
}
