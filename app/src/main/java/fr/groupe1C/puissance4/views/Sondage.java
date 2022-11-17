package fr.groupe1C.puissance4.models;


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

    // méthode qui permet d'insérer dans la table Sondage les données du sondage
    public static void insertSondage(int age, String sexe, int nbParties, Boolean facililité, String statut, String matrimoniale, String prochainJeux, String avecQui, Boolean mode) {
        Connection conn = connect();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Sondage VALUES (?,?,?,?,?,?,?,?,?)");
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
        } catch (SQLException e) {
            System.out.println("Erreur d'insertion dans la base de données");
            e.printStackTrace();
        }
    }

}
