package fr.groupe1C.puissance4.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import fr.groupe1C.puissance4.R;

public class Questionnaire extends AppCompatActivity implements View.OnClickListener {

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private String[] question;
    private Object[] reponse;
    private Button btn1;
    private Button btn2;
    private Button pas_avis;


    private int nb_question;
    private static int index;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.questionnaire);
        Questionnaire.index = 0;

        tv1 = findViewById(R.id.question);
        tv2 = findViewById(R.id.input);
        tv3 = findViewById(R.id.combobox);

        tv3.setVisibility(View.INVISIBLE);
        tv2.setVisibility(View.INVISIBLE);

        nb_question = 10;

        question = new String[nb_question];

        question[0] = "Voulez-vous répondre à un sondage rapide ? (2min)";
        question[1] = "Quel est votre age ?";
        question[2] = "Quel est votre sexe ?";
        question[3] = "Combien de partie(s) avez-vous joué ?";
        question[4] = "Trouvez-vous le jeu facile d'utilisation ?";
        question[5] = "Quel est votre statut ?";
        question[6] = "Quelle est votre situation matrimoniale ?";
        question[7] = "Quels jeux aimeriez-vous voir prochainement ?";
        question[8] = "Avec qui jouez-vous ?";
        question[9] = "Aimeriez-vous un mode 3 joueurs ?";



        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        pas_avis = findViewById(R.id.btn3);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        pas_avis.setOnClickListener(this);

        reponse = new Object[nb_question];
    }

    @Override
    public void onClick(View v) {

        switch (Questionnaire.index){
            case 0:{
                if(v.equals(this.btn1) || v.equals(this.btn2)){
                    tv1.setText(this.question[index]);
                }
                else{

                }
                Questionnaire.index++;
                break;
            }

            case 1:{

                Questionnaire.index++;
                break;
            }

            default: break;
        }

    }
}