package gsb_rv_gstk;


/*
 * @(#)UsaBdd.java
 *
 *
 * @author 
 * @version 1.00 2012/2/21
 */

// librairie pour utiliser les classes pour la base de données
import java.sql.*;
import java.util.*;


public class PasserelleBdd {	
	// Méthode lireVis
	// Lecture de données dans la table Visiteur
	// Paramètres :
	//   Matricule de l'utilisateur recherché ("" pour la liste complète)
	// Valeur retournée : liste des visiteurs
	 
    /**
     *
     * @param matricule
     * @return
     * @throws SQLException
     */
    	 
	public static ArrayList<Visiteur> lireVis() throws SQLException
	{
		ArrayList<Visiteur> lesV;
		Visiteur unV;	
		String requete;	
		ResultSet rs;
	
		boolean alire;
		
		lesV = new ArrayList<>();

		// Définition de la requête
		requete = "SELECT * FROM visiteur";
		
		// Si un vis_matricule de visiteur est précisé, faire une recherche sur ce numéro
		requete = requete + " order by  vis_matricule ;";
                
		// Lire les données dans la base de données
		Bdd laBdd = new Bdd();		
		rs = laBdd.lire(requete);
				
		// Avancer au premier enregistrement
		alire = rs.next();
		
		// Tant qu'il reste au moins un enregistrement à lire
		while (alire==true)
		{
			// Faire une trace des resultats de la requete SQL				
			// System.out.println("Numero : "+rs.getInt(1));
			// System.out.println("");
			unV = new Visiteur(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getString(9),rs.getInt(10));
			lesV.add(unV);
			// Aller à l'enregistrement suivant
			alire = rs.next();
		}
		// Fermeture du jeu d'enregistrements
		rs.close();
	
		return lesV;
	}
        	
	//****		
	
	// Méthode modifVis
	// Modification de données dans la table Visiteur
	// Paramètres :
	// - Type de la modification : char typeModif
	// 		'A' : ajouter
	//		'M' : modifier
	//		'S' : supprimer	
	// - Visiteur à modifier : Visiteur V
	// Valeur retournée : 1 si modification effectuée, 0 sinon
        
        public static int modifVis(char typeModif, Visiteur V) throws SQLException
	{
		
		String requete = null;
		int res;
		String unNom, unPrenom, uneAdresse, uneVille, uneDate, unSecteur, unLabo;
                int unMatricule, unCP, unRole; 
		
		unMatricule=V.getVis_matricule();
		unNom=V.getVis_nom();
                unPrenom=V.getVis_prenom();
                uneDate=V.getVis_dateembauche();
                uneAdresse=V.getVis_adresse();
                uneVille=V.getVis_ville();
                unCP=V.getVis_cp();
                unSecteur=V.getVis_secteur();
                unLabo=V.getVis_labo();
                unRole=V.getRole();
		
		switch (typeModif)
		{
                    case 'A' : // Ajouter
			requete = "INSERT INTO visiteur(vis_nom, vis_prenom, vis_dateembauche, vis_adresse, vis_ville, vis_CP, vis_secteur, vis_labo,role)"
                                + "VALUES('"+unNom+"','"+unPrenom+"','"+uneDate+"','"+uneAdresse+"','"+uneVille+"',"+unCP+",'"+unSecteur+"','"+unLabo+"','"+unRole+"');";
			break;
			
                    case 'M' : // Modifier
			requete = "UPDATE visiteur SET vis_nom ='" +unNom+ "', vis_prenom='" +unPrenom+ "', vis_dateembauche ='" +uneDate+ "', vis_adresse ='" +uneAdresse+ "', vis_ville='" +uneVille+ "',"
                                + "vis_CP=" +unCP+ ", vis_secteur='" +unSecteur+ "', vis_labo='" +unLabo+ "', role='" +unRole+ "'";
			requete = requete + "WHERE vis_matricule = "+unMatricule+";";	
			break;
			
                    case 'S' : // Supprimer
			requete = "DELETE FROM visiteur WHERE VIS_MATRICULE = "+unMatricule+";";	
			break;
			
                    default : // Erreur
			break;
		}
		
		System.out.println("Requete : "+requete+" ");
		V.afficher();
	
		
		Bdd laBdd = new Bdd();		
		res = laBdd.modif(requete);		
		return res;
	}
        
