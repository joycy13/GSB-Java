
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

public class ManipEnumerer 
{

    static public void lister() throws Exception 
    {
        // Variables
        int i;
        int unMedDepot, unRapNum, uneQteOff;
        Enumerer uneEnum;
        ArrayList<Enumerer> lesEnum;
        String ligneAffiche;
        
        // Début
        i=0;
        lesEnum = PasserelleBdd.lireEnum();
        System.out.println();
        ligneAffiche = String.format("|%-10s|%-10s|%-10s|","Medicament", "Numero rapport", "Quantité offerte");
        System.out.println(ligneAffiche);
        ligneAffiche = String.format("|%-10s|%-10s|%-10s|","----------", "----------", "----------" );
        System.out.println(ligneAffiche);
        
        while (i<lesEnum.size()) 
        {
            uneEnum = lesEnum.get(i); //erreur .get(i)
            unMedDepot = uneEnum.getMed_depot_legal();
            unRapNum = uneEnum.getRap_num();
            uneQteOff = uneEnum.getOff_qte();
            ligneAffiche = String.format("|%-10s|%-10s|%-10s|",unMedDepot, unRapNum, uneQteOff);
            System.out.println(ligneAffiche);
            i=i+1;
        } // Fin while

        if (i==0) 
        {
            System.out.println("Inexistant");
        } // Fin if

    } // Fin lister

    static public void ajouter() throws Exception 
    {
        // Variables
        int nb;
        int unMedDepot, unRapNum, uneQteOff;
        Enumerer uneEnum;
        ArrayList<Enumerer> lesEnum;
        Boolean c;
        
        // Début
        // Saisie des informations
        System.out.println("Saisir médicament :");
        unMedDepot = Cons.saisirEntier();
        System.out.println("Saisir numéro de rapport :");
        unRapNum = Cons.saisirEntier();
        System.out.println("Saisir quantité offerte :");
        uneQteOff = Cons.saisirEntier();
        uneEnum = new Enumerer(unMedDepot, unRapNum, uneQteOff);
        nb = PasserelleBdd.modifEnum('A',uneEnum);
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
        int laQteOff;
        ArrayList<Enumerer> lesEnum;
        
        // Début
        System.out.print("\nQuantité offerte recherchée : ");
        laQteOff = Cons.saisirEntier();
        lesEnum = PasserelleBdd.chercheEnum(laQteOff);

        // S'il y a un résultat
        if (lesEnum.size()>0)
        {
            System.out.println("La quantité recherchée est : ");
            lesEnum.get(0).afficher();
        }

        // Sinon, la quantité n'a pas été trouvé
        else
        {
            System.out.println("Quantité inconnue !");
        }

    } // Fin de rechercher

    static public void modifier() throws Exception 
    {
        // Variables
        boolean trouve = false;
        boolean c;
        int nb;
        int unMedDepot, unRapNum, uneQteOff;
        Enumerer uneEnum;
        ArrayList<Enumerer> lesEnum;
        
        // Début
        System.out.print("\nQuantité offerte à modifier : ");
        uneQteOff = Cons.saisirEntier();

        // Rechercher et afficher la quantité correspondante pour demander confirmation
        lesEnum = PasserelleBdd.lireEnum();

        // S'il y'a un résultat
        if (lesEnum.size()>0)
        {
            uneEnum = lesEnum.get(0);
            System.out.println("La quantité à modifier est : ");
            uneEnum.afficher();
            System.out.println("Nouveau médicament :");
            unMedDepot = Cons.saisirEntier();
            uneEnum.setMed_depot_legal(unMedDepot);
            System.out.println("Nouveau numéro :");
            unRapNum = Cons.saisirEntier();
            uneEnum.setRap_num(unRapNum);
            System.out.println("Nouveau quantité :");
            uneQteOff = Cons.saisirEntier();
            uneEnum.setOff_qte(uneQteOff);
            
            // Modifier la quantité
            nb = PasserelleBdd.modifEnum('M',uneEnum);
            if (nb==1)
            {
                System.out.println("Modification bien effectuée ");
            }
            else
            {
                System.out.println("Echec de la modification ! ");
            }

        }

        // Sinon, la quantité n'a pas été trouvée
        else
        {
            System.out.println("Quantité inconnue !");
        }

    } // Fin de modifier

    static public void supprimer() throws Exception 
    {
        // Variables
        int nb;
        int uneQteOff;
        String reponse;
        char choix;
        Enumerer uneEnum;
        ArrayList<Enumerer> lesEnum;
        
        // Début
        System.out.print("\nQuantité a supprimer : ");
        uneQteOff = Cons.saisirEntier();

        // Rechercher et afficher la quantité correspondante pour demander confirmation
        lesEnum = PasserelleBdd.lireEnum();

        // S'il y'a un résultat
        while (lesEnum.isEmpty())
        {
            System.out.println("Aucune quantité ne correspond à la quantité "+uneQteOff+".");
            System.out.print("\nQuantité a supprimer : ");
            uneQteOff = Cons.saisirEntier();
            lesEnum = PasserelleBdd.lireEnum();
        }
        uneEnum = lesEnum.get(0);
        System.out.println("La quantité à supprimer est : ");
        uneEnum.afficher();
        System.out.print("Voulez vous réellement supprimer cette quantité (o/n) ? : ");
        reponse = Cons.saisirChaine();
        choix = reponse.charAt(0);
        if (choix=='o')
        {
            // Supprimer la quantité
            nb = PasserelleBdd.modifEnum('S',uneEnum);
            if (nb==1)
            {
                System.out.println("Suppression bien effectuée ");
            }
            else
            {
                System.out.println("Echec de la suppression ! ");
            }
        }
        else
        {
            System.out.println("Suppression non effectuée ! ");
        }

        // Sinon, la quantité n'a pas été trouvée

    } // Fin de supprimer

} // Fin classe