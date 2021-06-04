package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the suv database table.
 * 
 */
@Entity
@Table(name = "suv")
@NamedQuery(name = "Suv.findAll", query = "SELECT s FROM Suv s")
@NamedQueries({ @NamedQuery(name = "Suv.findAll", query = "SELECT s FROM Suv s"),
		@NamedQuery(name = "Suv.buscarPorCodCoche", query = "SELECT s FROM Suv s WHERE s.coche = :codcliente"), })

public class Suv extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	// Definimos después de @Id cual será la id de la tabla
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codsuv;

	private int plazas;

	// bi-directional many-to-one association to Coche
	// Relaci�n bidireccional de uno a muchos entre Coche y Suv, donde un
	// Coche forma parte de muchos Suvs y un Suv solo es un coche
	@ManyToOne(fetch = FetchType.LAZY)
	// Insertará la columna de la FK que viene de Coche
	@JoinColumn(name = "codcoche")
	private Coche coche;

	// Constructor sin parámetros
	public Suv() {
	}

	// GETTERS AND SETTER
	public int getCodsuv() {
		return this.codsuv;
	}

	public void setCodsuv(int codsuv) {
		this.codsuv = codsuv;
	}

	public int getPlazas() {
		return this.plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
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
		return "Suv = codsuv=" + codsuv + ", plazas=" + plazas + ", coche=" + coche;
	}

}