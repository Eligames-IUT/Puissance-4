package fr.groupe1C.puissance4.models;

/**
 * 
 * @author Julien Charbonnel
 * @version 1.0
 * Classe qui représente une grille
 * 
 */

public class AlgoGrille {


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
