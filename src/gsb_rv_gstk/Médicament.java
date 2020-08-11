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
public class Médicament 
{
   // Attributs
    
    private int med_depot_legal;
    private String nom_commercial;
    private String famille;
    private String effet_therapetique;
    private String contre_indication;
    private float prix_echantillon;
    private String typemedicament;
    private int qte_stock;
    private String date_peremption;
    
    // Méthodes
    
    public Médicament(int med_depot_legal, String nom_commercial, String famille, String effet_therapetique, String contre_indication, float prix_echantillon, String typemedicament, int qte_stock, String date_peremption) 
    {
        this.med_depot_legal = med_depot_legal;
        this.nom_commercial = nom_commercial;
        this.famille = famille;
        this.effet_therapetique = effet_therapetique;
        this.contre_indication = contre_indication;
        this.prix_echantillon = prix_echantillon;
        this.typemedicament = typemedicament;
        this.qte_stock = qte_stock;
        this.date_peremption = date_peremption;
    }

    

    public int getMed_depot_legal() {
        return med_depot_legal;
    }

    public String getNom_commercial() {
        return nom_commercial;
    }

    public String getFamille() {
        return famille;
    }

    public String getEffet_therapetique() {
        return effet_therapetique;
    }

    public String getContre_indication() {
        return contre_indication;
    }

    public float getPrix_echantillon() {
        return prix_echantillon;
    }

    public String getTypemedicament() {
        return typemedicament;
    }

    public int getQte_stock() {
        return qte_stock;
    }

    public String getDate_peremption() {
        return date_peremption;
    }

    public void setMed_depot_legal(int med_depot_legal) {
        this.med_depot_legal = med_depot_legal;
    }

    public void setNom_commercial(String nom_commercial) {
        this.nom_commercial = nom_commercial;
    }

    public void setFamille(String famille) {
        this.famille = famille;
    }

    public void setEffet_therapetique(String effet_therapetique) {
        this.effet_therapetique = effet_therapetique;
    }

    public void setContre_indication(String contre_indication) {
        this.contre_indication = contre_indication;
    }

    public void setPrix_echantillon(float prix_echantillon) {
        this.prix_echantillon = prix_echantillon;
    }

    public void setTypemedicament(String typemedicament) {
        this.typemedicament = typemedicament;
    }

    public void setQte_stock(int qte_stock) {
        this.qte_stock = qte_stock;
    }

    public void setDate_peremption(String date_peremption) {
        this.date_peremption = date_peremption;
    }
    
    public void afficher()
    {
        System.out.println("Dépot légal :" + med_depot_legal);
        System.out.println("Nom commercial :" + nom_commercial);
        System.out.println("Famille :" + famille);
        System.out.println("Effets thérapeutiques :" + effet_therapetique);
        System.out.println("Contre-indication :" + contre_indication);
        System.out.println("Prix échantillon :" + prix_echantillon);
        System.out.println("Type de médicaments :" + typemedicament);
        System.out.println("Quantités en stock :" + qte_stock);
        System.out.println("Date de péremption :" + date_peremption);
    }
}
