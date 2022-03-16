package engine;
/* Auteurs: Akoumba Erica Ludivine, Pontarolo Stefano */

import chess.PlayerColor;

public class TurnManager {

    Player playerInTurn;
    Player playerNotInTurn;
    Player blackPlayer;
    Player whitePlayer;

    public TurnManager()
    {
        playerInTurn = new Player(PlayerColor.WHITE);
        whitePlayer = playerInTurn;
        playerNotInTurn = new Player(PlayerColor.BLACK);
        blackPlayer = playerNotInTurn;
    }

    public void switchTurn()
    {
        Player temp  = playerInTurn;
        playerInTurn = playerNotInTurn;
        playerNotInTurn = temp;
    }

    public void resetPlayerInTurn() {
        playerInTurn = whitePlayer;
        playerNotInTurn = blackPlayer;
    }
}