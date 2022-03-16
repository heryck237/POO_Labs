package engine.movement;
/* Auteurs: Akoumba Erica Ludivine, Pontarolo Stefano */

public class Castling implements Move {

    public static Boolean move(int fromX, int fromY, int toX, int toY) {
        return fromY == toY && (Math.abs(fromX - toX) == 2);
    }
}