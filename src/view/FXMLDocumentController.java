package view;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import SQL.Query;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import controller.Manager;
import model.*;
import utility.AlertFactory;
import utility.Parse;

public class FXMLDocumentController implements Initializable {
 
	private void checkElementsForm(boolean condition, String header, String contentText) {
		if (condition) {
    		new AlertFactory().createInformationAllert(header, contentText).showAndWait();
    		Manager.showVisualizzazione();
    	} else {
    		new AlertFactory().createErrorAllert("Uno o più Campi sono Errati!").showAndWait();
    	}
	}
	
    @FXML
    public void showMenuPrincipale(){
    	Manager.showMenuPrincipale();
    }
    
    @FXML
    public void showManipolazioneContenuto() {
    	Manager.showManipolazioneContenuto();
    }
    
    @FXML
    public void showVisualizzazione() {
    	Manager.showVisualizzazione();
    }
    
    @FXML
    public void showInsertChannel() {
    	Manager.showInsertChannel();
    }
    
    @FXML
    DatePicker datePickerCreazione; 
    @FXML
    TextField textFieldID, textFieldAmministratore, textFieldNCanale, textFieldnomecanale;
    @FXML
    RadioButton radioButtonAcquistato;
    @FXML
    TextField textFieldAcquistatoDa, textFieldAcquistatoPrezzo, TextFieldFrequenza;
    
    @FXML
    private void buttonInserisciCanale(ActionEvent event) throws SQLException {
    	ArrayList<String> date = new ArrayList<String>();
    	date.add(textFieldID.getText().toString());
    	date.add(textFieldAmministratore.getText().toString());
    	date.add(textFieldnomecanale.getText().toString());
    	date.add(textFieldNCanale.getText().toString());
    	date.add(datePickerCreazione.getValue()
				  .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString());
    	date.add(textFieldAcquistatoDa.getText().toString());
    	date.add(textFieldAcquistatoPrezzo.getText().toString());
    	date.add(TextFieldFrequenza.getText().toString());

    	this.checkElementsForm(!Query.InsertChannel(date.iterator()), "Aggiunta Canale", "Canale Aggiunto Correttamente!");
    }
    
    @FXML
    private void cancellacanale(ActionEvent event) throws SQLException {
    	ArrayList<String> date = new ArrayList<String>();
    	date.add(textFieldID.getText().toString());
    	date.add(textFieldAmministratore.getText().toString());
    	date.add(textFieldnomecanale.getText().toString());
    	date.add(textFieldNCanale.getText().toString());
    	date.add(datePickerCreazione.getValue()
				  .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString());
    	date.add(textFieldAcquistatoDa.getText().toString());
    	date.add(textFieldAcquistatoPrezzo.getText().toString());
    	date.add(TextFieldFrequenza.getText().toString());
    	
    	this.checkElementsForm(!Query.DeleteChannel(date.iterator()), "Canale Rimosso", "Canale Rimosso Correttamente!");
    }
    
    @FXML
    public void showInsertProgramma() {
    	Manager.showInsertProgramma();
    }
    
    @FXML
    TextField textFieldIDProgramma, textFieldNome, textFieldTipologia;
    
    @FXML
    private void buttonInserisciProgramma(ActionEvent event) throws SQLException {
    	ArrayList<String> date = new ArrayList<String>();
    	date.add(textFieldIDProgramma.getText().toString());
    	date.add(textFieldNome.getText().toString());
    	date.add(textFieldTipologia.getText().toString());
    	
    	this.checkElementsForm(!Query.InsertProgramme(date.iterator()), "Aggiunto Programma", "Programma Aggiunto Correttamente!");
    }
    
    @FXML
    private void modificaprogramma(ActionEvent event) throws SQLException {
    	ArrayList<String> date = new ArrayList<String>();
    	date.add(textFieldIDProgramma.getText().toString());
    	date.add(textFieldNome.getText().toString());
    	date.add(textFieldTipologia.getText().toString());

    	this.checkElementsForm(!Query.ModifyProgramme(date.iterator()), "Modificato Programma", "Programma Modificato Correttamente!");
    }
    
