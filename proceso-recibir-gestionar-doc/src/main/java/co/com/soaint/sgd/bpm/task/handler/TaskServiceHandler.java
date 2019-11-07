package co.com.soaint.sgd.bpm.task.handler;

import co.com.foundation.client.rs.correspondencia.ActualizarReferenciaEcmProxyCliente;
import co.com.foundation.client.rs.correspondencia.model.Documento;
import co.com.foundation.client.rs.gestionar.ActualizarEstadoDestinatarioProxyCliente;
import co.com.foundation.client.rs.gestionar.GestionarDevolucionProxyCliente;
import co.com.foundation.client.rs.gestionar.GuardarInstanciaProxyCliente;
import co.com.foundation.client.rs.gestionar.model.GuardarInstancia;
import co.com.foundation.client.rs.gestionar.model.Agente;
import co.com.foundation.client.rs.gestionar.model.InvocarSignal;

public class TaskServiceHandler {
	private ActualizarEstadoDestinatarioProxyCliente api = ActualizarEstadoDestinatarioProxyCliente.getInstance();
	private GuardarInstanciaProxyCliente apiGuardarInstancia = GuardarInstanciaProxyCliente.getInstance();
	private ActualizarReferenciaEcmProxyCliente apiActualizarReferencia = ActualizarReferenciaEcmProxyCliente.getInstance();
	private GestionarDevolucionProxyCliente apiGestionarDevolucion = GestionarDevolucionProxyCliente.getInstance();
	
	public String guardarInstanciaProceso(  GuardarInstancia guardarInstancia){
		System.out.println("----------------------- guardarInstanciaProceso: " + guardarInstancia);
		
		String tx = apiGuardarInstancia.guardarInstanciaProceso(guardarInstancia);
		return tx;
	}	

	public String actualizarEstadoDestinatario(  Agente agente){

		System.out.println("----------------------- actualizarEstadoDestinatario: " + agente);

		String tx = api.actualizarEstadoDestinatario(agente);

		return tx;
	}
	

	
	public String devolverCorrespondencia(  GuardarInstancia guardarInstancia){
		System.out.println("----------------------- devolverCorrespondencia: " + guardarInstancia);
		return "Exito";
	}	
	
	public String archivarDocumento(  GuardarInstancia guardarInstancia){
		System.out.println("----------------------- archivarDocumento: " + guardarInstancia);
		return "Exito";
	}	
	
	public String moverDocumento(  GuardarInstancia guardarInstancia){
		System.out.println("----------------------- moverDocumento: " + guardarInstancia);
		
		return "Exito";
	}	
	
	public String producirDocumento(  GuardarInstancia guardarInstancia){

		return "Exito";
	}	
	
    public String actualizarReferenciaECM( Documento documento ){	
		

		System.out.println("LOG: -- actualizarReferenciaECM_Proceso_Gestionar_Documento: " . concat( documento.toString() ) );

		String tx = apiActualizarReferencia.actualizarReferenciaECM(documento);

		return tx;
		
	}
    
 public String enviarSennal( InvocarSignal entrada ){	
		

		System.out.println("LOG: -- GestionarDevolucion: " . concat( entrada.toString() ) );

		String tx = apiGestionarDevolucion.enviarSennal(entrada);

		return tx;
		
	}
}
