package fr.groupe1C.puissance4.models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Julien Charbonnel
 * @version 1.0
 * @since 1.0
 * Classe qui représente une cellule du plateau de jeu
 */
public class Cellules {

    private static List<Cellules> cellules = new ArrayList<Cellules>();
    private int x;
    private int y;
    private Jetons content = null;
    private int id;

    public Cellules(int x, int y) {
        this.x = x;
        this.y = y;
        this.id = cellules.size();
        cellules.add(this);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Jetons getContent() {
        return content;
    }

    public int getId() {
        return id;
    }

    public void setContent(Jetons content) {
        this.content = content;
    }

    public boolean isAvailable(){
        return this.getContent() == null;
    }
}
