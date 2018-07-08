package utility;

import java.sql.Time;

public class Parse {

	public static String getDate(String input) {
    	String ret = input.substring(8) + input.substring(input.indexOf("-"), input.indexOf("-") + 3) +
				 "-" + input.substring(0, input.indexOf("-"));
	
    	return ret;
	}
	
	@SuppressWarnings("deprecation")
	public static String getTime(Time time) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(time.getHours());
		stringBuilder.append(":");
		stringBuilder.append(time.getMinutes());
		return stringBuilder.toString();
	} 
	
	public static boolean validationTextPuntataConduttore(String value, int index) {
		try {
			Integer.parseInt(value.substring(0, index));
			Integer.parseInt(value.substring(index+1));
		} catch (Exception e) { 
			return false;
		}
		
		return true;
	}
}
