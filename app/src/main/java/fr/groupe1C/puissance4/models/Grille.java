package fr.groupe1C.puissance4.models;

import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.os.Bundle;
import android.view.View;

import fr.groupe1C.puissance4.views.GameActivity;

public class Grille extends AppCompatActivity {

    private int ligne;
    private int colonne;
    private int[][] grille;
    private Colonne[] colonnes;


    public Grille(int ligne,int colonne) {
        this.ligne=ligne;
        this.colonne=colonne;
        this.grille = new int[ligne][colonne];
        this.colonnes = new Colonne[colonne];

        // Initialise la grille vide
        for(int i = 0; i < ligne; i++) {
            for (int j = 0; j < colonne; j++) {
                grille[i][j] = 0;
            }
            this.colonnes[i] = new Colonne(ligne);
        }
    }

    // getter de la grille
    public int[][] getGrille(){
        return this.grille;
    }
/*
    public Colonne getColonne(int colonne){
        return this.colonnes[colonne];
    }*/


}