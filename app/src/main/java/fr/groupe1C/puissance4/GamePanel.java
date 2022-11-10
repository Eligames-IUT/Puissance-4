import javax.swing.JPanel;



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

        // on crée une grille
        Grille grille = new Grille();
        

        



    }
    
}
