package co.com.colcomercio.siga.tasks;

import co.com.colcomercio.siga.utils.ExecuteSQLQuery;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class ConsultaChasisEntregado implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ExecuteSQLQuery.with(
                        "SELECT TOP 1 VehiculoSerieChasis, EstadoNombre FROM Vehiculo.Vehiculo\n" +
                                "      INNER JOIN Procesos.EjecucionProceso\n" +
                                "      ON Vehiculo.EjecucionProcesoId=EjecucionProceso.EjecucionProcesoId\n" +
                                "      INNER JOIN Procesos.Estado_Proceso\n" +
                                "      ON EjecucionProceso.Estado_ProcesoId=Estado_Proceso.Estado_ProcesoId\n" +
                                "      INNER JOIN Procesos.Estado\n" +
                                "     ON Estado.EstadoId= Estado_Proceso.EstadoId\n" +
                                "\twhere EstadoNombre IN ('entregado')\n" +
                                "  order by EjecucionProcesoFechaBloqueo desc",
                        "siga-pre-db-srv.database.windows.net",
                        "root",
                        "password",
                        "usernameResult"
                )
        );
    }
}
