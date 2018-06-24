package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnect {
	
	
	private Connection con;
	private Statement st;
	private ResultSet rs;

	public DBConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emittentetv?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
			st = con.createStatement();
			
		} catch (Exception ex) {
			System.out.println("Error " +ex);
		}
	}
	
	public void getData() {
		try {
			String query = "select * from film";
			rs = st.executeQuery(query);
			System.out.println("Records from database");
			while (rs.next()) {
				String idfilm = rs.getString("idFilm");
				System.out.println("ID: "+idfilm);
			}
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
