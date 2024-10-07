package co.com.colcomercio.siga.tasks;

import co.com.colcomercio.siga.utils.ExecuteSQLQuery;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConsultaChasisEntregado implements Task {
    private static final Logger logger = LogManager.getLogger(ExecuteSQLQuery.class);

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ExecuteSQLQuery.withParameters(
                        "siga-pre-db-srv.database.windows.net",     // Host
                        "1433",          // Puerto
                        "siga-pre-db",        // Base de datos o schema
                        "dbusrsigapreqa",            // Usuario
                        "PasswordQA2017*",  // Contraseña
                        "SELECT TOP 1 VehiculoSerieChasis, EstadoNombre FROM Vehiculo.Vehiculo\n" +
                                "      INNER JOIN Procesos.EjecucionProceso\n" +
                                "      ON Vehiculo.EjecucionProcesoId=EjecucionProceso.EjecucionProcesoId\n" +
                                "      INNER JOIN Procesos.Estado_Proceso\n" +
                                "      ON EjecucionProceso.Estado_ProcesoId=Estado_Proceso.Estado_ProcesoId\n" +
                                "      INNER JOIN Procesos.Estado\n" +
                                "     ON Estado.EstadoId= Estado_Proceso.EstadoId\n" +
                                "\twhere EstadoNombre IN ('entregado')\n" +
                                "  order by EjecucionProcesoFechaBloqueo desc" // Consulta SQL
                )
        );
        String queryResult = actor.recall("queryResult");
        logger.info("El resultado de la consulta es: "+queryResult);
    }
    public static ConsultaChasisEntregado consulta(){return Tasks.instrumented(ConsultaChasisEntregado.class);
    }
}
