package utility;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertAbstractFactory implements AlertAbstractFactoryInterface {

	@Override
	public Alert createErrorAllert(String contentText) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText("Ooops, there was an error!");
		alert.setContentText(contentText);
		
		return alert;
	}
	
	@Override
	public Alert createInformationAllert(String header, String contentText) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText("Look, an Information Dialog:\n" + header);
		alert.setContentText(contentText);
		
		return alert;
	}
}
