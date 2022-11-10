package src.main.java.fr.groupe1C.puissance4;
public class Grille {
    
    private int ligne = 6;
    private int colonne = 7;
    private int[][] grille = new int[ligne][colonne];


    public Grille(Colonne[] tabColonne) {
        grille = new int[ligne][colonne];
        for(int i = 0; i < ligne; i++) {
            for(int j = 0; j < colonne; j++) {
                grille[i][j] = tabColonne[j].getColonne()[i];
            }
        }
    }

    // getter de la grille
    public int[][] getGrille() {
        return grille;
    }
    
    
}
