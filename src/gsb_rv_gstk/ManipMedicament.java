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

public class ManipMedicament 
{

    static public void lister() throws Exception 
    {
        // Variables
        int i;
        String unNomCom, uneFamille, unEffetT, uneContreI, unTypeMed, uneDateP;
        int unMedDepot, uneQteStock;
        float unPrixE;
        Médicament unMédicament;
        ArrayList<Médicament> lesMédicament;
        String ligneAffiche;

		// Début
        i=0;
        lesMédicament = PasserelleBdd.lireMed();
        System.out.println(lesMédicament);
        System.out.println();
		ligneAffiche = String.format("|%-7s|%-18s|%-35s|%-25s|%-30s|%-16s|%-15s|%-8s|%-16s|","Dépot", "Nom", "Famille", "Effets thérapeutiques", "Contre indication", "Prix échantillon", "Type", "Quantité", "Date peremption");
		System.out.println(ligneAffiche);
		ligneAffiche = String.format("|%-7s|%-18s|%-35s|%-25s|%-30s|%-16s|%-15s|%-8s|%-16s|","-------", "------------------", "-----------------------------------" ,"-------------------------", "------------------------------", "----------------" ,"---------------", "--------", "----------------");
		System.out.println(ligneAffiche);

		while (i<lesMédicament.size()) 
        {
            unMédicament = lesMédicament.get(i);
            unMedDepot = unMédicament.getMed_depot_legal();
            unNomCom = unMédicament.getNom_commercial();
            uneFamille = unMédicament.getFamille();
            unEffetT = unMédicament.getEffet_therapetique();
            uneContreI = unMédicament.getContre_indication();
            unPrixE = unMédicament.getPrix_echantillon();
            unTypeMed = unMédicament.getTypemedicament();
            uneQteStock = unMédicament.getQte_stock();
            uneDateP = unMédicament.getDate_peremption();
            ligneAffiche = String.format("|%-7s|%-18s|%-35s|%-25s|%-30s|%-16s|%-15s|%-8s|%-16s|",unMedDepot, unNomCom, uneFamille, unEffetT, uneContreI, unPrixE, unTypeMed, uneQteStock, uneDateP);
            System.out.println(ligneAffiche);
            i=i+1;

		} //Fin while

		if (i==0) 
		{
            System.out.println("Aucun médicament");
        } // Fin if

    } // Fin lister


	static public void ajouter() throws Exception 
    {
        // Variables
        int nb;
        String unNomCom, uneFamille, unEffetT, uneContreI, unTypeMed, uneDateP;
        int unMedDepot, uneQteStock;
        float unPrixE;
        Médicament unMédicament;
        ArrayList<Médicament> lesMédicament;
        String ligneAffiche;
        Boolean c;
        
        // Début
        // Saisie des informations
	System.out.println("Saisir un dépot :");
        unMedDepot = Cons.saisirEntier();
        System.out.println("Saisir un nom commercial :");
        unNomCom = Cons.saisirChaine();
        System.out.println("Saisir une famille :");
        uneFamille = Cons.saisirChaine();
        System.out.println("Saisir un effet thérapeutique :");
        unEffetT = Cons.saisirChaine();
        System.out.println("Saisir une contre indication :");
        uneContreI = Cons.saisirChaine();
        System.out.println("Saisir un prix echantillon :");
        unPrixE = Cons.saisirReel();
        System.out.println("Saisir un type de médicament :");
        unTypeMed = Cons.saisirChaine();
        System.out.println("Saisir dépot :");
        uneQteStock = Cons.saisirEntier();
        System.out.println("Saisir date de peremption :");
        System.out.println("(aaaa-mm-jj)");
        uneDateP = Cons.saisirChaine();
        c = Pattern.matches("[1-9][0-9][0-9][0-9][-][0-1][0-9][-][0-3][0-9]",uneDateP);

        while (c == false)
        {
            System.out.println("La date n'est pas au bon format,");
            System.out.println("il faut respecter le format aaaa-mm-jj");
            uneDateP = Cons.saisirChaine();
            c = Pattern.matches("[1-9][0-9][0-9][0-9][-][0-1][0-9][-][0-3][0-9]",uneDateP);

        }
        unMédicament = new Médicament(unMedDepot, unNomCom, uneFamille, unEffetT, uneContreI, unPrixE, unTypeMed, uneQteStock, uneDateP);
        nb = PasserelleBdd.modifMed('A',unMédicament);

        if (nb==1)
        {
            System.out.println("Ajout bien effectué ");
        }

        else
        {
            System.out.println("Echec de l'ajout ! ");
        }

    } // Fin ajouter

