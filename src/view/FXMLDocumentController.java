package view;

import java.net.URL;
import java.util.ResourceBundle;

import app.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class FXMLDocumentController implements Initializable {
 
    @FXML
    private void handleButtonAction(ActionEvent event) {
 
    }
 
    @FXML
    public void showMenuPrincipale(){
    	MainApp.showMenuPrincipale();
    }
 
    @FXML
    public void showManipolazioneContenuto(){
    	MainApp.showManipolazioneContenuto();
    }
    
    @FXML
    public void showVisualizzazione(){
    	MainApp.showVisualizzazione();
    }
    
    @FXML
    public void showInsertChannel(){
    	MainApp.showInsertChannel();
    }
    
    @FXML
    public void showInsertProgramma(){
    	MainApp.showInsertProgramma();
    }
    
    /**
     * TODO: Realizzare grafica insertPuntata
     * */
    @FXML
    public void showInsertPuntata(){
    	MainApp.showInsertPuntata();
    }
    
    @FXML
    public void showInsertPersona(){
    	MainApp.showInsertPersona();
    }
    
    @FXML
    public void showInsertIncarico(){
    	MainApp.showInsertIncarico();
    }
    
    @FXML
    public void showInsertSerieTV(){
    	MainApp.showInsertSerieTV();
    }
    
    @FXML
    public void showInsertFilm(){
    	MainApp.showInsertFilm();
    }
    
    @FXML
    public void showInsertAcquistoSerieTV(){
    	MainApp.showInsertAcquistoSerieTV();
    }
    
    @FXML
    public void showInsertAcquistoFilm(){
    	MainApp.showInsertAcquistoFilm();
    }
    
    @FXML
    public void showPalinsesto(){
    	MainApp.showPalinsesto();
    }
    
    @FXML
    public void showPuntata(){
    	MainApp.showPuntata();
    }
    
    @FXML
    public void showCanali(){
    	MainApp.showCanali();
    }
    
    @FXML
    public void showSerieTVAcquistate(){
    	MainApp.showSerieTVAcquistate();
    }
    
    @FXML
    public void showFilmAcquistati(){
    	MainApp.showFilmAcquistati();
    }
    
    @FXML
    public void showPartecipazionePersona(){
    	MainApp.showPartecipazionePersona();
    }
    
    @FXML
    public void showProgrammi(){
    	MainApp.showProgrammi();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
}