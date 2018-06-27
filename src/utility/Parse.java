package utility;

public class Parse {

	public static String getDate(String input) {
    	String ret = input.substring(8) + input.substring(input.indexOf("-"), input.indexOf("-") + 3) +
				 "-" + input.substring(0, input.indexOf("-"));
	
	return ret;
	}
}
