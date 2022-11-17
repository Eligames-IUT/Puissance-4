package fr.groupe1C.puissance4.models;

import android.view.View.OnClickListener;
import android.app.Activity;
import android.view.View;
import android.util.Log;
import android.widget.TextView;

import fr.groupe1C.puissance4.R;

public class Joueur extends Activity implements OnClickListener {

    private int joueur=1;

    @Override
    public void onClick(View v) {
        if (this.joueur==1){
            this.joueur=2;
        } else {
            this.joueur=1;
        }
        Log.d("", ""+this.joueur);
    }

    public int getJoueur(){
        return this.joueur;
    }

}
