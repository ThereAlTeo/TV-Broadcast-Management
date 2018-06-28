package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RecordProgrammi {

	private final StringProperty nameProgramma;
	private final StringProperty tipologia;
	private final StringProperty studioRegistrazione;
	
	public RecordProgrammi(String nameProgramma, String tipologia, String studioRegistrazione) {
		this.nameProgramma = new SimpleStringProperty(nameProgramma);
		this.tipologia = new SimpleStringProperty(tipologia);
		this.studioRegistrazione = new SimpleStringProperty(studioRegistrazione);
	}

	public StringProperty nameProgrammaProperty() {
		return nameProgramma;
	}

	public StringProperty tipologiaProperty() {
		return tipologia;
	}

	public StringProperty studioRegistrazioneProperty() {
		return studioRegistrazione;
	}
}
