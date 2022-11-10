package fr.groupe1C.puissance4.InterPage;

import fr.groupe1C.puissance4.MainActivity;

import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.view.View;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.content.Intent;
import fr.groupe1C.puissance4.R;

public class Sondage extends AppCompatActivity implements  View.OnClickListener{
   private Button oui1;
   private Button non1;

    private Button oui2;
    private Button non2;


   @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question1);

        oui1 = findViewById(R.id.oui1);
        non1 = findViewById(R.id.oui1);

        oui1.setOnClickListener(this);
        non1.setOnClickListener(this);
        /**
        mAnswer1 = findViewById(R.id.game_activity_button_1);
        mAnswer2 = findViewById(R.id.game_activity_button_2);
        mAnswer3 = findViewById(R.id.game_activity_button_3);
        mAnswer4 = findViewById(R.id.game_activity_button_4);
         **/

   }

    @Override
    public void onClick(View v) {


        if (v.equals(oui1) || v.equals(non1)) {
            getSharedPreferences(SHARED_PREF_USER_INFO, MODE_PRIVATE)
                    .edit()
                    .putString(SHARED_PREF_USER_INFO_NAME, mNameEditText.getText().toString())
                    .apply();

            Intent gameActivityIntent = new Intent(Sondage.this, question2.);
            startActivityForResult(gameActivityIntent, GAME_ACTIVITY_REQUEST_CODE);
        }
        else {
            throw new IllegalStateException("Unknown clicked view : " + v);
        }
}
