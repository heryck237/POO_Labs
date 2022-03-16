package hanoi;

/* Auteurs: Akoumba Erica Ludivine, Pontarolo Stefano */
import hanoi.gui.JHanoi;

/**
 * Class pour tester le fonctionnement du programme.
 * Avec un argument il va utiliser l'affichage à la console
 * Avec zero argument il va lancer l'interface graphique
 * @throw   RunTimeException si on passe plus que un argument
 */

public class App {
  public static void main(String[] args) {
    if (args.length > 1) {
      throw new RuntimeException("Wrong number of parameters!");
    }
    if (args.length == 1) {
      Hanoi hanoi = new Hanoi(Integer.parseInt(args[0]));
      hanoi.solve();
    } else {
      JHanoi ui = new JHanoi();
    }
  }
}
