package chess.figure;

import chess.desk.Cell;

/**
 * Created by jz36 on 30.04.16.
 */
public class King extends Figure {
    public King(Cell start) {
        super(start);
    }

    @Override
    public boolean makeTurn() {
        return false;
    }
}
