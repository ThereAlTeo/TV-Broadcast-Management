package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnect {
	
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private boolean ins;

	public DBConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emittentetv?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
			st = con.createStatement();
			
		} catch (Exception ex) {
			System.out.println("Error " +ex);
		}
	}
	
	public ResultSet getResultOf(String value) {
		try {
			rs = st.executeQuery(value);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		return rs;
	}
	
	public boolean getResultInsert(String value) {
		try {
			ins = st.execute(value);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		return ins;
	}
}
