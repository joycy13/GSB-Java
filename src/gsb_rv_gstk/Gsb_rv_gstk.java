package gsb_rv_gstk;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.*;

 /* @author sio2
 */



public class Gsb_rv_gstk 
{

    /**
     * @param args the command line arguments
     */
    static public void main(String[] arg)throws Exception 
    {
        // TODO code application logic here

            // Variables         
            int i;
            int choix;
            int menu;
            int menu2;
            Visiteur unVisiteur;
            Médicament unMedicament;
            RapportVisite unRapportVisite;
            Praticien unPraticien;

            // Début
            System.out.println("\nVeuillez indiquez votre role :");
            System.out.println("1. Visiteur délégué"); 
            System.out.println("2. Visiteur médical");
            System.out.print("Choisir une action : ");
            String texte1 = Cons.saisirChaine();
            menu = texte1.charAt(0);
        
            if (menu=='1')
            {
                choix = '1';  

                System.out.println("\nVeuillez choisir votre menu :");
                System.out.println("1. Visiteur"); 
                System.out.println("2. Medicaments");
                System.out.println("3. Rapport de visite");
                System.out.println("4. Praticien");
                System.out.println("0. Terminer");
                System.out.print("Choisir une action : ");
                String texte2 = Cons.saisirChaine();
                menu2 = texte2.charAt(0);
    
                switch (menu2)
                {
                    case '1' : // Menu visiteur
                
                        while (choix!='0')
                        {
                            System.out.println("\nVisiteur délégué :");	 
                            System.out.println("1. Ajouter un visiteur"); 
                            System.out.println("2. Lister les visiteurs");  
                            System.out.println("3. Rechercher un visiteur"); 
                            System.out.println("4. Modifier un visiteur");  
                            System.out.println("5. Supprimer un visiteur");
                            System.out.println("0. Terminer"); 
                            System.out.print("Choisir une action : "); 
                            String texte = Cons.saisirChaine(); 
                            choix = texte.charAt(0);

                            switch (choix)
                            { 
                                case '1' : // Ajouter un visiteur 
                                    ManipVisiteur.ajouter();
                                    break;

                                case '2' : // Lister les visiteurs
                                    ManipVisiteur.lister();
                                    break;

                                case '3' : // Recherher un visiteur
                                    ManipVisiteur.rechercher();
                                    break;

                                case '4' : // Modifier un visiteur
                                    ManipVisiteur.modifier();
                                    break;

                                case '5' : // Supprimer un visiteur
                                    ManipVisiteur.supprimer();
                                    break;

                                case '0' : // Fin du programme
                                    break;
                            }
                        }
                        
                    case '2' : // Menu médicament
                
                        while (choix!='0')
                        {
                            System.out.println("\nVisiteur délégué :");	
                            System.out.println("1. Ajouter un médicament"); 
                            System.out.println("2. Lister les médicaments");  
                            System.out.println("3. Rechercher un médicament"); 
                            System.out.println("4. Modifier un médicament");  
                            System.out.println("5. Supprimer un médicament");
                            System.out.println("0. Terminer"); 
                            System.out.print("Choisir une action : "); 
                            String texte = Cons.saisirChaine(); 
                            choix = texte.charAt(0);

                            switch (choix)
                            {  
                                case '1' : // Ajouter les médicaments
                                    ManipMedicament.ajouter();
                                    break;

                                case '2' : // Lister les médicaments
                                    ManipMedicament.lister();
                                    break;  

                                case '3' : // Rechercher un médicament
                                    ManipMedicament.rechercher();
                                    break;

                                case '4' : // Modifier un médicament
                                    ManipMedicament.modifier();
                                    break;
              
                                case '5' : // Supprimer un médicament
                                    ManipMedicament.supprimer();
                                    break;

                                case '0' : // Fin du programme
                                    break;
                            }      
                        }
                
                    case '3' : // Menu rapport de visite
                
                        while (choix!='0')
                        {
                            System.out.println("\nVisiteur délégué :");	
                            System.out.println("1. Ajouter un rapport de visite"); 
                            System.out.println("2. Lister les rapports de visite");  
                            System.out.println("3. Rechercher un rapport de visite"); 
                            System.out.println("4. Modifier un rapport de visite");  
                            System.out.println("5. Supprimer un rapport de visite");
                            System.out.println("0. Terminer"); 
                            System.out.print("Choisir une action : "); 
                            String texte = Cons.saisirChaine(); 
                            choix = texte.charAt(0);

                            switch (choix)
                            {
                                case '1' : // Ajouter un rapport de visite
                                    ManipRapportVisite.ajouter();
                                    break;

                                case '2' : // Lister les rapports de visite
                                    ManipRapportVisite.lister();
                                    break;

                                case '3' : // Rechercher un rapport de visite
                                    ManipRapportVisite.rechercher();
                                    break;

                                case '4' : // Modifier un rapport de visite
                                    ManipRapportVisite.modifier();
                                    break;

                                case '5' : // Supprimer un rapport de visite
                                    ManipRapportVisite.supprimer();
                                    break;

                                case '0' : // Fin du programme
                                    break;     
                            }                    
                        }
                
                    case '4' : // Menu praticien
                
                        while (choix!='0')
                        {
                            System.out.println("\nVisiteur délégué :");	
                            System.out.println("1. Ajouter un praticien"); 
                            System.out.println("2. Lister les praticiens");  
                            System.out.println("3. Rechercher un praticien"); 
                            System.out.println("4. Modifier un praticien");  
                            System.out.println("5. Supprimer un praticien");
                            System.out.println("0. Terminer"); 
                            System.out.print("Choisir une action : "); 
                            String texte = Cons.saisirChaine(); 
                            choix = texte.charAt(0);

                            switch (choix)
                            {
                                case '1' : // Ajouter un praticien
                                    ManipPraticien.ajouter();
                                    break;

                                case '2' : // Lister les praticiens
                                    ManipPraticien.lister();
                                    break;

                                case '3' : // Recherher un praticien
                                    ManipPraticien.rechercher();
                                    break;

                                case '4' : // Modifier un praticien
                                    ManipPraticien.modifier();
                                    break;

                                case '5' : // Supprimer un praticien
                                    ManipPraticien.supprimer();
                                    break;  

                                case '0' : // Fin du programme
                                    break;    
                            }
                                             
                        }
                
                    case '0' :
                        break;     
                }             
            }
    
            if(menu=='2')
            {
                choix='1';
        
                System.out.println("\nVeuillez choisir votre menu :");
                System.out.println("1. Visiteur"); 
                System.out.println("2. Medicaments");
                System.out.println("3. Rapport de visite");
                System.out.println("4. Praticien");
                System.out.print("Choisir une action : ");
                String texte2 = Cons.saisirChaine();
                menu2 = texte2.charAt(0);
    
                switch (menu2)
                {
                    case '1' : // Menu visiteur
                
                        while (choix!='0')
                        {
                            System.out.println("\nVisiteur médical :");	  
                            System.out.println("1. Lister les visiteurs");  
                            System.out.println("2. Rechercher un visiteur");  
                            System.out.println("0. Terminer"); 
                            System.out.print("Choisir une action : "); 
                            String texte = Cons.saisirChaine(); 
                            choix = texte.charAt(0);

                            switch (choix)
                            {
                                case '1' : // Lister les visiteurs
                                    ManipVisiteur.lister();
                                    break;
                                       
                                case '2' : // Rechercher un visiteur
                                    ManipVisiteur.rechercher();
                                    break;
                                       
                                case '0' : // Fin du programme
                                    break;
                            }   
                        }
                
                    case '2' : // Menu médicament
                
                        while (choix!='0')
                        {
                            System.out.println("\nVisiteur médical :");	
                            System.out.println("1. Lister les medicaments");  
                            System.out.println("2. Rechercher un médicament");
                            System.out.println("0. Terminer"); 
                            System.out.print("Choisir une action : "); 
                            String texte = Cons.saisirChaine(); 
                            choix = texte.charAt(0);
                               
                            switch (choix)
                            {
                                case '1' : // Lister les médicaments
                                    ManipMedicament.lister();
                                    break;
                                       
                                case '2' : // Rechercher un médicament
                                    ManipMedicament.rechercher();
                                    break;
                                   
                                case '0' : // Fin du programme
                                    break;
                            }     
                        }
                        
                    case '3' : // Menu rapport de visite
                
                        while (choix!='0')
                        {
                            System.out.println("\nVisiteur médical :");	
                            System.out.println("1. Ajouter un rapport de visite"); 
                            System.out.println("2. Modifier un rapport de visite");
                            System.out.println("0. Terminer"); 
                            System.out.print("Choisir une action : "); 
                            String texte = Cons.saisirChaine(); 
                            choix = texte.charAt(0);

                            switch (choix)
                            {
                                
                                case '1' : // Ajouter un rapport de visite
                                    ManipRapportVisite.ajouter();
                                    break;
                                       
                                case '2' : // Modifier un rapport de visite
                                    ManipRapportVisite.modifier();
                                    break;
                                       
                                case '0' : // Fin du programme
                                    break;
                            }                  
                        }
                
                    case '4' : // Menu praticien
                
                        while (choix!='0')
                        {
                            System.out.println("\nVisiteur médical :");	
                            System.out.println("1. Lister un praticien"); 
                            System.out.println("2. Rechercher un praticien");
                            System.out.println("0. Terminer"); 
                            System.out.print("Choisir une action : "); 
                            String texte = Cons.saisirChaine(); 
                            choix = texte.charAt(0);
                               
                            switch (choix)
                            {
                                
                                case '1' : // Lister les praticiens
                                    ManipPraticien.lister();
                                    break;
                                       
                                case '2' : // Rechercher un praticien
                                    ManipPraticien.rechercher();
                                    break;
                                       
                                case '0' : // Fin du programme
                                    break;
                            }                   
                        }
                             
                    case '0' :
                        break;              
                }
            }
    }                     
}