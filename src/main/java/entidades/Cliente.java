package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@Table(name = "cliente")
@NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
public class Cliente extends Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	private String ape1clien;

	private String ape2clien;
	// Definimos después de @Id cual será la id de la tabla
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codcliente;

	private String contraclien;

	private String correoclien;

	private String nomclien;

	private String tlfnoclien;

	private String usuclien;

	// bi-directional many-to-one association to Contratocompra
	// Asociacion bidireccioal de uno a muchos entre Cliente que es uno y
	// ContratoCompra que es muchos
	// Un cliente forma parte de muchos ContratoCompras y un ContratoCompra tiene un
	// cliente
	@OneToMany(mappedBy = "cliente")
	private List<Contratocompra> contratocompras;

	// Constructor sin parámetros
	public Cliente() {
	}

	// GETTERS AND SETTERS
	public String getApe1clien() {
		return this.ape1clien;
	}

	public void setApe1clien(String ape1clien) {
		this.ape1clien = ape1clien;
	}

	public String getApe2clien() {
		return this.ape2clien;
	}

	public void setApe2clien(String ape2clien) {
		this.ape2clien = ape2clien;
	}

	public int getCodcliente() {
		return this.codcliente;
	}

	public void setCodcliente(int codcliente) {
		this.codcliente = codcliente;
	}

	public String getContraclien() {
		return this.contraclien;
	}

	public void setContraclien(String contraclien) {
		this.contraclien = contraclien;
	}

	public String getCorreoclien() {
		return this.correoclien;
	}

	public void setCorreoclien(String correoclien) {
		this.correoclien = correoclien;
	}

	public String getNomclien() {
		return this.nomclien;
	}

	public void setNomclien(String nomclien) {
		this.nomclien = nomclien;
	}

	public String getTlfnoclien() {
		return this.tlfnoclien;
	}

	public void setTlfnoclien(String tlfnoclien) {
		this.tlfnoclien = tlfnoclien;
	}

	public String getUsuclien() {
		return this.usuclien;
	}

	public void setUsuclien(String usuclien) {
		this.usuclien = usuclien;
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
		contratocompra.setCliente(this);

		return contratocompra;
	}

	// Añadirá datos a la lista y devolverá el objeto
	public Contratocompra removeContratocompra(Contratocompra contratocompra) {
		getContratocompras().remove(contratocompra);
		contratocompra.setCliente(null);

		return contratocompra;
	}

	// ToString
	@Override
	public String toString() {
		String coches = "";
		for (Contratocompra contratocompra : contratocompras) {
			coches += "CodCoche = " + contratocompra.getCoche().getCodcoche() + ", ";
		}
		if (coches.equalsIgnoreCase("")) {
			coches = "No ha comprado nada";
		}

		return "Cliente = codcliente=" + codcliente + ", nomclien=" + nomclien + ", ape1clien=" + ape1clien
				+ ", ape2clien=" + ape2clien + ", contraclien=" + contraclien + ", correoclien=" + correoclien
				+ ", tlfnoclien=" + tlfnoclien + ", usuclien=" + usuclien + ", coches comprados = " + coches;
	}

}