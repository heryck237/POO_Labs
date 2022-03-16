package hanoi;

/* Auteurs: Akoumba Erica Ludivine, Pontarolo Stefano */
import util.Pile;

/**
 * Classe qui représente les trois tours et leurs disques et met à disposition des methodes
 * permettant de déplacer tous les disques de la première tours à la troisième en passant par la
 * deuxieme.
 */
public class Hanoi {
  private final int disks;
  private final HanoiDisplayer displayer;
  private int nbToursDeplaces;
  Pile aiguille1 = new Pile();
  Pile aiguille2 = new Pile();
  Pile aiguille3 = new Pile();

  /**
   * Constructeur générique.
   *
   * @param disks le nombre de disques
   * @param displayer classe permettant d’afficher une instance de la classe Hanoi
   * @throw RunTimeException si le nombre des disques est negatif
   */
  public Hanoi(int disks, HanoiDisplayer displayer) {
    if (disks <= 0) {
      throw new RuntimeException("Disks can't be negative or 0");
    }
    this.disks = disks;
    this.displayer = displayer;
    for (int i = disks; i > 0; --i) {
      aiguille1.push(i);
    }
    nbToursDeplaces = 0;
  }

  /**
   * Constructeur pour l’affichage à la console.
   *
   * @param disks le nombre de disques
   * @throw RunTimeException si le nombre des disques est negatif
   */
  public Hanoi(int disks) {
    this(disks, new HanoiDisplayer());
  }

  /**
   * Déplace tous les disques de la première aiguille à la troisième en affichant les états
   * successifs des aiguilles au moyen de l’instance HanoiDisplayer sélectionnée.
   */
  private void compute(int disks, Pile from, Pile via, Pile to) {
    if (disks > 0) {
      compute(disks - 1, from, to, via);
      to.push(from.pop());
      compute(disks - 1, via, from, to);
    } else {
      displayer.display(this);
      nbToursDeplaces++;
    }
  }

  /** Utilise la fonction compute pour résoudre le problème */
  public void solve() {
    compute(disks, aiguille1, aiguille2, aiguille3);
  }

  /**
   * Pour un tel tableau t, l’élément t[i][j] correspond à la taille du j-ème disque (en partant du
   * haut) de la i-ème aiguille.
   *
   * @return un tableau de tableaux représentant l’état des aiguilles.
   */
  public int[][] status() {

    int[][] stat = new int[3][];
    Pile[] piles = {aiguille1, aiguille2, aiguille3};

    for (int i = 0; i < 3; ++i) {

      Object[] tmp = piles[i].getPile();
      int[] nbDisk = new int[piles[i].size()];
      for (int j = 0; j < piles[i].size(); ++j) {
        nbDisk[j] = (int) tmp[j];
      }
      stat[i] = nbDisk;
    }

    return stat;
  }

  /**
   * @return true si tous les disques on été déplacés de la premiere à la troisieme aiguille, false
   *     sinon.
   */
  public boolean finished() {
    return aiguille3.size() == disks;
  }

  /** @return le nombre de disques déplacés. */
  public int turn() {
    return nbToursDeplaces;
  }
}
