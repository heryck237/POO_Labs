import chess.*;
import chess.views.console.ConsoleView;
import chess.views.gui.GUIView;
import engine.Controller;
/* Auteurs: Akoumba Erica Ludivine, Pontarolo Stefano */

/**
 * Jeu d'échecs
 */
public class StudentChess
{
    public static void main( String[] args )
    {
        // 1. Création du contrôleur pour gérer le jeu d’échecs
        ChessController controller = new Controller();
        // 2. Création de la vue désirée
        ChessView view = new GUIView(controller) ; // mode GUI
       // ChessView view = new ConsoleView(controller) ; // ou mode Console

        // 3. Lancement du programme
        controller.start(view) ;
    }
}