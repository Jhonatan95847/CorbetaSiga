package co.com.colcomercio.siga.tasks;

import co.com.colcomercio.siga.interactions.ClickOnElement;
import co.com.colcomercio.siga.interactions.Wait;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static co.com.colcomercio.siga.userinterfaces.LoginPage.TEXT_AKT;
import static co.com.colcomercio.siga.userinterfaces.LoginPage.TEXT_CORAUTOS;
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
    @Step("Seleccionando la opcion del menu")
    public <T extends Actor> void performAs(T actor) {
        logger.info("#########################SELECCIONANDO LA OPCION EN EL MENU#########################");
        actor.attemptsTo(
                Wait.withDuration(5),
                ClickOnElement.on(BUTTON_MENU),
                Wait.withDuration(MICRO_TIME),
                ClickOnElement.on(MENU_OPTION.of(menu)),
                Wait.withDuration(MICRO_TIME),
                ClickOnElement.on(SUBMENU_OPTION.of(subMenu)),
                Wait.withDuration(5)
        );
        if (menu.equals("Vehículos")){
            if (TEXT_CORAUTOS.isVisibleFor(actor)){
                actor.attemptsTo(
                        ConsultaChasisEntregado.consulta("corautos")
                );
            } else if (TEXT_AKT.isVisibleFor(actor)) {
                 actor.attemptsTo(
                         ConsultaChasisEntregado.consulta("akt")
                 );
            }
        }
    }
    public static MenuOptions selectOption(String menu, String subMenu){return Tasks.instrumented(MenuOptions.class, menu, subMenu);}
}