        public static ArrayList<Visiteur> chercheVis(int matVis) throws SQLException
	{
		ArrayList<Visiteur> lesV;
		Visiteur unV;	
		String requete;	
		ResultSet rs  = null;
	
		boolean alire;
		
		lesV = new ArrayList<>();

		// Définition de la requête
		requete = "SELECT * FROM  visiteur WHERE vis_matricule =" +matVis+";";
		
		// Si un vis_matricule de visiteur est précisé, faire une recherche sur ce numéro
                
		// Lire les données dans la base de données
		Bdd laBdd = new Bdd();		
		rs = laBdd.lire(requete);
				
		// Avancer au premier enregistrement
		alire = rs.next();
		
		// Tant qu'il reste au moins un enregistrement à lire
		if (alire==true)
		{
			// Faire une trace des resultats de la requete SQL				
			// System.out.println("Matricule : "+rs.getInt(1));
			// System.out.println("");
                        
			unV = new Visiteur(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getString(9),rs.getInt(10));
			lesV.add(unV);
		}
		// Fermeture du jeu d'enregistrements
		rs.close();
	
		return lesV;
	}
        
        public static ArrayList<Médicament> lireMed() throws SQLException
	{
		ArrayList<Médicament> lesMed;
		Médicament unMed;	
		String requete;	
		ResultSet rs  = null;
	
		boolean alire;
		
		lesMed = new ArrayList<>();

		// Définition de la requête
		requete = "SELECT * FROM medicament";
		
		// Si un med_depot_legal de médicament est précisé, faire une recherche sur ce numéro
		requete = requete + " order by med_depot_legal;";
                
		// Lire les données dans la base de données
		Bdd laBdd = new Bdd();		
		rs = laBdd.lire(requete);
				
		// Avancer au premier enregistrement
		alire = rs.next();
		
		// Tant qu'il reste au moins un enregistrement à lire
		while (alire==true)
		{
			// Faire une trace des resultats de la requete SQL				
			// System.out.println("Dépot : "+rs.getInt(1));
			// System.out.println("");
                    
                        
			unMed = new Médicament(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getFloat(6), rs.getString(7), rs.getInt(8), rs.getString(9));
			lesMed.add(unMed);
			// Aller à l'enregistrement suivant
			alire = rs.next();
		}
		// Fermeture du jeu d'enregistrements
		rs.close();
	
		return lesMed;
	}
        
        // Méthode modifMed
	// Modification de données dans la table Médicament
	// Paramètres :
	// - Type de la modification : char typeModif
	// 		'A' : ajouter
	//		'M' : modifier
	//		'S' : supprimer	
	// - Médicament à modifier : Médicament M
	// Valeur retournée : 1 si modification effectuée, 0 sinon
        
        public static int modifMed(char typeModif, Médicament M) throws SQLException
	{
		
		String requete = null;
		int res;
		String unNomCom, uneFamille, unEffetT, uneContreI, unTypeMed, uneDateP;
                int unMedDepot, uneQteStock;
                double unPrixE;
		
		unMedDepot=M.getMed_depot_legal();
		unNomCom=M.getNom_commercial();
                uneFamille=M.getFamille();
                unEffetT=M.getEffet_therapetique();
                uneContreI=M.getContre_indication();
                unPrixE=M.getPrix_echantillon();
                unTypeMed=M.getTypemedicament();
                uneQteStock=M.getQte_stock();
                uneDateP=M.getDate_peremption();
		
		switch (typeModif)
		{
                    case 'A' : // Ajouter
			requete = "INSERT INTO medicament(med_depot_legal, nom_commercial, famille, effet_therapetique, contre_indication, prix_echantillon, typemedicament, qte_stock, date_peremption)"
                                + "VALUES('"+unMedDepot+"','"+unNomCom+"','"+uneFamille+"','"+unEffetT+"',"+uneContreI+",'"+unPrixE+"','"+unTypeMed+"','"+uneQteStock+"','"+uneDateP+"');";
			break;
			
                    case 'M' : // Modifier
			requete = "UPDATE medicament SET med_depot_legal ='" +unMedDepot+ "', nom_commercial='" +unNomCom+ "', famille='" +uneFamille+ "', effet_therapetique='" +unEffetT+ "',"
                                + "contre_indication=" +uneContreI+ ", prix_echantillon='" +unPrixE+ "', typemedicament='" +unTypeMed+ "', qte_stock='" +uneQteStock+ "', date_peremption='" +uneDateP+ "'";
			requete = requete + "WHERE med_depot_legal = "+unMedDepot+";";	
			break;
			
                    case 'S' : // Supprimer
			requete = "DELETE FROM medicament WHERE med_depot_legal= "+unMedDepot+";";	
			break;
			
                    default : // Erreur
			break;
		}
		
		System.out.println("Requete : "+requete+" ");
		M.afficher();
	
		
		Bdd laBdd = new Bdd();		
		res = laBdd.modif(requete);		
		return res;
	}
        
