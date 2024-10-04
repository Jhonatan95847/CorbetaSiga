package co.com.colcomercio.siga.interactions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class GetText implements Interaction {
    private static final Logger logger = LogManager.getLogger(GetText.class);
    private final Target elemento;
    //String keyCompraJson = DataGeneratorDate();
    public GetText(Target elemento) {
        this.elemento = elemento;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String texto = Text.of(elemento).answeredBy(actor);
        logger.info("El valor elemto es " + texto);
        //GuardarTextoEnArchivo.guardarTexto(","+texto,"C:\\Users\\1049644474\\Documents\\Automatizacion\\Baseautomatizacion\\financiero-testing-qa\\src\\archivo.txt");
        //GuardarDatoEnJson.guardarDatoEnJson("compra"+keyCompraJson,texto,"C:\\Users\\1049644474\\Documents\\Automatizacion\\Baseautomatizacion\\financiero-testing-qa\\src\\pedido.json");
    }

    public static GetText ofElement(Target elemento) {
        return Tasks.instrumented(GetText.class, elemento);
    }
}