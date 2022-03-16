package engine.piece;
/* Auteurs: Akoumba Erica Ludivine, Pontarolo Stefano */

import chess.ChessView;
import chess.PieceType;
import chess.PlayerColor;

public class Knight extends Piece implements ChessView.UserChoice {

    public Knight(PieceType type, PlayerColor color) {
        super(type, color);
    }


    @Override
    public String textValue() {
        return "Knight";
    }

    @Override
    public String toString() {
        return textValue();
    }
}
