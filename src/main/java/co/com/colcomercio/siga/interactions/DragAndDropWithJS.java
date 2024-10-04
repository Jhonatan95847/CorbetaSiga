package co.com.colcomercio.siga.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DragAndDropWithJS implements Task {

    private final Target sourceElement;
    private final Target targetElement;

    public DragAndDropWithJS(Target sourceElement, Target targetElement) {
        this.sourceElement = sourceElement;
        this.targetElement = targetElement;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebElement fromElement = sourceElement.resolveFor(actor).getElement();
        WebElement toElement = targetElement.resolveFor(actor).getElement();

        // Ejecutar el script de arrastrar y soltar
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "function createEvent(typeOfEvent) {" +
                "var event = document.createEvent('CustomEvent');" +
                "event.initCustomEvent(typeOfEvent, true, true, null);" +
                "event.dataTransfer = {" +
                "data: {}," +
                "setData: function(key, value) { this.data[key] = value; }," +
                "getData: function(key) { return this.data[key]; }" +
                "};" +
                "return event;" +
                "}" +
                "function dispatchEvent(element, event, transferData) {" +
                "if (transferData !== undefined) {" +
                "event.dataTransfer = transferData;" +
                "}" +
                "if (element.dispatchEvent) {" +
                "element.dispatchEvent(event);" +
                "} else if (element.fireEvent) {" +
                "element.fireEvent('on' + event.type, event);" +
                "}" +
                "}" +
                "function simulateHTML5DragAndDrop(element, destination) {" +
                "var dragStartEvent = createEvent('dragstart');" +
                "dispatchEvent(element, dragStartEvent);" +
                "var dropEvent = createEvent('drop');" +
                "dispatchEvent(destination, dropEvent, dragStartEvent.dataTransfer);" +
                "var dragEndEvent = createEvent('dragend');" +
                "dispatchEvent(element, dragEndEvent, dragStartEvent.dataTransfer);" +
                "}" +
                "simulateHTML5DragAndDrop(arguments[0], arguments[1]);";

        // Ejecutar el script
        js.executeScript(script, fromElement, toElement);
    }

    public static DragAndDropWithJS between(Target sourceElement, Target targetElement) {
        return instrumented(DragAndDropWithJS.class, sourceElement, targetElement);
    }
}