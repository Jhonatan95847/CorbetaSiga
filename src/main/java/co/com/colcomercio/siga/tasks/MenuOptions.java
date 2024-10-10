package co.com.colcomercio.siga.tasks;

import co.com.colcomercio.siga.interactions.ClickOnElement;
import co.com.colcomercio.siga.interactions.Wait;
import co.com.colcomercio.siga.questions.WaitUntilElementIsNotPresent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static co.com.colcomercio.siga.userinterfaces.SideMenu.*;
import static co.com.colcomercio.siga.utils.WaitingTime.LOW_TIME;
import static co.com.colcomercio.siga.utils.WaitingTime.MICRO_TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class MenuOptions implements Task {
    private static final Logger logger = LogManager.getLogger(MenuOptions.class);
    private final String menu;
    private final String subMenu;

    public MenuOptions(String menu, String subMenu) {
        this.menu = menu;
        this.subMenu = subMenu;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        logger.info("#########################SELECCIONANDO LA OPCION EN EL MENU#########################");
        actor.attemptsTo(
                Wait.withDuration(MICRO_TIME),
                WaitUntil.the(BUTTON_MENU, isVisible()).forNoMoreThan(LOW_TIME).seconds(),
                ClickOnElement.on(BUTTON_MENU),
                ClickOnElement.on(MENU_OPTION.of(menu)),
                ClickOnElement.on(SUBMENU_OPTION.of(subMenu))
        );
    }
    public static MenuOptions selectOption(String menu, String subMenu){return Tasks.instrumented(MenuOptions.class, menu, subMenu);}
}