    @FXML
    private void cancellaprogramma(ActionEvent event) throws SQLException {
    	ArrayList<String> date = new ArrayList<String>();
    	date.add(textFieldIDProgramma.getText().toString());
    	date.add(textFieldNome.getText().toString());
    	date.add(textFieldTipologia.getText().toString());
    	
    	this.checkElementsForm(!Query.DeleteProgramme(date.iterator()), "Cancellazione Programma", "Programma Cancellato Correttamente!");
    }
    
    @FXML
    public void showInsertPuntata() {
    	Manager.showInsertPuntata();
    }
    
    @FXML
    TextField idpun, idprog, orainizioreg, orafinereg, durata, s1, s2, s3;
    
    @FXML
    private void buttonInserisciPuntata(ActionEvent event) throws SQLException {
    	
    	ArrayList<String> date = new ArrayList<String>();
    	date.add(idpun.getText().toString());
    	date.add(idprog.getText().toString());
    	date.add(orainizioreg.getText().toString());
    	date.add(orafinereg.getText().toString());
    	date.add(durata.getText().toString());
    	date.add(s1.getText().toString());
    	date.add(s2.getText().toString());
    	date.add(s3.getText().toString());
    	
    	this.checkElementsForm(!Query.InsertEpisode(date.iterator()), "Aggiunta Puntata", "Puntata Aggiunta Correttamente!");
    }
    
    @FXML
    private void modificapuntata(ActionEvent event) throws SQLException {
    	
    	ArrayList<String> date = new ArrayList<String>();
    	date.add(idpun.getText().toString());
    	date.add(idprog.getText().toString());
    	date.add(orainizioreg.getText().toString());
    	date.add(orafinereg.getText().toString());
    	date.add(durata.getText().toString());
    	date.add(s1.getText().toString());
    	date.add(s2.getText().toString());
    	date.add(s3.getText().toString());
    	
    	this.checkElementsForm(!Query.ModifyEpisode(date.iterator()), "Modificata Puntata", "Puntata Modificata Correttamente!");
    }
    
    @FXML
    private void cancellapuntata(ActionEvent event) throws SQLException {
    	
    	ArrayList<String> date = new ArrayList<String>();
    	date.add(idpun.getText().toString());
    	date.add(idprog.getText().toString());
    	date.add(orainizioreg.getText().toString());
    	date.add(orafinereg.getText().toString());
    	date.add(durata.getText().toString());
    	date.add(s1.getText().toString());
    	date.add(s2.getText().toString());
    	date.add(s3.getText().toString());
    	
    	this.checkElementsForm(!Query.DeleteEpisode(date.iterator()), "Cancellata Puntata", "Puntata Cancellata Correttamente!");
    }
    
    @FXML
    public void showInsertPersona() {
    	Manager.showInsertPersona();
    }
    
    @FXML
    TextField cf, ddn, nome, cognome, via, civico, città, sesso;
    
    @FXML
    private void buttonInserisciPersona(ActionEvent event) throws SQLException {
    	
    	ArrayList<String> date = new ArrayList<String>();
    	date.add(cf.getText().toString());
    	date.add(nome.getText().toString());
    	date.add(cognome.getText().toString());
    	date.add(sesso.getText().toString());
    	date.add(ddn.getText().toString());
    	date.add(via.getText().toString());
    	date.add(civico.getText().toString());
    	date.add(città.getText().toString());
    	
    	this.checkElementsForm(!Query.InsertPersona(date.iterator()), "Aggiunta Persona", "Persona Aggiunta Correttamente!");
    }
    
    @FXML
    private void modificapersona(ActionEvent event) throws SQLException {
    	
    	ArrayList<String> date = new ArrayList<String>();
    	date.add(cf.getText().toString());
    	date.add(nome.getText().toString());
    	date.add(cognome.getText().toString());
    	date.add(sesso.getText().toString());
    	date.add(ddn.getText().toString());
    	date.add(via.getText().toString());
    	date.add(civico.getText().toString());
    	date.add(città.getText().toString());
    	
    	this.checkElementsForm(!Query.ModifyPersona(date.iterator()), "Modificata Persona", "Persona Modificata Correttamente!");
    }
    
