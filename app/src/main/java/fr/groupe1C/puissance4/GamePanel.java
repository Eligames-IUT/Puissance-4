package fr.groupe1C.puissance4;


<<<<<<< HEAD
public class GamePanel{
=======
public class GamePanel extends JPanel{
>>>>>>> fd5931944d878e576dc9d64b8b8dcc28f12c1859

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