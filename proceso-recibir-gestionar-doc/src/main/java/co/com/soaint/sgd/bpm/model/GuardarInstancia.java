package co.com.soaint.sgd.bpm.model;

import java.io.Serializable;
public class GuardarInstancia implements Serializable {
	
	private static final long serialVersionUID = 1L;

    private String idAsignacion;
	private String idInstancia;
	
	
	
	public GuardarInstancia(String idAsignacion, String idInstancia) {
		super();
		this.idAsignacion = idAsignacion;
		this.idInstancia = idInstancia;
	}

	public String getIdAsignacion() {
		return idAsignacion;
	}

	public void setIdAsignacion(String idAsignacion) {
		this.idAsignacion = idAsignacion;
	}

	public String getIdInstancia() {
		return idInstancia;
	}


	public void setIdInstancia(String idInstancia) {
		this.idInstancia = idInstancia;
	}





	@Override
	public String toString() {
		return "GuardarInstancia [idAsignacion=" + idAsignacion + ", idInstancia=" + idInstancia  + "]";
	}

}
