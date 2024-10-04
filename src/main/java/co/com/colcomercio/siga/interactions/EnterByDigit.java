package co.com.colcomercio.siga.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

public class EnterByDigit implements Interaction {

    private String value;
    private Target target;
    public EnterByDigit(Target target, String value){
        this.value = value;
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (char digit:value.toCharArray()) {
            actor.attemptsTo(
                    Enter.keyValues(String.valueOf(digit)).into(target)
            );
        }
    }

    public static EnterByDigit onTargetTheString(String value, Target target){
        return Tasks.instrumented(EnterByDigit.class,target,value);
    }



}
