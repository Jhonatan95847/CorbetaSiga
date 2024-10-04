package co.com.colcomercio.siga.stepdefinitions;

import co.com.colcomercio.siga.interactions.ClickOnElement;
import co.com.colcomercio.siga.interactions.Wait;
import co.com.colcomercio.siga.tasks.Login;
import co.com.colcomercio.siga.tasks.formularios.AsignarOT;
import co.com.colcomercio.siga.tasks.formularios.EstadoEntrega;
import co.com.colcomercio.siga.tasks.formularios.IniciarEjecucion;
import co.com.colcomercio.siga.tasks.formularios.RegistrarRecepcion;
import co.com.colcomercio.siga.userinterfaces.AsignarSolicitud;
import co.com.colcomercio.siga.utils.GetDataModel;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class FormulariosStepDefinitions {
    @Y("diligencia el formulario de Registrar Recepcion con cambio de propietario")
    public void queUnAsesorPqrDeseaAccederAlCrmAlkomprar() {
        theActorCalled("actor").wasAbleTo(
                RegistrarRecepcion.registrar()
        );
    }

    @Y("llena el formulario de Registar orden de trabajo")
    public void llenaElFormularioDeRegistarOrdenDeTrabajo() {
        theActorCalled("actor").wasAbleTo(
                EstadoEntrega.estado()
        );
    }

    @Y("diligencia el formulario de asignar solicitud")
    public void diligenciaElFormularioDeAsignarSolicitud() {
        theActorCalled("actor").wasAbleTo(
                AsignarOT.asignar(),
                Wait.withDuration(10)
        );
    }

    @Y("ejecuto la accion {string}")
    public void ejecutoLaAccion(String arg0) {
        theActorCalled("actor").wasAbleTo(
                IniciarEjecucion.iniciar()
        );
    }

    @Y("diligencio el formulario agregando los detalles y creo la novedad TP")
    public void diligencioElFormularioAgregandoLosDetallesYCreoLaNovedadTP() {
    }
}
