package chess.figure;

import chess.desk.Cell;

import javax.swing.*;

/**
 * Created by jz36 on 30.04.16.
 */
public abstract class Figure extends JLabel{
    protected boolean figureColor;
    private int[] figureCoord;
    private ImageIcon img;
    public Figure(Cell start){
        if (start.getYCoord() < 4) figureColor = true;
        else figureColor = false;
        if (figureColor) {
            img = new ImageIcon("src/chess/figure/image/b" + getClass().getSimpleName() + ".png");
        }
        else {
            img = new ImageIcon("src/chess/figure/image/w" + getClass().getSimpleName() + ".png");
        }
        this.setIcon(img);
        start.add(this);
    }


    public boolean getFigureColor(){
        return figureColor;
    }

    public int[] getFigureCoord(){
        return figureCoord;
    }

    public abstract boolean makeTurn();
}
