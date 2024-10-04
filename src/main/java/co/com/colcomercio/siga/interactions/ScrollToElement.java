package co.com.colcomercio.siga.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class ScrollToElement implements Interaction {


    private final Target target;

    public ScrollToElement(Target target) {
        this.target = target;
    }

    public static ScrollToElement to(Target target) {
        return instrumented(ScrollToElement.class, target);
    }
    private static final Logger logger = LogManager.getLogger(ScrollToElement.class);
    @Override
    public <T extends Actor> void performAs(T actor) {
        logger.info("Haciendo scroll###########################");
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebElement element = target.resolveFor(actor);

        ((JavascriptExecutor) driver).executeScript(
                "const element = arguments[0];" +
                        "const rect = element.getBoundingClientRect();" +
                        "window.scrollBy({top: rect.top - (window.innerHeight / 2), left: 0, behavior: 'instant'});",
                element
        );
    }
}
