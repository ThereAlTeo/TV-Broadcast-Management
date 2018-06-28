package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnect {
	
	private static DBConnect SINGLETON;
	private static Connection connnection;
	private static Statement state;
	private ResultSet rs;
	private boolean ins;

	private DBConnect() {
		
	}
	
	public static DBConnect getIstance() {
		if(SINGLETON == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emittentetv?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
				state = connnection.createStatement();
				
			} catch (Exception ex) {
				System.out.println("Error " +ex);
			}
		}
		
		return SINGLETON;
	}
		
	public ResultSet getResultOf(String value) {
		try {
			rs = state.executeQuery(value);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		return rs;
	}
	
	public boolean getResultInsert(String value) {
		try {
			ins = state.execute(value);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		return ins;
	}
}
