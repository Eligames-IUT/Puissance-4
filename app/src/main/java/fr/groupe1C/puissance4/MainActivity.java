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
import android.widget.TextView;

import java.util.LinkedList;
import java.util.Queue;



public class MainActivity extends AppCompatActivity {

    private TextView mGreetingTextView;
    private EditText mNameEditText;
    // on recupere les colonnes avec l'id colonne 1,2,3,4,5,6,7 dans activity_game.xml
    private Colonne mColonne1;
    private Colonne mColonne2;
    private Colonne mColonne3;
    private Colonne mColonne4;
    private Colonne mColonne5;
    private Colonne mColonne6;
    private Colonne mColonne7;  
    


   
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // on récupere les colonnes dans une file LinkedList<Colonne>
        Queue<Colonne> colonnes = new LinkedList<Colonne>();
        for (int i = 1; i <= 7; i++) {
            int id = getResources().getIdentifier("colonne" + i, "id", getPackageName());
            Button colonne = findViewById(id);
            colonnes.add(new Colonne(colonne));
        }

        // on affiche les colonnes dans la console
        for (Colonne colonne : colonnes) {
            System.out.println(colonne);
        }
    }
}
