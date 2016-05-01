package chess.desk;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jz36 on 30.04.16.
 */
public class Cell extends JPanel {
    private int coord;
    public Cell(int x, int y){
        if ((x+y)%2 == 0) {
            this.setBackground(Color.GRAY);
        }
        else{
            this.setBackground(Color.WHITE);
        }
        coord = x + y*10;
    }
    public int getYCoord(){
        return coord / 10;

    }


    public int getXCoord(){
        return coord % 10;
    }

}
