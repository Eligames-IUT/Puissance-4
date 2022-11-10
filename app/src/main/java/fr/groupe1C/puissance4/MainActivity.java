package fr.groupe1C.puissance4;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import fr.groupe1C.puissance4.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView mGreetingTextView;
    private EditText mNameEditText;
    // on recupere les colonnes avec l'id colonne 1,2,3,4,5,6,7 dans activity_game.xml
    private Button mColonne1;
    private Button mColonne2;
    private Button mColonne3;
    private Button mColonne4;
    private Button mColonne5;
    private Button mColonne6;
    private Button mColonne7;

    private lateinit var binding: ActivityMainBinding




   
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // on récupere les colonnes
        mColonne1 = findViewById(R.id.colonne1);
        mColonne2 = findViewById(R.id.colonne2);
        mColonne3 = findViewById(R.id.colonne3);
        mColonne4 = findViewById(R.id.colonne4);
        mColonne5 = findViewById(R.id.colonne5);
        mColonne6 = findViewById(R.id.colonne6);
        mColonne7 = findViewById(R.id.colonne7);

        // on récupere le textview
        mGreetingTextView = findViewById(R.id.greeting_text);
        // on récupere l'edittext
        mNameEditText = findViewById(R.id.name_edit_text);

        // on ajoute un listener sur les colonnes pour savoir quand on clique dessus
        mColonne1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on affiche un message
                Snackbar.make(v, "Colonne 1", Snackbar.LENGTH_LONG).show();
            }
        });


    }
}
