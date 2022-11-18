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
    private TextView mPlayer1;
    private TextView mPlayer2;

    public Joueur(TextView mPlayer1, TextView mPlayer2){
        this.joueur = 1;
        this.mPlayer1 = mPlayer1;
        this.mPlayer2 =  mPlayer2;
        this.mPlayer1.setBackgroundResource(R.color.p1);
    }

    public int getJoueur(){
        return this.joueur;
    }

    public void switchJoueur() {
        if (this.joueur==1){
            this.joueur=2;
            this.mPlayer2.setBackgroundResource(R.color.p2);
            this.mPlayer1.setBackgroundResource(R.color.beige);
        } else {
            this.joueur=1;
            this.mPlayer1.setBackgroundResource(R.color.p1);
            this.mPlayer2.setBackgroundResource(R.color.beige);
        }
    }

}