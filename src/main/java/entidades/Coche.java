package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the coche database table.
 * 
 */
@Entity
//Especificamos la NamedQuery para que funcione
@NamedQuery(name = "Coche.findAll", query = "SELECT c FROM Coche c")
public class Coche extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;
	// Definimos después de @Id cual será la id de la tabla
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codcoche;

	private boolean cambio;

	private String color;

	private String combustible;

	private String cv;

	private String marca;

	private String matricula;

	private String modelo;

	private double precio;

	// bi-directional many-to-one association to Contratocompra
	@OneToMany(mappedBy = "coche")
	private List<Contratocompra> contratocompras;

	// bi-directional many-to-one association to Deportivo
	@OneToMany(mappedBy = "coche")
	private List<Deportivo> deportivos;

	// bi-directional many-to-one association to Suv
	@OneToMany(mappedBy = "coche")
	private List<Suv> suvs;

	public Coche() {
	}

	// GETTERS AND SETTERS
	public int getCodcoche() {
		return this.codcoche;
	}

	public void setCodcoche(int codcoche) {
		this.codcoche = codcoche;
	}

	public boolean getCambio() {
		return this.cambio;
	}

	public void setCambio(boolean cambio) {
		this.cambio = cambio;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCombustible() {
		return this.combustible;
	}

	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}

	public String getCv() {
		return this.cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
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
		contratocompra.setCoche(this);

		return contratocompra;
	}

	// Borrará datos a la lista y devolverá el objeto
	public Contratocompra removeContratocompra(Contratocompra contratocompra) {
		getContratocompras().remove(contratocompra);
		contratocompra.setCoche(null);

		return contratocompra;
	}

	public List<Deportivo> getDeportivos() {
		return this.deportivos;
	}

	public void setDeportivos(List<Deportivo> deportivos) {
		this.deportivos = deportivos;
	}

	// Añadirá datos a la lista y devolverá el objeto
	public Deportivo addDeportivo(Deportivo deportivo) {
		getDeportivos().add(deportivo);
		deportivo.setCoche(this);

		return deportivo;
	}

	// Borrará datos a la lista y devolverá el objeto
	public Deportivo removeDeportivo(Deportivo deportivo) {
		getDeportivos().remove(deportivo);
		deportivo.setCoche(null);

		return deportivo;
	}

	public List<Suv> getSuvs() {
		return this.suvs;
	}

	public void setSuvs(List<Suv> suvs) {
		this.suvs = suvs;
	}

	// Añadirá datos a la lista y devolverá el objeto
	public Suv addSuv(Suv suv) {
		getSuvs().add(suv);
		suv.setCoche(this);

		return suv;
	}

	// Borarrá datos a la lista y devolverá el objeto
	public Suv removeSuv(Suv suv) {
		getSuvs().remove(suv);
		suv.setCoche(null);

		return suv;
	}

	// ToString
	@Override
	public String toString() {
		return "Coche =" + "codcoche=" + codcoche + ", cambio=" + cambio + ", color=" + color + ", combustible="
				+ combustible + ", cv=" + cv + ", marca=" + marca + ", matricula=" + matricula + ", modelo=" + modelo
				+ ", precio=" + precio + "€";
//				", contratocompras=" + contratocompras + ", deportivos=" + deportivos + ", suvs=" + suvs + "]";
	}

}