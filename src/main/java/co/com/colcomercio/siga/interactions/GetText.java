package co.com.colcomercio.siga.interactions;



import co.com.colcomercio.siga.utils.GuardarDatoEnJson;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static co.com.colcomercio.siga.utils.DataGenerator.DataGeneratorDate;


public class GetText implements Interaction {
    private static final Logger logger = LogManager.getLogger(GetText.class);
    private final Target elemento;
    private final String key;
    String idKey = DataGeneratorDate();
    public GetText(Target elemento, String key) {
        this.elemento = elemento;
        this.key = key;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String texto = Text.of(elemento).answeredBy(actor);
        logger.info("El valor elemto es " + texto);
        GuardarDatoEnJson.guardarDatoEnJson(key+idKey,texto,"C:\\Users\\1049644474\\Documents\\Automatizacion\\Baseautomatizacion\\siga-testing-qa\\src\\ot.json");
    }

    public static GetText ofElement(Target elemento, String key) {
        return Tasks.instrumented(GetText.class, elemento, key);
    }
}