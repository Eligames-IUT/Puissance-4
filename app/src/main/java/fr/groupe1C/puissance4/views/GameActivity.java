package fr.groupe1C.puissance4.views;

import android.support.annotation.ColorRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import fr.groupe1C.puissance4.R;
import fr.groupe1C.puissance4.models.Grille;
import fr.groupe1C.puissance4.models.ListenerCol;

public class GameActivity extends AppCompatActivity {

    private Grille grille;

    private TextView mTitre;
    private LinearLayout mGrille;

    private LinearLayout mColonne1;
    private LinearLayout mColonne2;
    private LinearLayout mColonne3;
    private LinearLayout mColonne4;
    private LinearLayout mColonne5;
    private LinearLayout mColonne6;
    private LinearLayout mColonne7;

    private TextView mCase1;
    private TextView mCase2;
    private TextView mCase3;
    private TextView mCase4;
    private TextView mCase5;
    private TextView mCase6;
    private TextView mCase7;
    private TextView mCase8;
    private TextView mCase9;
    private TextView mCase10;
    private TextView mCase11;
    private TextView mCase12;
    private TextView mCase13;
    private TextView mCase14;
    private TextView mCase15;
    private TextView mCase16;
    private TextView mCase17;
    private TextView mCase18;
    private TextView mCase19;
    private TextView mCase20;
    private TextView mCase21;
    private TextView mCase22;
    private TextView mCase23;
    private TextView mCase24;
    private TextView mCase25;
    private TextView mCase26;
    private TextView mCase27;
    private TextView mCase28;
    private TextView mCase29;
    private TextView mCase30;
    private TextView mCase31;
    private TextView mCase32;
    private TextView mCase33;
    private TextView mCase34;
    private TextView mCase35;
    private TextView mCase36;
    private TextView mCase37;
    private TextView mCase38;
    private TextView mCase39;
    private TextView mCase40;
    private TextView mCase41;
    private TextView mCase42;


    private TextView mPlayer1;
    private TextView mPlayer2;

    public void main(String args[]){
        this.grille = new Grille(6,7);
    }

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

        mCase1 = findViewById(R.id.case1);
        mCase2 = findViewById(R.id.case2);
        mCase3 = findViewById(R.id.case3);
        mCase4 = findViewById(R.id.case4);
        mCase5 = findViewById(R.id.case5);
        mCase6 = findViewById(R.id.case6);
        mCase7 = findViewById(R.id.case7);
        mCase8 = findViewById(R.id.case8);
        mCase9 = findViewById(R.id.case9);
        mCase10 = findViewById(R.id.case10);
        mCase11 = findViewById(R.id.case11);
        mCase12 = findViewById(R.id.case12);
        mCase13 = findViewById(R.id.case13);
        mCase14 = findViewById(R.id.case14);
        mCase15 = findViewById(R.id.case15);
        mCase16 = findViewById(R.id.case16);
        mCase17 = findViewById(R.id.case17);
        mCase18 = findViewById(R.id.case18);
        mCase19 = findViewById(R.id.case19);
        mCase20 = findViewById(R.id.case20);
        mCase21 = findViewById(R.id.case21);
        mCase22 = findViewById(R.id.case22);
        mCase23 = findViewById(R.id.case23);
        mCase24 = findViewById(R.id.case24);
        mCase25 = findViewById(R.id.case25);
        mCase26 = findViewById(R.id.case26);
        mCase27 = findViewById(R.id.case27);
        mCase28 = findViewById(R.id.case28);
        mCase29 = findViewById(R.id.case29);
        mCase30 = findViewById(R.id.case30);
        mCase31 = findViewById(R.id.case31);
        mCase32 = findViewById(R.id.case32);
        mCase33 = findViewById(R.id.case33);
        mCase34 = findViewById(R.id.case34);
        mCase35 = findViewById(R.id.case35);
        mCase36 = findViewById(R.id.case36);
        mCase37 = findViewById(R.id.case37);
        mCase38 = findViewById(R.id.case38);
        mCase39 = findViewById(R.id.case39);
        mCase40 = findViewById(R.id.case40);
        mCase41 = findViewById(R.id.case41);
        mCase42 = findViewById(R.id.case42);


        mPlayer1 = findViewById(R.id.j1);
        mPlayer2 = findViewById(R.id.j2);


        mColonne1.setOnClickListener(new ListenerCol(this.grille,1, mCase1, mCase8, mCase15, mCase22, mCase29, mCase36));
        mColonne2.setOnClickListener(new ListenerCol(this.grille, 2, mCase2, mCase9, mCase16, mCase23, mCase30, mCase37));
        mColonne3.setOnClickListener(new ListenerCol(this.grille, 3, mCase3, mCase10, mCase17, mCase24, mCase31, mCase38));
        mColonne4.setOnClickListener(new ListenerCol(this.grille, 4, mCase4, mCase11, mCase18, mCase25, mCase32, mCase39));
        mColonne5.setOnClickListener(new ListenerCol(this.grille, 5, mCase5, mCase12, mCase19, mCase26, mCase33, mCase40));
        mColonne6.setOnClickListener(new ListenerCol(this.grille,6, mCase6, mCase13, mCase20, mCase27, mCase34, mCase41));
        mColonne7.setOnClickListener(new ListenerCol(this.grille, 7, mCase7, mCase14, mCase21, mCase28, mCase35, mCase42));

    }
}