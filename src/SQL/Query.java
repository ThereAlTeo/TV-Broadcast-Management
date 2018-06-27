package SQL;

import java.sql.ResultSet;
import java.util.Iterator;

import utility.DBConnect;

public class Query {
	
	public static boolean InsertChannel(Iterator<String> date) {
		String value = "INSERT INTO `canale`(`idCanale`, `CFAmministratore`, `nome`, `numeroCanale`, "
				+ " `dataCreazione`, `acquistato_da`, `acquistato_prezzo`, `frequenza`) "
				+ " VALUES (" + date.next() + ", \"" + date.next() + "\", \"" + date.next() + "\", " + date.next()
				+ " , \"" + date.next() + "\", \"" + date.next() + "\", " + date.next() + ", " + date.next() + ")";
		System.out.println(value);

		return new DBConnect().getResultInsert(value);
	}
	
	public static boolean ModifyeChannel(Iterator<String> date) {
		String id = date.next();
		String value = "UPDATE `canale` SET `idCanale`=" + id + ", `CFAmministratore`=" + date.next() + ", "
				+ " `nome`=" + date.next() + ", `numeroCanale`=" + date.next() + ", `dataCreazione`=" + date.next() + ","
				+ " `acquistato_da`=?, `acquistato_prezzo`=?,"
				+ " `frequenza`=" + date.next() + "" + " WHERE `idCanale`=" + id + "";

		return new DBConnect().getResultInsert(value);
	}
	
	public static boolean DeleteChannel(Iterator<String> date) {
		String value = "DELETE FROM `canale` WHERE `idCanale`=" + date.next() + "";

		return new DBConnect().getResultInsert(value);
	}
	
	public static boolean InsertProgramme(Iterator<String> date) {
		String value = "INSERT INTO `programma`(`idProgramma`, `nome`, `tipologia`) "
				+ "VALUES (" + date.next() + ", \"" + date.next() + "\", \"" + date.next() + "\")";
		
		return new DBConnect().getResultInsert(value);
	}
	
	public static boolean DeleteProgramme(Iterator<String> date) {
		String value = "DELETE FROM `programma` WHERE `idProgramma`=" + date.next() + "";
		
		return new DBConnect().getResultInsert(value);
	}
	
	public static boolean ModifyProgramme(Iterator<String> date) {
		String id = date.next();
		String value = "UPDATE `programma` SET `idProgramma`=" + id + ", `nome`=\"" + date.next() 
		+ "\",`tipologia`=\"" + date.next() + "\" WHERE `idProgramma`=" + id + "";
		
		return new DBConnect().getResultInsert(value);
	}
	
	public static boolean InsertEpisode(Iterator<String> date) {
		String value = "INSERT INTO `puntata`(`idPuntata`, `idProgramma`, `oraInizioRegistrazione`,"
				+ " `oraFineRegistrazione`, `durata`, `share1`, `share2`, `share3`) "
				+ "VALUES (" + date.next() + ", " + date.next() + ", \"" + date.next() + "\", \"" + date.next()
				+ "\", " + date.next() + ", " + date.next() + ", " + date.next() + ", " + date.next() + ")";
		System.out.println(value);
		return new DBConnect().getResultInsert(value);
	}
	
	public static boolean DeleteEpisode(Iterator<String> date) {
		String value = "DELETE FROM `puntata` WHERE `idPuntata`=" + date.next() + "";
		
		return new DBConnect().getResultInsert(value);
	}
	
	public static boolean ModifyEpisode(Iterator<String> date) {
		String idPunt = date.next();
		String idProg = date.next();
		String value = "UPDATE `puntata` SET `idPuntata`=" + idPunt + ", `idProgramma`=" + idProg + ","
				+ " `oraInizioRegistrazione`=\"" + date.next() + "\", `oraFineRegistrazione`=\"" + date.next() + "\","
				+ "`durata`=" + date.next() + ", `share1`=" + date.next() + ", `share2`=" + date.next() + ","
				+ " `share3`=" + date.next() + " WHERE `idPuntata`=" + idPunt + ", `idProgramma`=" + idProg + "";
		
		return new DBConnect().getResultInsert(value);
	}
	
