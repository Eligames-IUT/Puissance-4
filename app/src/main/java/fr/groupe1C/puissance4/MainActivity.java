package src.main.java.fr.groupe1C.puissance4;

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
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.Queue;



public class MainActivity extends AppCompatActivity {

    private TextView mGreetingTextView;
    private EditText mNameEditText;
    // on recupere les colonnes avec l'id colonne 1,2,3,4,5,6,7 dans activity_game.xml
    private GridLayout mColonne1;
    private GridLayout mColonne2;
    private GridLayout mColonne3;
    private GridLayout mColonne4;
    private GridLayout mColonne5;
    private GridLayout mColonne6;
    private GridLayout mColonne7;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // on récupere les colonnes dans une file LinkedList<Colonne>
        Queue<GridLayout> colonnes = new LinkedList<>();
        mColonne1 = findViewById(R.id.colonne1);
        mColonne2 = findViewById(R.id.colonne2);
        mColonne3 = findViewById(R.id.colonne3);
        mColonne4 = findViewById(R.id.colonne4);
        mColonne5 = findViewById(R.id.colonne5);
        mColonne6 = findViewById(R.id.colonne6);
        mColonne7 = findViewById(R.id.colonne7);

        colonnes.add(new GridLayout(mColonne1));
        colonnes.add(new GridLayout(mColonne2));
        colonnes.add(new GridLayout(mColonne3));
        colonnes.add(new GridLayout(mColonne4));
        colonnes.add(new GridLayout(mColonne5));
        colonnes.add(new GridLayout(mColonne6));
        colonnes.add(new GridLayout(mColonne7));
        /*for (int i = 1; i <= 7; i++) {
            int id = getResources().getIdentifier("colonne" + i, "id", getPackageName());
        }*/

        // on affiche les colonnes dans la console
        for (Colonne colonne : colonnes) {
            System.out.println(colonne);
        }
    }
}
