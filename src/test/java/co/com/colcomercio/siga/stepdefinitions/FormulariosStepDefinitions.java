package co.com.colcomercio.siga.stepdefinitions;


import co.com.colcomercio.siga.tasks.formularios.*;
import io.cucumber.java.es.Y;

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
                AsignarOT.asignar()
        );
    }

    @Y("ejecuto la accion {string}")
    public void ejecutoLaAccion(String accion) {
        theActorCalled("actor").wasAbleTo(
                IniciarEjecucion.iniciar(accion)
        );
    }

    @Y("diligencio el formulario agregando los detalles y creo la novedad TP")
    public void diligencioElFormularioAgregandoLosDetallesYCreoLaNovedadTP() {
        theActorCalled("actor").wasAbleTo(
                CrearNovedadTP.crear()
        );
    }

    @Y("edita y vlaida la novedad TP")
    public void editaYVlaidaLaNovedadTP() {
        theActorCalled("actor").wasAbleTo(
                EditarYValidarNovedadTP.editar()
        );
    }
}
