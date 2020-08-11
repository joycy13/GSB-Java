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
public class RapportVisite 
{
    // Attributs
    
    private int rap_num;
    private String rap_date;
    private String rap_bilan;
    private String rap_motif;
    private int vis_matricule;
    private int pra_code;
    private String medicament_offert;
    private int nombre_echantillon_offert;
    
    // Méthodes

    public RapportVisite(int rap_num, String rap_date, String rap_bilan, String rap_motif, int vis_matricule, int pra_code, String medicament_offert, int nombre_echantillon_offert) {
        this.rap_num = rap_num;
        this.rap_date = rap_date;
        this.rap_bilan = rap_bilan;
        this.rap_motif = rap_motif;
        this.vis_matricule = vis_matricule;
        this.pra_code = pra_code;
        this.medicament_offert = medicament_offert;
        this.nombre_echantillon_offert = nombre_echantillon_offert;
    }

    public int getRap_num() {
        return rap_num;
    }

    public String getRap_date() {
        return rap_date;
    }

    public String getRap_bilan() {
        return rap_bilan;
    }

    public String getRap_motif() {
        return rap_motif;
    }

    public int getVis_matricule() {
        return vis_matricule;
    }

    public int getPra_code() {
        return pra_code;
    }

    public String getMedicament_offert() {
        return medicament_offert;
    }

    public int getNombre_echantillon_offert() {
        return nombre_echantillon_offert;
    }

    public void setRap_num(int rap_num) {
        this.rap_num = rap_num;
    }

    public void setRap_date(String rap_date) {
        this.rap_date = rap_date;
    }

    public void setRap_bilan(String rap_bilan) {
        this.rap_bilan = rap_bilan;
    }

    public void setRap_motif(String rap_motif) {
        this.rap_motif = rap_motif;
    }

    public void setVis_matricule(int vis_matricule) {
        this.vis_matricule = vis_matricule;
    }

    public void setPra_code(int pra_code) {
        this.pra_code = pra_code;
    }

    public void setMedicament_offert(String medicament_offert) {
        this.medicament_offert = medicament_offert;
    }

    public void setNombre_echantillon_offert(int nombre_echantillon_offert) {
        this.nombre_echantillon_offert = nombre_echantillon_offert;
    }
    
    public void afficher()
    {
        System.out.println("Numéro rapport :" + rap_num);
        System.out.println("Date :" + rap_date);
        System.out.println("Bilan :" + rap_bilan);
        System.out.println("Motif :" + rap_motif);
        System.out.println("Matricule :" + vis_matricule);
        System.out.println("Code praticien :" + pra_code);
        System.out.println("Médicaments offerts :" + medicament_offert);
        System.out.println("Nombre d'échantillon offert :" + nombre_echantillon_offert);
    }
    
    
    
}