	public static boolean InsertPersona(Iterator<String> date) {
		String value = "INSERT INTO `persona`(`CodiceFiscale`, `nome`, `cognome`, `sesso`,"
				+ " `dataDiNascita`, `indirizzo_via`, `indirizzo_civico`, `città`) VALUES"
				+ " (\"" + date.next() + "\", \"" + date.next() + "\", \"" + date.next() + "\", \"" + date.next() + "\",\""
				+ date.next() + "\", \"" + date.next() + "\", \"" + date.next() + "\", \"" + date.next() + "\")";
		
		return new DBConnect().getResultInsert(value);
	}
	
	public static boolean DeletePersona(Iterator<String> date) {
		String value = "DELETE FROM `persona` WHERE `CodiceFiscale`=\""+ date.next() + "\"";
		
		return new DBConnect().getResultInsert(value);
	}
	
	public static boolean ModifyPersona(Iterator<String> date) {
		String CF = date.next();
		String value = "UPDATE `persona` SET `CodiceFiscale`=\""+ CF + "\", `nome`=\""+ date.next() + "\","
				+ " `cognome`=\""+ date.next() + "\", `sesso`="+ date.next() + ", `dataDiNascita`=\""+ date.next() + "\","
				+ " `indirizzo_via`=\""+ date.next() + "\", `indirizzo_civico`="+ date.next() + ","
				+ " `città`=\""+ date.next() + "\" WHERE `CodiceFiscale`=\""+ CF + "\"";
		
		return new DBConnect().getResultInsert(value);
	}
	
	public static boolean InsertIncarico(Iterator<String> date) {
		String value = "INSERT INTO `incarico`(`idPuntata`, `idProgramma`, `CodiceFiscale`,"
				+ " `stipendio`, `idRuolo`) VALUES ("+ date.next() + ", "+ date.next() + ", \""+ date.next()
				+ "\", "+ date.next() + ", \"" + date.next() + "\")";
		
		return new DBConnect().getResultInsert(value);
	}
	
	public static boolean DeleteIncarico(Iterator<String> date) {
		String value = "DELETE FROM `incarico` "
				+ "WHERE `idPuntata`=" + date.next() + " "
				+ "AND `idProgramma`=" + date.next() + " "
				+ "AND `CodiceFiscale`=\"" + date.next() + "\"";
		
		return new DBConnect().getResultInsert(value);
	}
	
	public static boolean ModifyIncarico(Iterator<String> date) {
		String idPunt = date.next();
		String idProg = date.next();
		String value = "UPDATE `incarico` SET `idPuntata`=" + idPunt + ", "
				+ "`idProgramma`=" + idProg + ", "
				+ "`CodiceFiscale`=\"" + date.next() + "\", "
				+ "`stipendio`=" + date.next() + ", "
				+ "`idRuolo`=" + date.next() + " "
				+ "WHERE `idPuntata`=" + idPunt + " `idProgramma`=" + idProg + "";
		
		return new DBConnect().getResultInsert(value);
	}
	
	public static boolean InsertFilm(Iterator<String> date) {
		String value = "INSERT INTO `film`(`idFilm`, `idCasaCinematografica`,"
				+ " `nome`, `dataCreazione`, `dataPubblicazione`,"
				+ " `durata`, `lingua`) VALUES "
				+ "(" + date.next() + ", " + date.next() + ", \"" + date.next() + "\", \"" + date.next()
				+ "\", \"" + date.next() + "\", " + date.next() + ", \"" + date.next() + "\")";
		
		return new DBConnect().getResultInsert(value);
	}
	
	public static boolean DeleteFilm(Iterator<String> date) {
		String value = "DELETE FROM `film` WHERE `idFilm`=" + date.next() + "";
		
		return new DBConnect().getResultInsert(value);
	}
	
	public static boolean ModifyFilm(Iterator<String> date) {
		String idFilm = date.next();
		String value = "UPDATE `film` SET `idFilm`=" + idFilm + ", `idCasaCinematografica`=" + date.next() + ","
				+ " `nome`=\"" + date.next() + "\", `dataCreazione`=\"" + date.next() + "\","
				+ " `dataPubblicazione`=\"" + date.next() + "\", `durata`=" + date.next() + ","
				+ "`lingua`=\"" + date.next() + "\" WHERE `idFilm`=" + idFilm + "";
		
		return new DBConnect().getResultInsert(value);
	}
	
