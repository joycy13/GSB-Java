package gsb_rv_gstk;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
/**
 *
 * @author sio2
 */
public class Cons {
    public static int saisirEntier() throws IOException{      //Méthode de saisi des entiers
	
         // 1. Déclaration d'un flux en entrée
		InputStreamReader lecteur = new InputStreamReader(System.in);

         // 2. Déclaration d'un tampon (buffer) de lecture sur ce flux
		BufferedReader entree = new BufferedReader(lecteur);
	
		String texte;
		Integer x;
		
		texte = entree.readLine();
		x = new Integer(texte);
		
		return(x.intValue());		
       } 

	public	static float saisirReel() throws IOException{     //Méthode de saisi des réels
	
         // 1. Déclaration d'un flux en entrée
		InputStreamReader lecteur = new InputStreamReader(System.in);

         // 2. Déclaration d'un tampon (buffer) de lecture sur ce flux
		BufferedReader entree = new BufferedReader(lecteur);
	
		String texte;
		Float x;
		
		texte = entree.readLine();
		x = new Float(texte);
		
		return(x.floatValue());	
     }

	public	static String saisirChaine() throws IOException{        // Méthode de saisi des chaînes de caractères
	
         // 1. Déclaration d'un flux en entrée
		InputStreamReader lecteur = new InputStreamReader(System.in);

         // 2. Déclaration d'un tampon (buffer) de lecture sur ce flux
		BufferedReader entree = new BufferedReader(lecteur);

		String texte;
		Float x;
		
		texte = entree.readLine();
		
		return(texte);	
     }
        
} // Fin Classe
