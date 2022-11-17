package fr.groupe1C.puissance4.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fr.groupe1C.puissance4.R;

public class Questionnaire extends AppCompatActivity implements  View.OnClickListener{

    private TextView tv;

    private String[] question;

    private Button[] oui;
    private Button[] non;
    private Button pas_avis;

    private Button oui2;
    private Button non2;

    private int nb_question;


   @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.questionnaire);


        tv = findViewById(R.id.question);

        nb_question = 11;

        question = new String[nb_question];

        question[0] = "Voulez-vous répondre à un sondage rapide ? (2min)";
        question[1] = "Quel est votre age ?";
        question[2] = "Quel est votre sexe ?";
        question[3] = "Combien de partie(s) avez-vous joué ?";
        question[4] = "Trouvez-vous le jeu facile d'utilisation ?";
        question[5] = "Quel est votre statut ?";
        question[6] = "Quel est votre situation patrimoniale ?";
        question[7] = "Quels jeux aimeriez-vous voir prochainement ?";
        question[8] = "Avec qui jouez-vous ?";
        question[9] = "Aimeriez-vous un mode 3 joueurs ?";


        oui = new Button[nb_question];
        non = new Button[nb_question];
        pas_avis = findViewById(R.id.pas_avis1);


        oui[0] = findViewById(R.id.oui);
        non[0] = findViewById(R.id.non);

        pas_avis = findViewById(R.id.pas_avis1);

        oui[0].setOnClickListener(this);
        non[0].setOnClickListener(this);
        pas_avis.setOnClickListener(this);

   }

    @Override
    public void onClick(View v) {

        if(v.equals(pas_avis)){
            Intent gameActivityIntent = new Intent(this, MainActivity.class);
            startActivity(gameActivityIntent);
        }

            for(int i = 0; i < nb_question; i++){

                if(i == 0){
                    pas_avis.setVisibility(View.INVISIBLE);
                }

                if (v.equals(this.oui[i]) || v.equals(this.non[i])){

                    this.oui[i] = null;
                    this.non[i] = null;

                    this.oui[i+1] = findViewById(R.id.oui);
                    this.non[i+1] = findViewById(R.id.non);

                    this.oui[i+1].setOnClickListener(this);
                    this.non[i+1].setOnClickListener(this);

                    tv.setText(question[i]);
                    break;
                }
            }


   }
}


