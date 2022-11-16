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
    private LinearLayout[] viewCol;


    public Grille(int ligne,int colonne) {
        this.ligne=ligne;
        this.colonne=colonne;
        this.grille = new int[ligne][colonne];
        this.colonnes = new Colonne[colonne];
        this.viewCol = new LinearLayout[colonne];

        // Initialise la grille vide
        for(int i = 0; i < ligne; i++) {
            for(int j = 0; j < colonne; j++) {
                grille[i][j] = 0;
            }
            this.colonnes[i] = new Colonne(ligne);
        }

        // récupère l'élément XML corespondant à chaque colonne
        GameActivity view = new GameActivity();
        this.viewCol= view.getColonnes();

        // Place un Listener sur chaque colonne
        for(int n = 0; n < colonne; n++) {
            viewCol[n].setOnClickListener(new ListenerCol());
        }

    }

    // getter de la grille
    public int[][] getGrille() {
        return grille;
    }

}