	static public void rechercher() throws Exception 
    {
        // Variables
        int leMedD;
        ArrayList<Médicament> lesMédicament;
        
        // Début
        System.out.print("\nDépot du médicament recherché : ");
        leMedD = Cons.saisirEntier();
        lesMédicament = PasserelleBdd.chercheMed(leMedD);

        // S'il y'a un résultat
        if (lesMédicament.size()>0)
        {
            System.out.println("Le médicament recherché est : ");
            lesMédicament.get(0).afficher();
        }

        // Sinon, le médicament n'a pas été trouvé
        else
        {
            System.out.println("Médicament inconnu !");
        }

    } // Fin rechercher

	static public void modifier() throws Exception 
    {
        // Variables
        boolean trouve = false;
        String unNomCom, uneFamille, unEffetT, uneContreI, unTypeMed, uneDateP;
        int unMedDepot, uneQteStock;
        float unPrixE;
        Médicament unMédicament;
        ArrayList<Médicament> lesMédicament = null;
        
        // Début
        System.out.print("\nDépot du médicament à modifier : ");
            unMedDepot = Cons.saisirEntier();

        // Rechercher et afficher le médicament correspondant pour demander confirmation
        lesMédicament = PasserelleBdd.lireMed();

        // S'il y'a un résultat
        if (lesMédicament.size()>0)
        {
            unMédicament = lesMédicament.get(0);
            System.out.println("Le médicament à modifier est : ");
            unMédicament.afficher();
            System.out.print("Nouveau nom :");
            unNomCom = Cons.saisirChaine();
            unMédicament.setNom_commercial(unNomCom);
            System.out.println("Nouvelle famille :");
            uneFamille = Cons.saisirChaine();
            unMédicament.setFamille(uneFamille);
            System.out.println("Nouvel effet thérapeutique :");
            unEffetT = Cons.saisirChaine();
            unMédicament.setEffet_therapetique(unEffetT);
            System.out.println("Nouvelle contre indication :");
            uneContreI = Cons.saisirChaine();
            unMédicament.setContre_indication(uneContreI);
            System.out.println("Nouveau prix echantillon :");
            unPrixE = Cons.saisirReel();
            unMédicament.setPrix_echantillon(unPrixE);
            System.out.println("Nouveau type de médicament :");
            unTypeMed = Cons.saisirChaine();
            unMédicament.setTypemedicament(unTypeMed);
            System.out.println("Nouveau dépot :");
            uneQteStock = Cons.saisirEntier();
            unMédicament.setQte_stock(uneQteStock);
            System.out.println("Nouvelle date de peremption :");
            uneDateP = Cons.saisirChaine();
            unMédicament.setDate_peremption(uneDateP);

        // Modifier le médicament
        int nb = PasserelleBdd.modifMed('M',unMédicament);

            if (nb==1)
            {
                System.out.println("Modification bien effectuée ");
            }

            else
            {
                System.out.println("Echec de la modification ! ");
            }

        }

        // Sinon, le médicament n'a pas été trouvé
        else
        {
            System.out.println("Médicament inconnu !");
        }
    } // Fin de modifier

	static public void supprimer() throws Exception 
    {
        // Variables
        int nb;
        int unMedDepot;
        String reponse;
        char choix;
        ArrayList<Médicament> lesMédicament;
        Médicament unMédicament;

        // Début
        System.out.print("\nDepot de medicament a supprimer : ");
        unMedDepot = Cons.saisirEntier();

        // Rechercher et afficher le médicament correspondant pour demander confirmation
        lesMédicament = PasserelleBdd.lireMed();

        // S'il y'a un résultat
        while (lesMédicament.isEmpty())
        {
            System.out.println("Aucun médicament ne correspond au matricule "+unMedDepot+".");
            System.out.print("\nDepot de médicament a supprimer : ");
            unMedDepot = Cons.saisirEntier();
            lesMédicament = PasserelleBdd.lireMed();
        }

        unMédicament = lesMédicament.get(0);
        System.out.println("Le médicament à supprimer est : ");
        unMédicament.afficher();
        System.out.print("Voulez vous réellement supprimer ce Médicament (o/n) ? : ");
        reponse = Cons.saisirChaine();
        choix=reponse.charAt(0);

        if (choix=='o')
        {

        // Supprimer le médicament
        nb = PasserelleBdd.modifMed('S',unMédicament);

            if (nb==1)
            {
                System.out.println("Suppression bien effectuée ");
            }

            else
            {
                System.out.println("Echec de la suppression ! ");
            }
        }
    
        // Sinon, le médicament n'a pas été trouvé
        else
        {
            System.out.println("Suppression non effectuée ! ");
        }

    } // Fin de supprimer

} // Fin classe