package fr.groupe1C.puissance4.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import fr.groupe1C.puissance4.R;

public class GameActivity extends AppCompatActivity {

    private TextView mTitre;
    private LinearLayout mGrille;
    private LinearLayout mColonne1;
    private LinearLayout mColonne2;
    private LinearLayout mColonne3;
    private LinearLayout mColonne4;
    private LinearLayout mColonne5;
    private LinearLayout mColonne6;
    private LinearLayout mColonne7;
    private TextView mPlayer1;
    private TextView mPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mTitre = findViewById(R.id.eligames);
        mGrille = findViewById(R.id.grille);
        mColonne1 = findViewById(R.id.colonne1);
        mColonne2 = findViewById(R.id.colonne2);
        mColonne3 = findViewById(R.id.colonne3);
        mColonne4 = findViewById(R.id.colonne4);
        mColonne5 = findViewById(R.id.colonne5);
        mColonne6 = findViewById(R.id.colonne6);
        mColonne7 = findViewById(R.id.colonne7);
        mPlayer1 = findViewById(R.id.j1);
        mPlayer2 = findViewById(R.id.j2);
    }
}