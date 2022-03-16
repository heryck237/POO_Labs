package engine.piece;
/* Auteurs: Akoumba Erica Ludivine, Pontarolo Stefano */

import chess.ChessView;
import chess.PieceType;
import chess.PlayerColor;

public class Rook extends Piece implements ChessView.UserChoice {

    boolean hasMoved;

    public Rook(PieceType type, PlayerColor color) {
        super(type, color);
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

    @Override
    public String textValue() {
        return "Rook";
    }

    @Override
    public String toString() {
        return textValue();
    }

}
