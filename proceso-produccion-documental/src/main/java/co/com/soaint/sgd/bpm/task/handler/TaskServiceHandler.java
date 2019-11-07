package co.com.soaint.sgd.bpm.task.handler;

import co.com.foundation.client.rs.gestionar.GestionarDevolucionProxyCliente;
import co.com.foundation.client.rs.gestionar.model.InvocarSignal;
import co.com.foundation.client.rs.produccion.ActualizarMetadatosAnexosProxyCliente;
import co.com.foundation.client.rs.produccion.model.Metadatos;

public class TaskServiceHandler {
	
	 public String enviarSennal( InvocarSignal entrada ){	
			
		    GestionarDevolucionProxyCliente enviarSennalProceso = GestionarDevolucionProxyCliente.getInstance();
			System.out.println("LOG: -- Inicio envio de Sennal a Correspondencia de Salida: " . concat( entrada.toString() ) );

			
			String tx = enviarSennalProceso.enviarSennal(entrada);

			return tx;
			
		}
	 
	 public String actualizarMetadatosAnexos( Metadatos actualizarMetadatos ){	
			
		 ActualizarMetadatosAnexosProxyCliente api = ActualizarMetadatosAnexosProxyCliente.getInstance();
			System.out.println("LOG: -- Inicio envio Actualizar Metadatos Anexos: " . concat( actualizarMetadatos.toString() ) );

			
			String tx = api.actualizarMetadatosAnexos(actualizarMetadatos);

			return tx;
			
		}
	 
	

}
