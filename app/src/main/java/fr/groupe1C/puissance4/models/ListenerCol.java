package fr.groupe1C.puissance4.models;

import android.view.View.OnClickListener;
import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import fr.groupe1C.puissance4.R;

public class ListenerCol extends Activity implements OnClickListener {

    private Grille grille;
    private Colonne colonne;
    private TextView mCase1;
    private TextView mCase2;
    private TextView mCase3;
    private TextView mCase4;
    private TextView mCase5;
    private TextView mCase6;

    public ListenerCol(Grille grille, int colonne, TextView mCase1, TextView mCase2, TextView mCase3, TextView mCase4, TextView mCase5, TextView mCase6){
        this.grille = grille;
        //this.colonne = grille.getColonne(colonne);
        this.mCase1 = mCase1;
        this.mCase2 = mCase2;
        this.mCase3 = mCase3;
        this.mCase4 = mCase4;
        this.mCase5 = mCase5;
        this.mCase6 = mCase6;
    }


    @Override
    public void onClick(View v) {

        this.mCase1.setBackgroundResource(R.color.jaune);
        this.mCase2.setBackgroundResource(R.color.jaune);
        this.mCase3.setBackgroundResource(R.color.jaune);
        this.mCase4.setBackgroundResource(R.color.jaune);
        this.mCase5.setBackgroundResource(R.color.jaune);
        this.mCase6.setBackgroundResource(R.color.jaune);
    }
}