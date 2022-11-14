<<<<<<< HEAD
package fr.groupe1C.puissance4;
=======
package src.main.java.fr.groupe1C.puissance4;

>>>>>>> fd5931944d878e576dc9d64b8b8dcc28f12c1859
public class Colonne {

    private int[] colonne;

    public Colonne(int size){
        this.colonne = new int[size];
        for(int i = 0; i < size; i++) {
            this.colonne[i] = 0;
        }
    }

    public int[] getColonne() {
        return this.colonne;
    }

    public void setPion(int position, int pion) {
        this.colonne[position] = pion;
    }
}