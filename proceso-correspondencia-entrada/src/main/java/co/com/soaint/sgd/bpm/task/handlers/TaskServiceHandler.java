package co.com.soaint.sgd.bpm.task.handlers;



import co.com.foundation.client.rs.correspondencia.model.Correspondencia;
import co.com.foundation.client.rs.correspondencia.model.Documento;
import co.com.foundation.client.rs.correspondencia.ActualizarEstadoRadicacionProxyCliente;
import co.com.foundation.client.rs.correspondencia.ActualizarReferenciaEcmProxyCliente;


public class TaskServiceHandler {
	
	public String actualizarEstadoRadicacion(  Correspondencia correspondencia ){
		
		ActualizarEstadoRadicacionProxyCliente api = ActualizarEstadoRadicacionProxyCliente.getInstance();

		System.out.println("LOG: -- TaskServiceHandlerCorrepondencia: " . concat( correspondencia.toString() ) );

		String tx = api.actualizarEstadoRadicacion(correspondencia);

		return tx;
		
	}	
	
	public String actualizarReferenciaECM( Documento documento ){
		
		ActualizarReferenciaEcmProxyCliente api = ActualizarReferenciaEcmProxyCliente.getInstance();

		System.out.println("LOG: -- TaskServiceHandlerCorrepondencia: " . concat( documento.toString() ) );

		String tx = api.actualizarReferenciaECM(documento);

		return tx;
		
	}

}
