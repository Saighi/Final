package Elements.Pièces;

import java.util.ArrayList;

import Elements.Plateau;

public class Dame extends Piece{


    public Dame(Equipe e, int x, int y , Plateau p) {
        super(e, x,y,p);
    }

    @Override
    public void deplacements_Possibles() {
        ArrayList<int[]> deplacements= new ArrayList<int[]>();

        int h =0;
        boolean obstacle1=false;
        boolean obstacle2=false;
        boolean obstacle3=false;
        boolean obstacle4=false;
        boolean obstacle5=false;
        boolean obstacle6=false;
        boolean obstacle7=false;
        boolean obstacle8=false;

        do {

            h++;

            if (((x + h) < 8) && !obstacle1)     super.addMove(x + h, y, deplacements);
            if (((y + h) < 8) && !obstacle2)     super.addMove(x, y + h, deplacements);
            if (((x - h) < 8) && !obstacle3)     super.addMove(x - h, y, deplacements);
            if (((y - h) < 8) && !obstacle4)     super.addMove(x, y - h, deplacements);

            if (x+h<8) if (super.p.cases[x+h][y] != null)obstacle1=true;
            if (y+h<8) if (super.p.cases[x][y+h] != null)obstacle2=true;
            if (x-h>0) if (super.p.cases[x-h][y] != null)obstacle3=true;
            if (y-h>0) if (super.p.cases[x][y-h] != null)obstacle4=true;

            if (((x + h) < 8) && ((y + h) < 8) && !obstacle5)     super.addMove(x + h, y + h, deplacements);

            if (((x + h) < 8) && ((y - h) > 0)&& !obstacle6)     super.addMove(x + h, y - h, deplacements);

            if (((x - h) > 0) && ((y + h) < 8)&& !obstacle7)     super.addMove(x - h, y + h, deplacements);

            if (((x - h) > 0) && ((y - h) > 0) && !obstacle8)     super.addMove(x - h, y - h, deplacements);

            if (x+h<8 && y+h<8)if (super.p.cases[x+h][y+h] != null)obstacle5=true;
            if (x+h<8 && y-h>0)if (super.p.cases[x+h][y-h] != null)obstacle6=true;
            if (x-h>0 && y+h<8)if (super.p.cases[x-h][y+h] != null)obstacle7=true;
            if (x-h>0 && y-h>0)if (super.p.cases[x-h][y-h] != null)obstacle8=true;



        }while((x + h) < 8 || (y + h) < 8 || (x - h) > 0 || (y - h) > 0);

        super.deplacements = deplacements;
    }


}
