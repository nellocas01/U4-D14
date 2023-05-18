package esercizio;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "partitaDiCalcio")
@Getter
@Setter
@NoArgsConstructor
public class PartitaDiCalcio extends Evento {
	private String squadCasa;
	private String squadOspite;
	private String squadraVincente;
	private int golSquadCasa;
	private int golSquadOspite;

	public PartitaDiCalcio(String squadCasa, String squadOspite, String squadraVincente, int golSquadCasa,
			int golSquadOspite) {
		super();
		this.squadCasa = squadCasa;
		this.squadOspite = squadOspite;
		this.squadraVincente = squadraVincente;
		this.golSquadCasa = golSquadCasa;
		this.golSquadOspite = golSquadOspite;
	}

	@Override
	public String toString() {
		return "PartitaDiCalcio [squadCasa=" + squadCasa + ", squadOspite=" + squadOspite + ", squadraVincente="
				+ squadraVincente + ", golSquadCasa=" + golSquadCasa + ", golSquadOspite=" + golSquadOspite + "]";
	}

}
