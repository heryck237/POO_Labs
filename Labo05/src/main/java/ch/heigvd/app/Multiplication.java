package ch.heigvd.app;
/**
 * Classe Multiplication qui etend Operation et definie la methode operation prend en parametre a b
 * et retourne leur produit
 */
public class Multiplication extends Operation {
  @Override
  public int operation(int a, int b) {
    return a * b;
  }
}
