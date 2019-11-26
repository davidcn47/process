package co.com.soaint.jbpm.task.handler;

import co.com.soaint.jbpm.domains.*;
import co.com.soaint.jbpm.rs.correspondencia.ActualizarEstadoRadicacionProxyCliente;
import co.com.soaint.jbpm.rs.correspondencia.ActualizarReferenciaEcmProxyCliente;
import co.com.soaint.jbpm.rs.correspondencia.DistribucionElectronicaProxyCliente;
import co.com.soaint.jbpm.rs.gestionar.ActualizarEstadoDestinatarioProxyCliente;
import co.com.soaint.jbpm.rs.gestionar.GestionarDevolucionProxyCliente;
import co.com.soaint.jbpm.rs.gestionar.GuardarInstanciaProxyCliente;
import co.com.soaint.jbpm.rs.produccion.ActualizarMetadatosAnexosProxyCliente;
import co.com.soaint.jbpm.rs.transferencias.ActualizarEstadosUDProxyCliente;
import co.com.soaint.jbpm.rs.transferencias.GenerarInformeProxyCliente;

public class TaskServiceHandler {

    private ActualizarEstadoRadicacionProxyCliente actualizarEstadoRadicacion = ActualizarEstadoRadicacionProxyCliente.getInstance();
    private ActualizarReferenciaEcmProxyCliente actualizarReferenciaECM = ActualizarReferenciaEcmProxyCliente.getInstance();
    private GestionarDevolucionProxyCliente enviarSennalProceso = GestionarDevolucionProxyCliente.getInstance();
    private DistribucionElectronicaProxyCliente distribucionElectronica = DistribucionElectronicaProxyCliente.getInstance();
    private ActualizarEstadoDestinatarioProxyCliente actualizarEstadoDestinatario = ActualizarEstadoDestinatarioProxyCliente.getInstance();
    private ActualizarMetadatosAnexosProxyCliente actualizarMetadatosAnexos = ActualizarMetadatosAnexosProxyCliente.getInstance();
    private GuardarInstanciaProxyCliente apiGuardarInstancia = GuardarInstanciaProxyCliente.getInstance();
    private ActualizarEstadosUDProxyCliente actualizarEstadoUD = ActualizarEstadosUDProxyCliente.getInstance();
    private GenerarInformeProxyCliente generarInforme = GenerarInformeProxyCliente.getInstance();

    public String actualizarEstadoRadicacion(Correspondencia correspondencia) {
        System.out.println("LOG: -- TaskServiceHandlerCorrepondencia: ".concat(correspondencia.toString()));
        return actualizarEstadoRadicacion.actualizarEstadoRadicacion(correspondencia);
    }

    public String actualizarReferenciaECM(Documento documento) {
        System.out.println("LOG: -- TaskServiceHandlerCorrepondencia: ".concat(documento.toString()));
        return actualizarReferenciaECM.actualizarReferenciaECM(documento);
    }

    public String enviarSennal(InvocarSignal entrada) {
        System.out.println("LOG: -- Inicio envio de Sennal a Correspondencia de Salida: ".concat(entrada.toString()));
        return enviarSennalProceso.enviarSennal(entrada);
    }

    public String distribucionElectronica(String numeroRadicado) {
        System.out.println("LOG: -- Inicio distribucionElectronica: ");
        return distribucionElectronica.distribucionElectronica(numeroRadicado);
    }

    public String actualizarEstadoDestinatario(Agente agente) {
        System.out.println("----------------------- actualizarEstadoDestinatario: " + agente);
        return actualizarEstadoDestinatario.actualizarEstadoDestinatario(agente);
    }

    public String actualizarMetadatosAnexos(Metadatos actualizarMetadatos) {
        System.out.println("LOG: -- Inicio envio Actualizar Metadatos Anexos: ".concat(actualizarMetadatos.toString()));
        return actualizarMetadatosAnexos.actualizarMetadatosAnexos(actualizarMetadatos);
    }

    public String realizarArchivadoAutomatico(String numeroRadicado) {
        return "";
    }

    public String guardarInstanciaProceso(GuardarInstancia guardarInstancia) {
        System.out.println("----------------------- guardarInstanciaProceso: " + guardarInstancia);
        return apiGuardarInstancia.guardarInstanciaProceso(guardarInstancia);
    }

    public String devolverCorrespondencia(GuardarInstancia guardarInstancia) {
        System.out.println("----------------------- devolverCorrespondencia: " + guardarInstancia);
        return "Exito";
    }

    public String archivarDocumento(GuardarInstancia guardarInstancia) {
        System.out.println("----------------------- archivarDocumento: " + guardarInstancia);
        return "Exito";
    }

    public String moverDocumento(GuardarInstancia guardarInstancia) {
        System.out.println("----------------------- moverDocumento: " + guardarInstancia);
        return "Exito";
    }

    public String producirDocumento(GuardarInstancia guardarInstancia) {
        return "Exito";
    }

    public String actualizarEstadoUD() {
        return actualizarEstadoUD.actualizarEstadoUD();
    }

    public String generarInforme() {
        return generarInforme.generarInformeTransferencia();
    }
}
