package co.com.soaint.sgd.bpm.model;

import java.io.Serializable;

public class InformarAprobacion implements Serializable {
	
	private static final long serialVersionUID = 1L;

    private String idAsignacion;

    
    
	public InformarAprobacion(String idAsignacion) {
		super();
		this.idAsignacion = idAsignacion;
	}

	public String getIdAsignacion() {
		return idAsignacion;
	}

	public void setIdAsignacion(String idAsignacion) {
		this.idAsignacion = idAsignacion;
	}
	
    

}
