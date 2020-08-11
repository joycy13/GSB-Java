package gsb_rv_gstk;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;   
/**
 *
 * @author sio2
 */
public class Visiteur 
{
    // Attributs
    
    private int vis_matricule;
    private String vis_nom;
    private String vis_prenom;
    private String vis_dateembauche;
    private String vis_adresse;
    private String vis_ville;
    private int vis_cp;
    private String vis_secteur;
    private String vis_labo;
    private int role;
    
    // Méthodes

    public Visiteur(int vis_matricule, String vis_nom, String vis_prenom, String vis_dateembauche, String vis_adresse, String vis_ville, int vis_cp, String vis_secteur, String vis_labo, int role) 
    {
        this.vis_matricule = vis_matricule;
        this.vis_nom = vis_nom;
        this.vis_prenom = vis_prenom;
        this.vis_dateembauche = vis_dateembauche;
        this.vis_adresse = vis_adresse;
        this.vis_ville = vis_ville;
        this.vis_cp = vis_cp;
        this.vis_secteur = vis_secteur;
        this.vis_labo = vis_labo;
        this.role = role;
    }
    
    public int getVis_matricule() {
        return vis_matricule;
    }

    
    public String getVis_nom() {
        return vis_nom;
    }

    public String getVis_prenom() {
        return vis_prenom;
    }
    
    public String getVis_dateembauche() {
        return vis_dateembauche;
    }

    public String getVis_adresse() {
        return vis_adresse;
    }

    public String getVis_ville() {
        return vis_ville;
    }

    public int getVis_cp() {
        return vis_cp;
    }

    
    public String getVis_secteur() {
        return vis_secteur;
    }

    
    public String getVis_labo() {
        return vis_labo;
    }

    public int getRole() {
        return role;
    }

    public void setVis_matricule(int vis_matricule) {
        this.vis_matricule = vis_matricule;
    }

    public void setVis_nom(String vis_nom) {
        this.vis_nom = vis_nom;
    }

    public void setVis_prenom(String vis_prenom) {
        this.vis_prenom = vis_prenom;
    }
    
    public void setVis_dateembauche(String vis_dateembauche) {
        this.vis_dateembauche = vis_dateembauche;
    }
    
    public void setVis_adresse(String vis_adresse) {
        this.vis_adresse = vis_adresse;
    }

    public void setVis_ville(String vis_ville) {
        this.vis_ville = vis_ville;
    }

    public void setVis_cp(int vis_cp) {
        this.vis_cp = vis_cp;
    }
    
    public void setVis_secteur(String vis_secteur) {
        this.vis_secteur = vis_secteur;
    }

        
    public void setVis_labo(String vis_labo) {
        this.vis_labo = vis_labo;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
    public void afficher()
    {
        System.out.println("Matricule :" + vis_matricule);
        System.out.println("Nom :" + vis_nom);
        System.out.println("Prenom :" + vis_prenom);
        System.out.println("Date d'embauche :" + vis_dateembauche);
        System.out.println("Adresse :" + vis_adresse);
        System.out.println("Ville :" + vis_ville);
        System.out.println("Code postal :" + vis_cp);
        System.out.println("Secteur :" + vis_secteur);
        System.out.println("Laboratoire :" + vis_labo);
        System.out.println("Role :" + role);
    }
  
}
