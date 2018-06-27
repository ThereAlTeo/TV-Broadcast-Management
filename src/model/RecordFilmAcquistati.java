package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RecordFilmAcquistati {

	private final StringProperty nameFilm;
    private final StringProperty nameCasaDiscografica;
    private final IntegerProperty durata;
    private final IntegerProperty NrCast;
    
    public RecordFilmAcquistati(String nameFilm, String nameCasaDiscografica, int durata, int NrCast) {
    	this.nameFilm = new SimpleStringProperty(nameFilm);
    	this.nameCasaDiscografica = new SimpleStringProperty(nameCasaDiscografica);
    	this.durata = new SimpleIntegerProperty(durata);
    	this.NrCast = new SimpleIntegerProperty(NrCast);
	}

	public StringProperty nameFilmProperty() {
		return nameFilm;
	}

	public StringProperty nameCasaDiscograficaProperty() {
		return nameCasaDiscografica;
	}

	public IntegerProperty durataProperty() {
		return durata;
	}

	public IntegerProperty NrCastProperty() {
		return NrCast;
	}
}
