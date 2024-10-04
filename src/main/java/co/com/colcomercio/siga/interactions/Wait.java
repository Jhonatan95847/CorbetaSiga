package co.com.colcomercio.siga.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;


public class Wait implements Interaction {
    private final int timeWait;

    public Wait(int timeWait) {
        this.timeWait = timeWait;
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        try {
            Thread.sleep(timeWait * 1_000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    public static Wait withDuration(int timeWait) {
        return Tasks.instrumented(Wait.class, timeWait);
    }
}