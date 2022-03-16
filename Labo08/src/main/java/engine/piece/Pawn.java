package engine.piece;
/* Auteurs: Akoumba Erica Ludivine, Pontarolo Stefano */

import chess.PieceType;
import chess.PlayerColor;

public class Pawn extends Piece {

    private boolean hasMoved;

    public Pawn(PieceType type, PlayerColor color) {
        super(type,color);
        hasMoved = false;
    }

    @Override
    public boolean isHasMoved() {
        return hasMoved;
    }

    @Override
    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

}
