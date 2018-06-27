package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RecordSerieTVAcquistate {

	private final StringProperty nameSerie;
    private final StringProperty nameCasaDiscografica;
    private final IntegerProperty stagioni;
    private final IntegerProperty episodi;
    private final IntegerProperty NrCast;
    
    public RecordSerieTVAcquistate(String nameSerie, String nameCasaDiscografica, int stagioni, int episodi, int NrCast) {
		this.nameSerie = new SimpleStringProperty(nameSerie);
		this.nameCasaDiscografica = new SimpleStringProperty(nameCasaDiscografica);
		this.stagioni = new SimpleIntegerProperty(stagioni);
		this.episodi = new SimpleIntegerProperty(episodi);
		this.NrCast = new SimpleIntegerProperty(NrCast);
	}

	public StringProperty nameSerieProperty() {
		return nameSerie;
	}

	public StringProperty nameCasaDiscograficaProperty() {
		return nameCasaDiscografica;
	}

	public IntegerProperty stagioniProperty() {
		return stagioni;
	}

	public IntegerProperty episodiProperty() {
		return episodi;
	}

	public IntegerProperty NrCastProperty() {
		return NrCast;
	} 
}
