package fr.groupe1C.puissance4.models;

// import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sondage {

    private int age;
    private String sexe;
    private int nbParties;
    private String facililité;
    private String statut;
    private String matrimoniale;
    private String prochainJeux;
    private String avecQui;
    private boolean mode;

    // getter age
    public int getAge() {
        return age;
    }

    // getter nbParties
    public int getNbParties() {
        return nbParties;
    }

    // getter facililité
    public String getFacililité() {
        return facililité;
    }

    // getter statut
    public String getStatut() {
        return statut;
    }

    // getter matrimoniale
    public String getMatrimoniale() {
        return matrimoniale;
    }

    // getter prochainJeux
    public String getProchainJeux() {
        return prochainJeux;
    }

    // getter avecQui
    public String getAvecQui() {
        return avecQui;
    }

    // getter mode
    public Boolean getMode() {
        return mode;
    }

    // getter sexe
    public String getSexe() {
        return sexe;
    }

    public Sondage(int age, String sexe, int nbParties, String facililité, String statut, String matrimoniale, String prochainJeux, String avecQui, Boolean mode) {
        this.age = age;
        this.sexe = sexe;
        this.nbParties = nbParties;
        this.facililité = facililité;
        this.statut = statut;
        this.matrimoniale = matrimoniale;
        this.prochainJeux = prochainJeux;
        this.avecQui = avecQui;
        this.mode = mode;       
    }
    

    /**
     * 
     * @return la connexion à la base de données
     * @return null si la connexion n'a pas pu être établie
    */
    public static Connection connect() {
        try{
            String url = "jdbc:mariadb://dwarves.iut-fbleau.fr/dossantoad";
            String user = "dossantoad";
            String password = "314671";
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la base de données");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @author Julien Charbonnel
     * @version 1.0
     * @param age
     * @param sexe
     * @param nbParties
     * @param facililité
     * @param statut
     * @param matrimoniale
     * @param prochainJeux
     * @param avecQui
     * @param mode
     * @return true si l'insertion a réussi et false sinon
     */
    public static boolean insertSondage(int age, String sexe, int nbParties, String facililité, String statut, String matrimoniale, String prochainJeux, String avecQui, Boolean mode) {
        Connection conn = connect();
        try {
            assert conn != null;
            PreparedStatement ps = conn.prepareStatement("INSERT INTO repSondage VALUES (?,?,?,?,?,?,?,?,?)");

            ps.setInt(1, age);
            ps.setString(2, sexe);
            ps.setInt(3, nbParties);
            ps.setString(4, facililité);
            ps.setString(5, statut);
            ps.setString(6, matrimoniale);
            ps.setString(7, prochainJeux);
            ps.setString(8, avecQui);
            ps.setBoolean(9, mode);
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erreur d'insertion dans la base de données");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @author Julien Charbonnel
     * @version 1.0
     * @return les informations du sondage
    */
    public static ArrayList<Sondage> getAllSondage() {
        Connection conn = connect();
        ArrayList<Sondage> sondages = new ArrayList<Sondage>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM repSondage");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sondages.add(new Sondage(rs.getInt("age"), rs.getString("sexe"), rs.getInt("nbParties"), rs.getString("facililité"), rs.getString("statut"), rs.getString("matrimoniale"), rs.getString("prochainJeux"), rs.getString("avecQui"), rs.getBoolean("mode")));
            }
            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erreur de récupération des données de la base de données");
            e.printStackTrace();
        }
        return sondages;
    }

    /**
     * @author Julien Charbonnel
     * @version 1.0
     * 
     */
    public static void moyenne() {
        ArrayList<Sondage> sondages = getAllSondage();
        int age = 0;
        int nbParties = 0;
        int facililité = 0;
        int mode = 0;
        for (Sondage sondage : sondages) {
            age += sondage.getAge();
            nbParties += sondage.getNbParties();
            if (sondage.getFacililité() != null) {
                facililité++;
            }
            if (sondage.getMode()) {
                mode++;
            }
        }
        System.out.println("Moyenne d'age : " + age / sondages.size());
        System.out.println("Moyenne de parties jouées : " + nbParties / sondages.size());
        System.out.println("Pourcentage de personnes qui ont trouvé le jeu facile : " + facililité / sondages.size() * 100 + "%");
        System.out.println("Pourcentage de personnes qui ont joué en mode 2 joueurs : " + mode / sondages.size() * 100 + "%");
    }
/**
    // main pour insérer des données dans la base de données
    public static void main(String[] args) {
        insertSondage(18, "Homme", 10, true, "Etudiant", "Célibataire", "Puissance 4", "Seul", true);
        insertSondage(25, "Homme", 100, true, "Etudiant", "Célibataire", "Puissance 4", "Seul", true);
        insertSondage(30, "Homme", 1000, true, "Etudiant", "Célibataire", "Puissance 4", "Seul", true);
    }
*/

}
