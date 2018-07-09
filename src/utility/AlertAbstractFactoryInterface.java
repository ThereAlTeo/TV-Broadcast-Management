package utility;

import javafx.scene.control.Alert;

public interface AlertAbstractFactoryInterface {

	public Alert createErrorAllert(String contentText);
	
	public Alert createInformationAllert(String header, String contentText);
}
