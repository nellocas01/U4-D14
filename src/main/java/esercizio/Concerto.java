package esercizio;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Concerto extends Evento {
	@Enumerated(EnumType.STRING)
	private Genere genere;
	@Enumerated(EnumType.STRING)
	private InStreaming inStreaming;

	public Concerto(Genere genere, InStreaming inStreaming) {
		super();
		this.genere = genere;
		this.inStreaming = inStreaming;
	}

	public enum Genere {
		CLASSICO, ROCK, POP
	}

	public enum InStreaming {
		TRUE, FALSE
	}

}