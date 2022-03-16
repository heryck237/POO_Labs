package engine.piece;
/* Auteurs: Akoumba Erica Ludivine, Pontarolo Stefano */

import chess.ChessView;
import chess.PieceType;
import chess.PlayerColor;

public class Bishop extends Piece implements ChessView.UserChoice {

    public Bishop(PieceType type, PlayerColor color) {
        super(type, color);
    }

    @Override
    public String textValue() {
        return "Bishop";
    }

    @Override
    public String toString() {
        return textValue();
    }
}
