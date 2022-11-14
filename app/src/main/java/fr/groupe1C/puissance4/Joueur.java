package main.java.fr.groupe1C.puissance4;

import java.util.ArrayList;
import java.util.List;

public class Joueur {

    public static List<Joueur> Joueurs = new ArrayList<Joueur>();
    private Integer id;
    private String pseudo;
    private Level level = Level.NO;
    private Color color;
    protected List<Jetons> Jetonss = new ArrayList<Jetons>();

    public Joueur(Color color) {
        Joueurs.add(this);
        this.id = Joueurs.size();
        this.pseudo = "Joueur "+color.name();
        this.color = color;
        initJetonss();
    }

    public void initJetonss(){
        for (int i=0; i < 21;i++){
            Jetons Jetons = new Jetons(this);
            Jetonss.add(Jetons);
        }
    }

    public Color getColor() {
        return color;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

    public String getPseudo() {
        return pseudo;
    }


    /**
    public Cellules placeJetons(int x){
        //Cellules space = CheckColonnes.getInstance().getNextSpaceAvailable(x);
        Jetons Jetons = new Jetons(this);

        if(Jetons.getJoueur() == null)
            return null;

        CheckColonnes.getInstance().getSpaces()[x][space.getY()].setContent(Jetons);

        return space;
    }
    **/

    public List<Jetons> getJetonss() {
        return Jetonss;
    }
}