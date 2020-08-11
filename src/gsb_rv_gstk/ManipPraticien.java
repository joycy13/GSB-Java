package gsb_rv_gstk;
import java.util.*;
import java.util.regex.Pattern;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sio2
 */
public class ManipPraticien 
{
    static public void lister()  throws Exception 
    {
        // Variables
 	int  i;
	String unNom, unPrenom, uneAdresse, uneVille, unType;
        int unCode, unCP, unNumTel; 
	Praticien unPraticien;
	ArrayList<Praticien> lesPraticien;
	String ligneAffiche;
        
        // Début
	i=0;
	lesPraticien = PasserelleBdd.lirePrat();
        System.out.println(lesPraticien);
	System.out.println();
	ligneAffiche = String.format("|%-10s|%-10s|%-10s|%-34s|%-17s|%-6s|%-16s|%-16s|","Code", "Nom", "Prenom", "Adresse", "Ville", "CP", "Numero téléphone", "Type");
	System.out.println(ligneAffiche);

	ligneAffiche = String.format("|%-10s|%-10s|%-10s|%-34s|%-17s|%-6s|%-16s|%-16s|","----------", "----------", "----------" ,"----------------------------------", "-----------------", "------" ,"----------------", "----------------");
	System.out.println(ligneAffiche);

	while (i<lesPraticien.size()) {
            unPraticien = lesPraticien.get(i);

            unCode = unPraticien.getPra_code();
            unNom = unPraticien.getNom();
            unPrenom = unPraticien.getPrenom();
            uneAdresse = unPraticien.getAdresse();
            uneVille = unPraticien.getVille();
            unCP = unPraticien.getCode_postal();
            unNumTel = unPraticien.getNumero_tel();
            unType = unPraticien.getType_praticien();
            ligneAffiche = String.format("|%-10s|%-10s|%-10s|%-34s|%-17s|%-6s|%-16s|%-16s|",unCode, unNom, unPrenom, uneAdresse, uneVille, unCP, unNumTel, unType);
            System.out.println(ligneAffiche);
            i=i+1;
	} // Fin while
        
	if (i==0) {
            System.out.println("Aucun praticien");
	} // Fin if
        
    } // Fin lister
    
    static public void ajouter() throws Exception 
    {
        // Variables
	int nb;
	String unNom, unPrenom, uneAdresse, uneVille, uneDate, unSecteur, unLabo, unType;
        int unCode, unCP, unNumTel;
	Praticien unPraticien;
	ArrayList<Praticien> lesPraticien;
        Boolean c;
        
	// Saisie des informations
        System.out.println("Saisir code :");
	unCode = Cons.saisirEntier();
	System.out.println("Saisir nom :");
	unNom = Cons.saisirChaine();
	System.out.println("Saisir prenom :");
	unPrenom = Cons.saisirChaine();
        System.out.println("Saisir une adresse :");
	uneAdresse = Cons.saisirChaine();
	System.out.println("Saisir ville :");
	uneVille = Cons.saisirChaine();
        System.out.println("Saisir code postale :");
        unCP = Cons.saisirEntier();
	System.out.println("Saisir numero de telephone :");
        unNumTel = Cons.saisirEntier();      
        System.out.println("Saisir type praticien :");
	unType = Cons.saisirChaine();
		
	unPraticien = new Praticien(unCode, unNom, unPrenom, uneAdresse, uneVille, unCP, unNumTel, unType);
	nb = PasserelleBdd.modifPrat('A',unPraticien);
	if (nb==1)
	{
            System.out.println("Ajout bien effectué ");
	}
	else
	{
            System.out.println("Echec de l'ajout ! ");
	}
        
    } // Fin ajouter
    
    static public void rechercher() throws Exception {
	int leCode;
	ArrayList<Praticien> lesPraticien;
        
        // Début
	System.out.print("\nCode du praticien recherché : ");
	leCode = Cons.saisirEntier();
	lesPraticien = PasserelleBdd.cherchePrat(leCode);
	
	// S'il y'a un résultat
	if (lesPraticien.size()>0)
	{
	    System.out.println("Le praticien recherché est : ");
	    lesPraticien.get(0).afficher();
	}	
	// Sinon, le praticien n'a pas été trouvé
	else
	{
            System.out.println("Praticien inconnu !");
	}

    } // Fin de rechercher
    
