package gsb_rv_gstk;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sio2
 */
public class Praticien 
{
    // Attributs
    
    private int pra_code;
    private String nom;
    private String prenom;
    private String adresse;
    private String ville;
    private int code_postal;
    private int numero_tel;
    private String type_praticien;
    
    // Méthodes

    public Praticien(int pra_code, String nom, String prenom, String adresse, String ville, int code_postal, int numero_tel, String type_praticien) {
        this.pra_code = pra_code;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.ville = ville;
        this.code_postal = code_postal;
        this.numero_tel = numero_tel;
        this.type_praticien = type_praticien;
    }


    public int getPra_code() {
        return pra_code;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getVille() {
        return ville;
    }

    public int getCode_postal() {
        return code_postal;
    }

    public int getNumero_tel() {
        return numero_tel;
    }

    public String getType_praticien() {
        return type_praticien;
    }

    public void setPra_code(int pra_code) {
        this.pra_code = pra_code;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setCode_postal(int code_postal) {
        this.code_postal = code_postal;
    }

    public void setNumero_tel(int numero_tel) {
        this.numero_tel = numero_tel;
    }

    public void setType_praticien(String type_praticien) {
        this.type_praticien = type_praticien;
    }
    
        public void afficher()
    {
        System.out.println("Code praticien :" + pra_code);
        System.out.println("Nom praticien :" + nom);
        System.out.println("Prénom :" + prenom);
        System.out.println("Adresse :" + adresse);
        System.out.println("Ville :" + ville);
        System.out.println("Code postal :" + code_postal);
        System.out.println("Numéro de téléphone :" + numero_tel);
        System.out.println("Type de praticien :" + type_praticien);
    }
    
}
