package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the contratocompra database table.
 * 
 */
// Anotación para especificar desde donde será la entidad
@Entity
//Especificamos la NamedQuery para que funcione
@NamedQuery(name = "Contratocompra.findAll", query = "SELECT c FROM Contratocompra c")
public class Contratocompra implements Serializable {
	private static final long serialVersionUID = 1L;

	// Definimos después de @Id cual será la id de la tabla
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codcontracompra;

	// La anotación @Temporal sirve para indicar a JPA el tipo de dato
	// JDBC java.sql (DATE, TIME, TIMESTAMP) al que pasar el atributo
	// "fechaventa", que es de tipo java.util.Date
	@Temporal(TemporalType.DATE)
	private Date fechaventa;

	private double precioventa;

	// bi-directional many-to-one association to Cliente
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codcliente")
	private Cliente cliente;

	// bi-directional many-to-one association to Coche
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codcoche")
	private Coche coche;

	// bi-directional many-to-one association to Trabajador
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codtrabajador")
	private Trabajador trabajador;

	// Constructor sin parámetros
	public Contratocompra() {
	}

	// GETTERS AND SETTERS
	public int getCodcontracompra() {
		return this.codcontracompra;
	}

	public void setCodcontracompra(int codcontracompra) {
		this.codcontracompra = codcontracompra;
	}

	public Date getFechaventa() {
		return this.fechaventa;
	}

	public void setFechaventa(Date fechaventa) {
		this.fechaventa = fechaventa;
	}

	public double getPrecioventa() {
		return this.precioventa;
	}

	public void setPrecioventa(double precioventa) {
		this.precioventa = precioventa;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Coche getCoche() {
		return this.coche;
	}

	public void setCoche(Coche coche) {
		this.coche = coche;
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
		return "Contratocompra [codcontracompra=" + codcontracompra + ", fechaventa=" + fechaventa + ", precioventa="
				+ precioventa + ", cliente=" + cliente + ", coche=" + coche + ", trabajador=" + trabajador + "]";
	}

}