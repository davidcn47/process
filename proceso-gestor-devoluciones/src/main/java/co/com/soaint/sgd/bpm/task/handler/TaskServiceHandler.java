package co.com.soaint.sgd.bpm.task.handler;

import co.com.foundation.client.rs.correspondencia.ActualizarReferenciaEcmProxyCliente;
import co.com.foundation.client.rs.correspondencia.model.Documento;
import co.com.foundation.client.rs.gestionar.ActualizarEstadoDestinatarioProxyCliente;
import co.com.foundation.client.rs.gestionar.model.Agente;

public class TaskServiceHandler {
	
	private ActualizarEstadoDestinatarioProxyCliente api = ActualizarEstadoDestinatarioProxyCliente.getInstance();
	private ActualizarReferenciaEcmProxyCliente apiActualizarReferencia = ActualizarReferenciaEcmProxyCliente.getInstance();
	
	public String actualizarEstadoDestinatario(  Agente agente){

		System.out.println("----------------------- actualizarEstadoDestinatario: " + agente);

		String tx = api.actualizarEstadoDestinatario(agente);

		return tx;
	}
	
	
    public String actualizarReferenciaECM( Documento documento ){	
		

		System.out.println("LOG: -- actualizarReferenciaECM_Proceso_Gestionar_Documento: " . concat( documento.toString() ) );

		String tx = apiActualizarReferencia.actualizarReferenciaECM(documento);

		return tx;
		
	}
	

}
