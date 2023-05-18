package esercizio;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dao.ConcertoDAO;
import dao.EventoDAO;
import dao.GaraDiAtleticaDAO;
import dao.PartitaDiCalcioDAO;
import lombok.extern.slf4j.Slf4j;
import utils.JpaUtil;

@Slf4j
public class Main {
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EventoDAO ed = new EventoDAO(em);
		ConcertoDAO cd = new ConcertoDAO(em);
		GaraDiAtleticaDAO gd = new GaraDiAtleticaDAO(em);
		PartitaDiCalcioDAO pd = new PartitaDiCalcioDAO(em);

		Evento festa = new Evento("Buon Compleanno", LocalDate.now(), "18esimo compleanno", "disco", 50);
		Concerto jovanotti = new Concerto(Concerto.Genere.POP, Concerto.InStreaming.TRUE);
		GaraDiAtletica corsa = new GaraDiAtletica("mondiali", "bolt");
		PartitaDiCalcio champions = new PartitaDiCalcio("Napoli", "Juve", "Napoli", 5, 1);
		ed.save(festa);
		cd.save(jovanotti);
		gd.save(corsa);
		pd.save(champions);

		em.close();
		emf.close();
	}
}
