package model;

import java.sql.Time;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import utility.Parse;

public class RecordPalinsesto {
	
	private final StringProperty nameChannel;
    private final StringProperty nameProgramm;
    private final IntegerProperty NrPuntata;
    private final StringProperty oraTrasmissione;
    
    public RecordPalinsesto(String nameChannel, String nameProgramm, Integer NrPuntata, Time oraTrasmissione) {
		this.nameChannel = new SimpleStringProperty(nameChannel);
		this.nameProgramm = new SimpleStringProperty(nameProgramm);
		this.NrPuntata = new SimpleIntegerProperty(NrPuntata);
		this.oraTrasmissione = new SimpleStringProperty(Parse.getTime(oraTrasmissione));
	}

    public String getNameChannel() {
    	return this.nameChannel.get();
    }
  
	public StringProperty nameChannelProperty() {
		return nameChannel;
	}

	public String getNameProgramm() {
		return this.nameProgramm.get();
	}
	
	public StringProperty nameProgrammProperty() {
		return nameProgramm;
	}

	public Integer getNrPuntata() {
		return this.NrPuntata.get();
	}
	
	public IntegerProperty NrPuntataProperty() {
		return NrPuntata;
	}

	public String getOraTrasmissione() {
		return this.oraTrasmissione.get();
	}
	
	public StringProperty oraTrasmissioneProperty() {
		return oraTrasmissione;
	}
	
	@Override
	public String toString() {
		return "Nome Canale: " + this.getNameChannel() + "\n" +
			   "Nome Programma: " + this.getNameProgramm() + "\n" +
			   "Numero Puntata: " + this.getNrPuntata() + "\n" +
			   "Ora Trasmissione: " + this.getOraTrasmissione() + "\n\n";
	}
}
