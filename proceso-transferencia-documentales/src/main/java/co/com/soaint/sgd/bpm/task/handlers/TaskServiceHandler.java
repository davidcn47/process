package co.com.soaint.sgd.bpm.task.handlers;

import co.com.foundation.client.rs.transferencias.ActualizarEstadosUDProxyCliente;
import co.com.foundation.client.rs.transferencias.GenerarInformeProxyCliente;

public class TaskServiceHandler {

public String actualizarEstadoUD( ){
		
	ActualizarEstadosUDProxyCliente  api = ActualizarEstadosUDProxyCliente.getInstance();

	//	System.out.println("LOG: -- TaskServiceHandlerCorrepondencia: " . concat( correspondencia.toString() ) );

	String tx = api.actualizarEstadoUD();
		return tx;
		
	}	

public String generarInforme( ){
	
	GenerarInformeProxyCliente  api = GenerarInformeProxyCliente.getInstance();

	//	System.out.println("LOG: -- TaskServiceHandlerCorrepondencia: " . concat( correspondencia.toString() ) );

	String tx = api.generarInformeTransferencia();
		return tx;
		
	}	
}
