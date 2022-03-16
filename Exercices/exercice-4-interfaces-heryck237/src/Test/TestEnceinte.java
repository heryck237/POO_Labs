package Test;

import Main.*;

public class TestEnceinte {

  Enceinte[] enceintes = new Enceinte[] {new Cercle(5.0), new Carre(10.0)};

  public static void main(String[] args) {
    new TestEnceinte().test();
    Cercle a = new Cercle(3.2);
    Cercle b = new Cercle(3.2);
    Carre c = new Carre(4);
    Carre d = new Carre(3);

    Enceinte[] enceintes = {a, b, c, d};

    System.out.println(new TestEnceinte().minPerParSurf(enceintes));
  }

  void test() {
    for (Enceinte e : enceintes)
      System.out.println("surface = " + e.surface() + ", périmètre = " + e.perimetre());
  }

  String minPerParSurf(Enceinte[] enceintes) {
    double min = Double.MAX_VALUE;  // Nous donne la plus grande valeur d'un double
    Enceinte minE = null;
    for (Enceinte e : enceintes) {
      double perParSurf = e.perimetre() / e.surface();
      if (perParSurf < min) {
        min = perParSurf;
        minE = e;
      }
    }
    assert minE != null;
    return minE.toString();  // je peux retourner l'index du tableau ou alors redefinir toString
  }
}