        public static ArrayList<Médicament> chercheMed(int depMed) throws SQLException
	{
		ArrayList<Médicament> lesM;
		Médicament unM;	
		String requete;	
		ResultSet rs  = null;
	
		boolean alire;
		
		lesM = new ArrayList<>();

		// Définition de la requête
		requete = "SELECT * FROM  medicament WHERE med_depot_legal =" +depMed+";";
		System.out.println(requete);
		// Si un med_depot_legal de médicament est précisé, faire une recherche sur ce numéro
                
		// Lire les données dans la base de données
		Bdd laBdd = new Bdd();		
		rs = laBdd.lire(requete);
				
		// Avancer au premier enregistrement
		alire = rs.next();
		
		// Tant qu'il reste au moins un enregistrement à lire
		if (alire==true)
		{
			// Faire une trace des resultats de la requete SQL				
			// System.out.println("Dépot : "+rs.getInt(1));
			// System.out.println("");
                        
			unM = new Médicament(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getFloat(6), rs.getString(7), rs.getInt(8), rs.getString(9));
			lesM.add(unM);
		}
		// Fermeture du jeu d'enregistrements
		rs.close();
	
		return lesM;
	}
        
        public static ArrayList<Praticien> lirePrat() throws SQLException
	{
		ArrayList<Praticien> lesPra;
		Praticien unPra;	
		String requete;	
		ResultSet rs  = null;
                
		boolean alire;
		
		lesPra = new ArrayList<>();

		// Définition de la requête
		requete = "SELECT * FROM praticien";
		
		// Si un pra_code de praticien est précisé, faire une recherche sur ce numéro
		requete = requete + " order by pra_code;";
                
		// Lire les données dans la base de données
		Bdd laBdd = new Bdd();		
		rs = laBdd.lire(requete);
				
		// Avancer au premier enregistrement
		alire = rs.next();
		
		// Tant qu'il reste au moins un enregistrement à lire
		while (alire==true)
		{
			// Faire une trace des resultats de la requete SQL				
			// System.out.println("Code : "+rs.getInt(1));
			// System.out.println("");
                        
                    
                        // unType = new Type_praticien(0,rs.getString(8));
                    
			unPra = new Praticien(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7), rs.getString(8));
			lesPra.add(unPra);
			// Aller à l'enregistrement suivant
			alire = rs.next();
		}
		// Fermeture du jeu d'enregistrements
		rs.close();
	
