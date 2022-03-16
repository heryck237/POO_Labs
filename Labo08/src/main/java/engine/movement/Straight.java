package engine.movement;
/* Auteurs: Akoumba Erica Ludivine, Pontarolo Stefano */

public class Straight implements Move {

    public static Boolean move(int fromX, int fromY, int toX, int toY) {
        return fromX == toX || fromY == toY;
    }
}