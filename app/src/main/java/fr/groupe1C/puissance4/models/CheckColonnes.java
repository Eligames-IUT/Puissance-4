package fr.groupe1C.puissance4.models;

import java.util.ArrayList;


public class CheckColonnes implements Cloneable{ 

    private static CheckColonnes instance;
    public Cellules[][] Celluless;
    public int width;
    public int height;

    private CheckColonnes(int width, int height) {
        this.width = width;
        this.height = height;
        this.Celluless = new Cellules[width][height];
        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                Celluless[w][h] = new Cellules(w, h);
            }
        }
    }

    public static CheckColonnes getInstance(){
        if(instance==null){
            instance = new CheckColonnes(7,6);
        }
        return instance;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean checkVictory(Cellules lastCellules){
        if(checkColumn(lastCellules) || checkRow(lastCellules) || checkDiagonal(lastCellules)){
            return true;
        }
        return false;
    }

    /**
     * return true si la ligne est gagnante
     * @param lastCellules
     * @return
     */
    private boolean checkRow(Cellules lastCellules) {
        boolean res = false;
        Joueur Joueur = lastCellules.getContent().getJoueur();
        int i = 0;
        int y = lastCellules.getY();
        while(!res && i < 7){
            int newX = lastCellules.getX() + (i - 3);
            if(isNotOut(newX,y)){
                int j = 0;
                do{
                    if(isNotOut(newX+j,y) &&!Celluless[newX + j][y].isAvailable())
                        res = Joueur.equals(Celluless[newX + j][y].getContent().getJoueur());
                    else
                        res = false;
                    j++;
                }while (res && j<4);
            }
            i++;
        }
        return res;
    }

    /**
     * return true si la colonne est pleine
     * @param lastCellules
     * @return
     */
    private boolean checkColumn(Cellules lastCellules) {
        boolean res = false;
        Joueur Joueur = lastCellules.getContent().getJoueur();
        int i = 0;
        int x = lastCellules.getX();
        while(!res && i < 4){
            int newY = lastCellules.getY() - (i + 3);
            if(isNotOut(x,newY)){
                int j = 0;
                do{
                    if(isNotOut(x,newY+j) && !Celluless[x][newY + j].isAvailable())
                        res = Joueur.equals(Celluless[x][newY + j].getContent().getJoueur());
                    else
                        res = false;
                    j++;
                }while (res && j<4);
            }
            i++;
        }
        return res;
    }

    private boolean checkDiagonal(Cellules lastCellules) {
        return checkRisingDiagonal(lastCellules)||checkFailingDiagonal(lastCellules);
    }

    public Cellules[][] getCelluless() {
        return Celluless;
    }


    public Cellules getNextCellulesAvailable(int x) {
        int y = 0;
        Cellules currentCellules = CheckColonnes.getInstance().Celluless[x][y];
        if (!currentCellules.isAvailable()) {
            while (!currentCellules.isAvailable() && y < height-1) {
                currentCellules = this.getNextCellules(currentCellules);
                y++;
            }
        }
        return currentCellules;
    }

    public Cellules getNextCellules(Cellules Cellules){
        return CheckColonnes.getInstance().Celluless[Cellules.getX()][Cellules.getY()+1];
    }

    public Cellules[] getCellulessToPlace(){
        Cellules[] res = new Cellules[7];
        for(int y = 0;y<instance.getWidth();y++){
            res[y]=getNextCellulesAvailable(y);
        }
        return res;
    }

    @Override
    protected CheckColonnes clone() throws CloneNotSupportedException {
        return (CheckColonnes) super.clone();
    }

    public static CheckColonnes manualClone(){
        CheckColonnes initCheckColonnes = CheckColonnes.getInstance();
        CheckColonnes returnedCheckColonnes = new CheckColonnes(7,6);
        returnedCheckColonnes.Celluless = initCheckColonnes.Celluless;
        return returnedCheckColonnes;
    }

    private boolean isNotOut(int x,int y){
        return (x >= 0 && x <= 6)&&(y >=0 && y <= 5);
    }

    /**
     * Regarde si il y a une diagonale descendante
     * @param initCellules
     * @return
     */
    public boolean checkFailingDiagonal(Cellules initCellules){
        boolean res = false;
        Joueur Joueur = initCellules.getContent().getJoueur();
        int i = 0;
        while(!res && i < 6){
            int newX = initCellules.getX() - (3 - i);
            int newY = initCellules.getY() - (i - 3);

            if(isNotOut(newX,newY)){
                int j = 0;
                do{
                    if(isNotOut(newX + j,newY - j) && !Celluless[newX + j][newY - j].isAvailable())
                        res = Joueur.equals(Celluless[newX + j][newY - j].getContent().getJoueur());
                    else
                        res = false;
                    j++;
                }while (res && j<4);
            }
            i++;
        }
        return res;
    }


    /**
     * Regarde si il y a une diagonale montante
     * @param initCellules
     * @return
     */
    public boolean checkRisingDiagonal(Cellules initCellules){
        boolean res = false;
        Joueur Joueur = initCellules.getContent().getJoueur();
        int i = 0;
        while(!res && i < 7){
            int newX = initCellules.getX() + (i - 3);
            int newY = initCellules.getY() + (i - 3);
            if(isNotOut(newX,newY)){
                int j = 0;
                do{
                    if(isNotOut(newX + j,newY + j) && !Celluless[newX + j][newY + j].isAvailable())
                        res = Joueur.equals(Celluless[newX + j][newY + j].getContent().getJoueur());
                    else
                        res = false;
                    j++;
                }while (res && j<4);
            }
            i++;
        }
        return res;
    }

    public static void renew(){
        instance = new CheckColonnes(7,6);
        Joueur.Joueurs = new ArrayList<Joueur>();
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