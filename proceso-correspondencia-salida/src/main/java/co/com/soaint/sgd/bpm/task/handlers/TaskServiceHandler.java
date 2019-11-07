package co.com.soaint.sgd.bpm.task.handlers;

import co.com.foundation.client.rs.correspondencia.model.Correspondencia;
import co.com.foundation.client.rs.correspondencia.model.Documento;
import co.com.foundation.client.rs.gestionar.GestionarDevolucionProxyCliente;
import co.com.foundation.client.rs.gestionar.model.InvocarSignal;
import co.com.foundation.client.rs.correspondencia.ActualizarEstadoRadicacionProxyCliente;
import co.com.foundation.client.rs.correspondencia.ActualizarReferenciaEcmProxyCliente;
import co.com.foundation.client.rs.correspondencia.DistribucionElectronicaProxyCliente;

public class TaskServiceHandler {

	public String actualizarEstadoRadicacion(Correspondencia correspondencia) {

		ActualizarEstadoRadicacionProxyCliente api = ActualizarEstadoRadicacionProxyCliente.getInstance();

		System.out.println("LOG: -- TaskServiceHandlerCorrepondencia: ".concat(correspondencia.toString()));

		String tx = api.actualizarEstadoRadicacion(correspondencia);

		return tx;

	}

	public String actualizarReferenciaECM(Documento documento) {

		ActualizarReferenciaEcmProxyCliente api = ActualizarReferenciaEcmProxyCliente.getInstance();

		System.out.println("LOG: -- TaskServiceHandlerCorrepondencia: ".concat(documento.toString()));

		String tx = api.actualizarReferenciaECM(documento);

		return tx;

	}

	public String enviarSennal(InvocarSignal entrada) {

		GestionarDevolucionProxyCliente enviarSennalProceso = GestionarDevolucionProxyCliente.getInstance();
		System.out.println("LOG: -- Inicio envio de Sennal a Correspondencia de Salida: ".concat(entrada.toString()));

		String tx = enviarSennalProceso.enviarSennal(entrada);

		return tx;

	}

	public String distribucionElectronica(String numeroRadicado) {
		DistribucionElectronicaProxyCliente distribucionElectronica=DistribucionElectronicaProxyCliente.getInstance();
		System.out.println("LOG: -- Inicio distribucionElectronica: ");

		String tx = distribucionElectronica.distribucionElectronica(numeroRadicado);

		return tx;

	}
	
	public String realizarArchivadoAutomatico(String numeroRadicado) {

		String tx = "";

		return tx;

	}

}
