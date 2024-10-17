package co.com.colcomercio.siga.tasks;

import co.com.colcomercio.siga.utils.ExecuteSQLQuery;
import co.com.colcomercio.siga.utils.GuardarDatoEnJson;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static co.com.colcomercio.siga.utils.DataGenerator.DataGeneratorDate;

public class ConsultaChasisEntregado implements Task {
    private static final Logger logger = LogManager.getLogger(ConsultaChasisEntregado.class);
    String idKey = DataGeneratorDate();

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ExecuteSQLQuery.withParameters(
                        "siga-pre-db-srv.database.windows.net",     // Host
                        "1433",          // Puerto
                        "siga-pre-db",        // Base de datos o schema
                        "dbusrsigapreqa",            // Usuario
                        "PasswordQA2017*",  // Contraseña
                        "SELECT TOP 1 VehiculoSerieChasis, ReferenciaUnicaId, VehiculoPSEAN, EstadoNombre, EjecucionProcesoFechaBloqueo, EjecucionProceso.EjecucionProcesoId, ReferenciaNombre, ReferenciaCodigoInt, MarcaNombre, VehiculoSerieMotor FROM Vehiculo.Vehiculo\n" +
                                "      INNER JOIN Vehiculo.VehiculoPS\n" +
                                "      ON Vehiculo.VehiculoPSId=VehiculoPS.VehiculoPSId\n" +
                                "      INNER JOIN Vehiculo.Referencia\n" +
                                "      ON VehiculoPS.ReferenciaId=Referencia.ReferenciaId\n" +
                                "      INNER JOIN Vehiculo.Marca\n" +
                                "      ON Referencia.MarcaId=Marca.MarcaId\n" +
                                "      INNER JOIN Procesos.EjecucionProceso\n" +
                                "      ON Vehiculo.EjecucionProcesoId=EjecucionProceso.EjecucionProcesoId\n" +
                                "      INNER JOIN Procesos.Estado_Proceso\n" +
                                "      ON EjecucionProceso.Estado_ProcesoId=Estado_Proceso.Estado_ProcesoId\n" +
                                "      INNER JOIN Procesos.Estado\n" +
                                "     ON Estado.EstadoId= Estado_Proceso.EstadoId\n" +
                                "--WHERE vehiculo.vehiculoSerieChasis='9G4B2MBV6LPC01125'\n" +
                                "--where marca.UnidadNegocioId=1 and EstadoNombre IN ('despachado')  AND Referencia.ReferenciaNombre like '%TTR%' --Akt \n" +
                                "where marca.UnidadNegocioId=2 and EstadoNombre IN ('entregado')  AND Referencia.ReferenciaNombre like '%BJ2037%' --(Corautos) \n" +
                                "  order by EjecucionProcesoFechaBloqueo asc" // Consulta SQL
                )
        );
        String queryResult = actor.recall("queryResult");
        logger.info("=============El resultado de la consulta es: "+queryResult);
        GuardarDatoEnJson.guardarDatoEnJson("serieChasis"+idKey,queryResult,"C:\\Users\\1049644474\\Documents\\Automatizacion\\Baseautomatizacion\\siga-testing-qa\\src\\ot.json");
    }
    public static ConsultaChasisEntregado consulta(){return Tasks.instrumented(ConsultaChasisEntregado.class);
    }
}
