import java.awt.Color;

public class Joueur {
    
    private int id;
    private int score;
    private Color couleur;
    private boolean peutJoeur;
    private boolean passerSonTour;

    Algorithme algorithme;
    
    public Joueur(int id) {
        this.id = id;
        this.score = 0;
        this.peutJoeur = true;
        algorithme = new Algorithme();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    /**
     * méthode qui permet au joueur de chosisir une colonne
     * @param colonne
     */
    public void choisirColonne(int colonne) {
        // le joueur clique sur la colonne qu'il veut jouer
        // on vérifie si la colonne est pleine
        if(algorithme.colonnePleine(colonne)) {
            // on affiche un message d'erreur
        }
        else {
            // on joue le coup
            algorithme.jouerColonne(colonne);
        }
        
    }

}