		return lesPra;
	}
        
        // Méthode modifPrat
	// Modification de données dans la table Praticien
	// Paramètres :
	// - Type de la modification : char typeModif
	// 		'A' : ajouter
	//		'M' : modifier
	//		'S' : supprimer	
	// - Praticien à modifier : Praticien P
	// Valeur retournée : 1 si modification effectuée, 0 sinon

	public static int modifPrat(char typeModif, Praticien P) throws SQLException
	{
		
		String requete = null;
		int res;
		String unNom, unPrenom, uneAdresse, uneVille, uneDate, unSecteur, unLabo, unTypeP;
                int unCode, unCP, unNumTel;
		
		unCode=P.getPra_code();
		unNom=P.getNom();
                unPrenom=P.getPrenom();
                uneAdresse=P.getAdresse();
                uneVille=P.getVille();
                unCP=P.getCode_postal();
                unNumTel=P.getNumero_tel();
                unTypeP=P.getType_praticien();
		
		switch (typeModif)
		{
                    case 'A' : // Ajouter
			requete = "INSERT INTO praticien(pra_code, nom, prenom, adresse, ville, code_postal, numero_tel, type_praticien)"
                                + "VALUES('"+unCode+"','"+unNom+"','"+unPrenom+"','"+uneAdresse+"','"+uneVille+"',"+unCP+",'"+unNumTel+"','"+unTypeP+"');";
			break;
			
                    case 'M' : // Modifier
			requete = "UPDATE praticien SET pra_code='"+unCode+"', nom ='" +unNom+ "', prenom='" +unPrenom+ "', adresse ='" +uneAdresse+ "'ville='" +uneVille+ "',"
                                + "code_postal=" +unCP+ ", numero_tel='" +unNumTel+ "', type_praticien='" +unTypeP+ "'";
			requete = requete + "WHERE pra_code = "+unCode+";";	
			break;
			
                    case 'S' : // Supprimer
			requete = "DELETE FROM praticien WHERE pra_code = "+unCode+";";	
			break;
			
                    default : // Erreur
			break;
		}
		
		System.out.println("Requete : "+requete+" ");
		P.afficher();
	
		
		Bdd laBdd = new Bdd();		
		res = laBdd.modif(requete);		
		return res;
	}
        
        public static ArrayList<Praticien> cherchePrat(int CodePra) throws SQLException
	{
		ArrayList<Praticien> lesPra;
		Praticien unPra;	
		String requete;	
		ResultSet rs  = null;
	
		boolean alire;
		
		lesPra = new ArrayList<>();

		// Définition de la requête
		requete = "SELECT * FROM  praticien WHERE pra_code =" +CodePra+";";
		
		// Si un pra_code de praticien est précisé, faire une recherche sur ce numéro
                
		// Lire les données dans la base de données
		Bdd laBdd = new Bdd();		
		rs = laBdd.lire(requete);
				
		// Avancer au premier enregistrement
		alire = rs.next();
		
		// Tant qu'il reste au moins un enregistrement à lire
		if (alire==true)
		{
			// Faire une trace des resultats de la requete SQL				
                        // System.out.println("Code : "+rs.getInt(1));
			// System.out.println("");
                        
			unPra = new Praticien(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7), rs.getString(8));
			lesPra.add(unPra);
		}
		// Fermeture du jeu d'enregistrements
		rs.close();
	
		return lesPra;
	}
        
        public static ArrayList<RapportVisite> lireRap() throws SQLException
	{
		ArrayList<RapportVisite> lesRap;
		RapportVisite unRap;	
                // ArrayList<Praticien> lesPra;
		// Praticien unPra;
                // ArrayList<Visiteur> lesV;
		// Visiteur unV;
		String requete;	
		ResultSet rs  = null;
                
                // Praticien pra_code;
                // pra_code=new Praticien();
                // Visiteur vis_matricule;
                // vis_matricule=new Visiteur();
	
		boolean alire;
		
		lesRap = new ArrayList<>();

		// Définition de la requête
		requete = "SELECT * FROM rapport_visite"; 
		
		// Si un rap_num de rapport de visite est précisé, faire une recherche sur ce numéro				
		requete = requete + " order by rap_date;";
                
		// Lire les données dans la base de données
		Bdd laBdd = new Bdd();		
		rs = laBdd.lire(requete);
				
		// Avancer au premier enregistrement
		alire = rs.next();
		
		// Tant qu'il reste au moins un enregistrement à lire
		while (alire==true)
		{
			// Faire une trace des resultats de la requete SQL				
			// System.out.println("Numero : "+rs.getInt(1));
			// System.out.println("");
                    
                        
                        
			unRap = new RapportVisite(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getInt(8));
			lesRap.add(unRap);
			// Aller à l'enregistrement suivant
			alire = rs.next();
		}
		// Fermeture du jeu d'enregistrements
		rs.close();
	
		return lesRap;
	}
        
        // Méthode modifRap
	// Modification de données dans la table Praticien
	// Paramètres :
	// - Type de la modification : char typeModif
	// 		'A' : ajouter
	//		'M' : modifier
	//		'S' : supprimer	
	// - Rapport de visite à modifier : RapportVisite R
	// Valeur retournée : 1 si modification effectuée, 0 sinon
        
        public static int modifRap(char typeModif, RapportVisite R) throws SQLException
	{
		
		String requete = null;
		String unRap_date,unRap_bilan,unRap_motif, unMed_offert;
                int unRap_num, unPra_code,unVis_matricule, unNb_offert, res;
                RapportVisite unRapportVisite;
                Visiteur unVisiteur;
                Praticien unPraticien;
		
                unRap_num=R.getRap_num();
		unRap_date=R.getRap_date();
		unRap_bilan=R.getRap_bilan();
                unRap_motif=R.getRap_motif();
                unVis_matricule=R.getVis_matricule();
                unPra_code=R.getPra_code();
                unMed_offert=R.getMedicament_offert();
                unNb_offert=R.getNombre_echantillon_offert();
                
                // unVis_matricule = unVisiteur.getVis_matricule();
                // unPra_code = unPraticien.getPra_code();
                
		switch (typeModif)
		{
                    case 'A' : // Ajouter
			requete = "INSERT INTO rapport_visite(rap_num, rap_date, rap_bilan, rap_motif, vis_matricule, pra_code, medicament_offert, nombre_echantillon_offert)"
                                + "VALUES('"+unRap_num+"','"+unRap_date+"','"+unRap_bilan+"','"+unRap_motif+"',"+unPra_code+","+unVis_matricule+","+unMed_offert+","+unNb_offert+");";
			break;
                        
                    case 'M' : // Modifier
			requete = "UPDATE rapport_visite SET rap_num='"+unRap_num+"', rap_date ='" +unRap_date+ "', rap_bilan='" +unRap_bilan+ "', rap_motif ='" +unRap_motif+ "', pra_code='" +unPra_code+ "', vis_matricule='" +unVis_matricule+ "'";
			requete = requete + "WHERE rap_num = "+unRap_num+";";	
			break;
			
                    case 'S' : // Supprimer
			requete = "DELETE FROM rapport_visite WHERE rap_num = "+unRap_num+";";	
			break;	
                        
                    default : // Erreur
			break;
		}
		
		System.out.println("Requete : "+requete+" ");
		R.afficher();
	
		
		Bdd laBdd = new Bdd();		
		res = laBdd.modif(requete);		
		return res;
	}

        public static ArrayList<RapportVisite> chercheRap(int numRap) throws SQLException
	{
		ArrayList<RapportVisite> lesRap;
		RapportVisite unRap;	
		String requete;	
		ResultSet rs  = null;
	
		boolean alire;
		
		lesRap = new ArrayList<>();

		// Définition de la requête
		requete = "SELECT * FROM  rapport_visite WHERE rap_num =" +numRap+";";
		
		// Si un rap_num de rapport de visite est précisé, faire une recherche sur ce numéro
                
		// Lire les données dans la base de données
		Bdd laBdd = new Bdd();		
		rs = laBdd.lire(requete);
				
		// Avancer au premier enregistrement
		alire = rs.next();
		
		// Tant qu'il reste au moins un enregistrement à lire
		if (alire==true)
		{
			// Faire une trace des resultats de la requete SQL				
			// System.out.println("Numero : "+rs.getInt(1));
			// System.out.println("");
                        
			unRap = new  RapportVisite(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getInt(8));
			lesRap.add(unRap);
		}
		// Fermeture du jeu d'enregistrements
		rs.close();
	
		return lesRap;
	}
        
        public static ArrayList<Enumerer> lireEnum() throws SQLException
	{
		ArrayList<Enumerer> lesE;
		Enumerer uneEnum;	
		String requete;	
		ResultSet rs  = null;
                
                RapportVisite unRap;
                Médicament unMed;
	
		boolean alire;
		
		lesE = new ArrayList<>();

		// Définition de la requête
		requete = "SELECT *  FROM enumerer";
		
		// Si une off_qte de enumerer est précisé, faire une recherche sur ce numéro
		
                System.out.println(requete);
		// Lire les données dans la base de données
		Bdd laBdd = new Bdd();		
		rs = laBdd.lire(requete);
				
		// Avancer au premier enregistrement
		alire = rs.next();
		
		// Tant qu'il reste au moins un enregistrement à lire
		while (alire==true)
		{
                    
                    unMed=new Médicament(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getFloat(6), rs.getString(7), rs.getInt(8), rs.getString(9));
                    
                    unRap=new RapportVisite(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getInt(8));
                    
			// Faire une trace des resultats de la requete SQL				
			// System.out.println("Quantité offert : "+rs.getInt(3));
			// System.out.println("");
			uneEnum = new Enumerer(rs.getInt(1),rs.getInt(2), rs.getInt(3));
			lesE.add(uneEnum);
			// Aller à l'enregistrement suivant
			alire = rs.next();
		}
		// Fermeture du jeu d'enregistrements
		rs.close();
	
		return lesE;
	}
        
        // Méthode modifEnum
	// Modification de données dans la table Enumerer
	// Paramètres :
	// - Type de la modification : char typeModif
	// 		'A' : ajouter
	//		'M' : modifier
	//		'S' : supprimer	
	// - Enumeration à modifier : Enumerer E
	// Valeur retournée : 1 si modification effectuée, 0 sinon
        
        public static int modifEnum(char typeModif, Enumerer E) throws SQLException
	{
		
		String requete = null;
                int unMedDepot, unRapNum, uneQteOff;
                int res;
                ArrayList<Enumerer> lesE;
                Enumerer uneEnum;
                // Médicament unMédicament;
                // Visiteur unVisiteur;
                // Praticien unPraticien;
                // RapportVisite unRapportVisite;
                
                unMedDepot=E.getMed_depot_legal();
                unRapNum=E.getRap_num();
                uneQteOff=E.getOff_qte(); 
                // unMédicament = E.getMed_depot_legal();
		// med_depot_legal = uneEnum.getMed_depot_legal();
                
                // unRapportVisite = E.getRap_num();
		// rap_num = uneEnum.getRap_num();
                        
                // off_qte=E.getOff_qte();
                
		switch (typeModif)
		{
                    case 'A' : // Ajouter
			requete = "INSERT INTO enumerer(med_depot_legal, rap_num, off_qte)"
                                + "VALUES("+unMedDepot+","+unRapNum+","+uneQteOff+");";
			break;
                        
                    case 'M' : // Modifier
			requete = "UPDATE enumerer SET med_depot_legal='"+unMedDepot+"', rap_num ='" +unRapNum+ "', off_qte='" +uneQteOff+ "'";
			requete = requete + "WHERE off_qte = "+uneQteOff+";";	
			break;
			
                    case 'S' : // Supprimer
			requete = "DELETE FROM enumerer WHERE off_qte = "+uneQteOff+";";	
			break;
			
                    default : // Erreur
			break;              
		}
		
		System.out.println("Requete : "+requete+" ");
	
		
		Bdd laBdd = new Bdd();		
		res = laBdd.modif(requete);		
		return res;
	}
        
        public static ArrayList<Enumerer> chercheEnum(int QteOff) throws SQLException
	{
		ArrayList<Enumerer> lesEnum;
		Enumerer uneEnum;	
		String requete;	
		ResultSet rs  = null;
	
		boolean alire;
		
		lesEnum = new ArrayList<>();

		// Définition de la requête
		requete = "SELECT * FROM  enumerer WHERE off_qte =" +QteOff+";";
		
		// Si un off_qte de enumerer est précisé, faire une recherche sur ce numéro
                
		// Lire les données dans la base de données
		Bdd laBdd = new Bdd();		
		rs = laBdd.lire(requete);
				
		// Avancer au premier enregistrement
		alire = rs.next();
		
		// Tant qu'il reste au moins un enregistrement à lire
		if (alire==true)
		{
			// Faire une trace des resultats de la requete SQL				
			// System.out.println("Quantité offerte : "+rs.getInt(3));
			// System.out.println("");
                        
			uneEnum = new Enumerer(rs.getInt(1),rs.getInt(2), rs.getInt(3));
			lesEnum.add(uneEnum);
		}
		// Fermeture du jeu d'enregistrements
		rs.close();
	
		return lesEnum;
	}
         
}

	
	
	