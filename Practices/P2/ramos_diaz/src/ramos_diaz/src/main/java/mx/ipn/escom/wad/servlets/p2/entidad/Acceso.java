package mx.ipn.escom.wad.servlets.p2.entidad;

import java.util.Date;

public class Acceso {
	
	private Integer idAcceso;
	private Integer intentos;
	private Date ultimoIntetentoFallido;
	private Date bloqueo;

	public Acceso() {
		
	}
	
	public Integer getIdAcceso() {
		return idAcceso;
	}

	public void setIdAcceso(Integer idAcceso) {
		this.idAcceso = idAcceso;
	}

	public Integer getIntentos() {
		return intentos;
	}

	public void setIntentos(Integer intentos) {
		this.intentos = intentos;
	}

	public Date getUltimoIntetentoFallido() {
		return ultimoIntetentoFallido;
	}

	public void setUltimoIntetentoFallido(Date ultimoIntetentoFallido) {
		this.ultimoIntetentoFallido = ultimoIntetentoFallido;
	}

	public Date getBloqueo() {
		return bloqueo;
	}

	public void setBloqueo(Date bloqueo) {
		this.bloqueo = bloqueo;
	}
}