    @FXML
    private void cancellapersona(ActionEvent event) throws SQLException {
    	
    	ArrayList<String> date = new ArrayList<String>();
    	date.add(cf.getText().toString());
    	date.add(nome.getText().toString());
    	date.add(cognome.getText().toString());
    	date.add(sesso.getText().toString());
    	date.add(ddn.getText().toString());
    	date.add(via.getText().toString());
    	date.add(civico.getText().toString());
    	date.add(città.getText().toString());

    	this.checkElementsForm(!Query.DeletePersona(date.iterator()), "Cancellazione Persona", "Persona Cancellata Correttamente!");
    }
    
    @FXML
    public void showInsertIncarico() {
    	Manager.showInsertIncarico();
    }
    
    @FXML
    TextField idp, idpr, cf2, s, r;
    
    @FXML
    private void buttonInserisciIncarico(ActionEvent event) throws SQLException {
    	
    	ArrayList<String> date = new ArrayList<String>();
    	date.add(idp.getText().toString());
    	date.add(idpr.getText().toString());
    	date.add(cf2.getText().toString());
    	date.add(s.getText().toString());
    	date.add(r.getText().toString());
    	
    	this.checkElementsForm(!Query.InsertIncarico(date.iterator()), "Aggiunto Incarico", "Incarico Aggiunto Correttamente!");
    }
    
    @FXML
    private void modificaincarico(ActionEvent event) throws SQLException {
    	
    	ArrayList<String> date = new ArrayList<String>();
    	date.add(idp.getText().toString());
    	date.add(idpr.getText().toString());
    	date.add(cf2.getText().toString());
    	date.add(s.getText().toString());
    	date.add(r.getText().toString());
    	
    	this.checkElementsForm(!Query.ModifyIncarico(date.iterator()), "Modificato Incarico", "Incarico Modificato Correttamente!");
    }
    
    @FXML
    private void cancellaincarico(ActionEvent event) throws SQLException {
    	
    	ArrayList<String> date = new ArrayList<String>();
    	date.add(idp.getText().toString());
    	date.add(idpr.getText().toString());
    	date.add(cf2.getText().toString());
    	date.add(s.getText().toString());
    	date.add(r.getText().toString());
    	
    	this.checkElementsForm(!Query.DeleteIncarico(date.iterator()), "Cancellazione Incarico", "Incarico Cancellato Correttamente!");
    }
    
    @FXML
    public void showInsertSerieTV() {
    	Manager.showInsertSerieTV();
    }
    
    @FXML
    TextField ids, cd, no, t, st, e, d, l;
    
    @FXML
    private void buttonInserisciSerieTv(ActionEvent event) throws SQLException {
    	
    	ArrayList<String> date = new ArrayList<String>();
    	date.add(ids.getText().toString());
    	date.add(cd.getText().toString());
    	date.add(no.getText().toString());
    	date.add(t.getText().toString());
    	date.add(st.getText().toString());
    	date.add(e.getText().toString());
    	date.add(d.getText().toString());
    	date.add(l.getText().toString());
    	
    	this.checkElementsForm(!Query.InsertSerieTv(date.iterator()), "Aggiunta SerieTV", "SerieTv Aggiunta Correttamente!");
    }
    
    @FXML
    private void modificaserietv(ActionEvent event) throws SQLException {
    	
    	ArrayList<String> date = new ArrayList<String>();
    	date.add(ids.getText().toString());
    	date.add(cd.getText().toString());
    	date.add(no.getText().toString());
    	date.add(t.getText().toString());
    	date.add(st.getText().toString());
    	date.add(e.getText().toString());
    	date.add(d.getText().toString());
    	date.add(l.getText().toString());
    	
    	this.checkElementsForm(!Query.ModifySerieTv(date.iterator()), "Modfica SerieTV", "SerieTv Modificata Correttamente!");
    }
    
