package co.com.colcomercio.siga.interactions.RegistrarRecepcion;

import org.openqa.selenium.JavascriptExecutor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SimularArrastreConJS implements Task {

    private final Target elementoOrigen;
    private final Target elementoDestino;

    public SimularArrastreConJS(Target elementoOrigen, Target elementoDestino) {
        this.elementoOrigen = elementoOrigen;
        this.elementoDestino = elementoDestino;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = ThucydidesWebDriverSupport.getDriver();
        WebElement origen = elementoOrigen.resolveFor(actor);
        WebElement destino = elementoDestino.resolveFor(actor);

        String script = "function createEvent(typeOfEvent) { " +
                "var event = document.createEvent(\"CustomEvent\");" +
                "event.initCustomEvent(typeOfEvent, true, true, null);" +
                "event.dataTransfer = {" +
                "data: {}," +
                "setData: function(key, value) {this.data[key] = value;}," +
                "getData: function(key) {return this.data[key];}" +
                "}; return event; } " +
                "function dispatchEvent(element, event, transferData) { " +
                "if (transferData !== undefined) { " +
                "event.dataTransfer = transferData; } " +
                "if (element.dispatchEvent) { element.dispatchEvent(event); } " +
                "else if (element.fireEvent) { element.fireEvent(\"on\" + event.type, event); } } " +
                "function simulateHTML5DragAndDrop(elementDrag, elementDrop) { " +
                "var dragStartEvent = createEvent('dragstart'); dispatchEvent(elementDrag, dragStartEvent); " +
                "var dropEvent = createEvent('drop'); dispatchEvent(elementDrop, dropEvent, dragStartEvent.dataTransfer); " +
                "var dragEndEvent = createEvent('dragend'); dispatchEvent(elementDrag, dragEndEvent, dragStartEvent.dataTransfer); } " +
                "simulateHTML5DragAndDrop(arguments[0], arguments[1])";

        ((JavascriptExecutor) driver).executeScript(script, origen, destino);
    }

    public static SimularArrastreConJS desdeHasta(Target elementoOrigen, Target elementoDestino) {
        return new SimularArrastreConJS(elementoOrigen, elementoDestino);
    }
}
