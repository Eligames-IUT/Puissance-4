package fr.groupe1C.puissance4;

/**
 * 
 * @author Julien Charbonnel
 * @version 1.0
 * 
 */

public class Algorithme {

   /**
    * 
    * @param grille
    * @param joueur
    * @return la colonne ou le joueur doit jouer
    *
    */
   public static int meilleurCoup(int[][] grille, int joueur) {
      int meilleurCoup = 0;
      int meilleurScore = Integer.MIN_VALUE; // on initialise le meilleur score à -infini
      int score;
      for (int i = 0; i < grille[0].length; i++) { // on parcourt les colonnes
         if (grille[0][i] == 0) { // si la colonne n'est pas pleine
            score = minimax(grille, i, joueur); // on calcule le score du coup
            if (score > meilleurScore) { // si le score est meilleur que le meilleur score
               meilleurScore = score; // on met à jour le meilleur score
               meilleurCoup = i; // on met à jour le meilleur coup
            }
         }
      }
      return meilleurCoup;
   }

   // méthode qui écoute les events des clics sur les colonnes
   public void sourisCliquer(MouseEvent e) {
      // on récupère la colonne sur laquelle on a cliqué
      int colonne = e.getX() / 100;
      // on vérifie si la colonne est pleine
      if (colonnePleine(colonne)) {
         // on affiche un message d'erreur
         System.err.println("La colonne est pleine");
      } else {
         // on joue le coup
         jouerColonne(colonne);
      }
   }

   // méthode qui permet au joeur de jouer un coup en cliquant sur une colonne
   public static void jouerColonne(int colonne) {
      // on parcourt les lignes de la colonne
      for (int i = 0; i < Grille.grille.length; i++) {
         // si la case est vide
         if (Grille.grille[i][colonne] == 0) {
            // on joue le coup
            Grille.grille[i][colonne] = Grille.joueurCourant;
            break;
         }
      }
   }


   /**
    * 
    * @param grille
    * @param colonne
    * @return true si il y a un pion dans la colonne, false sinon
    *
    */
   public static boolean pionExistantColonne(int[][] grille, int colonne) {
      boolean pionExistant = false;
      // on verifie dans toute la colonne si il y a un pion
      for (int i = 0; i < grille.length; i++) {
         if (grille[i][colonne] != 0) {
            pionExistant = true;
         }
      }
      return pionExistant;
   }

   /**
    * 
    * @param grille
    * @param colonne
    * @return l'existance d'un pion dans la première ligne de la colonne
    *
    */
   public static boolean colonnePleine(int[][] grille, int colonne) {
      boolean colonnePleine = false;
      if (grille[0][colonne] != 0) { // si la colonne est pleine
         colonnePleine = true;
      }
      return colonnePleine;
   }

   
   /**
    * 
    * @param grille
    * @param couleur
    * @return vrai si il y a 4 pions alignés horizontalement sur la grille
    *
    */
   public boolean ligneHorizontale(int[][] grille, int couleur){
      for(int i=0; i<6; i++){
         for(int j=0; j<4; j++){
            if(grille[i][j]==couleur && grille[i][j+1]==couleur && grille[i][j+2]==couleur && grille[i][j+3]==couleur){
               return true;
            }
         }
      }
      return false;
   }

   /**
    * 
    * @param grille
    * @param couleur
    * @return vrai si il y a 4 pions alignés verticalement sur la grille
    *
    */
   public boolean ligneVerticale(int[][] grille, int couleur){
      for(int i=0; i<3; i++){
         for(int j=0; j<7; j++){
            if(grille[i][j]==couleur && grille[i+1][j]==couleur && grille[i+2][j]==couleur && grille[i+3][j]==couleur){
               return true;
            }
         }
      }
      return false;
   }

   /**
    * 
    * @param grille
    * @param couleur
    * @return vrai si il y a 4 pions alignés en diagonale sur la grille (de gauche à droite)
    *
    */
   public boolean ligneDiagonale(int[][] grille, int couleur){
      for(int i=0; i<3; i++){
         for(int j=0; j<4; j++){
            if(grille[i][j]==couleur && grille[i+1][j+1]==couleur && grille[i+2][j+2]==couleur && grille[i+3][j+3]==couleur){
               return true;
            }
         }
      }
      for(int i=0; i<3; i++){
         for(int j=3; j<7; j++){
            if(grille[i][j]==couleur && grille[i+1][j-1]==couleur && grille[i+2][j-2]==couleur && grille[i+3][j-3]==couleur){
               return true;
            }
         }
      }
      return false;
   }
}