    @FXML
    private void cancellaserietv(ActionEvent event) throws SQLException {
    	
    	ArrayList<String> date = new ArrayList<String>();
    	date.add(ids.getText().toString());
    	date.add(cd.getText().toString());
    	date.add(no.getText().toString());
    	date.add(t.getText().toString());
    	date.add(st.getText().toString());
    	date.add(e.getText().toString());
    	date.add(d.getText().toString());
    	date.add(l.getText().toString());
    	
    	this.checkElementsForm(!Query.DeleteSerieTv(date.iterator()), "Cancellazione SerieTV", "SerieTv Cancellata Correttamente!");
    }
    
    @FXML
    public void showInsertFilm() {
    	Manager.showInsertFilm();
    }
    
    @FXML
    TextField idf, cd2, nom, du, li;
    DatePicker dp, dc;
    
    @FXML
    private void buttonInserisciFilm(ActionEvent event) throws SQLException {
    	/*ArrayList<String> date = new ArrayList<String>();
    	date.add(idf.getText().toString());
    	date.add(cd2.getText().toString());
    	date.add(nom.getText().toString());
    	date.add(dc.getText().toString());
    	date.add(dp.getValue()
				  .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString());
    	date.add(du.getValue()
				  .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString());
    	date.add(li.getText().toString());
    	
    	this.checkElementsForm(!Query.InsertFilm(date.iterator()), "Aggiunto Film", "Film Aggiunto Correttamente!");*/
    }
    
    @FXML
    private void modificafilm(ActionEvent event) throws SQLException {
    	/*ArrayList<String> date = new ArrayList<String>();
    	date.add(idf.getText().toString());
    	date.add(cd2.getText().toString());
    	date.add(nom.getText().toString());
    	date.add(dc.getText().toString());
    	date.add(dp.getValue()
				  .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString());
    	date.add(du.getValue()
				  .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString());
    	date.add(li.getText().toString());
    	
    	this.checkElementsForm(!Query.ModifyFilm(date.iterator()), "Modificato Film", "Film Modificato Correttamente!");*/
    }
    
    @FXML
    private void cancellafilm(ActionEvent event) throws SQLException {
    	/*ArrayList<String> date = new ArrayList<String>();
    	date.add(idf.getText().toString());
    	date.add(cd2.getText().toString());
    	date.add(nom.getText().toString());
    	date.add(dc.getText().toString());
    	date.add(dp.getValue()
				  .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString());
    	date.add(du.getValue()
				  .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString());
    	date.add(li.getText().toString());
    	
    	this.checkElementsForm(!Query.DeleteFilm(date.iterator()), "Cancellato Film", "Film Cancellato Correttamente!");*/
    }
    
    @FXML
    public void showInsertAcquistoFilm() {
    	Manager.showInsertAcquistoFilm();
    }
    
    @FXML
    TextField film, canale, prezzo;
    DatePicker da;
    
    @FXML
    private void buttonInserisciAcquistoFilm(ActionEvent event) throws SQLException {
    	ArrayList<String> date = new ArrayList<String>();
    	date.add(film.getText().toString());
    	date.add(canale.getText().toString());
    	date.add(prezzo.getText().toString());
    	date.add(da.getValue()
				  .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString());
    	
    	this.checkElementsForm(!Query.InsertAcqFilm(date.iterator()), "Aggiunto Acquisto Film", "Acquisto Film Aggiunto Correttamente!");
    }
    
    @FXML
    private void modificaacquistofilm(ActionEvent event) throws SQLException {
    	ArrayList<String> date = new ArrayList<String>();
    	date.add(film.getText().toString());
    	date.add(canale.getText().toString());
    	date.add(prezzo.getText().toString());
    	date.add(da.getValue()
				  .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString());
    	
    	this.checkElementsForm(!Query.ModifyAcqFilm(date.iterator()), "Modificato Acquisto Film", "Acquisto Film Modificato Correttamente!");
    }
    
