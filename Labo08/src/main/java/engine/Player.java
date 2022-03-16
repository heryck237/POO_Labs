package engine;
/* Auteurs: Akoumba Erica Ludivine, Pontarolo Stefano */

import chess.PlayerColor;


public class Player {
    private final PlayerColor color;

    public Player(PlayerColor color){
        this.color = color;
    }

    public PlayerColor getColor() {
        return color;
    }
}