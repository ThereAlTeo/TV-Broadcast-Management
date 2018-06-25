package view;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.mysql.cj.result.LocalTimeValueFactory;

import SQL.Query;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import app.MainApp;
import model.RecordPalinsesto;

public class FXMLDocumentController implements Initializable {
 
    @FXML
    private void handleButtonAction(ActionEvent event) {
 
    }
 
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
    	//System.out.println(date.iterator().next());
    	boolean ris = Query.InsertChannel(date.iterator());
    	//System.out.println(date);
    	if (!ris) {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("Aggiunta Canale");
    		alert2.setContentText("Canale Aggiunto Correttamente!");
    		alert2.showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		Alert alert3 = new Alert(AlertType.INFORMATION);
    		alert3.setTitle("ERROR");
    		alert3.setContentText("Uno o più Campi sono Errati!");
    		alert3.showAndWait();
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
    	//System.out.println(date.iterator().next());
    	boolean ris = Query.DeleteChannel(date.iterator());
    	//System.out.println(date);
    	if (!ris) {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("Canale Rimosso");
    		alert2.setContentText("Canale Rimosso Correttamente!");
    		alert2.showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		Alert alert3 = new Alert(AlertType.INFORMATION);
    		alert3.setTitle("ERROR");
    		alert3.setContentText("Uno o più Campi sono Errati!");
    		alert3.showAndWait();
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
    	//System.out.println(date.iterator().next());
    	boolean ris = Query.InsertProgramme(date.iterator());
    	//System.out.println(date);
    	if (!ris) {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("Aggiunto Programma");
    		alert2.setContentText("Programma Aggiunto Correttamente!");
    		alert2.showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		Alert alert3 = new Alert(AlertType.INFORMATION);
    		alert3.setTitle("ERROR");
    		alert3.setContentText("Uno o più Campi sono Errati!");
    		alert3.showAndWait();
    	}
    }
    
    @FXML
    private void modificaprogramma(ActionEvent event) throws SQLException {
    	ArrayList<String> date = new ArrayList<String>();
    	date.add(textFieldIDProgramma.getText().toString());
    	date.add(textFieldNome.getText().toString());
    	date.add(textFieldTipologia.getText().toString());
    	//System.out.println(date.iterator().next());
    	boolean ris = Query.ModifyProgramme(date.iterator());
    	//System.out.println(date);
    	if (!ris) {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("Modificato Programma");
    		alert2.setContentText("Programma Modificato Correttamente!");
    		alert2.showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		Alert alert3 = new Alert(AlertType.INFORMATION);
    		alert3.setTitle("ERROR");
    		alert3.setContentText("Uno o più Campi sono Errati!");
    		alert3.showAndWait();
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
    	//System.out.println(date.iterator().next());
    	boolean ris = Query.InsertEpisode(date.iterator());
    	//System.out.println(date);
    	if (!ris) {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("Aggiunta Puntata");
    		alert2.setContentText("Puntata Aggiunta Correttamente!");
    		alert2.showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		Alert alert3 = new Alert(AlertType.INFORMATION);
    		alert3.setTitle("ERROR");
    		alert3.setContentText("Uno o più Campi sono Errati!");
    		alert3.showAndWait();
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
    	//System.out.println(date.iterator().next());
    	boolean ris = Query.ModifyEpisode(date.iterator());
    	//System.out.println(date);
    	if (!ris) {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("Modificata Puntata");
    		alert2.setContentText("Puntata Modificata Correttamente!");
    		alert2.showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		Alert alert3 = new Alert(AlertType.INFORMATION);
    		alert3.setTitle("ERROR");
    		alert3.setContentText("Uno o più Campi sono Errati!");
    		alert3.showAndWait();
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
    	//System.out.println(date.iterator().next());
    	boolean ris = Query.DeleteEpisode(date.iterator());
    	//System.out.println(date);
    	if (!ris) {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("Cancellata Puntata");
    		alert2.setContentText("Puntata Cancellata Correttamente!");
    		alert2.showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		Alert alert3 = new Alert(AlertType.INFORMATION);
    		alert3.setTitle("ERROR");
    		alert3.setContentText("Uno o più Campi sono Errati!");
    		alert3.showAndWait();
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
    	//System.out.println(date.iterator().next());
    	boolean ris = Query.InsertPersona(date.iterator());
    	//System.out.println(date);
    	if (!ris) {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("Aggiunta Persona");
    		alert2.setContentText("Persona Aggiunta Correttamente!");
    		alert2.showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		Alert alert3 = new Alert(AlertType.INFORMATION);
    		alert3.setTitle("ERROR");
    		alert3.setContentText("Uno o più Campi sono Errati!");
    		alert3.showAndWait();
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
    	//System.out.println(date.iterator().next());
    	boolean ris = Query.ModifyPersona(date.iterator());
    	//System.out.println(date);
    	if (!ris) {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("Modificata Persona");
    		alert2.setContentText("Persona Modificata Correttamente!");
    		alert2.showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		Alert alert3 = new Alert(AlertType.INFORMATION);
    		alert3.setTitle("ERROR");
    		alert3.setContentText("Uno o più Campi sono Errati!");
    		alert3.showAndWait();
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
    	//System.out.println(date.iterator().next());
    	boolean ris = Query.DeletePersona(date.iterator());
    	//System.out.println(date);
    	if (!ris) {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("Cancellazione Persona");
    		alert2.setContentText("Persona Cancellata Correttamente!");
    		alert2.showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		Alert alert3 = new Alert(AlertType.INFORMATION);
    		alert3.setTitle("ERROR");
    		alert3.setContentText("Uno o più Campi sono Errati!");
    		alert3.showAndWait();
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
    	//System.out.println(date.iterator().next());
    	boolean ris = Query.InsertIncarico(date.iterator());
    	//System.out.println(date);
    	if (!ris) {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("Aggiunto Incarico");
    		alert2.setContentText("Incarico Aggiunto Correttamente!");
    		alert2.showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		Alert alert3 = new Alert(AlertType.INFORMATION);
    		alert3.setTitle("ERROR");
    		alert3.setContentText("Uno o più Campi sono Errati!");
    		alert3.showAndWait();
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
    	//System.out.println(date.iterator().next());
    	boolean ris = Query.ModifyIncarico(date.iterator());
    	//System.out.println(date);
    	if (!ris) {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("Modificato Incarico");
    		alert2.setContentText("Incarico Modificato Correttamente!");
    		alert2.showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		Alert alert3 = new Alert(AlertType.INFORMATION);
    		alert3.setTitle("ERROR");
    		alert3.setContentText("Uno o più Campi sono Errati!");
    		alert3.showAndWait();
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
    	//System.out.println(date.iterator().next());
    	boolean ris = Query.DeleteIncarico(date.iterator());
    	//System.out.println(date);
    	if (!ris) {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("Cancellazione Incarico");
    		alert2.setContentText("Incarico Cancellato Correttamente!");
    		alert2.showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		Alert alert3 = new Alert(AlertType.INFORMATION);
    		alert3.setTitle("ERROR");
    		alert3.setContentText("Uno o più Campi sono Errati!");
    		alert3.showAndWait();
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
    	//System.out.println(date.iterator().next());
    	boolean ris = Query.InsertSerieTv(date.iterator());
    	//System.out.println(date);
    	if (!ris) {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("Aggiunta SerieTV");
    		alert2.setContentText("SerieTv Aggiunta Correttamente!");
    		alert2.showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		Alert alert3 = new Alert(AlertType.INFORMATION);
    		alert3.setTitle("ERROR");
    		alert3.setContentText("Uno o più Campi sono Errati!");
    		alert3.showAndWait();
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
    	//System.out.println(date.iterator().next());
    	boolean ris = Query.ModifySerieTv(date.iterator());
    	//System.out.println(date);
    	if (!ris) {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("Modfica SerieTV");
    		alert2.setContentText("SerieTv Modificata Correttamente!");
    		alert2.showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		Alert alert3 = new Alert(AlertType.INFORMATION);
    		alert3.setTitle("ERROR");
    		alert3.setContentText("Uno o più Campi sono Errati!");
    		alert3.showAndWait();
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
    	//System.out.println(date.iterator().next());
    	boolean ris = Query.DeleteSerieTv(date.iterator());
    	//System.out.println(date);
    	if (!ris) {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("Cancellazione SerieTV");
    		alert2.setContentText("SerieTv Cancellata Correttamente!");
    		alert2.showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		Alert alert3 = new Alert(AlertType.INFORMATION);
    		alert3.setTitle("ERROR");
    		alert3.setContentText("Uno o più Campi sono Errati!");
    		alert3.showAndWait();
    	}
    }
    
    @FXML
    public void showInsertFilm() {
    	MainApp.showInsertFilm();
    }
    
    @FXML
    TextField idf, cd2, nom, dc, li;
    DatePicker dp, du;
    
    @FXML
    private void buttonInserisciFilm(ActionEvent event) throws SQLException {
    	
    	ArrayList<String> date = new ArrayList<String>();
    	date.add(idf.getText().toString());
    	date.add(cd2.getText().toString());
    	date.add(nom.getText().toString());
    	date.add(dc.getText().toString());
    	date.add(dp.getValue()
				  .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString());
    	date.add(du.getValue()
				  .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString());
    	date.add(li.getText().toString());
    	//System.out.println(date.iterator().next());
    	boolean ris = Query.InsertFilm(date.iterator());
    	//System.out.println(date);
    	if (!ris) {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("Aggiunto Film");
    		alert2.setContentText("Film Aggiunto Correttamente!");
    		alert2.showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		Alert alert3 = new Alert(AlertType.INFORMATION);
    		alert3.setTitle("ERROR");
    		alert3.setContentText("Uno o più Campi sono Errati!");
    		alert3.showAndWait();
    	}
    }
    
    @FXML
    private void modificafilm(ActionEvent event) throws SQLException {
    	
    	ArrayList<String> date = new ArrayList<String>();
    	date.add(idf.getText().toString());
    	date.add(cd2.getText().toString());
    	date.add(nom.getText().toString());
    	date.add(dc.getText().toString());
    	date.add(dp.getValue()
				  .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString());
    	date.add(du.getValue()
				  .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString());
    	date.add(li.getText().toString());
    	//System.out.println(date.iterator().next());
    	boolean ris = Query.ModifyFilm(date.iterator());
    	//System.out.println(date);
    	if (!ris) {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("Modificato Film");
    		alert2.setContentText("Film Modificato Correttamente!");
    		alert2.showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		Alert alert3 = new Alert(AlertType.INFORMATION);
    		alert3.setTitle("ERROR");
    		alert3.setContentText("Uno o più Campi sono Errati!");
    		alert3.showAndWait();
    	}
    }
    
    @FXML
    private void cancellafilm(ActionEvent event) throws SQLException {
    	
    	ArrayList<String> date = new ArrayList<String>();
    	date.add(idf.getText().toString());
    	date.add(cd2.getText().toString());
    	date.add(nom.getText().toString());
    	date.add(dc.getText().toString());
    	date.add(dp.getValue()
				  .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString());
    	date.add(du.getValue()
				  .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString());
    	date.add(li.getText().toString());
    	//System.out.println(date.iterator().next());
    	boolean ris = Query.DeleteFilm(date.iterator());
    	//System.out.println(date);
    	if (!ris) {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("Cancellato Film");
    		alert2.setContentText("Film Cancellato Correttamente!");
    		alert2.showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		Alert alert3 = new Alert(AlertType.INFORMATION);
    		alert3.setTitle("ERROR");
    		alert3.setContentText("Uno o più Campi sono Errati!");
    		alert3.showAndWait();
    	}
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
    	//System.out.println(date.iterator().next());
    	boolean ris = Query.InsertAcqFilm(date.iterator());
    	//System.out.println(date);
    	if (!ris) {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("Aggiunto Acquisto Film");
    		alert2.setContentText("Acquisto Film Aggiunto Correttamente!");
    		alert2.showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		Alert alert3 = new Alert(AlertType.INFORMATION);
    		alert3.setTitle("ERROR");
    		alert3.setContentText("Uno o più Campi sono Errati!");
    		alert3.showAndWait();
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
    	//System.out.println(date.iterator().next());
    	boolean ris = Query.ModifyAcqFilm(date.iterator());
    	//System.out.println(date);
    	if (!ris) {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("Modificato Acquisto Film");
    		alert2.setContentText("Acquisto Film Modificato Correttamente!");
    		alert2.showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		Alert alert3 = new Alert(AlertType.INFORMATION);
    		alert3.setTitle("ERROR");
    		alert3.setContentText("Uno o più Campi sono Errati!");
    		alert3.showAndWait();
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
    	//System.out.println(date.iterator().next());
    	boolean ris = Query.ModifyAcqFilm(date.iterator());
    	//System.out.println(date);
    	if (!ris) {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("Cancella Acquisto Film");
    		alert2.setContentText("Acquisto Film Cancellato Correttamente!");
    		alert2.showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		Alert alert3 = new Alert(AlertType.INFORMATION);
    		alert3.setTitle("ERROR");
    		alert3.setContentText("Uno o più Campi sono Errati!");
    		alert3.showAndWait();
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
    	//System.out.println(date.iterator().next());
    	boolean ris = Query.InsertAcqSerieTv(date.iterator());
    	//System.out.println(date);
    	if (!ris) {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("Aggiunto Acquisto SerieTV");
    		alert2.setContentText("Acquisto SerieTV Aggiunto Correttamente!");
    		alert2.showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		Alert alert3 = new Alert(AlertType.INFORMATION);
    		alert3.setTitle("ERROR");
    		alert3.setContentText("Uno o più Campi sono Errati!");
    		alert3.showAndWait();
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
    	//System.out.println(date.iterator().next());
    	boolean ris = Query.ModifyAcqSerieTv(date.iterator());
    	//System.out.println(date);
    	if (!ris) {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("Modificato Acquisto SerieTV");
    		alert2.setContentText("Acquisto SerieTV Modificata Correttamente!");
    		alert2.showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		Alert alert3 = new Alert(AlertType.INFORMATION);
    		alert3.setTitle("ERROR");
    		alert3.setContentText("Uno o più Campi sono Errati!");
    		alert3.showAndWait();
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
    	//System.out.println(date.iterator().next());
    	boolean ris = Query.DeleteAcqSerieTv(date.iterator());
    	//System.out.println(date);
    	if (!ris) {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("Cancellato Acquisto SerieTV");
    		alert2.setContentText("Acquisto SerieTV Cancellato Correttamente!");
    		alert2.showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		Alert alert3 = new Alert(AlertType.INFORMATION);
    		alert3.setTitle("ERROR");
    		alert3.setContentText("Uno o più Campi sono Errati!");
    		alert3.showAndWait();
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
    	
    	/**
    	 * TODO: Inserire ora!
    	 * Palinsesto ha un costruttore al quale può essere passato anche il quarto parametro.
    	 * */
    	while(ris.next()) {
    		data.add(new RecordPalinsesto(ris.getString("nome"), 
    									  ris.getString("nomeProgramma"), 
    									  ris.getInt("idPuntata"),
    									  new LocalTimeValueFactory().createFromTime(ris.getTime("oraTrasmissione").getHours(),
    											  ris.getTime("oraTrasmissione").getMinutes(),
    											  ris.getTime("oraTrasmissione").getSeconds(),
    											  0)));
    	}
    	
    	tableView.setItems(data);
    	canaleColumn.setCellValueFactory(value -> value.getValue().nameChannelProperty());
    	programmaColumn.setCellValueFactory(value -> value.getValue().nameProgrammProperty());
    	puntataColumn.setCellValueFactory(value -> value.getValue().NrPuntataProperty().asString());
    	oraTrasmissioneColumn.setCellValueFactory(value -> value.getValue().oraTrasmissioneProperty().asString());
    }
    
    @FXML
    public void showPuntata() {
    	MainApp.showPuntata();
    }
    
    @FXML
    public void showCanali() {
    	MainApp.showCanali();
    }
    
    @FXML
    public void invioRicercaFilmAcquistati() {
    	
    }
    
    @FXML
    public void showFilmAcquistati() {
    	MainApp.showFilmAcquistati();
    }
    
    @FXML
    public void showSerieTVAcquistate() {
    	MainApp.showSerieTVAcquistate();
    }
    
    @FXML
    public void showPartecipazionePersona() {
    	MainApp.showPartecipazionePersona();
    }
    
    @FXML
    public void showProgrammi() {
    	MainApp.showProgrammi();
    }
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
    }    
}