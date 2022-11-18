package fr.groupe1C.puissance4.models;

public class Victoire {

    private int[][] grille;

    public Victoire(int[][] grille){
        this.grille=grille;
    }

    public int Result(){
        if (checkcol()==1 || checkline()==1 || checkdiag1()==1 || checkdiag2()==1){
            return 1;
        }else if (checkcol()==2 || checkline()==2 || checkdiag1()==2 || checkdiag2()==2){
            return 2;
        } else {
            return 0;
        }
    }

    protected int checkcol(){
        for(int i=0; i<3; i++){
            for(int j=0; j<7; j++){
                if(grille[i][j]==1 && grille[i+1][j]==1 && grille[i+2][j]==1 && grille[i+3][j]==1){
                    return 1;
                } else if (grille[i][j]==2 && grille[i+1][j]==2 && grille[i+2][j]==2 && grille[i+3][j]==2) {
                    return 2;
                }
            }
        }
        return 0;
    }


    protected int checkline(){
        for(int i=0; i<6; i++){
            for(int j=0; j<4; j++){
                if(grille[i][j]==1 && grille[i][j+1]==1 && grille[i][j+2]==1 && grille[i][j+3]==1){
                    return 1;
                } else if(grille[i][j]==2 && grille[i][j+1]==2 && grille[i][j+2]==2 && grille[i][j+3]==2){
                    return 2;
                }
            }
        }
        return 0;
    }


    protected int checkdiag1(){
        for(int i=0; i<3; i++) {
            for (int j = 0; j < 4; j++) {
                if (grille[i][j] == 1 && grille[i + 1][j + 1] == 1 && grille[i + 2][j + 2] == 1 && grille[i + 3][j + 3] == 1) {
                    return 1;
                } else if (grille[i][j] == 2 && grille[i + 1][j + 1] == 2 && grille[i + 2][j + 2] == 2 && grille[i + 3][j + 3] == 2) {
                    return 2;
                }
            }
        }
        return 0;
    }

    protected int checkdiag2(){
        for(int i=0; i<3; i++){
            for(int j=3; j<7; j++){
                if(grille[i][j]==1 && grille[i+1][j-1]==1 && grille[i+2][j-2]==1 && grille[i+3][j-3]==1){
                    return 1;
                } else if(grille[i][j]==2 && grille[i+1][j-1]==2 && grille[i+2][j-2]==2 && grille[i+3][j-3]==2){
                    return 2;
                }
            }
        }
        return 0;
    }


}
