package ch.heigvd.app;

/**
 * Classe Substraction qui etend Operation et definie la methode operation prend en parametre a b et
 * retourne leur difference
 */
public class Substraction extends Operation {
  @Override
  public int operation(int a, int b) {
    return a - b;
  }
}
