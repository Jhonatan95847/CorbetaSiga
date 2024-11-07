package co.com.colcomercio.siga.stepdefinitions;

import co.com.colcomercio.siga.tasks.AccionVehiculo;
import co.com.colcomercio.siga.tasks.BuscarChasis;
import co.com.colcomercio.siga.tasks.BuscarOT;
import io.cucumber.java.es.Cuando;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class BuscarStepDefinitions {
    @Cuando("el usuario busca el chasis para el caso y selecciona la accion {string}")
    public void queUnAsesorPqrDeseaAccederAlCrmAlkomprar(String accion) {
        theActorCalled("actor").wasAbleTo(
                BuscarChasis.buscar(),
                AccionVehiculo.accion(accion)
        );
    }

    @Cuando("el usuario busca la OT para el caso y selecciona la accion {string}")
    public void elUsuarioBuscaLaOTParaElCasoYSeleccionaLaAccion(String accion) {
        theActorCalled("actor").wasAbleTo(
                BuscarOT.buscar(),
                AccionVehiculo.accion(accion)
        );
    }

}
