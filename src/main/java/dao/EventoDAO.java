package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import esercizio.Concerto;
import esercizio.Evento;
import esercizio.GaraDiAtletica;
import esercizio1.Persona;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EventoDAO {

	private final EntityManager em;

	public EventoDAO(EntityManager em) {
		this.em = em;
	}

	public List<Evento> getConcertiInStreaming(boolean isStreaming) {
		String jpql = "SELECT e FROM Evento e WHERE e.isStreaming = :isStreaming";
		Query query = em.createQuery(jpql);
		query.setParameter("isStreaming", isStreaming);
		return query.getResultList();
	}

	public List<Evento> getConcertiPerGenere(List<Concerto> generi) {
		String jpql = "SELECT e FROM Evento e WHERE e.genereConcerto IN :generi";
		Query query = em.createQuery(jpql);
		query.setParameter("generi", generi);
		return query.getResultList();
	}

	public List<Evento> getPartiteVinteInCasa() {
		TypedQuery<Evento> query = em.createNamedQuery("Evento.getPartiteVinteInCasa", Evento.class);
		return query.getResultList();
	}

	public List<Evento> getPartiteVinteInTrasferta() {
		TypedQuery<Evento> query = em.createNamedQuery("Evento.getPartiteVinteInTrasferta", Evento.class);
		return query.getResultList();
	}

	public List<Evento> getPartitePareggiate() {
		TypedQuery<Evento> query = em.createNamedQuery("Evento.getPartitePareggiate", Evento.class);
		return query.getResultList();
	}

	public List<Evento> getGareDiAtleticaPerVincitore(GaraDiAtletica vincitore) {
		TypedQuery<Evento> query = em.createNamedQuery("Evento.getGareDiAtleticaPerVincitore", Evento.class);
		query.setParameter("vincitore", vincitore);
		return query.getResultList();
	}

	public List<Evento> getGareDiAtleticaPerPartecipante(GaraDiAtletica partecipante) {
		TypedQuery<Evento> query = em.createNamedQuery("Evento.getGareDiAtleticaPerPartecipante", Evento.class);
		query.setParameter("partecipante", partecipante);
		return query.getResultList();
	}

	public List<Evento> getEventiSoldOut() {
		TypedQuery<Evento> query = em.createNamedQuery("Evento.getEventiSoldOut", Evento.class);
		return query.getResultList();
	}

	public List<Evento> getEventiPerInvitato(Persona invitato) {
		TypedQuery<Evento> query = em.createNamedQuery("Evento.getEventiPerInvitato", Evento.class);
		query.setParameter("invitato", invitato);
		return query.getResultList();
	}

	public void save(Evento ed) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(ed);
		transaction.commit();
		System.out.println("evento salvato");
	}

	public Evento getById(long id) {
		Evento found = em.find(Evento.class, id);
		return found;
	}

	public void delete(long id) {
		Evento found = em.find(Evento.class, id);
		if (found != null) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(found);
			transaction.commit();
			System.out.println("evento con id " + id + " eliminato!");
		}
	}

	public void refresh(long id) {
		Evento found = em.find(Evento.class, id);
		System.out.println("PRE REFRESH");
		System.out.println(found);
		em.refresh(found);
		System.out.println("POST REFRESH");
		System.out.println(found);
	}
}
