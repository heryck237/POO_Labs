package engine.movement;
/* Auteurs: Akoumba Erica Ludivine, Pontarolo Stefano */

public class Diagonal implements Move {

    public static boolean move(int fromX, int fromY, int toX, int toY) {
        return Math.abs(fromX -  toX) == Math.abs(fromY - toY);
    }
}
