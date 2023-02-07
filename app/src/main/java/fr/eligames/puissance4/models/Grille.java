package fr.eligames.puissance4.models;

import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.os.Bundle;
import android.view.View;

import fr.groupe1C.puissance4.views.GameActivity;

public class Grille extends AppCompatActivity {

    private int ligne;
    private int colonne;
    private int[][] grille;


    public Grille(int ligne,int colonne) {
        this.ligne=ligne;
        this.colonne=colonne;
        this.grille = new int[ligne][colonne];

        // Initialise la grille vide
        for(int i = 0; i < ligne; i++) {
            for (int j = 0; j < colonne; j++) {
                grille[i][j] = 0;
            }
        }
    }

    // getter de la grille
    public int[][] getGrille(){
        return this.grille;
    }

    // getter de la colonne

    // setter de la grille
    public void setGrille(int ligne, int colonne, int pion){
        this.grille[ligne][colonne] = pion;
    }
    public int getLowestJeton(int colonne){
        int i;
        for(i = 0; i<6; i++ ){
            if(this.grille[i][colonne]==0){
                break; //On sort de la boucle une fois le premier jeton vide atteint
            }
        }
        return i;
    }




}