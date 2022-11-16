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

    private int nb_question,note;


   @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.questionnaire);


        tv = findViewById(R.id.question);

        nb_question = 10;
        note = 10;

        question = new String[nb_question];

        question[0] = "RATIO0";
        question[1] = "RATIO1";
        question[2] = "RATIO2";
        question[3] = "RATIO3";
        question[4] = "RATIO4";
        question[5] = "RATIO5";
        question[6] = "RATIO6";
        question[7] = "RATIO7";
        question[8] = "RATIO8";
        question[9] = "RATIO9";


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

            if(i == 9){
                tv.setText("NOTE :" + note);
            }
            if (v.equals(this.oui[i]) || v.equals(this.non[i])){

                if(v.equals(this.non[i])){
                    if(note > 0){
                        note--;
                    }
                }


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


