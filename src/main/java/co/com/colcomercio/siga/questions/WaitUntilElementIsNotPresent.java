package co.com.colcomercio.siga.questions;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.conditions.Check;


import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;

public class WaitUntilElementIsNotPresent implements Task {

    private final Target target;
    private final int waitTimeInSeconds;

    public WaitUntilElementIsNotPresent(Target target, int waitTimeInSeconds) {
        this.target = target;
        this.waitTimeInSeconds = waitTimeInSeconds;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Check.whether(target.resolveFor(actor).isPresent())
                        .andIfSo(
                                WaitUntil.the(target, isNotPresent())
                                        .forNoMoreThan(waitTimeInSeconds).seconds()
                        )
        );
    }

    public static WaitUntilElementIsNotPresent forThe(Target target, int waitTimeInSeconds) {
        return instrumented(WaitUntilElementIsNotPresent.class, target, waitTimeInSeconds);
    }
}