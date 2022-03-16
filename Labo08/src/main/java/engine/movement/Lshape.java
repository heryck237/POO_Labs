package engine.movement;
/* Auteurs: Akoumba Erica Ludivine, Pontarolo Stefano */

public class Lshape implements Move {

    public static Boolean move(int fromX, int fromY, int toX, int toY) {
        int x = Math.abs(fromX - toX);
        int y = Math.abs(fromY - toY);
        return x * y == 2;
    }
}