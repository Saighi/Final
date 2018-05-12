package Elements;

import Elements.Pièces.Equipe;
import Elements.Pièces.Piece;
import Elements.Pièces.Pion;
import Elements.Pièces.Dame;
import Elements.Pièces.Roi;
import Elements.Pièces.Tour;
import Elements.Pièces.Fou;
import Elements.Pièces.Cavalier;

public class Plateau {
    public Piece[][] cases;
    private Roi Wking;
    private Roi Bking;


    public Plateau() {
        cases = new Piece[8][8];

        //Blanc

        new Tour(Equipe.Blanc,0,0, this);
        new Cavalier(Equipe.Blanc,1,0, this);
        new Fou(Equipe.Blanc,2,0, this);
        new Dame(Equipe.Blanc,3,0, this);
        Wking = new Roi(Equipe.Blanc,4,0, this);
        new Fou(Equipe.Blanc,5,0, this);
        new Cavalier(Equipe.Blanc,6,0, this);
        new Tour(Equipe.Blanc,7,0, this);

        new Pion(Equipe.Blanc,0,1, this);
        new Pion(Equipe.Blanc,1,1, this);
        new Pion(Equipe.Blanc,2,1, this);
        new Pion(Equipe.Blanc,3,1, this);
        new Pion(Equipe.Blanc,4,1, this);
        new Pion(Equipe.Blanc,5,1, this);
        new Pion(Equipe.Blanc,6,1, this);
        new Pion(Equipe.Blanc,7,1, this);


        //Noir

        new Tour(Equipe.Noir,0,7, this);
        new Cavalier(Equipe.Noir,1,7, this);
        new Fou(Equipe.Noir,2,7, this);
        new Dame(Equipe.Noir,3,7, this);
        Bking = new Roi(Equipe.Noir,4,7, this);
        new Fou(Equipe.Noir,5,7, this);
        new Cavalier(Equipe.Noir,6,7, this);
        new Tour(Equipe.Noir,7,7, this);

        new Pion(Equipe.Noir,0,6, this);
        new Pion(Equipe.Noir,1,6, this);
        new Pion(Equipe.Noir,2,6, this);
        new Pion(Equipe.Noir,3,6, this);
        new Pion(Equipe.Noir,4,6, this);
        new Pion(Equipe.Noir,5,6, this);
        new Pion(Equipe.Noir,6,6, this);
        new Pion(Equipe.Noir,7,6, this);

    }

    public void updateDeplacements(){

        for (int x =0; x<8; x++) {
            for (int y = 0; y < 8; y++) {

                if(this.cases[x][y]!=null) this.cases[x][y].deplacements_Possibles();

            }
        }

    }

    public Equipe isWon(){

        if(Wking.isCapturee()) {

            System.out.print("Les Noirs ont gagnées");
            return Equipe.Noir;
        }
        else if(Bking.isCapturee()) {

            System.out.print("Les Blancs ont gagnées");
            return Equipe.Blanc;
        }

        return null;
    }

    public boolean checkCase(Piece p, int x, int y){
        if (y>=8 || x>=8 || y<0 ||x<0) return false;


        if (this.cases[x][y] == null) return true;

        else if (this.cases[x][y].e == p.e ) return false;

        else if (this.cases[x][y].e != p.e ) return true;

        return false;
    }

    public boolean checkKing(Piece p, int x, int y){

        if (this.cases[x][y] instanceof Roi && this.cases[x][y].e != p.e) {
            return true;
        }

        return false;
    }

    public Piece getCase(int x, int y) {
        if(x==999 && y==999) return null;
        return this.cases[x][y];
    }

    public Roi getEking(Piece p){

        if(p.e == Equipe.Blanc) return Bking;
        if(p.e == Equipe.Noir) return Wking;

        return null;
    }

    public Roi getking(Piece p){

        if(p.e == Equipe.Blanc) return Wking;
        if(p.e == Equipe.Noir) return Bking;

        return null;
    }

    public void changeCase(Piece p, int x, int y){

        if (this.cases[x][y] !=null) this.cases[x][y].setCapturee(true);
        this.cases[x][y]=p;
    }

    public void setCases(Piece[][] cases) {
        this.cases = cases;
    }
}
