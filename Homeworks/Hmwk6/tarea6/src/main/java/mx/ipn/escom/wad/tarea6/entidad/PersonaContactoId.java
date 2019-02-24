package mx.ipn.escom.wad.tarea6.entidad;

import java.io.Serializable;

public class PersonaContactoId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idPersona;
	private Integer idTipo;

	public PersonaContactoId() {
		super();
	}

	public PersonaContactoId(Integer idPersona, Integer idTipo) {
		super();
		this.idPersona = idPersona;
		this.idTipo = idTipo;
	}

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public Integer getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}
}
