package engine.piece;
/* Auteurs: Akoumba Erica Ludivine, Pontarolo Stefano */

import chess.PieceType;
import chess.PlayerColor;

public abstract class Piece {

    private final PieceType type;
    private final PlayerColor color;
    private boolean hasMoved;

    public Piece(PieceType type, PlayerColor color) {
        this.type = type;
        this.color = color;
        hasMoved = false;
    }

    public PieceType getType() {
        return type;
    }

    public PlayerColor getColor() {
        return color;
    }

    public boolean isHasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }
}
