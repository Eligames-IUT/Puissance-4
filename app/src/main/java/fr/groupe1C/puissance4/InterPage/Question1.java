package fr.groupe1C.puissance4.InterPage;

import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.view.View;
import android.os.Bundle;
import android.content.Intent;
import fr.groupe1C.puissance4.R;

public class Question1 extends AppCompatActivity implements  View.OnClickListener{

    private Button oui1;
    private Button non1;
    private Button pas_avis;

    private Button oui2;
    private Button non2;


   @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.question1);

        oui1 = findViewById(R.id.oui1);
        non1 = findViewById(R.id.oui1);
        pas_avis = findViewById(R.id.pas_avis1);

        oui1.setOnClickListener(this);
        non1.setOnClickListener(this);
        pas_avis.setOnClickListener(this);
   }

    @Override
    public void onClick(View v) {


        if (v.equals(this.oui1) || v.equals(this.non1)) {
            Intent next = new Intent(this, Question2.class);
            this.startActivity(next);
        } else if (v.equals(pas_avis)) {

        } else {
            throw new IllegalStateException("Unknown clicked view : " + v);
        }
    }
}
