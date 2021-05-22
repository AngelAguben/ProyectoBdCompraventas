package controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Coche;

public class ControladorCoche {

	// Factoria para obtener objetos EntityManager
	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("ProyectoCompraventa");
	private EntityManager em;
	private Query consulta;

	// Este método borrará un Coche indicado por parámetros
	public void borrarCoche(Coche a) {
		this.em = entityManagerFactory.createEntityManager();
		Coche aux = null;
		this.em.getTransaction().begin();
		// Si a no es un objeto gestionado por el contexto de persistencia
		if (!this.em.contains(a)) {
			// Carga a en el contexto de persistencia y se guarda en aux
			aux = this.em.merge(a);
		}
		// Ahora se puede borrar usando aux, porque es una entidad gestionada por la
		// caché
		this.em.remove(aux);
		// Se vuelca la información del contexto (caché intermedia) en la base de datos
		this.em.getTransaction().commit();
		// Cierra el entityManager
		this.em.close();
	}

	// Este método modificará un Coche pasado por parámetros
	public void modifyCoche(Coche a) {
		this.em = entityManagerFactory.createEntityManager();
		// En este caso es necesario iniciar una transacción en la base de datos
		// porque vamos a persistir información en la misma
		this.em.getTransaction().begin();
		// merge(Objeto) - Si una entidad con el mismo identificador que v existe en el
		// contexto de persistencia (caché), se actualizan sus atributos y se devuelve
		// como entidad gestionada
		// Si el objeto a no existe en la base de datos, se comporta como persist() y la
		// entidad gestionada es la devuelta por merge(), por lo que v es una entidad
		// desconectada
		this.em.merge(a);
		this.em.getTransaction().commit();
		this.em.close();

	}

	// Este método creará un Coche pasado por parámetros
	public void createCoche(Coche a) {
		this.em = entityManagerFactory.createEntityManager();
		// En este caso es necesario iniciar una transacción en la base de datos
		// porque vamos a persistir información en la misma
		this.em.getTransaction().begin();
		// Se guarda el objeto en el contexto de persistencia (caché intermedia)
		// a es una entidad conectada
		this.em.persist(a);
		// Se vuelca la información del contexto (caché intermedia) en la base de datos
		this.em.getTransaction().commit();
		// Cierra el entityManager
		this.em.close();
	}

	// Este método encontrará un Coche pasando por parámetros su pk y lo
	// devolverá
	public Coche findByPK(int pk) {
		this.em = entityManagerFactory.createEntityManager();
		Coche aux = null;
		// Se crea el objeto Query a partir de una SQL nativa
		this.consulta = em.createNativeQuery("Select * from Coche where codCoche = ?", Coche.class);
		this.consulta.setParameter(1, pk);
		aux = (Coche) consulta.getSingleResult();
		this.em.close();
		return aux;

	}

	// Este método devolverá una lista de todos los coches de la base de datos
	public List<Coche> findAll() {
		this.em = entityManagerFactory.createEntityManager();
		this.consulta = em.createNamedQuery("Coche.findAll");
		List<Coche> listaCoche = (List<Coche>) consulta.getResultList();
		this.em.close();
		return listaCoche;
	}

	// Método para imprimir la lista
	public void imprimirLista(List<Coche> lista) {
		for (Coche co : lista) {
			System.out.println(co);
		}
	}
}
