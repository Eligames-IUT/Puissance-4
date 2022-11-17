package fr.groupe1C.puissance4.models;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sondage {

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
    public static boolean insertSondage(int age, String sexe, int nbParties, Boolean facililité, String statut, String matrimoniale, String prochainJeux, String avecQui, Boolean mode) {
        Connection conn = connect();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO repSondage VALUES (?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, age);
            ps.setString(2, sexe);
            ps.setInt(3, nbParties);
            ps.setBoolean(4, facililité);
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
                Sondage sondage = new Sondage(rs.getInt("age"), rs.getString("sexe"), rs.getInt("nbParties"), rs.getBoolean("facililité"), rs.getString("statut"), rs.getString("matrimoniale"), rs.getString("prochainJeux"), rs.getString("avecQui"), rs.getBoolean("mode"));
                sondages.add(sondage);
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
            if (sondage.getFacililité()) {
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
    

}
