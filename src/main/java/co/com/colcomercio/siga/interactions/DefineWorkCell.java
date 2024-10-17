package co.com.colcomercio.siga.interactions;



import co.com.colcomercio.siga.utils.General;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import org.openqa.selenium.JavascriptExecutor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static co.com.colcomercio.siga.userinterfaces.AsignarSolicitud.*;


public class DefineWorkCell implements Interaction {
    private final String cell;
    private final String minimumTime;
    private final String maximumTime;

    public DefineWorkCell(String cell, String minimumTime, String maximumTime) {
        this.cell = cell;
        this.minimumTime = minimumTime;
        this.maximumTime = maximumTime;
    }

    public static Performable on(String cell, String minimumTime, String maximumTime) {
        return Tasks.instrumented(DefineWorkCell.class, cell, minimumTime, maximumTime);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Serenity.getWebdriverManager().getWebdriver();
        LocalDate actualDate = LocalDate.now();
        LocalDate nextDate = actualDate.plusDays(1);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String actualDateFormatted = actualDate.format(format);
        String nextDateFormatted = nextDate.format(format);

        jsExecutor.executeScript(General.ARGUMENTS.getMsj(), INPUT_CELL.resolveFor(actor).getElement(), cell);
        switch (evaluarCaso(minimumTime, maximumTime)) {

            case 1:
                jsExecutor.executeScript(General.ARGUMENTS.getMsj(), INPUT_MINIMUM_TIME.resolveFor(actor).getElement(), nextDateFormatted + " " + minimumTime);
                jsExecutor.executeScript(General.ARGUMENTS.getMsj(), INPUT_MAXIMUM_TIME.resolveFor(actor).getElement(), nextDateFormatted + " " + maximumTime);
                break;
            case 2:
                jsExecutor.executeScript(General.ARGUMENTS.getMsj(), INPUT_MINIMUM_TIME.resolveFor(actor).getElement(), actualDateFormatted + " " + minimumTime);
                jsExecutor.executeScript(General.ARGUMENTS.getMsj(), INPUT_MAXIMUM_TIME.resolveFor(actor).getElement(), nextDateFormatted + " " + maximumTime);
                break;
            case 3:
                jsExecutor.executeScript(General.ARGUMENTS.getMsj(), INPUT_MINIMUM_TIME.resolveFor(actor).getElement(), actualDateFormatted + " " + minimumTime);
                jsExecutor.executeScript(General.ARGUMENTS.getMsj(), INPUT_MAXIMUM_TIME.resolveFor(actor).getElement(), actualDateFormatted + " " + maximumTime);
                break;
            default:

        }
        jsExecutor.executeScript("arguments[0].value='true';", CHECK_EVENT.resolveFor(actor).getElement());
    }


    private static int evaluarCaso(String minimumTime, String maximumTime) {
        if (minimumTime.equals(General.ZEROS.getMsj()) && maximumTime.equals(General.ZEROS.getMsj())) {
            return 1;
        } else if (minimumTime.equals("23:30") && maximumTime.equals(General.ZEROS.getMsj())) {
            return 2;
        } else {
            return 3;
        }
    }
}



