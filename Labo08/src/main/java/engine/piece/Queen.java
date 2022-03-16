package engine.piece;
/* Auteurs: Akoumba Erica Ludivine, Pontarolo Stefano */

import chess.ChessView;
import chess.PieceType;
import chess.PlayerColor;

public class Queen extends Piece implements ChessView.UserChoice {

    public Queen(PieceType type, PlayerColor color) {
        super(type, color);

    }

    @Override
    public String textValue() {
        return "Queen";
    }

    @Override
    public String toString() {
        return textValue();
    }
}
