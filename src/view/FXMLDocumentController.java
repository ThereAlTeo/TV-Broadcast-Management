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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import app.MainApp;
import model.RecordCanale;
import model.RecordFilmAcquistati;
import model.RecordPalinsesto;
import model.RecordPersonaRuolo;
import model.RecordProgrammi;
import model.RecordSerieTVAcquistate;
import utility.AlertFactory;
import utility.Parse;

public class FXMLDocumentController implements Initializable {
 
    @FXML
    public void showMenuPrincipale(){
    	MainApp.showMenuPrincipale();
    }
    
    @FXML
    public void showManipolazioneContenuto() {
    	MainApp.showManipolazioneContenuto();
    }
    
    @FXML
    public void showVisualizzazione() {
    	MainApp.showVisualizzazione();
    }
    
    @FXML
    public void showInsertChannel() {
    	MainApp.showInsertChannel();
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

    	boolean ris = Query.InsertChannel(date.iterator());

    	if (!ris) {
    		new AlertFactory().createInformationAllert("Aggiunta Canale", "Canale Aggiunto Correttamente!")
    						  .showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		new AlertFactory().createErrorAllert("Uno o più Campi sono Errati!").showAndWait();
    	}
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
    	
    	boolean ris = Query.DeleteChannel(date.iterator());
    	
    	if (!ris) {
    		new AlertFactory().createInformationAllert("Canale Rimosso", "Canale Rimosso Correttamente!")
    						  .showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		new AlertFactory().createErrorAllert("Uno o più Campi sono Errati!").showAndWait();
    	}
    }
    
    @FXML
    public void showInsertProgramma() {
    	MainApp.showInsertProgramma();
    }
    
    @FXML
    TextField textFieldIDProgramma, textFieldNome, textFieldTipologia;
    
    @FXML
    private void buttonInserisciProgramma(ActionEvent event) throws SQLException {
    	ArrayList<String> date = new ArrayList<String>();
    	date.add(textFieldIDProgramma.getText().toString());
    	date.add(textFieldNome.getText().toString());
    	date.add(textFieldTipologia.getText().toString());
    	
    	boolean ris = Query.InsertProgramme(date.iterator());

    	if (!ris) {
    		new AlertFactory().createInformationAllert("Aggiunto Programma", "Programma Aggiunto Correttamente!")
    						  .showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		new AlertFactory().createErrorAllert("Uno o più Campi sono Errati!").showAndWait();
    	}
    }
    
    @FXML
    private void modificaprogramma(ActionEvent event) throws SQLException {
    	ArrayList<String> date = new ArrayList<String>();
    	date.add(textFieldIDProgramma.getText().toString());
    	date.add(textFieldNome.getText().toString());
    	date.add(textFieldTipologia.getText().toString());

    	boolean ris = Query.ModifyProgramme(date.iterator());
    	
    	if (!ris) {
    		new AlertFactory().createInformationAllert("Modificato Programma", "Programma Modificato Correttamente!")
    						  .showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		new AlertFactory().createErrorAllert("Uno o più Campi sono Errati!").showAndWait();
    	}
    }
    
    @FXML
    private void cancellaprogramma(ActionEvent event) throws SQLException {
    	ArrayList<String> date = new ArrayList<String>();
    	date.add(textFieldIDProgramma.getText().toString());
    	date.add(textFieldNome.getText().toString());
    	date.add(textFieldTipologia.getText().toString());
    	
    	boolean ris = Query.DeleteProgramme(date.iterator());
    	
    	if (!ris) {
    		new AlertFactory().createInformationAllert("Cancellazione Programma", "Programma Cancellato Correttamente!")
    						  .showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		new AlertFactory().createErrorAllert("Uno o più Campi sono Errati!").showAndWait();
    	}
    }
    
    @FXML
    public void showInsertPuntata() {
    	MainApp.showInsertPuntata();
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
    	
    	boolean ris = Query.InsertEpisode(date.iterator());
    	
    	if (!ris) {
    		new AlertFactory().createInformationAllert("Aggiunta Puntata", "Puntata Aggiunta Correttamente!")
    						  .showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		new AlertFactory().createErrorAllert("Uno o più Campi sono Errati!").showAndWait();
    	}
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
    	
    	boolean ris = Query.ModifyEpisode(date.iterator());
    	
    	if (!ris) {
    		new AlertFactory().createInformationAllert("Modificata Puntata", "Puntata Modificata Correttamente!")
    						  .showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		new AlertFactory().createErrorAllert("Uno o più Campi sono Errati!").showAndWait();
    	}
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
    	
    	boolean ris = Query.DeleteEpisode(date.iterator());
    	
    	if (!ris) {
    		new AlertFactory().createInformationAllert("Cancellata Puntata", "Puntata Cancellata Correttamente!") 
    						  .showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		new AlertFactory().createErrorAllert("Uno o più Campi sono Errati!").showAndWait();
    	}
    }
    
