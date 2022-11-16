package fr.groupe1C.puissance4.models;


public class GamePanel{

    // main
    public static void main(String[] args) {


        // on crÃ©e une grille de 7 colonnes et 6 lignes
        Grille grille = new Grille(6,7);


        // Impression en console de la grille
        for (int i=0;i<6;i++){
            for (int j=0;j<7;j++){
                System.out.print(grille.getGrille()[i][j]);
            }
            System.out.println();
        }




    }

}