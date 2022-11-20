package fr.groupe1C.puissance4.views;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import fr.groupe1C.puissance4.R;
import fr.groupe1C.puissance4.models.Sondage;

public class Questionnaire extends AppCompatActivity implements View.OnClickListener {

    private TextView tv1;
    private TextView tv2;

    private Sondage sdg;
    private String[] question;
    private Object[] reponse;

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;

    private Button pas_avis;


    private String[] value_of_rb;


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
        tv2.setVisibility(View.GONE);

        nb_question = 10;

        question = new String[nb_question];

        question[0] = "Voulez-vous répondre à un sondage rapide ? (2min)";
        question[1] = "Quel est votre age ?";
        question[2] = "Quel est votre sexe ?";
        question[3] = "Combien de partie(s) avez-vous joué ?";
        question[4] = "Trouvez-vous le jeu facile d'utilisation ?";
        question[5] = "Quel est votre statut ?";
        question[6] = "Quelle est votre situation matrimoniale ?";
        question[7] = "Quels jeux aimeriez-vous voir prochainement sur Eligames?";
        question[8] = "Avec qui jouez-vous ?";
        question[9] = "Aimeriez-vous un mode 3 joueurs ?";

        this.value_of_rb = new String[]{"Homme","Femme","Autre","Hélicoptère","Teletubbies"};


        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        pas_avis = findViewById(R.id.btn6);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        pas_avis.setOnClickListener(this);
        btn3.setVisibility(View.GONE);
        btn4.setVisibility(View.GONE);
        btn5.setVisibility(View.GONE);
        reponse = new Object[nb_question-1];
        it = new Intent(Questionnaire.this,MainActivity.class);
    }

    public static void prepareTabtoSondage(Object[] rep){
        for(int i = 0; i < rep.length; i++){
            if(rep[i] != null){
                if(i == 0 || i == 2){
                    try{
                        rep[i]=Integer.parseInt((String)rep[i]);
                    }
                    catch (NumberFormatException ex){
                        rep[i]=null;
                    }
                }
                else if(i == 3 || i == 8){
                    if(rep[i].equals("OUI")){
                        rep[i] = true;
                    }
                    else if(rep[i].equals("NON")){
                        rep[i] = false;
                    }
                    else{
                        rep[i] = null;
                    }
                }
                else{
                    rep[i] = (String)rep[i];
                }
            }
        }
    }


    @Override
    public void onClick(View v) {


        switch (Questionnaire.index){
            case 0:{

                if(v.equals(this.pas_avis)){
                    startActivity(it);
                }
                tv1.setText(this.question[index]);
                Questionnaire.index++;
                break;
            }

            case 1:{
                if(v.equals(this.btn1)){
                    tv1.setText(this.question[index]);
                    tv2.setInputType(InputType.TYPE_CLASS_NUMBER);
                    tv2.setVisibility(View.VISIBLE);
                    btn1.setText("Valider");
                    btn2.setVisibility(View.GONE);
                }
                if(v.equals(btn2) || v.equals(pas_avis)){
                    startActivity(it);
                }


                Questionnaire.index++;
                break;
            }

            case 2:{


                if(v.equals(this.btn1)){
                    reponse[0] = tv2.getText().toString();
                    this.tv2.setVisibility(View.GONE);
                }
                if(v.equals(this.pas_avis)){
                    reponse[0] = null;
                    this.tv2.setVisibility(View.GONE);
                }

                tv1.setText(this.question[index]);
                this.tv2.setText("");
                this.tv2.setHint("");
                this.btn1.setText("HOMME");
                this.btn2.setText("FEMME");
                this.btn3.setText("AUTRE");
                this.btn4.setText("HELICOPTERE");
                this.btn5.setText("TELETUBBIES");

                this.btn2.setVisibility(View.VISIBLE);
                this.btn3.setVisibility(View.VISIBLE);
                this.btn4.setVisibility(View.INVISIBLE);
                this.btn5.setVisibility(View.INVISIBLE);
                Questionnaire.index++;
                break;

            }

            case 3 :{

                if(v.equals(btn1)){
                    reponse[1]=btn1.getText().toString();
                }
                if(v.equals(btn2)){
                    reponse[1]=btn2.getText().toString();
                }
                if(v.equals(btn3)){
                    reponse[1]=btn3.getText().toString();
                }
                if(v.equals(btn4)){
                    reponse[1]=btn4.getText().toString();
                }
                if(v.equals(btn5)){
                    reponse[1]=btn5.getText().toString();
                }
                if(v.equals(this.pas_avis)){
                    reponse[1] = null;
                }

                tv1.setText(this.question[index]);



                this.tv2.setVisibility(View.VISIBLE);
                this.btn1.setText("Valider");
                this.btn2.setVisibility(View.GONE);
                this.btn3.setVisibility(View.GONE);
                this.btn4.setVisibility(View.GONE);
                this.btn5.setVisibility(View.GONE);

                Questionnaire.index++;
                break;
            }

            case 4 :{

                if(v.equals(this.btn1)){
                    reponse[2] = tv2.getText().toString();
                }
                if(v.equals(this.pas_avis)){
                    reponse[2] = null;
                }


                tv1.setText(this.question[index]);

                tv2.setVisibility(View.GONE);
                tv2.setText("");

                btn3.setVisibility(View.GONE);

                btn1.setText("très facile");
                btn2.setText("facile");
                btn3.setText("difficile");
                btn4.setText("très difficile");

                btn2.setVisibility(View.VISIBLE);
                btn3.setVisibility(View.VISIBLE);
                btn4.setVisibility(View.VISIBLE);
                Questionnaire.index++;
                break;
            }
            case 5 :{
                if(v.equals(this.btn1)){
                    reponse[3] = btn1.getText().toString();
                }
                if(v.equals(this.btn2)){
                    reponse[3] = btn2.getText().toString();
                }
                if(v.equals(this.btn3)){
                    reponse[3] = btn3.getText().toString();
                }
                if(v.equals(this.btn4)){
                    reponse[3] = btn4.getText().toString();
                }
                if(v.equals(this.pas_avis)){
                    reponse[3] = null;
                }

                tv1.setText(this.question[index]);


                this.btn1.setText("étudiant");
                this.btn2.setText("salarié");
                this.btn3.setText("auto-entrepreneur");
                this.btn4.setText("sans profession");
                this.btn5.setText("autre");


                this.btn2.setVisibility(View.VISIBLE);
                this.btn3.setVisibility(View.VISIBLE);
                this.btn4.setVisibility(View.VISIBLE);
                this.btn5.setVisibility(View.VISIBLE);

                Questionnaire.index++;
                break;
            }
            case 6 :{

                if(v.equals(this.btn1)){
                    reponse[4] = btn1.getText().toString();
                }
                if(v.equals(this.btn2)){
                    reponse[4] = btn2.getText().toString();
                }
                if(v.equals(this.btn3)){
                    reponse[4] = btn3.getText().toString();
                }
                if(v.equals(this.btn4)){
                    reponse[4] = btn4.getText().toString();
                }
                if(v.equals(this.btn5)){
                    reponse[4] = btn5.getText().toString();
                }
                if(v.equals(this.pas_avis)){
                    reponse[4] = null;
                }

                tv1.setText(this.question[index]);
                this.tv2.setText("");

                this.btn1.setText("couple");
                this.btn2.setText("célibataire");
                this.btn3.setText("trouple");
                this.btn4.setText("couple libre");

                this.btn5.setVisibility(View.GONE);
                Questionnaire.index++;
                break;
            }
            case 7 :{
                if(v.equals(this.btn1)){
                    reponse[5] = btn1.getText().toString();
                }
                if(v.equals(this.btn2)){
                    reponse[5] = btn2.getText().toString();
                }
                if(v.equals(this.btn3)){
                    reponse[5] = btn3.getText().toString();
                }
                if(v.equals(this.btn4)){
                    reponse[5] = btn4.getText().toString();
                }
                if(v.equals(this.pas_avis)){
                    reponse[5] = null;
                }

                tv1.setText(this.question[index]);

                this.btn1.setText("Snake");
                this.btn2.setText("Bataille navale");
                this.btn3.setText("morpion");
                this.btn4.setText("échec");
                Questionnaire.index++;
                break;
            }
            case 8 :{
                if(v.equals(this.btn1)){
                    reponse[6] = btn1.getText().toString();
                }
                if(v.equals(this.btn2)){
                    reponse[6] = btn2.getText().toString();
                }
                if(v.equals(this.btn3)){
                    reponse[6] = btn3.getText().toString();
                }
                if(v.equals(this.btn4)){
                    reponse[6] = btn4.getText().toString();
                }
                if(v.equals(this.pas_avis)){
                    reponse[6] = null;
                }

                tv1.setText(this.question[index]);

                this.btn1.setText("amis");
                this.btn2.setText("famille");
                this.btn3.setText("moi");
                this.btn4.setText("autre");

                Questionnaire.index++;
                break;
            }

            case 9 :{
                if(v.equals(this.btn1)){
                    reponse[7] = btn1.getText().toString();
                }
                if(v.equals(this.btn2)){
                    reponse[7] = btn2.getText().toString();
                }
                if(v.equals(this.btn3)){
                    reponse[7] = btn3.getText().toString();
                }
                if(v.equals(this.btn4)){
                    reponse[7] = btn4.getText().toString();
                }
                if(v.equals(this.pas_avis)){
                    reponse[7] = null;
                }

                tv1.setText(this.question[index]);
                tv2.setVisibility(View.GONE);
                btn1.setText("OUI");
                btn2.setText("NON");
                btn3.setText("SANS AVIS");
                btn3.setVisibility(View.VISIBLE);
                btn4.setVisibility(View.GONE);
                Questionnaire.index++;
                break;
            }
            case 10:{

                if(v.equals(this.btn1)){
                    reponse[8] = btn1.getText().toString();
                }
                if(v.equals(this.btn2)){
                    reponse[8] = btn2.getText().toString();
                }
                if(v.equals(this.btn3)){
                    reponse[8] = btn3.getText().toString();
                }
                if(v.equals(this.pas_avis)){
                    reponse[8]= null;
                }



//                Questionnaire.prepareTabtoSondage(reponse);
//
//                tv1.setText(reponse[0]+" "+reponse[1]+" "+reponse[2]+" "+reponse[3]+" "+
//                        reponse[4]+" "+reponse[5]+" "+reponse[6]+" "+reponse[7]+" "+reponse[8]);


//                sdg.insertSondage((int)reponse[0],(String)reponse[1],(int)reponse[2],(Boolean)reponse[3],
//                        (String)reponse[4],(String)reponse[5],(String)reponse[6],(String)reponse[7],(Boolean)reponse[8]);

//                sdg = new Sondage(20,"H",5,true,"etudiant","celibataire","Echec","Amis",true);
//                    Sondage.insertSondage(20,"H",5,true,"etudiant","celibataire","Echec","Amis",true);

                tv1.setText("Merci d'avoir repondu !");

                tv2.setText("");
                tv2.setVisibility(View.GONE);

                btn1.setVisibility(View.INVISIBLE);
                btn2.setVisibility(View.INVISIBLE);
                btn3.setVisibility(View.INVISIBLE);
                pas_avis.setVisibility(View.GONE);

                btn4.setText("Retour à l'accueil");
                btn4.setVisibility(View.VISIBLE);

                if(v.equals(btn4)){

                    startActivity(it);
                }

                break;
            }

            default: break;
        }

    }
}
