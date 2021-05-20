package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
//Especificamos la NamedQuery para que funcione
@NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	private String ape1clien;

	private String ape2clien;
	// Definimos despu�s de @Id cual ser� la id de la tabla
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codcliente;

	private String contraclien;

	private String correoclien;

	private String nomclien;

	private String tlfnoclien;

	private String usuclien;

	// bi-directional many-to-one association to Contratocompra
	@OneToMany(mappedBy = "cliente")
	private List<Contratocompra> contratocompras;

	// Constructor sin par�metros
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

	// A�adir� datos a la lista y devolver� el objeto
	public Contratocompra addContratocompra(Contratocompra contratocompra) {
		getContratocompras().add(contratocompra);
		contratocompra.setCliente(this);

		return contratocompra;
	}

	// A�adir� datos a la lista y devolver� el objeto
	public Contratocompra removeContratocompra(Contratocompra contratocompra) {
		getContratocompras().remove(contratocompra);
		contratocompra.setCliente(null);

		return contratocompra;
	}

	// ToString
	@Override
	public String toString() {
		return "Cliente [ape1clien=" + ape1clien + ", ape2clien=" + ape2clien + ", codcliente=" + codcliente
				+ ", contraclien=" + contraclien + ", correoclien=" + correoclien + ", nomclien=" + nomclien
				+ ", tlfnoclien=" + tlfnoclien + ", usuclien=" + usuclien + "]";
	}

}