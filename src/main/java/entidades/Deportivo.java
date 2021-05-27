package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the deportivo database table.
 * 
 */
@Entity
@Table(name = "deportivo")
@NamedQuery(name = "Deportivo.findAll", query = "SELECT d FROM Deportivo d")
public class Deportivo extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	// Definimos después de @Id cual será la id de la tabla
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int coddepor;

	private boolean packaero;

	private boolean turbo;

	// bi-directional many-to-one association to Coche
	// Relaci�n bidireccional de uno a muchos entre Coche y Deportivo, donde un
	// Coche forma parte de muchos Deportivos y un Deportivo solo es un coche
	@ManyToOne(fetch = FetchType.LAZY)
	// Insertará la columna de la FK que viene de Coche
	@JoinColumn(name = "codcoche")
	private Coche coche;

	// Constructor sin parámetros
	public Deportivo() {
	}

	// GETTERS AND SETTERS
	public int getCoddepor() {
		return this.coddepor;
	}

	public void setCoddepor(int coddepor) {
		this.coddepor = coddepor;
	}

	public boolean getPackaero() {
		return this.packaero;
	}

	public void setPackaero(boolean packaero) {
		this.packaero = packaero;
	}

	public boolean getTurbo() {
		return this.turbo;
	}

	public void setTurbo(boolean turbo) {
		this.turbo = turbo;
	}

	public Coche getCoche() {
		return this.coche;
	}

	public void setCoche(Coche coche) {
		this.coche = coche;
	}

	// ToString
	@Override
	public String toString() {
		return "Deportivo = coddepor=" + coddepor + ", packaero=" + packaero + ", turbo=" + turbo + ", coche=" + coche;
	}

}