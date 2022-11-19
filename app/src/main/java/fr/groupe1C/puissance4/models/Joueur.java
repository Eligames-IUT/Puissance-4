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
        this.mPlayer1.setBackgroundResource(R.drawable.p1_round);
    }

    public int getJoueur(){
        return this.joueur;
    }

    public TextView getmPlayer(int joueur){
        if (joueur==1){
            return this.mPlayer1;
        } else {
            return this.mPlayer2;
        }
    }

    public void switchJoueur() {
        if (this.joueur==1){
            this.joueur=2;
            this.mPlayer2.setBackgroundResource(R.drawable.p2_round);
            this.mPlayer1.setBackgroundResource(R.color.light_grey);
        } else {
            this.joueur=1;
            this.mPlayer1.setBackgroundResource(R.drawable.p1_round);
            this.mPlayer2.setBackgroundResource(R.color.light_grey);
        }
    }

}