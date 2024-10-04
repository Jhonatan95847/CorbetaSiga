package co.com.colcomercio.siga.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class ElementPresent implements Question<Boolean> {

    private Target target;

    public ElementPresent(Target target) {
        this.target = target;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        try {
            target.resolveFor(actor).isVisible(); // Verifica si el elemento es visible
            return true;  // Si encuentra el elemento, está presente
        } catch (NoSuchElementException e) {
            return false;  // Si lanza NoSuchElementException, no está presente
        }
    }

    public static ElementPresent in(Target target) {
        return new ElementPresent(target);
    }
}