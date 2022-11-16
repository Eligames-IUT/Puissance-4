package fr.groupe1C.puissance4.models;

import java.awt.event.*;

/**
 * 
 * @author Julien Charbonnel
 * @version 1.0
 * Classe qui écoute les events des clics sur les colonnes
 * 
 */
public class EcouteCLick extends MouseAdapter {

   private int xPositionSouris;
   private int yPositionSouris;
   Grille plateau;
   Joeur joueur;

   public EcouteCLick(Grille plateau, Joeur joueur) {
      this.plateau = plateau;
      this.joueur = joueur;
   }
   /**
    * méthode qui écoute les events des clics sur les colonnes
    * @param MouseEvent e
    */
   public void mousePressed(MouseEvent e) {
      // récupère la position du clic
      int x = e.getX();
      int y = e.getY();
      // récupère la position de la case cliquée
      int i = (x - 10) / 100;
      int j = (y - 10) / 100;
      // si la case est vide
      if (plateau[i][j] == 0) {
         // si c'est le tour du joueur 1
         if (tour == 1) {
            // on place le pion du joueur 1
            plateau[i][j] = 1;
            // on change le tour
            tour = 2;
         } else {
            // on place le pion du joueur 2
            plateau[i][j] = 2;
            // on change le tour
            tour = 1;
         }
      }
      // on redessine le plateau
      repaint();
   }

   
   /*
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
   */
}
   
