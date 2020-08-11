
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

public class ManipVisiteur 
{

    static public void lister() throws Exception 
    {
        // Variables
        int i;
        String unNom, unPrenom, uneAdresse, uneVille, uneDate, unSecteur, unLabo;
        int unMatricule, unCP, unRole;
        Visiteur unVisiteur;
        ArrayList<Visiteur> lesVisiteur;
        String ligneAffiche;
        
        // Début
        i=0;
        lesVisiteur = PasserelleBdd.lireVis();
        System.out.println();
        ligneAffiche = String.format("|%-10s|%-10s|%-10s|%-15s|%-34s|%-17s|%-6s|%-10s|%-10s|%-10s|","Matricule", "Nom", "Prenom", "Date d'embauche", "Adresse", "Ville", "CP", "Secteur", "Code secteur", "Labo", "Rôle");
        System.out.println(ligneAffiche);
        ligneAffiche = String.format("|%-10s|%-10s|%-10s|%-15s|%-34s|%-17s|%-6s|%-10s|%-10s|%-10s|","----------", "----------", "----------" , "---------------", "----------------------------------", "-----------------", "------" , "----------", "----------", "----------");
        System.out.println(ligneAffiche);
        
        while (i<lesVisiteur.size()) 
        {
            unVisiteur = lesVisiteur.get(i); //erreur .get(i)
            unMatricule = unVisiteur.getVis_matricule();
            unNom = unVisiteur.getVis_nom();
            unPrenom = unVisiteur.getVis_prenom();
            uneDate = unVisiteur.getVis_dateembauche();
            uneAdresse = unVisiteur.getVis_adresse();
            uneVille = unVisiteur.getVis_ville();
            unCP = unVisiteur.getVis_cp();
            unSecteur = unVisiteur.getVis_secteur();
            unLabo = unVisiteur.getVis_labo();
            unRole = unVisiteur.getRole();
            ligneAffiche = String.format("|%-10s|%-10s|%-10s|%-15s|%-34s|%-17s|%-6s|%-10s|%-10s|%-10s|",unMatricule, unNom, unPrenom, uneDate, uneAdresse, uneVille, unCP, unSecteur, unLabo, unRole);
            System.out.println(ligneAffiche);
            i=i+1;
        } // Fin while

        if (i==0) 
        {
            System.out.println("Aucun visiteur");
        } // Fin if

    } // Fin lister

    static public void ajouter() throws Exception 
    {
        // Variables
        int nb;
        String unNom, unPrenom, uneAdresse, uneVille, uneDate, unSecteur, unLabo;
        int unMatricule, unCP, unRole;
        Visiteur unVisiteur;
        ArrayList<Visiteur> lesVisiteurs;
        Boolean c;
        
        // Début
        // Saisie des informations
        System.out.println("Saisir matricule :");
        unMatricule = Cons.saisirEntier();
        System.out.println("Saisir nom :");
        unNom = Cons.saisirChaine();
        System.out.println("Saisir prenom :");
        unPrenom = Cons.saisirChaine();
        System.out.println("Saisir date d'embauche :");
        System.out.println("(aaaa-mm-jj)");
        uneDate = Cons.saisirChaine();
        c = Pattern.matches("[1-9][0-9][0-9][0-9][-][0-1][0-9][-][0-3][0-9]",uneDate);
        while (c == false)
        {
            System.out.println("La date n'est pas au bon format,");
            System.out.println("il faut respecter le format aaaa-mm-jj");
            uneDate = Cons.saisirChaine();
            c = Pattern.matches("[1-9][0-9][0-9][0-9][-][0-1][0-9][-][0-3][0-9]",uneDate);
        }
        System.out.println("Saisir une adresse :");
        uneAdresse = Cons.saisirChaine();
        System.out.println("Saisir ville :");
        uneVille = Cons.saisirChaine();
        System.out.println("Saisir code postale :");
        unCP = Cons.saisirEntier();
        System.out.println("Saisir secteur :");
        unSecteur = Cons.saisirChaine();
        System.out.println("Saisir labo :");
        unLabo = Cons.saisirChaine();
        System.out.println("Saisir role :");
        unRole = Cons.saisirEntier();
        unVisiteur = new Visiteur(unMatricule, unNom, unPrenom, uneDate, uneAdresse, uneVille, unCP, unSecteur, unLabo, unRole);
        nb = PasserelleBdd.modifVis('A',unVisiteur);
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
        int leMat;
        ArrayList<Visiteur> lesVisiteur;
        
        // Début
        System.out.print("\nMatricule de visiteur recherché : ");
        leMat = Cons.saisirEntier();
        lesVisiteur = PasserelleBdd.chercheVis(leMat);

        // S'il y'a un résultat
        if (lesVisiteur.size()>0)
        {
            System.out.println("Le visiteur recherché est : ");
            lesVisiteur.get(0).afficher();
        }

        // Sinon, le visiteur n'a pas été trouvé
        else
        {
            System.out.println("Visiteur inconnu !");
        }

    } // Fin de rechercher

