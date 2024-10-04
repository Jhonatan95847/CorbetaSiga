package co.com.colcomercio.siga.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ScrollVertically implements Task {

    private final int pixels;

    public ScrollVertically(int pixels) {
        this.pixels = pixels;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        // Ejecutar el script de JavaScript para hacer scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, arguments[0]);", pixels);
    }

    public static ScrollVertically by(int pixels) {
        return instrumented(ScrollVertically.class, pixels);
    }
}
