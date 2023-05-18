package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import esercizio.PartitaDiCalcio;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PartitaDiCalcioDAO {

	private final EntityManager em;

	public PartitaDiCalcioDAO(EntityManager em) {
		this.em = em;
	}

	public void save(PartitaDiCalcio pd) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(pd);
		transaction.commit();
		System.out.println("evento salvato");
	}

	public PartitaDiCalcio getById(long id) {
		PartitaDiCalcio found = em.find(PartitaDiCalcio.class, id);
		return found;
	}

	public void delete(long id) {
		PartitaDiCalcio found = em.find(PartitaDiCalcio.class, id);
		if (found != null) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(found);
			transaction.commit();
			System.out.println("evento con id " + id + " eliminato!");
		}
	}

	public void refresh(long id) {
		PartitaDiCalcio found = em.find(PartitaDiCalcio.class, id);
		System.out.println("PRE REFRESH");
		System.out.println(found);
		em.refresh(found);
		System.out.println("POST REFRESH");
		System.out.println(found);
	}
}
