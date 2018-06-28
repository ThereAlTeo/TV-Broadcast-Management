package model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RecordPersonaRuolo {

	private final StringProperty nameProgramma;
	private final IntegerProperty NrPuntata;
	private final FloatProperty stipendio;
    private final StringProperty ruolo;
    
    public RecordPersonaRuolo(String nameProgramma, int NrPuntata, float stipendio, String ruolo) {
		this.nameProgramma = new SimpleStringProperty(nameProgramma);
		this.NrPuntata = new SimpleIntegerProperty(NrPuntata);
		this.stipendio = new SimpleFloatProperty(stipendio);
		this.ruolo = new SimpleStringProperty(ruolo);
	}

	public StringProperty nameProgrammaProperty() {
		return nameProgramma;
	}

	public IntegerProperty NrPuntataProperty() {
		return NrPuntata;
	}

	public FloatProperty stipendioProperty() {
		return stipendio;
	}

	public StringProperty ruoloProperty() {
		return ruolo;
	}
}
