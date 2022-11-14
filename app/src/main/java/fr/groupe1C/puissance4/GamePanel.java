package src.main.java.fr.groupe1C.puissance4;
import javax.swing.*;


public class GamePanel extends JPanel{

    // main
    public static void main(String[] args) {
        // on crée une JFrame avec un JPanel
        JFrame frame = new JFrame("Puissance 4");
        JPanel panel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(700, 700);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.setVisible(true);

        // création de colonnes
        int[] test = {0,1,2,3,4,5};

        Colonne zero = new Colonne();
        Colonne un = new Colonne();
        Colonne deux = new Colonne();
        Colonne trois = new Colonne();
        Colonne quatre = new Colonne();
        Colonne cinq = new Colonne();
        Colonne six = new Colonne();

        zero.setColonne(test);
        un.setColonne(test);
        deux.setColonne(test);
        trois.setColonne(test);
        quatre.setColonne(test);
        cinq.setColonne(test);
        six.setColonne(test);

        Colonne[] colonnes = {zero,un, deux, trois, quatre, cinq, six};

        // on crée une grille
        Grille grille = new Grille(colonnes);
        
        
        // Impression en console de la grille
        for (int i=0;i<6;i++){
            for (int j=0;j<7;j++){
                System.out.print(grille.getGrille()[i][j]);
            }
            System.out.println();
        }
        



    }
    
}
