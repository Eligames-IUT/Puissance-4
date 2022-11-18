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

    private String[] question;
    private String[] reponse;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button pas_avis;
    private Intent it;

    private int nb_question;
    private static int index;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.questionnaire);
        Questionnaire.index = 0;

        tv1 = findViewById(R.id.question);
        tv2 = findViewById(R.id.input);
        //tv3 = findViewById(R.id.combobox);


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
        btn3 = findViewById(R.id.btn3);
        pas_avis = findViewById(R.id.btn4);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        pas_avis.setOnClickListener(this);
        btn3.setVisibility(View.INVISIBLE);
        reponse = new String[nb_question];
        it = new Intent(this,MainActivity.class);
    }

    @Override
    public void onClick(View v) {

        switch (Questionnaire.index){
            case 0:{
                if(v.equals(this.btn1) || v.equals(this.btn2)){
                    tv1.setText(this.question[index]);
                }
                if(v.equals(this.pas_avis)){
                    startActivity(it);
                }
                Questionnaire.index++;
                break;
            }

            case 1:{
                if(v.equals(this.btn1)){
                    tv1.setText(this.question[index]);
                    tv2.setInputType(InputType.TYPE_CLASS_NUMBER);
                    tv2.setVisibility(View.VISIBLE);
                    btn1.setText("Valider");
                    btn2.setVisibility(View.INVISIBLE);
                }
                if(v.equals(btn2) || v.equals(pas_avis)){
                    startActivity(it);
                }


                Questionnaire.index++;
                break;
            }

            case 2:{
                if(v.equals(this.btn1)){
                    //String str = (String)tv2.getText();
                    //tv2.setVisibility(View.INVISIBLE);

                    //reponse[0] = str;
                    this.tv2.setVisibility(View.INVISIBLE);
                    this.btn1.setText("Homme");
                    this.btn2.setVisibility(View.VISIBLE);
                    this.btn2.setText("Femme");
                    this.btn3.setVisibility(View.VISIBLE);
                    this.btn3.setText("Autre");
                }
                if(v.equals(this.pas_avis)){
                    //reponse[0] = null;
                }
                tv1.setText(this.question[index]);
                Questionnaire.index++;
                break;
            }

            case 3 :{
                if(v.equals(this.btn1)){

                }
                if(v.equals(this.pas_avis)){

                }

                tv1.setText(this.question[index]);
                this.tv2.setText("");
                this.tv2.setVisibility(View.VISIBLE);
                this.btn1.setText("Valider");
                this.btn2.setVisibility(View.INVISIBLE);
                this.btn3.setVisibility(View.INVISIBLE);

                Questionnaire.index++;
                break;
            }

            case 4 :{
                if(v.equals(this.btn1)){

                }
                if(v.equals(this.pas_avis)){

                }


                tv1.setText(this.question[index]);

                tv2.setVisibility(View.INVISIBLE);


                btn3.setVisibility(View.INVISIBLE);

                btn1.setText("OUI");
                btn2.setText("NON");
                btn2.setVisibility(View.VISIBLE);

                Questionnaire.index++;
                break;
            }
            case 5 :{



                tv1.setText(this.question[index]);
                this.tv2.setText("");
                this.tv2.setInputType(InputType.TYPE_CLASS_TEXT);
                this.tv2.setVisibility(View.VISIBLE);
                this.btn1.setText("Valider");
                this.btn2.setVisibility(View.INVISIBLE);
                this.btn3.setVisibility(View.INVISIBLE);

                Questionnaire.index++;
                break;
            }
            case 6 :{
                tv1.setText(this.question[index]);
                this.tv2.setText("");

                Questionnaire.index++;
                break;
            }
            case 7 :{
                tv1.setText(this.question[index]);
                this.tv2.setText("");

                Questionnaire.index++;
                break;
            }
            case 8 :{
                tv1.setText(this.question[index]);
                this.tv2.setText("");

                Questionnaire.index++;
                break;
            }

            case 9 :{
                tv1.setText(this.question[index]);
                tv2.setVisibility(View.INVISIBLE);
                btn1.setText("OUI");
                btn2.setText("NON");
                btn2.setVisibility(View.VISIBLE);
                Questionnaire.index++;
                break;
            }
            case 10:{
                tv1.setText("Merci d'avoir repondu");
                tv2.setVisibility(View.INVISIBLE);

                btn2.setText("Retour a l'accueil");
                btn1.setVisibility(View.INVISIBLE);
                pas_avis.setVisibility(View.INVISIBLE);
                if(v.equals(btn2)){
                    startActivity(it);
                    Questionnaire.index=0;
                }

                break;
            }

            default: break;
        }

    }
}