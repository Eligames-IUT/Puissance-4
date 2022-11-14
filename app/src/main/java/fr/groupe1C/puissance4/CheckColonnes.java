package main.java.fr.groupe1C.puissance4;

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
}