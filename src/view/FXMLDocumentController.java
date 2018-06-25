package view;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.ResourceBundle;

import com.mysql.cj.result.LocalTimeValueFactory;

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
    private TextField textFieldPuntataConduttore;
    @FXML
    private Label labelOptionalConduttore;
    @FXML
    private Label labelRegistrazione;
    @FXML
    private Label labelDurata;
    @FXML
    private LineChart<String, Float> lineChartShares;
    
    private ObservableList<String> shares = FXCollections.observableArrayList();

    @FXML
    private void showPuntataConduttore() throws SQLException {
    	String value = textFieldPuntataConduttore.getText();
    	int vingola = value.indexOf(",");
    	shares.addAll(Arrays.asList("Share1", "Share2", "Share3"));
    	XYChart.Series<String, Float> series = new XYChart.Series<>();
    	
    	ResultSet ris = Query.getPuntataConduttore(Arrays.asList(value.substring(0, vingola), 
    															 value.substring(vingola))
    													 .iterator());
    	
    	if(ris.getString("nome").length() == 0 || ris.getString("cognome").length() == 0) {
    		labelOptionalConduttore.setText("ASSENTE");
    	}
    	else {
    		labelOptionalConduttore.setText(ris.getString("cognome") + ris.getString("nome"));
    	}
    	
    	/*labelRegistrazione.setText(ris.getString(3));
    	// OPPURE    	labelRegistrazione.setText(ris.getDate(3).toString());
    	
    	labelDurata.setText(ris.getString(4));
    	
    	/*for(int i = 5; i < 8; i++) {
    		series.getData().add(new XYChart.Data<>(shares.get(i-5), ris.getFloat(i)));
    	}
    	
    	lineChartShares.getData().add(series);*/
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