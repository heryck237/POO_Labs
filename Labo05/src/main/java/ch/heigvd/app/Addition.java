package ch.heigvd.app;

/**
 * Classe Addition qui etend Operation et definie la methode operation prend en parametre a b et
 * retourne leur somme
 */
public class Addition extends Operation {
  @Override
  public int operation(int a, int b) {
    return a + b;
  }
}
