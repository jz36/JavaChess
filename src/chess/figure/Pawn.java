package chess.figure;

import chess.desk.Cell;

/**
 * Created by jz36 on 30.04.16.
 */
public class Pawn extends Figure {


    public Pawn(Cell cell) {
        super(cell);
    }

    public boolean makeTurn(){
        return false;
    }


}
