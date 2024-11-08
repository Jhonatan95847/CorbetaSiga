package co.com.colcomercio.siga.stepdefinitions;


import co.com.colcomercio.siga.models.users.Negocio;
import co.com.colcomercio.siga.tasks.formularios.*;
import co.com.colcomercio.siga.utils.GetDataModel;
import io.cucumber.java.es.Y;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class FormulariosStepDefinitions {
    private Negocio dataNegocio;
    @Y("diligencia el formulario de Registrar Recepcion en taller {string} con cambio de propietario")
    public void queUnAsesorPqrDeseaAccederAlCrmAlkomprar(String data) {
        dataNegocio = GetDataModel.negocio(data);
        theActorCalled("actor").wasAbleTo(
                RegistrarRecepcion.registrar(dataNegocio)
        );
    }

    @Y("llena el formulario de Registar orden de trabajo")
    public void llenaElFormularioDeRegistarOrdenDeTrabajo() {
        theActorCalled("actor").wasAbleTo(
                EstadoEntrega.estado()
        );
    }

    @Y("diligencia el formulario de asignar solicitud para taller {string}")
    public void diligenciaElFormularioDeAsignarSolicitud(String data) {
        dataNegocio = GetDataModel.negocio(data);
        theActorCalled("actor").wasAbleTo(
                AsignarOT.asignar(dataNegocio)
        );
    }

    @Y("ejecuto la accion {string}")
    public void ejecutoLaAccion(String accion) {
        theActorCalled("actor").wasAbleTo(
                IniciarEjecucion.iniciar(accion)
        );
    }

    @Y("diligencio el formulario agregando los detalles y creo la novedad TP para {string}")
    public void diligencioElFormularioAgregandoLosDetallesYCreoLaNovedadTP(String data) {
        dataNegocio = GetDataModel.negocio(data);
        theActorCalled("actor").wasAbleTo(
                CrearNovedadTP.crear(dataNegocio)
        );
    }

    @Y("edita y vlaida la novedad TP")
    public void editaYVlaidaLaNovedadTP() {
        theActorCalled("actor").wasAbleTo(
                EditarYValidarNovedadTP.editar()
        );
    }

    @Y("diligencia el formulario de Registrar Recepcion akt en el taller {string} con cambio de propietario")
    public void diligenciaElFormularioDeRegistrarRecepcionAktConCambioDePropietario(String data) {
        dataNegocio = GetDataModel.negocio(data);
        theActorCalled("actor").wasAbleTo(
                RegistrarRecepcionAkt.registrar(dataNegocio)
        );
    }
}
