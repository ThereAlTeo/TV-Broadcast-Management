package model;

import java.sql.Date;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import utility.Parse;

public class RecordCanale {

	private final StringProperty nameChannel;
    private final StringProperty CFAmministratore;
    private final IntegerProperty NrCanale;
    private final StringProperty dataCreazione;
    private final FloatProperty frequenza;
    
    public RecordCanale(String nameChannel, String CF, int NrCanale, Date dataCreazione, float frequenza) {
		this.nameChannel = new SimpleStringProperty(nameChannel);
		this.CFAmministratore = new SimpleStringProperty(CF);
		this.NrCanale = new SimpleIntegerProperty(NrCanale);
		this.dataCreazione = new SimpleStringProperty(Parse.getDate((dataCreazione.toString())));
		this.frequenza = new SimpleFloatProperty(frequenza);
	}

	public StringProperty nameChannelProperty() {
		return nameChannel;
	}

	public String getNameChannel() {
		return this.nameChannel.get();
	}
	
	public StringProperty CFAmministratoreProperty() {
		return CFAmministratore;
	}

	public String getCFAmministratore() {
		return this.CFAmministratore.get();
	}
	
	public IntegerProperty NrCanaleProperty() {
		return NrCanale;
	}
	
	public Integer getNrCanale() {
		return this.NrCanale.get();
	}
	
	public StringProperty DataCreazioneProperty() {
		return dataCreazione;
	}

	public String getDataCreazione() {
		return this.dataCreazione.get();
	}
	
	public FloatProperty FrequenzaProperty() {
		return frequenza;
	}
	
	public float getFrequenza() {
		return this.frequenza.get();
	}

	@Override
	public String toString() {
		return "RecordCanale [nameChannel=" + this.getNameChannel() + ", CFAmministratore=" + this.getCFAmministratore() + 
				", NrCanale=" + this.getNameChannel() + ", dataCreazione=" + this.getDataCreazione() + ", frequenza=" + 
				this.getFrequenza() + "]";
	}
}