	public static boolean InsertSerieTv(Iterator<String> date) {
		String value = "INSERT INTO `serie_tv`(`idSerieTV`, `idCasaCinematografica`,"
				+ " `nome`, `tipologia`, `stagioni`, `episodi`,"
				+ " `durata`, `lingua`) VALUES "
				+ "(" + date.next() + ", " + date.next() + ", \"" + date.next() + "\", \"" + date.next()
				+ "\", " + date.next() + ", " + date.next() + ", " + date.next() + ", \"" + date.next() + "\")";
		
		return new DBConnect().getResultInsert(value);
	}
	
	public static boolean DeleteSerieTv(Iterator<String> date) {
		String value = "DELETE FROM `serie_tv` WHERE `idSerieTV`=" + date.next() + "";
		
		return new DBConnect().getResultInsert(value);
	}
	
	public static boolean ModifySerieTv(Iterator<String> date) {
		String idSerieTV = date.next();
		String value = "UPDATE `serie_tv` SET `idSerieTV`=" + idSerieTV + ", `idCasaCinematografica`=" + date.next() + ","
				+ " `nome`=\"" + date.next() + "\", `tipologia`=\"" + date.next() + "\", `stagioni`=" + date.next() + ","
				+ " `episodi`=" + date.next() + ", `durata`=" + date.next() + ", `lingua`=\"" + date.next() + "\""
				+ " WHERE `idSerieTV`=" + idSerieTV + "";
		
		return new DBConnect().getResultInsert(value);
	}
	
	public static boolean InsertAcqFilm(Iterator<String> date) {
		String value = "INSERT INTO `acquisizioni_film`(`idFilm`, "
				+ "`idCanale`, `prezzo`, `dataAcquisto`) VALUES "
				+ "(" + date.next() + ", " + date.next() + ", " + date.next() + ", \"" + date.next() + "\")";
		
		return new DBConnect().getResultInsert(value);
	}
	
	public static boolean DeleteAcqFilm(Iterator<String> date) {
		String value = "DELETE FROM `acquisizioni_film` WHERE"
				+ " `idFilm`=" + date.next() + " AND `idCanale`=" + date.next() + "";
		
		return new DBConnect().getResultInsert(value);
	}
	
	public static boolean ModifyAcqFilm(Iterator<String> date) {
		String idFilm = date.next();
		String idCanale = date.next();
		String value = "UPDATE `acquisizioni_film` SET `idFilm`=" + idFilm + ","
				+ " `idCanale`=" + idCanale + ", `prezzo`=" + date.next() + ", `dataAcquisto`=\"" + date.next() + "\""
				+ " WHERE `idFilm`=" + idFilm + ", `idCanale`=" + idCanale + "";
		
		return new DBConnect().getResultInsert(value);
	}
	
	public static boolean InsertAcqSerieTv(Iterator<String> date) {
		String value = "INSERT INTO `acquisizioni_serie_tv`(`idSerieTV`,"
				+ " `idCanale`, `prezzo`, `dataAcquisto`) VALUES"
				+ " (" + date.next() + ", " + date.next() + ", " + date.next() + ", \"" + date.next() + "\")";
		
		return new DBConnect().getResultInsert(value);
	}
	
	public static boolean DeleteAcqSerieTv(Iterator<String> date) {
		String value = "DELETE FROM `acquisizioni_serie_tv` WHERE `idSerieTV`=" + date.next()
		+ " AND `idCanale`=" + date.next() + "";
		
		return new DBConnect().getResultInsert(value);
	}
	
	public static boolean ModifyAcqSerieTv(Iterator<String> date) {
		String idSerieTV = date.next();
		String idCanale = date.next();
		String value = "UPDATE `acquisizioni_serie_tv` SET `idSerieTV`=" + idSerieTV + ","
				+ " `idCanale`=" + idCanale + ", `prezzo`=" + date.next() + ", `dataAcquisto`=\"" + date.next() + "\""
				+ " WHERE `idSerieTV`=" + idSerieTV + ", `idCanale`=" + idCanale + "";
		
		return new DBConnect().getResultInsert(value);
	}

	public static ResultSet getPalinsesto(String date) {
		String value = "SELECT c.nome AS nome, pr.nome AS nomeProgramma, t.idPuntata AS idPuntata, t.oraTrasmissione AS oraTrasmissione "
				+ " FROM palinsesto pa, canale c, trasmissione t, programma pr"
				+ " WHERE pa.dataTrasmissione =\" " + date + "\"  AND c.idCanale=pa.idCanale"
				+ " AND t.dataTrasmissione=pa.dataTrasmissione"
				+ " AND t.idProgramma=pr.idProgramma";
		
		return new DBConnect().getResultOf(value);
	}
	
