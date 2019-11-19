package co.com.soaint.jbpm.domains;

/**
 * This class was automatically generated by the data modeler tool.
 */

import java.io.Serializable;

public class MedioRecepcion implements Serializable {
	
	static final long serialVersionUID = 1L;	
	String codMedioRecepcion;
	String tiempoRespuesta;
	String codUnidaTiempo;
	String inicioConteo;
	
	
	public MedioRecepcion(String codMedioRecepcion, String tiempoRespuesta, String codUnidaTiempo,String inicioConteo ) {
		
		this.codMedioRecepcion = codMedioRecepcion;
		
	}
	public MedioRecepcion() {
		
	}
	public String getCodMedioRecepcion() {
		return codMedioRecepcion;
	}
	public void setCodMedioRecepcion(String codMedioRecepcion) {
		this.codMedioRecepcion = codMedioRecepcion;
	}

	public String getTiempoRespuesta() {
		return tiempoRespuesta;
	}
	public void setTiempoRespuesta(String tiempoRespuesta) {
		this.tiempoRespuesta = tiempoRespuesta;
	}
	public String getCodUnidaTiempo() {
		return codUnidaTiempo;
	}
	public void setCodUnidaTiempo(String codUnidaTiempo) {
		this.codUnidaTiempo = codUnidaTiempo;
	}
	public String getInicioConteo() {
		return inicioConteo;
	}
	public void setInicioConteo(String inicioConteo) {
		this.inicioConteo = inicioConteo;
	}
	

}
