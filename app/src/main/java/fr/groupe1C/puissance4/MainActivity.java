package fr.groupe1C.puissance4;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import fr.groupe1C.puissance4.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;
    private editText mEditText;
    private Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textview);
        mEditText = findViewById(R.id.editext);
        mButton = findViewById(R.id.button);

        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mButton.setEnable(s.toString().length() != 0);
                
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText(mEditText.getText().toString());
            }
        });

        // on ajoute un listener sur la partie texte pour pouvoir modifier le texte
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(mTextView.getText().toString());
            }
        });

    }    

}