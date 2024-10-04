package co.com.colcomercio.siga.utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.core.Serenity.getDriver;

public class SwitchIframe implements Interaction {

    private final Target iframe;

    public SwitchIframe(Target iframe) {
        this.iframe = iframe;
    }

    public static SwitchIframe to(Target iframe) {
        return Tasks.instrumented(SwitchIframe.class, iframe);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        getDriver().switchTo().frame(iframe.resolveFor(actor).getElement());
    }
}