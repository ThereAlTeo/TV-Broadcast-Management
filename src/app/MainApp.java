package app;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
    private static BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Emittente TV");

        initRootLayout();
        showBenvenuto();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
        	FXMLLoader loader = new FXMLLoader();
            loader.setLocation(new File("src/view/RootLayout.fxml").toURI().toURL());
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows Welcome inside the root layout.
     */
    public static void showBenvenuto() {
    	templatePane("src/view/Benvenuto.fxml");
    }
    
    public static void showMenuPrincipale() {
        templatePane("src/view/MenuPrincipale.fxml");
    }
    
    public static void showManipolazioneContenuto() {
        templatePane("src/view/ManipolazioneContenuto.fxml");
    }
    
    public static void showVisualizzazione() {
        templatePane("src/view/Visualizzazione.fxml");
    }
    
    public static void showInsertChannel() {
        templatePane("src/view/InsertChannel.fxml");       
    }
    
    public static void showInsertProgramma() {
        templatePane("src/view/InsertProgramma.fxml");
    }
    
    public static void showInsertPuntata() {
        templatePane("src/view/InsertPuntata.fxml");
    }
    
    public static void showInsertPersona() {
        templatePane("src/view/InsertPersona.fxml");
    }
    
    public static void showInsertIncarico() {
        templatePane("src/view/InsertIncarico.fxml");
    }
    
    public static void showInsertSerieTV() {
        templatePane("src/view/InsertSerieTV.fxml");
    }
    
    public static void showInsertFilm() {
        templatePane("src/view/InsertFilm.fxml");
    }
    
    public static void showInsertAcquistoFilm() {
       templatePane("src/view/InsertAcquistoFilm.fxml");    	
    }
    
    public static void showInsertAcquistoSerieTV() {
       templatePane("src/view/InsertAcquistoSerieTV.fxml");
    }
    
    public static void showPalinsesto() {
        templatePane("src/view/Palinsesto.fxml");
    }
    
    public static void showPuntata() {
        templatePane("src/view/Puntata.fxml");
    }
    
    public static void showCanali() {
        templatePane("src/view/Canali.fxml");    	
    }
    
    public static void showFilmAcquistati() {
        templatePane("src/view/FilmAcquistati.fxml");
    }
    
    public static void showSerieTVAcquistate() {
        templatePane("src/view/SerieTVAcquistate.fxml");    	
    }
    
    public static void showPartecipazionePersona() {
        templatePane("src/view/PartecipazionePersona.fxml");
    }
    
    public static void showProgrammi() {
        templatePane("src/view/Programmi.fxml");    	
    }
    
    private static void templatePane(String path) {
    	try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(new File(path).toURI().toURL());
            AnchorPane newPane = (AnchorPane) loader.load();

            rootLayout.setCenter(newPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
	public static void main(String[] args) {
		launch(args);
	}
}
