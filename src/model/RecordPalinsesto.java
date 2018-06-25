package model;

import java.time.LocalDateTime;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RecordPalinsesto {
	
	private final StringProperty nameChannel;
    private final StringProperty nameProgramm;
    private final IntegerProperty NrPuntata;
    private final ObjectProperty<LocalDateTime> oraTrasmissione;
    
    public RecordPalinsesto(String nameChannel, String nameProgramm, Integer NrPuntata, LocalDateTime oraTrasmissione) {
		this.nameChannel = new SimpleStringProperty(nameChannel);
		this.nameProgramm = new SimpleStringProperty(nameProgramm);
		this.NrPuntata = new SimpleIntegerProperty(NrPuntata);
		this.oraTrasmissione = new SimpleObjectProperty<LocalDateTime>(oraTrasmissione);
	}

    public RecordPalinsesto(String nameChannel, String nameProgramm, Integer NrPuntata) {
		this.nameChannel = new SimpleStringProperty(nameChannel);
		this.nameProgramm = new SimpleStringProperty(nameProgramm);
		this.NrPuntata = new SimpleIntegerProperty(NrPuntata);
		this.oraTrasmissione = new SimpleObjectProperty<LocalDateTime>(LocalDateTime.of(1999, 2, 21, 15, 10));
	}
    
    public String getNameChannel() {
    	return this.nameChannel.get();
    }
    
    public void setNameChannel(String nameChannel) {
    	this.nameChannel.set(nameChannel);
    }
    
	public StringProperty nameChannelProperty() {
		return nameChannel;
	}

	public String getNameProgramm() {
		return this.nameProgramm.get();
	}
	
	public void setNameProgramm(String nameProgramm) {
		this.nameProgramm.set(nameProgramm);
	}
	
	public StringProperty nameProgrammProperty() {
		return nameProgramm;
	}

	public Integer getNrPuntata() {
		return this.NrPuntata.get();
	}
	
	public void setNrPuntata(Integer NrPuntata) {
		this.NrPuntata.set(NrPuntata);
	}
	
	public IntegerProperty NrPuntataProperty() {
		return NrPuntata;
	}

	public LocalDateTime getOraTrasmissione() {
		return this.oraTrasmissione.get();
	}
	
	public void setOraTrasmissione(LocalDateTime oraTrasmissione) {
		this.oraTrasmissione.set(oraTrasmissione);
	}
	
	public ObjectProperty<LocalDateTime> oraTrasmissioneProperty() {
		return oraTrasmissione;
	}
	
	@Override
	public String toString() {
		return "Nome Canale: " + this.getNameChannel() + "\n" +
			   "Nome Programma: " + this.getNameProgramm() + "\n" +
			   "Numero Puntata: " + this.getNrPuntata() + "\n" +
			   "Ora Trasmissione: " + this.getOraTrasmissione().getHour() + ":" + 
			   this.getOraTrasmissione().getMinute() +"\n\n";
	}
}
