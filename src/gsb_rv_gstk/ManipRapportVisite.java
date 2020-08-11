
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

public class ManipRapportVisite 
{

    static public void lister() throws Exception 
    {
        // Variables
        int i;
        String uneDateR, unBilan, unMotif, unMedOffert;
        int unRapNum, unMatricule, unCode, unNbEchantillon;
        RapportVisite unRapportVisite;
        ArrayList<RapportVisite> lesRapportVisite;
        String ligneAffiche;
        
        // Début
        i=0;
        lesRapportVisite = PasserelleBdd.lireRap();
        System.out.println();
        ligneAffiche = String.format("|%-10s|%-10s|%-20s|%-34s|%-10s|%-10s|%-17s|%-25s|","Numéro", "Date", "Bilan", "Motif", "Matricule", "Code", "Médicament offert", "Nombre échantillon offert");
        System.out.println(ligneAffiche);
        ligneAffiche = String.format("|%-10s|%-10s|%-20s|%-34s|%-10s|%-10s|%-17s|%-25s|","----------", "----------", "--------------------" ,"----------------------------------", "----------", "----------", "-----------------", "-------------------------");
        System.out.println(ligneAffiche);
        
        while (i<lesRapportVisite.size()) 
        {
            unRapportVisite = lesRapportVisite.get(i); //erreur .get(i)
            unRapNum = unRapportVisite.getRap_num();
            uneDateR = unRapportVisite.getRap_date();
            unBilan = unRapportVisite.getRap_bilan();
            unMotif = unRapportVisite.getRap_motif();
            unMatricule = unRapportVisite.getVis_matricule();
            unCode = unRapportVisite.getPra_code();
            unMedOffert = unRapportVisite.getMedicament_offert();
            unNbEchantillon = unRapportVisite.getNombre_echantillon_offert();
            ligneAffiche = String.format("|%-10s|%-10s|%-20s|%-34s|%-10s|%-10s|%-17s|%-25s|",unRapNum, uneDateR, unBilan, unMotif, unMatricule, unCode, unMedOffert, unNbEchantillon);
            System.out.println(ligneAffiche);
            i=i+1;
        } // Fin while

        if (i==0) 
        {
            System.out.println("Aucun rapport de visite");
        } // Fin if

    } // Fin lister

    static public void ajouter() throws Exception 
    {
        // Variables
        int nb;
        String uneDateR, unBilan, unMotif, unMedOffert;
        int unRapNum, unMatricule, unCode, unNbEchantillon;
        RapportVisite unRapportVisite;
        ArrayList<RapportVisite> lesRapportVisite;
        Boolean c;
        
        // Début
        // Saisie des informations
        System.out.println("Saisir numéro :");
        unRapNum = Cons.saisirEntier();
        System.out.println("Saisir date :");
        uneDateR = Cons.saisirChaine();
        System.out.println("Saisir bilan :");
        unBilan = Cons.saisirChaine();
        System.out.println("Saisir motif :");
        unMotif = Cons.saisirChaine();
        System.out.println("Saisir matricule :");
        unMatricule = Cons.saisirEntier();
        System.out.println("Saisir code :");
        unCode = Cons.saisirEntier();
        System.out.println("Saisir médicament :");
        unMedOffert = Cons.saisirChaine();
        System.out.println("Saisir nb échantillon :");
        unNbEchantillon = Cons.saisirEntier();
        unRapportVisite = new RapportVisite(unRapNum, uneDateR, unBilan, unMotif, unMatricule, unCode, unMedOffert, unNbEchantillon);
        nb = PasserelleBdd.modifRap('A',unRapportVisite);
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
        int leRapNum;
        ArrayList<RapportVisite> lesRapportVisite;
        
        // Début
        System.out.print("\nNumero de rapport recherché : ");
        leRapNum = Cons.saisirEntier();
        lesRapportVisite = PasserelleBdd.chercheRap(leRapNum);

        // S'il y'a un résultat
        if (lesRapportVisite.size()>0)
        {
            System.out.println("Le rapport de visite recherché est : ");
            lesRapportVisite.get(0).afficher();
        }

        // Sinon, le rapport de visite n'a pas été trouvé
        else
        {
            System.out.println("Rapport de visite inconnu !");
        }

    } // Fin de rechercher

