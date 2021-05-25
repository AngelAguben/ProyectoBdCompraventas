package controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Trabajador;

public class ControladorTrabajador extends Controlador {

//	// Factoria para obtener objetos EntityManager
//	private static EntityManagerFactory entityManagerFactory = Persistence
//			.createEntityManagerFactory("ProyectoCompraventa");
//	private EntityManager em;
//	private Query consulta;
//
//	// Este m�todo borrar� un trabajador indicado por par�metros
//	public void borrarTrabajador(Trabajador t) {
//		this.em = entityManagerFactory.createEntityManager();
//		Trabajador aux = null;
//		this.em.getTransaction().begin();
//		// Si a no es un objeto gestionado por el contexto de persistencia
//		if (!this.em.contains(t)) {
//			// Carga a en el contexto de persistencia y se guarda en aux
//			aux = this.em.merge(t);
//		}
//		// Ahora se puede borrar usando aux, porque es una entidad gestionada por la
//		// cach�
//		this.em.remove(aux);
//		// Se vuelca la informaci�n del contexto (cach� intermedia) en la base de datos
//		this.em.getTransaction().commit();
//		// Cierra el entityManager
//		this.em.close();
//	}
//
//	// Este m�todo modificar� un trabajador pasado por par�metros
//	public void modifyTrabajador(Trabajador t) {
//		this.em = entityManagerFactory.createEntityManager();
//		// En este caso es necesario iniciar una transacci�n en la base de datos
//		// porque vamos a persistir informaci�n en la misma
//		this.em.getTransaction().begin();
//		// merge(Objeto) - Si una entidad con el mismo identificador que v existe en el
//		// contexto de persistencia (cach�), se actualizan sus atributos y se devuelve
//		// como entidad gestionada
//		// Si el objeto a no existe en la base de datos, se comporta como persist() y la
//		// entidad gestionada es la devuelta por merge(), por lo que v es una entidad
//		// desconectada
//		this.em.merge(t);
//		this.em.getTransaction().commit();
//		this.em.close();
//
//	}
//
//	// Este m�todo crear� un Trabajador pasado por par�metros
//	public void createTrabajador(Trabajador a) {
//		this.em = entityManagerFactory.createEntityManager();
//		// En este caso es necesario iniciar una transacci�n en la base de datos
//		// porque vamos a persistir informaci�n en la misma
//		this.em.getTransaction().begin();
//		// Se guarda el objeto en el contexto de persistencia (cach� intermedia)
//		// a es una entidad conectada
//		this.em.persist(a);
//		// Se vuelca la informaci�n del contexto (cach� intermedia) en la base de datos
//		this.em.getTransaction().commit();
//		// Cierra el entityManager
//		this.em.close();
//	}

	// Este m�todo encontrar� un Trabajador pasando por par�metros su pk y lo
	// devolver�
	public Trabajador findByPK(int pk) {
		this.em = entityManagerFactory.createEntityManager();
		Trabajador aux = null;
		// Se crea el objeto Query a partir de una SQL nativa
		this.consulta = em.createNativeQuery("Select * from Trabajador where codTrabajador = ?", Trabajador.class);
		this.consulta.setParameter(1, pk);
		aux = (Trabajador) consulta.getSingleResult();
		this.em.close();
		return aux;

	}

	// Este m�todo devolver� una lista de todos los trabajadores de la base de datos
	public List<Trabajador> findAll() {
		this.em = entityManagerFactory.createEntityManager();
		this.consulta = em.createNamedQuery("Trabajador.findAll");
		List<Trabajador> listaTrabajador = (List<Trabajador>) consulta.getResultList();
		this.em.close();
		return listaTrabajador;
	}

	// M�todo para imprimir la lista
	public void imprimirLista(List<Trabajador> lista) {
		for (Trabajador trab : lista) {
			System.out.println(trab);
		}
	}
}
