package SQL;

import java.sql.ResultSet;
import java.util.Iterator;

import utility.DBConnect;

public class Query {

	public static ResultSet getPalinsesto(Iterator<String> date) {
		String value = "SELECT c.nome, pr.nome, t.idPuntata, t.oraTrasmissione "
				+ "FROM palinsesto pa, canale c, trasmissione t, programma pr"
				+ "WHERE pa.dataTrasmissione = " + date.next() 
				+ "AND c.idCanale=pa.idCanale"
				+ "AND t.dataTrasmissione=pa.dataTrasmissione"
				+ "AND t.idProgramma=pr.idProgramma";
		
		return new DBConnect().getResultOf(value);
	}
}
