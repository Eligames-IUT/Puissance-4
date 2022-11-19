package fr.groupe1C.puissance4.models;

import android.app.Activity;
import android.view.View;

import fr.groupe1C.puissance4.views.GameActivity;

public class NextActivity extends Activity implements View.OnClickListener {

    private GameActivity papa;

    public NextActivity(GameActivity papa){
        this.papa=papa;
    }

    @Override
    public void onClick(View view) {
        this.papa.toQuestionnaire();
    }
}