    @FXML
    public void showInsertPersona() {
    	MainApp.showInsertPersona();
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
    	
    	boolean ris = Query.InsertPersona(date.iterator());
    	
    	if (!ris) {
    		new AlertFactory().createInformationAllert("Aggiunta Persona", "Persona Aggiunta Correttamente!")
    						  .showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		new AlertFactory().createErrorAllert("Uno o più Campi sono Errati!").showAndWait();
    	}
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
    	
    	boolean ris = Query.ModifyPersona(date.iterator());
    	
    	if (!ris) {
    		new AlertFactory().createInformationAllert("Modificata Persona", "Persona Modificata Correttamente!")
    						  .showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		new AlertFactory().createErrorAllert("Uno o più Campi sono Errati!").showAndWait();
    	}
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

    	boolean ris = Query.DeletePersona(date.iterator());
    	
    	if (!ris) {
    		new AlertFactory().createInformationAllert("Cancellazione Persona", "Persona Cancellata Correttamente!")
    						  .showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		new AlertFactory().createErrorAllert("Uno o più Campi sono Errati!").showAndWait();
    	}
    }
    
    @FXML
    public void showInsertIncarico() {
    	MainApp.showInsertIncarico();
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
    	
    	boolean ris = Query.InsertIncarico(date.iterator());
    	
    	if (!ris) {
    		new AlertFactory().createInformationAllert("Aggiunto Incarico", "Incarico Aggiunto Correttamente!") 
    						  .showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		new AlertFactory().createErrorAllert("Uno o più Campi sono Errati!").showAndWait();
    	}
    }
    
    @FXML
    private void modificaincarico(ActionEvent event) throws SQLException {
    	
    	ArrayList<String> date = new ArrayList<String>();
    	date.add(idp.getText().toString());
    	date.add(idpr.getText().toString());
    	date.add(cf2.getText().toString());
    	date.add(s.getText().toString());
    	date.add(r.getText().toString());
    	
    	boolean ris = Query.ModifyIncarico(date.iterator());
    	
    	if (!ris) {
    		new AlertFactory().createInformationAllert("Modificato Incarico", "Incarico Modificato Correttamente!") 
    						  .showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		new AlertFactory().createErrorAllert("Uno o più Campi sono Errati!").showAndWait();
    	}
    }
    
    @FXML
    private void cancellaincarico(ActionEvent event) throws SQLException {
    	
    	ArrayList<String> date = new ArrayList<String>();
    	date.add(idp.getText().toString());
    	date.add(idpr.getText().toString());
    	date.add(cf2.getText().toString());
    	date.add(s.getText().toString());
    	date.add(r.getText().toString());
    	
    	boolean ris = Query.DeleteIncarico(date.iterator());
    	
    	if (!ris) {
    		new AlertFactory().createInformationAllert("Cancellazione Incarico", "Incarico Cancellato Correttamente!")
    					      .showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		new AlertFactory().createErrorAllert("Uno o più Campi sono Errati!").showAndWait();
    	}
    }
    
    @FXML
    public void showInsertSerieTV() {
    	MainApp.showInsertSerieTV();
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
    	
    	boolean ris = Query.InsertSerieTv(date.iterator());
    	
    	if (!ris) {
    		new AlertFactory().createInformationAllert("Aggiunta SerieTV", "SerieTv Aggiunta Correttamente!")
    						  .showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		new AlertFactory().createErrorAllert("Uno o più Campi sono Errati!").showAndWait();
    	}
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
    	
    	boolean ris = Query.ModifySerieTv(date.iterator());
    	
    	if (!ris) {
    		new AlertFactory().createInformationAllert("Modfica SerieTV", "SerieTv Modificata Correttamente!")
    						  .showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		new AlertFactory().createErrorAllert("Uno o più Campi sono Errati!").showAndWait();
    	}
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
    	
    	boolean ris = Query.DeleteSerieTv(date.iterator());
    	
    	if (!ris) {
    		new AlertFactory().createInformationAllert("Cancellazione SerieTV", "SerieTv Cancellata Correttamente!")
    						  .showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		new AlertFactory().createErrorAllert("Uno o più Campi sono Errati!").showAndWait();
    	}
    }
    
    @FXML
    public void showInsertFilm() {
    	MainApp.showInsertFilm();
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
    	
    	boolean ris = Query.InsertFilm(date.iterator());
    	
    	if (!ris) {
    		new AlertFactory().createInformationAllert("Aggiunto Film", "Film Aggiunto Correttamente!")
    						  .showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		new AlertFactory().createErrorAllert("Uno o più Campi sono Errati!").showAndWait();
    	}*/
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
    	
    	boolean ris = Query.ModifyFilm(date.iterator());
    	
    	if (!ris) {
    		new AlertFactory().createInformationAllert("Modificato Film", "Film Modificato Correttamente!")
    						  .showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		new AlertFactory().createErrorAllert("Uno o più Campi sono Errati!").showAndWait();
    	}*/
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
    	
    	boolean ris = Query.DeleteFilm(date.iterator());
    	
    	if (!ris) {
    		new AlertFactory().createInformationAllert("Cancellato Film", "Film Cancellato Correttamente!")
    						  .showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		new AlertFactory().createErrorAllert("Uno o più Campi sono Errati!").showAndWait();
    	}*/
    }
    
