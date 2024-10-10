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

public class LoginValidador implements Task {
    private static final Logger logger = LogManager.getLogger(LoginValidador.class);
    private final Users users;

    public LoginValidador(Users users) {
        this.users = users;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        logger.info("################################INICIANDO SE SESION EN SIGA##############################");
        actor.attemptsTo(
                WaitUntil.the(TEXTBOX_USER, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                EnterText.intoField(users.getDataUsers().getUser(),TEXTBOX_USER),
                EnterText.intoField(users.getDataUsers().getPassword(),TEXTBOX_PASS),
                ClickOnElement.on(BUTTON_LOGIN),
                Wait.withDuration(5)
        );
    }

    public static LoginValidador addCredentials(Users users){return Tasks.instrumented(LoginValidador.class, users);}
}