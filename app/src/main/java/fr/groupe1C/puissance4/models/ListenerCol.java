package fr.groupe1C.puissance4.models;

import android.content.Intent;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.view.View;
import android.util.Log;
import android.widget.TextView;

import fr.groupe1C.puissance4.R;
import fr.groupe1C.puissance4.views.GameActivity;
import fr.groupe1C.puissance4.views.MainActivity;
import android.content.Intent;

public class ListenerCol extends Activity implements OnClickListener {

    private Grille grille;
    private int colonne;
    private TextView mCase1;
    private TextView mCase2;
    private TextView mCase3;
    private TextView mCase4;
    private TextView mCase5;
    private TextView mCase6;
    private Joueur etatJoueur;

    public ListenerCol(Grille grille, Joueur etatJoueur, int colonne, TextView mCase1, TextView mCase2, TextView mCase3, TextView mCase4, TextView mCase5, TextView mCase6) {
        this.grille = grille;
        this.colonne = colonne-1;
        this.etatJoueur = etatJoueur;
        this.mCase1 = mCase1;
        this.mCase2 = mCase2;
        this.mCase3 = mCase3;
        this.mCase4 = mCase4;
        this.mCase5 = mCase5;
        this.mCase6 = mCase6;
    }

    @Override
    public void onClick(View v) {

        int line = this.grille.getLowestJeton(this.colonne);
        if (this.etatJoueur.getJoueur()==1) {
            if (line == 0) {
                this.mCase6.setBackgroundResource(R.color.p1);
                this.grille.setGrille(line, this.colonne, 1);
            } else if (line == 1) {
                this.mCase5.setBackgroundResource(R.color.p1);
                this.grille.setGrille(line, this.colonne, 1);
            } else if (line == 2) {
                this.mCase4.setBackgroundResource(R.color.p1);
                this.grille.setGrille(line, this.colonne, 1);
            } else if (line == 3) {
                this.mCase3.setBackgroundResource(R.color.p1);
                this.grille.setGrille(line, this.colonne, 1);
            } else if (line == 4) {
                this.mCase2.setBackgroundResource(R.color.p1);
                this.grille.setGrille(line, this.colonne, 1);
            } else if (line == 5) {
                this.mCase1.setBackgroundResource(R.color.p1);
                this.grille.setGrille(line, this.colonne, 1);
            }
        } else if (this.etatJoueur.getJoueur()==2) {
            if (line == 0) {
                this.mCase6.setBackgroundResource(R.color.p2);
                this.grille.setGrille(line, this.colonne, 2);
            } else if (line == 1) {
                this.mCase5.setBackgroundResource(R.color.p2);
                this.grille.setGrille(line, this.colonne, 2);
            } else if (line == 2) {
                this.mCase4.setBackgroundResource(R.color.p2);
                this.grille.setGrille(line, this.colonne, 2);
            } else if (line == 3) {
                this.mCase3.setBackgroundResource(R.color.p2);
                this.grille.setGrille(line, this.colonne, 2);
            } else if (line == 4) {
                this.mCase2.setBackgroundResource(R.color.p2);
                this.grille.setGrille(line, this.colonne, 2);
            } else if (line == 5) {
                this.mCase1.setBackgroundResource(R.color.p2);
                this.grille.setGrille(line, this.colonne, 2);
            }

        }

        Victoire vic = new Victoire(this.grille.getGrille());
        if (vic.Result()==1){
            //pop up victoire j1 ok vers sondage
            Intent intent = new Intent(this ,MainActivity.class);
            startActivity(intent);
        } else if (vic.Result()==2){
            // pop up victoire j2 ok vers sondage
            Intent intent = new Intent(this ,MainActivity.class);
            startActivity(intent);
        }



        // Teste si le pion rend la grille pleine
        int pionInGrille = 0;

        for (int i=0; i<6; i++){
            for (int j=0; j<7; j++){
                if (this.grille.getGrille()[i][j]!=0){
                    pionInGrille+=1;
                }
            }
        }
        // Met fin à la partie si la grille est pleine
        if(pionInGrille==6*7){
            // pop up match nul, ok vers sondage
        }


        if (line<6) {
            etatJoueur.switchJoueur();
        }

    }
}