package co.com.colcomercio.siga.tasks;

import co.com.colcomercio.siga.interactions.ClickOnElement;
import co.com.colcomercio.siga.interactions.EnterText;
import co.com.colcomercio.siga.interactions.Wait;
import co.com.colcomercio.siga.models.users.Users;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static co.com.colcomercio.siga.userinterfaces.LoginPage.*;
import static co.com.colcomercio.siga.utils.WaitingTime.LOW_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Login implements Task {
    private static final Logger logger = LogManager.getLogger(Login.class);
    private final Users users;

    public Login(Users users) {
        this.users = users;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        logger.info("################################BUSCANDO PRODUCTO##############################");
        actor.attemptsTo(
                WaitUntil.the(TEXTBOX_USER, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                EnterText.intoField(users.getDataUsers().getUser(),TEXTBOX_USER),
                EnterText.intoField(users.getDataUsers().getPassword(),TEXTBOX_PASS),
                ClickOnElement.on(BUTTON_LOGIN),
                Wait.withDuration(5),
                SelectFromOptions.byVisibleText("CORAUTOS").from(SELECT_UNIDAD_NEGOCIO)
        );
    }

    public static Login addCredentials(Users users){return Tasks.instrumented(Login.class, users);}
}
