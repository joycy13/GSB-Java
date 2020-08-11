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

public class Enumerer

{
    // Attributs
    private int med_depot_legal;
    private int rap_num;
    private int off_qte;

    // Méthodes

    public Enumerer(int med_depot_legal, int rap_num, int off_qte)
    {
        this.med_depot_legal = med_depot_legal;
        this.rap_num = rap_num;
        this.off_qte = off_qte;
    }

    public int getMed_depot_legal() 
    {
        return med_depot_legal;
    }

    public int getRap_num() 
    {
        return rap_num;
    }

    public int getOff_qte() 
    {
        return off_qte;
    }
    
    public void setMed_depot_legal(int med_depot_legal) 
    {
        this.med_depot_legal = med_depot_legal;
    }

    public void setRap_num(int rap_num) 
    {
        this.rap_num = rap_num;
    }
    
    public void setOff_qte(int off_qte) 
    {
        this.off_qte = off_qte;
    }

    public void afficher()
    {
        System.out.println("Dépot légal :" + med_depot_legal);
        System.out.println("Numéro rapport :" + rap_num);
        System.out.println("Quantité offerte :" + off_qte);
    }
}