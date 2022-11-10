package fr.groupe1C.puissance4;

public class Puissance4{
    private int[][] grille;

    public Puissance4(){
        
        int[][] puiss4 = new int[6][7]; 
        this.grille = new int[6][7]; 
        this.grille = puiss4;
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                puiss4[i][j]=0;
            }
        }

        // for(int i = 0; i < 6; i++){
        //     for(int j = 0; j < 7; j++){
        //        System.out.println(puiss4[i][j]);
        //     }
        // }        
    }

    public void add(int y,int value){
        for(int i = 5; i >=0; i--){
            if(this.grille[i][y] != 0){
                System.out.println("Occupé");
            }
            else{
                this.grille[i][y]=value;
                System.out.println("Valeur ajoutée");
            }
        }
    }

    @Override
    public String toString() {
        
        String console = new String();
        console = "\n";

        for(int i = 0; i < 6; i++){
            console +="|";
            for(int j = 0; j < 7; j++){
               console += this.grille[i][j]+"|";
            }
            console += "\n";
        }   

        console += "____________________";

        return console;
     }
}