package fr.groupe1C.puissance4.InterPage;

import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.view.View;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

import fr.groupe1C.puissance4.R;

public class Questionnaire extends AppCompatActivity implements  View.OnClickListener{

    private TextView tv;

    private String[] question;

    private Button[] oui;
    private Button[] non;
    private Button pas_avis1;

    private Button oui2;
    private Button non2;

    private int nb_question,note;


   @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.questionnaire);

        tv = findViewById(R.id.question);

        nb_question = 10;
        note =0;

        String[] question = new String[nb_question];


        oui = new Button[nb_question];
        non = new Button[nb_question];

        oui[0] = findViewById(R.id.oui);
        non[0] = findViewById(R.id.non);
        pas_avis1 = findViewById(R.id.pas_avis1);

        oui[0].setOnClickListener(this);
        non[0].setOnClickListener(this);
        pas_avis1.setOnClickListener(this);
   }

    @Override
    public void onClick(View v) {

        for(int i = 0; i < nb_question; i++) {
            if(i == 0){

                if (v.equals(this.oui[i])){

                    this.oui[i+1] = findViewById(R.id.oui);
                    this.non[i+1] = findViewById(R.id.non);

                    this.oui[i+1].setOnClickListener(this);
                    this.non[i+1].setOnClickListener(this);

                    tv.setText(this.question[i]);
                }
                else if(v.equals(this.non[i])){
                        // premier non
                }
                else{
                    // ne souhaite pas repondre
                }
            }
            else{
                if(v.equals(this.oui[i])){

                    note++;

                    this.oui[i+1] = findViewById(R.id.oui);
                    this.non[i+1] = findViewById(R.id.non);

                    this.oui[i+1].setOnClickListener(this);
                    this.non[i+1].setOnClickListener(this);

                }
                else{
                    if(note > 0){
                        note--;
                    }
                }
            }
        }



    }
}