	public static ResultSet getPuntataConduttore(Iterator<String> date) {
		String value = "SELECT p.nome AS Nome, p.cognome AS Cognome, pu.durata AS Durata, pu.share1 AS Share1, pu.share2 AS Share2, pu.share3 AS Share3, t.dataTrasmissione AS Trasmissione " + 
				"FROM incarico i INNER JOIN persona p ON i.CodiceFiscale = p.CodiceFiscale " + 
				"INNER JOIN ruolo r ON i.idRUolo = r.idRuolo " + 
				"INNER JOIN puntata pu ON pu.idPuntata = i.idPuntata AND pu.idProgramma = i.idProgramma " + 
				"INNER JOIN trasmissione t ON t.idPuntata = pu.idPuntata AND t.idProgramma = pu.idProgramma " + 
				"WHERE i.idPuntata=" + date.next() +" AND i.idProgramma=" + date.next()+" AND r.tipologia = \"Conduttore\"";
		
		return new DBConnect().getResultOf(value);
	}
	
	public static ResultSet getCanale() {
		String value = "SELECT nome, CFAmministratore, numeroCanale, dataCreazione, frequenza " + 
				"FROM canale " +
				"ORDER BY numeroCanale";
		
		return new DBConnect().getResultOf(value);
	}
	
	public static ResultSet getFilmAcquistati(Iterator<String> date) {
		String value = "SELECT f.nome AS NomeFILM, cc.nome AS NomeCasaCinematografica, f.durata AS Durata, COUNT(cf.CodiceFiscale) AS Cast " + 
				"	FROM canale c, acquisizioni_film af, film f, casa_cinematografica cc, cast_film cf " + 
				"	WHERE c.idCanale=" + date.next() + " AND af.idCanale=c.idCanale AND af.idFilm=f.idFilm " + 
				"	AND f.idCasaCinematografica=cc.idCasaCinematografica AND f.idFilm=cf.idFilm " +
				"   GROUP BY NomeFILM, NomeCasaCinematografica, Durata";
		
		return new DBConnect().getResultOf(value);
	}
	
	public static ResultSet getSerieTvAcquistate(Iterator<String> date) {
		String value = "SELECT st.nome AS NomeSerieTV, cc.nome AS NomeCasaCinematografica, st.stagioni AS Stagioni, " +
				"   st.episodi AS Episodi, COUNT(cst.CodiceFiscale) AS NrCast" + 
				"	FROM canale c, acquisizioni_serie_tv ast, serie_tv st, casa_cinematografica cc, cast_serie_tv cst " + 
				"	WHERE c.idCanale=" + date.next() + " AND ast.idCanale=c.idCanale " + 
				"	AND ast.idSerieTv=st.idSerieTv AND st.idCasaCinematografica=cc.idCasaCinematografica " + 
				"	AND st.idSerieTV=cst.idSerieTV " +
				"   GROUP BY NomeSerieTV, NomeCasaCinematografica, Stagioni, Episodi";
		
		return new DBConnect().getResultOf(value);
	}
	
	public static ResultSet getProgrammiStudioDiRegistrazione(Iterator<String> date) {
		String value = "SELECT p.nome, p.tipologia, sdr.nomeStudio" + 
				"	FROM programma p, registrazione r, studio_di_registrazione sdr" + 
				"	WHERE p.idProgramma=r.idProgramma" + 
				"	AND r.nomeStudio=sdr.nomeStudio" + 
				"	AND r.città=sdr.città";
		
		return new DBConnect().getResultOf(value);
	}
	
	public static ResultSet getPuntateInCuiPersonaHaRuolo(Iterator<String> date) {
		String value = "SELECT p.nome, p.cognome, p.dataDiNascita, p.indirizzo_via, i.idProgramma, i.idPuntata, t.dataTrasmissione, r.tipologia" + 
				"	FROM persona p, incarico i, ruolo r, puntata pu, trasmissione t" + 
				"	WHERE p.CodiceFiscale=\"" + date.next() + "\"" + 
				"	AND i.CodiceFiscale=p.CodiceFiscale" + 
				"	AND r.idRuolo=i.idRuolo" + 
				"	AND i.idPuntata=t.idPuntata" + 
				"	AND i.idProgramma=t.idProgramma";
		
		return new DBConnect().getResultOf(value);
	}
}