    static public void modifier() throws Exception 
    {
        // Variables
        boolean trouve = false;
        boolean c;
        String unNom, unPrenom, uneAdresse, uneVille, uneDate, unSecteur, unLabo;
        int unMatricule, unCP, unRole, nb;
        Visiteur unVisiteur;
        ArrayList<Visiteur> lesVisiteurs;
        
        // Début
        System.out.print("\nMatricule du visiteur à modifier : ");
        unMatricule = Cons.saisirEntier();

        // Rechercher et afficher le visiteur correspondant pour demander confirmation
        lesVisiteurs = PasserelleBdd.lireVis();

        // S'il y'a un résultat
        if (lesVisiteurs.size()>0)
        {
            unVisiteur = lesVisiteurs.get(0);
            System.out.println("Le Visiteur à modifier est : ");
            unVisiteur.afficher();
            System.out.print("Nouveau nom :");
            unNom = Cons.saisirChaine();
            unVisiteur.setVis_nom(unNom);
            System.out.println("Nouveau prenom :");
            unPrenom = Cons.saisirChaine();
            unVisiteur.setVis_prenom(unPrenom);
            System.out.println("Nouvelle date d'embauche :");
            System.out.println("(aaaa-mm-jj)");
            uneDate = Cons.saisirChaine();
            c = Pattern.matches("[1-9][0-9][0-9][0-9][-][0-1][0-9][-][0-3][0-9]",uneDate);
            while (c == false)
            {
                System.out.println("La date n'est pas au bon format,");
                System.out.println("il faut respecter le format aaaa-mm-jj");
                uneDate = Cons.saisirChaine();
                c = Pattern.matches("[1-9][0-9][0-9][0-9][-][0-1][0-9][-][0-3][0-9]",uneDate);
            }
            unVisiteur.setVis_dateembauche(uneDate);
            System.out.println("Nouvelle adresse :");
            uneAdresse = Cons.saisirChaine();
            unVisiteur.setVis_adresse(uneAdresse);
            System.out.println("Nouvelle ville :");
            uneVille = Cons.saisirChaine();
            unVisiteur.setVis_ville(uneVille);
            System.out.println("Nouveau code postale :");
            unCP = Cons.saisirEntier();
            unVisiteur.setVis_cp(unCP);
            System.out.println("Nouveau secteur :");
            unSecteur = Cons.saisirChaine();
            unVisiteur.setVis_secteur(unSecteur);
            System.out.println("Nouveau labo :");
            unLabo = Cons.saisirChaine();
            unVisiteur.setVis_labo(unLabo);
            System.out.println("Nouveau role :");
            unRole = Cons.saisirEntier();
            unVisiteur.setRole(unRole);

            // Modifier le visiteur
            nb = PasserelleBdd.modifVis('M',unVisiteur);
            if (nb==1)
            {
                System.out.println("Modification bien effectuée ");
            }
            else
            {
                System.out.println("Echec de la modification ! ");
            }

        }

        // Sinon, le visiteur n'a pas été trouvé
        else
        {
            System.out.println("Visiteur inconnu !");
        }

    } // Fin de modifier

    static public void supprimer() throws Exception 
    {
        // Variables
        int nb;
        int unMatricule;
        String reponse;
        char choix;
        ArrayList<Visiteur> lesVisiteurs;
        Visiteur unVisiteur;
        
        // Début
        System.out.print("\nMatricule du visiteur a supprimer : ");
        unMatricule = Cons.saisirEntier();

        // Rechercher et afficher le visiteur correspondant pour demander confirmation
        lesVisiteurs = PasserelleBdd.lireVis();

        // S'il y'a un résultat
        while (lesVisiteurs.isEmpty())
        {
            System.out.println("Aucun visiteur ne correspond au matricule "+unMatricule+".");
            System.out.print("\nMatricule du visiteur a supprimer : ");
            unMatricule = Cons.saisirEntier();
            lesVisiteurs = PasserelleBdd.lireVis();
        }
        unVisiteur = lesVisiteurs.get(0);
        System.out.println("Le visiteur à supprimer est : ");
        unVisiteur.afficher();
        System.out.print("Voulez vous réellement supprimer ce Visiteur (o/n) ? : ");
        reponse = Cons.saisirChaine();
        choix = reponse.charAt(0);
        if (choix=='o')
        {
            // Supprimer le visiteur
            nb = PasserelleBdd.modifVis('S',unVisiteur);
            if (nb==1)
            {
                System.out.println("Suppression bien effectuée ");
            }
            else
            {
                System.out.println("Echec de la suppression ! ");
            }
        }
        
        // Sinon, le visiteur n'a pas été trouvé
        else
        {
            System.out.println("Suppression non effectuée ! ");
        }

    } // Fin de supprimer

} // Fin classe