package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import esercizio.GaraDiAtletica;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GaraDiAtleticaDAO {

	private final EntityManager em;

	public GaraDiAtleticaDAO(EntityManager em) {
		this.em = em;
	}

	public void save(GaraDiAtletica gd) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(gd);
		transaction.commit();
		System.out.println("evento salvato");
	}

	public GaraDiAtletica getById(long id) {
		GaraDiAtletica found = em.find(GaraDiAtletica.class, id);
		return found;
	}

	public void delete(long id) {
		GaraDiAtletica found = em.find(GaraDiAtletica.class, id);
		if (found != null) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(found);
			transaction.commit();
			System.out.println("evento con id " + id + " eliminato!");
		}
	}

	public void refresh(long id) {
		GaraDiAtletica found = em.find(GaraDiAtletica.class, id);
		System.out.println("PRE REFRESH");
		System.out.println(found);
		em.refresh(found);
		System.out.println("POST REFRESH");
		System.out.println(found);
	}
}