    @FXML
    public void showInsertAcquistoFilm() {
    	MainApp.showInsertAcquistoFilm();
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
    	
    	boolean ris = Query.InsertAcqFilm(date.iterator());
    	
    	if (!ris) {
    		new AlertFactory().createInformationAllert("Aggiunto Acquisto Film", "Acquisto Film Aggiunto Correttamente!")
    						  .showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		new AlertFactory().createErrorAllert("Uno o più Campi sono Errati!").showAndWait();
    	}
    }
    
    @FXML
    private void modificaacquistofilm(ActionEvent event) throws SQLException {
    	ArrayList<String> date = new ArrayList<String>();
    	date.add(film.getText().toString());
    	date.add(canale.getText().toString());
    	date.add(prezzo.getText().toString());
    	date.add(da.getValue()
				  .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString());
    	
    	boolean ris = Query.ModifyAcqFilm(date.iterator());
    	
    	if (!ris) {
    		new AlertFactory().createInformationAllert("Modificato Acquisto Film", "Acquisto Film Modificato Correttamente!")
    						  .showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		new AlertFactory().createErrorAllert("Uno o più Campi sono Errati!").showAndWait();
    	}
    }
    
    @FXML
    private void cancellaacquistofilm(ActionEvent event) throws SQLException {
    	ArrayList<String> date = new ArrayList<String>();
    	date.add(film.getText().toString());
    	date.add(canale.getText().toString());
    	date.add(prezzo.getText().toString());
    	date.add(da.getValue()
				  .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString());
    	
    	boolean ris = Query.ModifyAcqFilm(date.iterator());
    	
    	if (!ris) {
    		new AlertFactory().createInformationAllert("Cancella Acquisto Film", "Acquisto Film Cancellato Correttamente!")
    						  .showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		new AlertFactory().createErrorAllert("Uno o più Campi sono Errati!").showAndWait();
    	}
    }
    
    @FXML
    public void showInsertAcquistoSerieTV() {
    	MainApp.showInsertAcquistoSerieTV();
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
    	
    	boolean ris = Query.InsertAcqSerieTv(date.iterator());
    	
    	if (!ris) {
    		new AlertFactory().createInformationAllert("Aggiunto Acquisto SerieTV", "Acquisto SerieTV Aggiunto Correttamente!")
    						  .showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		new AlertFactory().createErrorAllert("Uno o più Campi sono Errati!").showAndWait();
    	}
    }
    
    @FXML
    private void modificaacquistoserietv(ActionEvent event) throws SQLException {
    	ArrayList<String> date = new ArrayList<String>();
    	date.add(idserie.getText().toString());
    	date.add(idcan.getText().toString());
    	date.add(prezz.getText().toString());
    	date.add(dast.getValue()
				  .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString());
    	
    	boolean ris = Query.ModifyAcqSerieTv(date.iterator());
    	
    	if (!ris) {
    		new AlertFactory().createInformationAllert("Modificato Acquisto SerieTV", "Acquisto SerieTV Modificata Correttamente!")
    						  .showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		new AlertFactory().createErrorAllert("Uno o più Campi sono Errati!").showAndWait();
    	}
    }
    
    @FXML
    private void cancellaacquistoserietv(ActionEvent event) throws SQLException {
    	ArrayList<String> date = new ArrayList<String>();
    	date.add(idserie.getText().toString());
    	date.add(idcan.getText().toString());
    	date.add(prezz.getText().toString());
    	date.add(dast.getValue()
				  .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString());
    	
    	boolean ris = Query.DeleteAcqSerieTv(date.iterator());
    	
    	if (!ris) {
    		new AlertFactory().createInformationAllert("Cancellato Acquisto SerieTV", "Acquisto SerieTV Cancellato Correttamente!")
    						  .showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		new AlertFactory().createErrorAllert("Uno o più Campi sono Errati!").showAndWait();
    	}
    }
    
    @FXML
    public void showPalinsesto() {
    	MainApp.showPalinsesto();
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
    	MainApp.showPuntata();
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
    	MainApp.showCanali();
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
    	MainApp.showFilmAcquistati();
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
    	MainApp.showSerieTVAcquistate();
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
    	MainApp.showPartecipazionePersona();
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
    	}else
    	{
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
    	MainApp.showProgrammi();
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