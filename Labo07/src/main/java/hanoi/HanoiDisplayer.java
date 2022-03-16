package hanoi;

/* Auteurs: Akoumba Erica Ludivine, Pontarolo Stefano */

/**
 * Classe qui permet d’afficher une instance de la classe `Hanoi`
 */

public class HanoiDisplayer {

  public void display(Hanoi h) {

    System.out.println(" -- Turn: " + h.turn());
    System.out.println("One  : " + h.aiguille1);
    System.out.println("Two  : " + h.aiguille2);
    System.out.println("Three: " + h.aiguille3);
  }
}
