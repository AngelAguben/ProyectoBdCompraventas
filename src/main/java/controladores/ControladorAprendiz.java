package controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Aprendiz;

public class ControladorAprendiz extends Controlador {
//	// Factoria para obtener objetos EntityManager
//		private static EntityManagerFactory entityManagerFactory = Persistence
//				.createEntityManagerFactory("ProyectoCompraventa");
//		private EntityManager em;
//		private Query consulta;
//	
//	// Este método borrará un aprendiz indicado por parámetros
//	public void borrarAprendiz(Aprendiz a) {
//		em = entityManagerFactory.createEntityManager();
//		Aprendiz aux = null;
//		em.getTransaction().begin();
//		// Si a no es un objeto gestionado por el contexto de persistencia
//		if (!this.em.contains(a)) {
//			// Carga a en el contexto de persistencia y se guarda en aux
//			aux = this.em.merge(a);
//		}
//		// Ahora se puede borrar usando aux, porque es una entidad gestionada por la
//		// caché
//		this.em.remove(aux);
//		// Se vuelca la información del contexto (caché intermedia) en la base de datos
//		this.em.getTransaction().commit();
//		// Cierra el entityManager
//		this.em.close();
//	}
//
//	// Este método modificará un aprendiz pasado por parámetros
//	public void modifyAprendiz(Aprendiz a) {
//		em = entityManagerFactory.createEntityManager();
//		// En este caso es necesario iniciar una transacción en la base de datos
//		// porque vamos a persistir información en la misma
//		this.em.getTransaction().begin();
//		// merge(Objeto) - Si una entidad con el mismo identificador que v existe en el
//		// contexto de persistencia (caché), se actualizan sus atributos y se devuelve
//		// como entidad gestionada
//		// Si el objeto a no existe en la base de datos, se comporta como persist() y la
//		// entidad gestionada es la devuelta por merge(), por lo que v es una entidad
//		// desconectada
//		this.em.merge(a);
//		this.em.getTransaction().commit();
//		this.em.close();
//	}
//
//	// Este método creará un aprendiz pasado por parámetros
//	public void createAprendiz(Aprendiz a) {
//		em = entityManagerFactory.createEntityManager();
//		// En este caso es necesario iniciar una transacción en la base de datos
//		// porque vamos a persistir información en la misma
//		this.em.getTransaction().begin();
//		// Se guarda el objeto en el contexto de persistencia (caché intermedia)
//		// a es una entidad conectada
//		this.em.persist(a);
//		// Se vuelca la información del contexto (caché intermedia) en la base de datos
//		this.em.getTransaction().commit();
//		// Cierra el entityManager
//		this.em.close();
//	}

	// Este método encontrará un aprendiz pasando por parámetros su pk y lo
	// devolverá
	public Aprendiz findByPK(int pk) {
		em = entityManagerFactory.createEntityManager();
		Aprendiz aux = null;
		// Se crea el objeto Query a partir de una SQL nativa
		consulta = this.em.createNativeQuery("Select * from aprendiz where codaprendiz = ?", Aprendiz.class);
		consulta.setParameter(1, pk);
		aux = (Aprendiz) consulta.getSingleResult();
		this.em.close();
		return aux;
	}

	// Este método devolverá una lista de todos los aprendices de la base de datos
	public List<Aprendiz> findAll() {
		em = entityManagerFactory.createEntityManager();
		consulta = this.em.createNamedQuery("Aprendiz.findAll");
		List<Aprendiz> listaAprendiz = (List<Aprendiz>) consulta.getResultList();
		this.em.close();
		return listaAprendiz;
	}

	// Método para imprimir la lista
	public void imprimirLista(List<Aprendiz> lista) {
		for (Aprendiz apren : lista) {
			System.out.println(apren);
		}
	}

}
