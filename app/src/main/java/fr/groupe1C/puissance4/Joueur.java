package fr.groupe1C.puissance4;
import android.graphics.Color;

import ai.MiniMaxCombined;

import java.awt.Color;

/**
 * 
 * @author Julien Charbonnel
 * @version 1.0
 * Classe qui représente un joueur
 * 
 */
public class Joueur {
    
    private int id;
    private int score;
    private Color couleur;
    private boolean peutJoeur;
    private boolean passerSonTour;

    Algorithme algorithme;
    
    public Joueur(int id) {
        this.id = id;
        this.score = 0;
        this.peutJoeur = true;
        algorithme = new Algorithme();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    /**
     * méthode qui permet au joueur de chosisir une colonne
     * @param colonne
     */
    public void choisirColonne(int colonne) {
        // le joueur clique sur la colonne qu'il veut jouer
        // on vérifie si la colonne est pleine
        if(algorithme.colonnePleine(colonne)) {
            // on affiche un message d'erreur
        }
        else {
            // on joue le coup
            algorithme.jouerColonne(colonne);
        }
        
    }

   /**
   * méthode qui permet au joueur de jouer un tour
   * @param colonne
   */
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

}