    static public void modifier() throws Exception 
    {
        // Variables
	boolean trouve = false;
	String unNom, unPrenom, uneAdresse, uneVille, unTypeP;
        int unCode, unCP, unNumTel;
        int nb;
	Praticien unPraticien;
	ArrayList<Praticien> lesPraticien;
        
        // Début
	System.out.print("\nCode du praticien à modifier : ");
	unCode = Cons.saisirEntier();

        // Rechercher et afficher le praticien correspondant pour demander confirmation
	lesPraticien = PasserelleBdd.lirePrat();
	
	// S'il y'a un résultat
	if (lesPraticien.size()>0)
	{
            unPraticien = lesPraticien.get(0);
	    System.out.println("Le praticien à modifier est : ");
	    unPraticien.afficher();
	    
            System.out.print("Nouveau nom   :");
            unNom = Cons.saisirChaine();
            unPraticien.setNom(unNom);
            System.out.print("Nouveau prénom   :");
            unPrenom = Cons.saisirChaine();
            unPraticien.setPrenom(unPrenom);
            System.out.print("Nouvelle adresse   :");
            uneAdresse = Cons.saisirChaine();
            unPraticien.setAdresse(uneAdresse);
            System.out.print("Nouvelle ville   :");
            uneVille = Cons.saisirChaine();
            unPraticien.setVille(uneVille);
            System.out.print("Nouveau code postal   :");
            unCP = Cons.saisirEntier();
            unPraticien.setCode_postal(unCP);
            System.out.print("Nouveau numero de telephone   :");
            unNumTel = Cons.saisirEntier();
            unPraticien.setNumero_tel(unNumTel);
            System.out.print("Nouveau type   :");
            unTypeP = Cons.saisirChaine();
            unPraticien.setType_praticien(unTypeP);
            
            // Modifier le praticien
            nb = PasserelleBdd.modifPrat('M',unPraticien);
            if (nb==1)
            {
                System.out.println("Modification bien effectuée ");
            }
            else
            {
		System.out.println("Echec de la modification ! ");
            }     	          	    	    
	}
        
            // Sinon, le praticien n'a pas été trouvé
            else
            {
		System.out.println("Praticien inconnu !");
            }
		
    } // Fin de modifier
    
    
 
 static public void supprimer() throws Exception {
	int nb;
	int unCode;
	String reponse;
	char choix;
	ArrayList<Praticien> lesPraticien;
        Praticien unPraticien;
        
        // Début
	System.out.print("\nMatricule de praticien a supprimer : ");
	unCode = Cons.saisirEntier();
	
        // Rechercher et afficher le praticien correspondant pour demander confirmation
	lesPraticien = PasserelleBdd.lirePrat();
	
	// S'il y'a un résultat
	while (lesPraticien.isEmpty())
	{
            System.out.println("Aucun praticien ne correspond au code "+unCode+".");
            System.out.print("\nCode de praticien a supprimer : ");
            unCode = Cons.saisirEntier();
            lesPraticien = PasserelleBdd.lirePrat();
        }
        
        unPraticien = lesPraticien.get(0);
        System.out.println("Le praticien à supprimer est : ");
        unPraticien.afficher();

	System.out.print("Voulez vous réellement supprimer ce praticien (o/n) ? : ");
    	reponse = Cons.saisirChaine();
    	choix=reponse.charAt(0);
        if (choix=='o')
        {
        // Supprimer le praticien
            nb = PasserelleBdd.modifPrat('S',unPraticien);
            if (nb==1)
            {
                System.out.println("Suppression bien effectuée ");
            }
            else
            {
                System.out.println("Echec de la suppression ! ");
            }     
        }
        
        // Sinon, le praticien n'a pas été trouvé
        else
        {
          System.out.println("Suppression non effectuée ! ");
        }	    	    	    	
	
    } // Fin de supprimer
    
} // Fin classe