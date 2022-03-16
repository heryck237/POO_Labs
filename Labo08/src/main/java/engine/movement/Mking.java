package engine.movement;
/* Auteurs: Akoumba Erica Ludivine, Pontarolo Stefano */

public class Mking implements Move {

    public static Boolean move(int fromX, int fromY, int toX, int toY) {
        return Math.abs(fromX - toX) < 2 && Math.abs(fromY - toY) < 2;
    }
}
