package fr.groupe1C.puissance4.models;

import android.view.View.OnClickListener;
import android.app.Activity;
import android.view.View;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import fr.groupe1C.puissance4.R;

public class Joueur {

    private int joueur;

    public Joueur(){
        this.joueur = 1;
    }

    public int getJoueur(){
        return this.joueur;
    }

    public void switchJoueur() {
        if (this.joueur==1){
            this.joueur=2;
        } else {
            this.joueur=1;
        }
    }

}
