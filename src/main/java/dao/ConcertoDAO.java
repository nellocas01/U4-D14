package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import esercizio.Concerto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcertoDAO {

	private final EntityManager em;

	public ConcertoDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Concerto cd) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(cd);
		transaction.commit();
		System.out.println("evento salvato");
	}

	public Concerto getById(long id) {
		Concerto found = em.find(Concerto.class, id);
		return found;
	}

	public void delete(long id) {
		Concerto found = em.find(Concerto.class, id);
		if (found != null) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(found);
			transaction.commit();
			System.out.println("evento con id " + id + " eliminato!");
		}
	}

	public void refresh(long id) {
		Concerto found = em.find(Concerto.class, id);
		System.out.println("PRE REFRESH");
		System.out.println(found);
		em.refresh(found);
		System.out.println("POST REFRESH");
		System.out.println(found);
	}
}
