package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the aprendiz database table.
 * 
 */
@Entity
//Especificamos la NamedQuery para que funcione
@NamedQuery(name = "Aprendiz.findAll", query = "SELECT a FROM Aprendiz a")
public class Aprendiz implements Serializable {
	private static final long serialVersionUID = 1L;

	// Definimos después de @Id cual será la id de la tabla
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codaprendiz;

	private String dniapren;

	private String nomapren;

	private String tlfnoapren;

	// bi-directional one-to-one association to Trabajador
	@OneToOne(mappedBy = "aprendiz", fetch = FetchType.LAZY)
	private Trabajador trabajador;

	// Constructor sin parámetros
	public Aprendiz() {
	}

	// GETTERS AND SETTERS
	public int getCodaprendiz() {
		return this.codaprendiz;
	}

	public void setCodaprendiz(int codaprendiz) {
		this.codaprendiz = codaprendiz;
	}

	public String getDniapren() {
		return this.dniapren;
	}

	public void setDniapren(String dniapren) {
		this.dniapren = dniapren;
	}

	public String getNomapren() {
		return this.nomapren;
	}

	public void setNomapren(String nomapren) {
		this.nomapren = nomapren;
	}

	public String getTlfnoapren() {
		return this.tlfnoapren;
	}

	public void setTlfnoapren(String tlfnoapren) {
		this.tlfnoapren = tlfnoapren;
	}

	public Trabajador getTrabajador() {
		return this.trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

	// ToString
	@Override
	public String toString() {
		return "Aprendiz = codaprendiz=" + codaprendiz + ", dniapren=" + dniapren + ", nomapren=" + nomapren
				+ ", tlfnoapren=" + tlfnoapren + ", trabajador=" + trabajador;
	}

}