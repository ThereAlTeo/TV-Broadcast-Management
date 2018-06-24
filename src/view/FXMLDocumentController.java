package view;

import java.net.URL;
import java.util.ResourceBundle;

import app.MainApp;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import sun.launcher.resources.launcher;
 
public class FXMLDocumentController implements Initializable {
 
    @FXML
    private void handleButtonAction(ActionEvent event) {
 
    }
 
    @FXML
    public void exitCalculator(){
    	MainApp.showPersonOverview2();
    }
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
    }    
 
}