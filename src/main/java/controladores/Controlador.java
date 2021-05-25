package controladores;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Entidad;

// Al tener un método abstracto la clase deberá de ser abstracta
public abstract class Controlador {
	// Factoria para obtener objetos EntityManager
	protected static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("ProyectoCompraventa");
	protected EntityManager em;
	protected Query consulta;

	// Este método creará un Entidad pasado por parámetros
	public void createEntidad(Entidad e) {
		em = entityManagerFactory.createEntityManager();
		// En este caso es necesario iniciar una transacción en la base de datos
		// porque vamos a persistir información en la misma
		this.em.getTransaction().begin();
		// Se guarda el objeto en el contexto de persistencia (caché intermedia)
		// a es una entidad conectada
		this.em.persist(e);
		// Se vuelca la información del contexto (caché intermedia) en la base de datos
		this.em.getTransaction().commit();
		// Cierra el entityManager
		this.em.close();
	}

	// Este método borrará un Entidad indicado por parámetros
	public void borrarEntidad(Entidad a) {
		em = entityManagerFactory.createEntityManager();
		Entidad aux = null;
		em.getTransaction().begin();
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

	// Este método modificará un Entidad pasado por parámetros
	public void modifyEntidad(Entidad a) {
		em = entityManagerFactory.createEntityManager();
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

	// El método abstracto para implementar en las clases
	public abstract Entidad findByPK(int pk);
}
