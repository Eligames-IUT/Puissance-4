package fr.groupe1C.puissance4.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fr.groupe1C.puissance4.R;


public class MainActivity extends AppCompatActivity {

    private TextView mTitle;
    private Button mConnect4;
    private Button mGame2;
    private Button mGame3;
    private Button mGame4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitle = findViewById(R.id.title);
        mConnect4 = findViewById(R.id.p4);
        mGame2 = findViewById(R.id.game2);
        mGame3 = findViewById(R.id.game3);
        mGame4 = findViewById(R.id.game4);

        mConnect4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gameActivityIntent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(gameActivityIntent);
            }
        });
    }
}