    @FXML
    private void cancellaacquistofilm(ActionEvent event) throws SQLException {
    	ArrayList<String> date = new ArrayList<String>();
    	date.add(film.getText().toString());
    	date.add(canale.getText().toString());
    	date.add(prezzo.getText().toString());
    	date.add(da.getValue()
				  .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString());
    	
    	this.checkElementsForm(!Query.ModifyAcqFilm(date.iterator()), "Cancella Acquisto Film", "Acquisto Film Cancellato Correttamente!");
    }
    
    @FXML
    public void showInsertAcquistoSerieTV() {
    	Manager.showInsertAcquistoSerieTV();
    }
    
    @FXML
    TextField idserie, idcan, prezz;
    DatePicker dast;
    
    @FXML
    private void buttonInserisciAcquistoSerieTv(ActionEvent event) throws SQLException {
    	ArrayList<String> date = new ArrayList<String>();
    	date.add(idserie.getText().toString());
    	date.add(idcan.getText().toString());
    	date.add(prezz.getText().toString());
    	date.add(dast.getValue()
				  .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString());
    	
    	this.checkElementsForm(!Query.InsertAcqSerieTv(date.iterator()), "Aggiunto Acquisto SerieTV", "Acquisto SerieTV Aggiunto Correttamente!");
    }
    
    @FXML
    private void modificaacquistoserietv(ActionEvent event) throws SQLException {
    	ArrayList<String> date = new ArrayList<String>();
    	date.add(idserie.getText().toString());
    	date.add(idcan.getText().toString());
    	date.add(prezz.getText().toString());
    	date.add(dast.getValue()
				  .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString());
    	
    	this.checkElementsForm(!Query.ModifyAcqSerieTv(date.iterator()), "Modificato Acquisto SerieTV", "Acquisto SerieTV Modificata Correttamente!");
    }
    
    @FXML
    private void cancellaacquistoserietv(ActionEvent event) throws SQLException {
    	ArrayList<String> date = new ArrayList<String>();
    	date.add(idserie.getText().toString());
    	date.add(idcan.getText().toString());
    	date.add(prezz.getText().toString());
    	date.add(dast.getValue()
				  .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString());
    	
    	this.checkElementsForm(!Query.DeleteAcqSerieTv(date.iterator()), "Cancellato Acquisto SerieTV", "Acquisto SerieTV Cancellato Correttamente!");
    }
    
    @FXML
    public void showPalinsesto() {
    	Manager.showPalinsesto();
    }
    
    @FXML
    DatePicker DataPalinsesto;   
    @FXML
    TableView<RecordPalinsesto> tableView;
    @FXML
    private TableColumn<RecordPalinsesto, String> canaleColumn;
    @FXML
    private TableColumn<RecordPalinsesto, String> programmaColumn;
    @FXML
    private TableColumn<RecordPalinsesto, String> puntataColumn;
    @FXML
    private TableColumn<RecordPalinsesto, String> oraTrasmissioneColumn;
    
    private ObservableList<RecordPalinsesto> data = FXCollections.observableArrayList();
    
