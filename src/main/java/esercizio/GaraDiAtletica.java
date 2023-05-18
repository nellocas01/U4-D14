package esercizio;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "garaDiAtletica")
@Getter
@Setter
@NoArgsConstructor
public class GaraDiAtletica extends Evento {
	private String atleti;
	private String vincitore;

	public GaraDiAtletica(String atleti, String vincitore) {
		super();
		this.atleti = atleti;
		this.vincitore = vincitore;
	}

	@Override
	public String toString() {
		return "GaraDiAtletica [atleti=" + atleti + ", vincitore=" + vincitore + "]";
	}

}
