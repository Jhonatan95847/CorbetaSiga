package co.com.colcomercio.siga.tasks;

import co.com.colcomercio.siga.utils.ExecuteSQLQuery;
import co.com.colcomercio.siga.utils.GuardarDatoEnJson;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static co.com.colcomercio.siga.utils.ConsultasSQL.CHASIS_ENTREGADO_AKT;
import static co.com.colcomercio.siga.utils.ConsultasSQL.CHASIS_ENTREGADO_CORAUTOS;
import static co.com.colcomercio.siga.utils.DataGenerator.DataGeneratorDate;

public class ConsultaChasisEntregado implements Task {
    private static final Logger logger = LogManager.getLogger(ConsultaChasisEntregado.class);
    private static String consulta;
    private final String negocio;
    String idKey = DataGeneratorDate();

    public ConsultaChasisEntregado(String negocio) {
        this.negocio = negocio;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (negocio.equals("akt")){
            consulta = CHASIS_ENTREGADO_AKT;
        } else if (negocio.equals("corautos")) {
            consulta =  CHASIS_ENTREGADO_CORAUTOS;
        }
        actor.attemptsTo(
                ExecuteSQLQuery.withParameters(
                        "siga-qag-srv.database.windows.net",     // Host
                        "1433",          // Puerto
                        "siga-qag-db",        // Base de datos o schema
                        "gtkTester",            // Usuario
                        "9740SIGAQagTest",  // Contraseña
                        consulta // Consulta SQL
                )
        );
        String queryResult = actor.recall("queryResult");
        logger.info("=============El resultado de la consulta es: "+queryResult);
        GuardarDatoEnJson.guardarDatoEnJson("serieChasis"+idKey,queryResult,"C:\\Users\\Testqa\\Documents\\GenerarOTSiga\\CorbetaSiga\\src\\ot.json");
    }
    public static ConsultaChasisEntregado consulta(String negocio){return Tasks.instrumented(ConsultaChasisEntregado.class, negocio);
    }
}