    @FXML
    private void invioDataPalinsesto(ActionEvent event) throws SQLException {
    	ResultSet ris = Query.getPalinsesto(DataPalinsesto.getValue()
    													  .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    	
    	data.clear();
    	while(ris.next()) {
    		data.add(new RecordPalinsesto(ris.getString("nome"), 
    									  ris.getString("nomeProgramma"), 
    									  ris.getInt("idPuntata"),
    									  ris.getTime("oraTrasmissione")));
    	}
    	
    	tableView.setItems(data);
    	canaleColumn.setCellValueFactory(value -> value.getValue().nameChannelProperty());
    	programmaColumn.setCellValueFactory(value -> value.getValue().nameProgrammProperty());
    	puntataColumn.setCellValueFactory(value -> value.getValue().NrPuntataProperty().asString());
    	oraTrasmissioneColumn.setCellValueFactory(value -> value.getValue().oraTrasmissioneProperty());
    }
    
    @FXML
    public void showPuntata() {
    	Manager.showPuntata();
    }

    @FXML
    private TextField textFieldPuntataConduttore;
    @FXML
    private Label labelOptionalConduttore;
    @FXML
    private Label labelTrasmissione;
    @FXML
    private Label labelDurata;
    @FXML
    private LineChart<String, Float> lineChartShares;
    
    private ObservableList<String> shares = FXCollections.observableArrayList(Arrays.asList("Share1", "Share2", "Share3"));

    @FXML
    private void showPuntataConduttore() throws SQLException {
    	String value = textFieldPuntataConduttore.getText();
    	int vingola = value.indexOf(",");
    	
    	if(Parse.validationTextPuntataConduttore(value, vingola)) {
    		XYChart.Series<String, Float> series = new XYChart.Series<>();
        	series.setName("Valori dello Share");
        	
        	lineChartShares.getData().clear();
        	lineChartShares.setTitle("INDICI DI SHARE");
        	
        	ResultSet ris = Query.getPuntataConduttore(Arrays.asList(value.substring(0, vingola), 
        															 value.substring(vingola+1))
        													 .iterator());
        	if(ris.next()) {
    	    	if(ris.getString("Nome") == null || ris.getString("Cognome") == null) {
    	    		labelOptionalConduttore.setText("ASSENTE");
    	    	}
    	    	else {
    	    		labelOptionalConduttore.setText(ris.getString("Cognome") + ris.getString("Nome"));
    	    	}
    	    	
    	    	labelTrasmissione.setText(ris.getString("Trasmissione").substring(0, 10));	    	
    	    	labelDurata.setText(ris.getString("Durata"));
    	    	
    	    	for(int i = 1; i <= 3; i++) {
    	    		series.getData().add(new XYChart.Data<>(shares.get(i-1), ris.getFloat("Share" + i)));
    	    	}
    	    	
    	    	lineChartShares.getData().add(series);
        	}
    	}
    	else {
    		new AlertFactory().createErrorAllert("ERRORE: Il valore inserito non è conforme al formato richiesto!").showAndWait();
    	}
    }
    
    @FXML
    public void showCanali() throws SQLException {
    	Manager.showCanali();
    }
    
    @FXML
    private TableView<RecordCanale> tableViewCanali;
    @FXML
    private TableColumn<RecordCanale, String> channelColumn;
    @FXML
    private TableColumn<RecordCanale, String> CFAmministratoreColumn;
    @FXML
    private TableColumn<RecordCanale, String> NrCanaleColumn;
    @FXML
    private TableColumn<RecordCanale, String> dataCreazioneColumn;
    @FXML
    private TableColumn<RecordCanale, String> frequenzaColumn;
    
    private ObservableList<RecordCanale> dataCanale = FXCollections.observableArrayList();
    
    @FXML
    private void visualizzaCanali(ActionEvent event) throws SQLException {
    	ResultSet ris = Query.getCanale();
    	
    	dataCanale.clear();
    	while(ris.next()) {
    		dataCanale.add(new RecordCanale(ris.getString("nome"), 
    										ris.getString("CFAmministratore"), 
    										ris.getInt("numeroCanale"),
    										ris.getDate("dataCreazione"),
    										ris.getFloat("frequenza")));
    	}
    	
    	tableViewCanali.setItems(dataCanale);
    	
    	channelColumn.setCellValueFactory(value -> value.getValue().nameChannelProperty());
    	CFAmministratoreColumn.setCellValueFactory(value -> value.getValue().CFAmministratoreProperty());
    	NrCanaleColumn.setCellValueFactory(value -> value.getValue().nameChannelProperty());
    	dataCreazioneColumn.setCellValueFactory(value -> value.getValue().DataCreazioneProperty());
    	frequenzaColumn.setCellValueFactory(value -> value.getValue().FrequenzaProperty().asString());
    }
    
    @FXML
    public void showFilmAcquistati() {
    	Manager.showFilmAcquistati();
    }
    
    @FXML
    private TextField textFieldFilmAcquistati;
    @FXML
    private TableView<RecordFilmAcquistati> tableViewFIlm;
    @FXML
    private TableColumn<RecordFilmAcquistati, String> nomeFilmColumn;
    @FXML
    private TableColumn<RecordFilmAcquistati, String> casaDiscograficaColumn;
    @FXML
    private TableColumn<RecordFilmAcquistati, String> durataColumn;
    @FXML
    private TableColumn<RecordFilmAcquistati, String> castColumn;
    
    private ObservableList<RecordFilmAcquistati> dataFilmAcquistati = FXCollections.observableArrayList();
    
    @FXML
    private void invioRicercaFilmAcquistati(ActionEvent event) throws SQLException {
    	ResultSet ris = Query.getFilmAcquistati(Arrays.asList(textFieldFilmAcquistati.getText()).iterator());
    	
    	dataFilmAcquistati.clear();
    	while(ris.next()) {
    		dataFilmAcquistati.add(new RecordFilmAcquistati(ris.getString("NomeFILM"), 
    										ris.getString("NomeCasaCinematografica"), 
    										ris.getInt("Durata"), ris.getInt("Cast")));
    	}
    	
    	tableViewFIlm.setItems(dataFilmAcquistati);
    	
    	nomeFilmColumn.setCellValueFactory(value -> value.getValue().nameFilmProperty());
    	casaDiscograficaColumn.setCellValueFactory(value -> value.getValue().nameCasaDiscograficaProperty());
    	durataColumn.setCellValueFactory(value -> value.getValue().durataProperty().asString());
    	castColumn.setCellValueFactory(value -> value.getValue().NrCastProperty().asString());
    }
    
    @FXML
    public void showSerieTVAcquistate() {
    	Manager.showSerieTVAcquistate();
    }
    
    @FXML
    private TextField textFieldSerieAcquistate;
    @FXML
    private TableView<RecordSerieTVAcquistate> tableViewSerieTV;
    @FXML
    private TableColumn<RecordSerieTVAcquistate, String> nomeSerieColumn;
    @FXML
    private TableColumn<RecordSerieTVAcquistate, String> nomeCasaCinematograficaColumn;
    @FXML
    private TableColumn<RecordSerieTVAcquistate, String> stagioniColumn;
    @FXML
    private TableColumn<RecordSerieTVAcquistate, String> episodiColumn;
    @FXML
    private TableColumn<RecordSerieTVAcquistate, String> castSerieColumn;
    
    private ObservableList<RecordSerieTVAcquistate> dataSerieAcquistati = FXCollections.observableArrayList();
    
    @FXML
    private void invioRicercaSerieTVAcquistati(ActionEvent event) throws SQLException {
    	ResultSet ris = Query.getSerieTvAcquistate(Arrays.asList(textFieldSerieAcquistate.getText()).iterator());
    	
    	dataSerieAcquistati.clear();
    	while(ris.next()) {
    		dataSerieAcquistati.add(new RecordSerieTVAcquistate(ris.getString("NomeSerieTV"), 
    														 ris.getString("NomeCasaCinematografica"), 
    														 ris.getInt("Stagioni"), 
    														 ris.getInt("Episodi"),
    														 ris.getInt("NrCast")));
    	}
    
    	tableViewSerieTV.setItems(dataSerieAcquistati);
    	
    	nomeSerieColumn.setCellValueFactory(value -> value.getValue().nameSerieProperty());
    	nomeCasaCinematograficaColumn.setCellValueFactory(value -> value.getValue().nameCasaDiscograficaProperty());
    	stagioniColumn.setCellValueFactory(value -> value.getValue().stagioniProperty().asString());
    	episodiColumn.setCellValueFactory(value -> value.getValue().episodiProperty().asString());
    	castSerieColumn.setCellValueFactory(value -> value.getValue().NrCastProperty().asString());
    }
    
    @FXML
    public void showPartecipazionePersona() {
    	Manager.showPartecipazionePersona();
    }
    
    @FXML
    private TextField textFieldPersonaRuolo;
    @FXML
    private Label labelNomePersona;
    @FXML
    private Label labelCognomePersona;
    @FXML
    private Label labelNascitaPersona;
    @FXML
    private Label labelViaPersona;
    @FXML
    private TableView<RecordPersonaRuolo> tableViewPersonaRuolo;
    @FXML
    private TableColumn<RecordPersonaRuolo, String> programmaRuoloColumn;
    @FXML
    private TableColumn<RecordPersonaRuolo, String> nrPuntataColumn;
    @FXML
    private TableColumn<RecordPersonaRuolo, String> stipendioColumn;
    @FXML
    private TableColumn<RecordPersonaRuolo, String> ruoloColumn;
    
    private ObservableList<RecordPersonaRuolo> dataPersonaRuolo = FXCollections.observableArrayList();
    
    @FXML
    private void ricercaPersonaRuolo(ActionEvent event) throws SQLException{
    	List<String> date = Arrays.asList(textFieldPersonaRuolo.getText());
    	ResultSet risAnagrafica = Query.getSelectPersona(date.iterator());
    	ResultSet risTable = Query.getPuntateInCuiPersonaHaRuolo(date.iterator());
    	
    	if(risAnagrafica.next()) {
    		labelNomePersona.setText(risAnagrafica.getString("Nome"));
    		labelCognomePersona.setText(risAnagrafica.getString("Cognome"));
    		labelNascitaPersona.setText(Parse.getDate(risAnagrafica.getString("DataDiNasciata")));
    		labelViaPersona.setText(risAnagrafica.getString("Via") + ", " + risAnagrafica.getString("Civico"));
    	}else{
    		new AlertFactory().createInformationAllert("", "Valore non trovato").showAndWait();
    	}
    	
    	if(risTable.next()) {
    		dataPersonaRuolo.clear(); 
    		do {
    			dataPersonaRuolo.add(new RecordPersonaRuolo(risTable.getString("NomeProgramma"),
    														risTable.getInt("NumPuntata"),
    														risTable.getFloat("Stipendio"),
    														risTable.getString("Tipologia")));
    			
    			
    		}while(risTable.next());
    		
    		tableViewPersonaRuolo.setItems(dataPersonaRuolo);
    		
    		programmaRuoloColumn.setCellValueFactory(value -> value.getValue().nameProgrammaProperty());
    		nrPuntataColumn.setCellValueFactory(value -> value.getValue().NrPuntataProperty().asString());
    		stipendioColumn.setCellValueFactory(value -> value.getValue().stipendioProperty().asString());
    		ruoloColumn.setCellValueFactory(value -> value.getValue().ruoloProperty());
    	}else {
    		new AlertFactory().createInformationAllert("", "Valore non trovato").showAndWait();
    	}
    }
    
    @FXML
    public void showProgrammi() {
    	Manager.showProgrammi();
    }
    
    @FXML
    private TableView<RecordProgrammi>tableViewProgrammi;
    @FXML
    private TableColumn<RecordProgrammi, String> nomeProgrammaColumn;
    @FXML
    private TableColumn<RecordProgrammi, String> tipologiaColumn;
    @FXML
    private TableColumn<RecordProgrammi, String> studioRegistrazioneColumn;
    
    private ObservableList<RecordProgrammi> dataProgrammi = FXCollections.observableArrayList();
    
    @FXML
    private void ricercaProgrammi(ActionEvent event) throws SQLException{
    	ResultSet ris = Query.getProgrammiStudioDiRegistrazione();

    	dataProgrammi.clear();
    	while(ris.next()) {
    		dataProgrammi.add(new RecordProgrammi(ris.getString("NomePrograma"),
    											  ris.getString("Tipologia"),
    											  ris.getString("NomeStudio") + ", " + ris.getString("Citta")));
    	}
    	
    	tableViewProgrammi.setItems(dataProgrammi);
    	
    	nomeProgrammaColumn.setCellValueFactory(value -> value.getValue().nameProgrammaProperty());
    	tipologiaColumn.setCellValueFactory(value -> value.getValue().tipologiaProperty());
    	studioRegistrazioneColumn.setCellValueFactory(value -> value.getValue().studioRegistrazioneProperty());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
    }    
}