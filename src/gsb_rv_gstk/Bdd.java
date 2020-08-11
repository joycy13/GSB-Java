package gsb_rv_gstk;
/**
 * @(#)Bdd.java
 *
 *
 * @author 
 * @version 1.00 2015/03/09
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;


class Bdd
{
	Connection connection;
	String nom; // Nom de la base

	public Bdd()
	{
		 connection = null;
		 nom="gsb_cr_gsk";
			
	}

	// Connexion ï¿½ la base de donnees
	private Connection ouvrir () 
	{
    	try
        {
			// Chargement des drivers SQL
			Class.forName ("org.gjt.mm.mysql.Driver").newInstance();
		}
		catch (ClassNotFoundException a)
		{
			System.out.println ("Driver non trouve");
		}
		catch (Exception b)
		{      
			System.out.println ("Problï¿½me de chargement de driver");			
		}

		try
        {		
			// Etablissement de la connexion avec la base
			connection = DriverManager.getConnection ("jdbc:mysql://localhost:8889/"+nom, "root", "root");
		}
		catch (SQLException c)
		{	
			System.out.println ("Connexion refusee ou base inconnue");
		}
		catch (Exception d)
		{
			System.out.println ("Problï¿½me de connexion");		
		}
		return connection;
	}


	// Fermer la connexion ï¿½ la base
	private void fermer()
	{
		try
		{
			// Fermeture de la connexion
			connection.close();
		}
		catch (Exception d)
		{
			System.out.println ("ProblÃ¨me Ã  la fermeture de la connexion");	
		}
	}
	
	// Obtenir le ResultSet correspondant
	// ï¿½ la requete passï¿½e en paramï¿½tre
	public ResultSet lire(String requete) throws SQLException
	{
		Connection cnx;		
		ResultSet rs  = null;
	
		// Ouverture d'une connexion ï¿½ la base
		cnx = ouvrir();
		
		// Si la connexion ï¿½ rï¿½ussi
		if (cnx!=null)
		{			
			// Crï¿½ation d'un objet de classe Statement permettant
			// de transmettre une requï¿½te ï¿½ la base
			Statement stmt = cnx.createStatement();
								
			// Exï¿½cution de la requete et rï¿½cupï¿½ration 
			// du rï¿½sultat dans un jeu d'enregistrements
			rs = stmt.executeQuery(requete);
		
			// fermeture de la connexion
			// laBdd.fermer();
		}
		return rs;
	}
	

	// Mï¿½thode modif
	// Paramï¿½tre : requï¿½te de modification (Insert, Update ou Delete)
	// Valeur retournï¿½e : 1 si modification effectuï¿½e, 0 sinon
	
	public int modif(String requete) throws SQLException
	{
		Connection cnx;
		int res;
		
		res = 0;		

		// Ouverture d'une connexion ï¿½ la base
		cnx = ouvrir();

		// Si la connexion a rï¿½ussi
		if (cnx!=null)
		{
			// Crï¿½ation d'un objet de classe Statement permettant
			// de transmettre une requï¿½te ï¿½ la base
			Statement stmt = cnx.createStatement();	
		
			// Trace de la requete
			// System.out.println("Requete : "+requete);
			
			// Exï¿½cution de la requete 
			try {
				res = stmt.executeUpdate(requete);
			    }
			catch (Exception e) {
				// Problï¿½mes tels que :
				// - valeur de clï¿½ primaire dï¿½ja existante
			    // System.out.println("Problï¿½me d'exï¿½cution !");
			    //affichage de la pile d'exceptions :
			    // e.printStackTrace();
				}
		
			// fermeture de la connexion
			fermer();
		}		
		return res;	
	}	

	
}