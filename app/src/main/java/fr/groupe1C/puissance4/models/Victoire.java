package fr.groupe1C.puissance4.models;

public class Victoire {

    private boolean etatJeu;
    private AlgoGrille AlgoGrille;

    public Victoire() {
        this.etatJeu = false;
    }
    
    public boolean getEtatJeu() {
        return etatJeu;
    }

    public void setEtatJeu(boolean etatJeu) {
        this.etatJeu = etatJeu;
    }

    // méthode conditions de victoire
    public boolean victoire(Grille grille) {
        // on utilise les méthodes de la classe AlgoGrille pour vérifier les conditions de victoire
        if (AlgoGrille.ligneDiagonale(grille.getGrille(), 1) || AlgoGrille.ligneDiagonale(grille.getGrille(), 2) || AlgoGrille.ligneHorizontale(grille.getGrille(), 1) || AlgoGrille.ligneHorizontale(grille.getGrille(), 2) || AlgoGrille.ligneVerticale(grille.getGrille(), 1) || AlgoGrille.ligneVerticale(grille.getGrille(), 2)) {
            setEtatJeu(etatJeu = true);
            return true;
        }
        return false;
    }


}