    static public void modifier() throws Exception 
    {
        // Variables
        boolean trouve = false;
        boolean c;
        String uneDateR, unBilan, unMotif, unMedOffert;
        int unRapNum, unMatricule, unCode, unNbEchantillon, nb;
        RapportVisite unRapportVisite;
        ArrayList<RapportVisite> lesRapportVisite;
        
        // Début
        System.out.print("\nNuméro du rapport à modifier : ");
        unRapNum = Cons.saisirEntier();

        // Rechercher et afficher le rapport de visite correspondant pour demander confirmation
        lesRapportVisite = PasserelleBdd.lireRap();

        // S'il y'a un résultat
        if (lesRapportVisite.size()>0)
        {
            unRapportVisite = lesRapportVisite.get(0);
            System.out.println("Le rapport de visite à modifier est : ");
            unRapportVisite.afficher();
            System.out.println("Nouveau numéro :");
            unRapNum = Cons.saisirEntier();
            unRapportVisite.setRap_num(unRapNum);
            System.out.println("Nouvelle date :");
            uneDateR = Cons.saisirChaine();
            unRapportVisite.setRap_date(uneDateR);
            System.out.println("Nouveau bilan :");
            unBilan = Cons.saisirChaine();
            unRapportVisite.setRap_bilan(unBilan);
            System.out.println("Nouveau motif :");
            unMotif = Cons.saisirChaine();
            unRapportVisite.setRap_motif(unMotif);
            System.out.println("Nouveau matricule :");
            unMatricule = Cons.saisirEntier();
            unRapportVisite.setVis_matricule(unMatricule);
            System.out.println("Nouveau code :");
            unCode = Cons.saisirEntier();
            unRapportVisite.setPra_code(unCode);
            System.out.println("Nouveau médicament :");
            unMedOffert = Cons.saisirChaine();
            unRapportVisite.setMedicament_offert(unMedOffert);
            System.out.println("Nouveau nb échantillon :");
            unNbEchantillon = Cons.saisirEntier();
            unRapportVisite.setNombre_echantillon_offert(unNbEchantillon);

            // Modifier le rapport de visite
            nb = PasserelleBdd.modifRap('M',unRapportVisite);
            if (nb==1)
            {
                System.out.println("Modification bien effectuée ");
            }
            else
            {
                System.out.println("Echec de la modification ! ");
            }

        }

        // Sinon, le rapport de visite n'a pas été trouvé
        else
        {
            System.out.println("Rapport visite inconnu !");
        }

    } // Fin de modifier

    static public void supprimer() throws Exception 
    {
        // Variables
        int nb;
        int unRapNum;
        String reponse;
        char choix;
        ArrayList<RapportVisite> lesRapportVisite;
        RapportVisite unRapportVisite;
        
        // Début
        System.out.print("\nNuméro du rapport a supprimer : ");
        unRapNum = Cons.saisirEntier();

        // Rechercher et afficher le rapport de visite correspondant pour demander confirmation
        lesRapportVisite = PasserelleBdd.lireRap();

        // S'il y'a un résultat
        while (lesRapportVisite.isEmpty())
        {
            System.out.println("Aucun rapport de visite ne correspond au numero "+unRapNum+".");
            System.out.print("\nNuemro du rapport a supprimer : ");
            unRapNum = Cons.saisirEntier();
            lesRapportVisite = PasserelleBdd.lireRap();
        }
        unRapportVisite = lesRapportVisite.get(0);
        System.out.println("Le rapport à supprimer est : ");
        unRapportVisite.afficher();
        System.out.print("Voulez vous réellement supprimer ce rapport (o/n) ? : ");
        reponse = Cons.saisirChaine();
        choix = reponse.charAt(0);
        if (choix=='o')
        {
            // Supprimer le rapport de visite
            nb = PasserelleBdd.modifRap('S',unRapportVisite);
            if (nb==1)
            {
                System.out.println("Suppression bien effectuée ");
            }
            else
            {
                System.out.println("Echec de la suppression ! ");
            }
        }
        
        // Sinon, le rapport de visite n'a pas été trouvé
        else
        {
            System.out.println("Suppression non effectuée ! ");
        }

    } // Fin de supprimer

} // Fin classe