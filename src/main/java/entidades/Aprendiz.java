package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the aprendiz database table.
 * 
 */
@Entity
@Table(name = "aprendiz")
@NamedQuery(name = "Aprendiz.findAll", query = "SELECT a FROM Aprendiz a")
public class Aprendiz extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	// Definimos despu�s de @Id cual ser� la id de la tabla
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codaprendiz;

	private String dniapren;

	private String nomapren;

	private String tlfnoapren;

	// bi-directional one-to-one association to Trabajador
	// Relacion bidireccional de uno a uno entre Aprendiz y Trabajador, donde un
	// trabajador tiene un aprendiz y un aprendiz forma parte de un trabajador
	@OneToOne(mappedBy = "aprendiz", fetch = FetchType.LAZY)
	private Trabajador trabajador;

	// Constructor sin par�metros
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

//		String trab = "";
//		trab = "CodTrabajador = " + getTrabajador().getCodtrabajador();
//		if (trab.equalsIgnoreCase("CodTrabajador = ")) {
//			trab = "No tiene trabajador";
//		}

		return "Aprendiz = codaprendiz=" + codaprendiz + ", dniapren=" + dniapren + ", nomapren=" + nomapren
				+ ", tlfnoapren=" + tlfnoapren;
//		+ ", trabajador a cargo = ";
	}
}