package fr.groupe1C.puissance4;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.view.View;

public class ListenerCol extends Activity implements OnClickListener {

    @Override
    public void onClick(View v) {
        System.out.println("Je suis une colonne ?");
    }
}