package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the trabajador database table.
 * 
 */
@Entity
// Especificamos la NamedQuery para que funcione
@NamedQuery(name = "Trabajador.findAll", query = "SELECT t FROM Trabajador t")
public class Trabajador implements Serializable {
	private static final long serialVersionUID = 1L;

	// Definimos después de @Id cual será la id de la tabla
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codtrabajador;

	private String dnitrab;

	private String horario;

	private String nomtrab;

	private String tlfnotrab;

	// bi-directional many-to-one association to Contratocompra
	@OneToMany(mappedBy = "trabajador")
	private List<Contratocompra> contratocompras;

	// bi-directional one-to-one association to Aprendiz
	@OneToOne(fetch = FetchType.LAZY)
	// Insertará la columna de la FK que viene de Aprendiz<
	// Aquí tendremos que poner insertable = false y updateble = false, porque si no
	// se insertará también en la otra tabla y dará error
	@JoinColumn(name = "codaprendiz", insertable = false, updatable = false)
	private Aprendiz aprendiz;

	// Constructor sin parámetros
	public Trabajador() {
	}

	// GETTERS AND SETTERS
	public int getCodtrabajador() {
		return this.codtrabajador;
	}

	public void setCodtrabajador(int codtrabajador) {
		this.codtrabajador = codtrabajador;
	}

	public String getDnitrab() {
		return this.dnitrab;
	}

	public void setDnitrab(String dnitrab) {
		this.dnitrab = dnitrab;
	}

	public String getHorario() {
		return this.horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getNomtrab() {
		return this.nomtrab;
	}

	public void setNomtrab(String nomtrab) {
		this.nomtrab = nomtrab;
	}

	public String getTlfnotrab() {
		return this.tlfnotrab;
	}

	public void setTlfnotrab(String tlfnotrab) {
		this.tlfnotrab = tlfnotrab;
	}

	public List<Contratocompra> getContratocompras() {
		return this.contratocompras;
	}

	public void setContratocompras(List<Contratocompra> contratocompras) {
		this.contratocompras = contratocompras;
	}

	// Añadirá datos a la lista y devolverá el objeto
	public Contratocompra addContratocompra(Contratocompra contratocompra) {
		getContratocompras().add(contratocompra);
		contratocompra.setTrabajador(this);

		return contratocompra;
	}

	// Borrará datos a la lista y devolverá el objeto
	public Contratocompra removeContratocompra(Contratocompra contratocompra) {
		getContratocompras().remove(contratocompra);
		contratocompra.setTrabajador(null);

		return contratocompra;
	}

	public Aprendiz getAprendiz() {
		return this.aprendiz;
	}

	public void setAprendiz(Aprendiz aprendiz) {
		this.aprendiz = aprendiz;
	}

	// ToString
	@Override
	public String toString() {
		return "Trabajador = codtrabajador=" + codtrabajador + ", dnitrab=" + dnitrab + ", horario=" + horario
				+ ", nomtrab=" + nomtrab + ", tlfnotrab=" + tlfnotrab;
	}

}