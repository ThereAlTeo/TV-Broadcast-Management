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
    TextField textFieldID;
    @FXML
    TextField textFieldAmministratore;
    @FXML
    TextField textFieldNCanale;
    @FXML
    TextField textFieldnomecanale;
    @FXML
    RadioButton radioButtonAcquistato;
    @FXML
    TextField textFieldAcquistatoDa;
    @FXML
    TextField textFieldAcquistatoPrezzo;
    @FXML
    TextField TextFieldFrequenza;
    
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
    	System.out.println(date);
    	if (!ris) {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("Aggiunta Canale");
    		alert2.setContentText("Canale Aggiunto Correttamente!");
    		alert2.showAndWait();
    		MainApp.showVisualizzazione();
    	} else {
    		Alert alert3 = new Alert(AlertType.INFORMATION);
    		alert3.setTitle("ERROR");
    		alert3.setContentText("Aggiunta di Campi Errati!");
    		alert3.showAndWait();
    	}
    }
    
    @FXML
    public void showInsertProgramma() {
    	MainApp.showInsertProgramma();
    }
    
    @FXML
    public void showInsertPuntata() {
    	MainApp.showInsertPuntata();
    }
    
    @FXML
    public void showInsertPersona() {
    	MainApp.showInsertPersona();
    }
    
    @FXML
    public void showInsertIncarico() {
    	MainApp.showInsertIncarico();
    }
    
    @FXML
    public void showInsertSerieTV() {
    	MainApp.showInsertSerieTV();
    }
    
    @FXML
    public void showInsertFilm() {
    	MainApp.showInsertFilm();
    }
    
    @FXML
    public void showInsertAcquistoFilm() {
    	MainApp.showInsertAcquistoFilm();
    }
    
    @FXML
    public void showInsertAcquistoSerieTV() {
    	MainApp.showInsertAcquistoSerieTV();
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