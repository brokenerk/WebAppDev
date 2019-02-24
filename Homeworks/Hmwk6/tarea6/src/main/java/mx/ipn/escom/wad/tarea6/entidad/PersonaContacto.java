package mx.ipn.escom.wad.tarea6.entidad;

public class PersonaContacto {
	private PersonaContactoId id;
	private Integer idPersona;
	private Integer idTipo;
	private String contacto;

	public PersonaContactoId getId() {
		return id;
	}

	public void setId(PersonaContactoId id) {
		this.id = id;
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

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
}
