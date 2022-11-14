package fr.groupe1C.puissance4;
import android.widget.LinearLayout;
import android.os.Bundle;
import android.view.View;
public class Grille {

    private int ligne;
    private int colonne;
    private int[][] grille;
    private Colonne[] colonnes;
    private LinearLayout[] viewCol;


    public Grille(int ligne,int colonne) {
        this.ligne=ligne;
        this.colonne=colonne;
        this.grille = new int[ligne][colonne];
        this.colonnes = new Colonne[colonne];
        this.viewCol = new LinearLayout[colonne];

        // Initialise la grille vide
        for(int i = 0; i < ligne; i++) {
            for(int j = 0; j < colonne; j++) {
                grille[i][j] = 0;
            }
            this.colonnes[i] = new Colonne(ligne);
        }

        // récupère l'élément XML corespondant à chaque colonne
        viewCol[0] = findViewById(R.id.colonne1);
        viewCol[1] = findViewById(R.id.colonne2);
        viewCol[2] = findViewById(R.id.colonne3);
        viewCol[3] = findViewById(R.id.colonne4);
        viewCol[4] = findViewById(R.id.colonne5);
        viewCol[5] = findViewById(R.id.colonne6);
        viewCol[6] = findViewById(R.id.colonne7);

        // Place un Listener sur chaque colonne
        for(int n = 0; n < colonne; n++) {
            viewCol[n].setOnClickListener(new ListenerCol());
        }

    }

    // getter de la grille
    public int[][] getGrille() {
        return grille;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

}