package controladores;

import java.util.List;

import javax.persistence.NoResultException;

import entidades.Deportivo;

public class ControladorDeportivo extends Controlador {
//	// Factoria para obtener objetos EntityManager
//	private static EntityManagerFactory entityManagerFactory = Persistence
//			.createEntityManagerFactory("ProyectoCompraventa");
//	private EntityManager em;
//	private Query consulta;
//
//	// Este m�todo borrar� un Deportivo indicado por par�metros
//	public void borrarDeportivo(Deportivo a) {
//		this.em = entityManagerFactory.createEntityManager();
//		Deportivo aux = null;
//		this.em.getTransaction().begin();
//		// Si a no es un objeto gestionado por el contexto de persistencia
//		if (!this.em.contains(a)) {
//			// Carga a en el contexto de persistencia y se guarda en aux
//			aux = this.em.merge(a);
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
//	// Este m�todo modificar� un Deportivo pasado por par�metros
//	public void modifyDeportivo(Deportivo a) {
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
//		this.em.merge(a);
//		this.em.getTransaction().commit();
//		this.em.close();
//
//	}
//
//	// Este m�todo crear� un Deportivo pasado por par�metros
//	public void createDeportivo(Deportivo a) {
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

	// Este m�todo encontrar� un Deportivo pasando por par�metros su pk y lo
	// devolver�
	public Deportivo findByPK(int pk) {
		this.em = entityManagerFactory.createEntityManager();
		Deportivo aux = null;
		// Se crea el objeto Query a partir de una SQL nativa
		this.consulta = em.createNativeQuery("Select * from deportivo where coddeportivo = ?", Deportivo.class);
		this.consulta.setParameter(1, pk);
		aux = (Deportivo) consulta.getSingleResult();
		this.em.close();
		return aux;

	}

	// Método para buscar un Deportivo por codigo de coche
	public Deportivo buscarPorCodCoche(int fk) {
		this.em = entityManagerFactory.createEntityManager();
		Deportivo c = null;
		// Se crea el objeto Query a partir de una SQL nativa
		this.consulta = em.createNamedQuery("Deportivo.buscarPorCodCoche");
		this.consulta.setParameter(1, fk);
		try {
			c = (Deportivo) consulta.getSingleResult();
		} catch (NoResultException nre) {
			c = null;
		}
		this.em.close();
		return c;
	}

	// Este m�todo devolver� una lista de todos los Deportivos de la base de datos
	public List<Deportivo> findAll() {
		this.em = entityManagerFactory.createEntityManager();
		this.consulta = em.createNamedQuery("Deportivo.findAll");
		List<Deportivo> listaDeportivo = (List<Deportivo>) consulta.getResultList();
		this.em.close();
		return listaDeportivo;
	}

	// M�todo para imprimir la lista
	public void imprimirLista(List<Deportivo> lista) {
		for (Deportivo depor : lista) {
			System.out.println(depor);
		}
	}
}
