/*
  Auteurs: Akoumba Erica Ludivine, Stefano Pontarolo
 */

package com.company;

public class Main {

  /**
   * Méthode permettant d’échanger la valeur de deux objets `Int'
   * @param tab une tableau de Int a trier
   */
  public static void sortInt(Int[] tab) {
    if (tab.length > 0) {
      boolean fini = false;
      int taille = tab.length;

      while (!fini) {
        fini = true;
        for (int i = 0; i < taille - 1; ++i) {
          Int tmp = new Int(0);
          if (tab[i].getI() > tab[i + 1].getI()) {
            tmp.setI(tab[i].getI());
            tab[i].setI(tab[i + 1].getI());
            tab[i + 1].setI(tmp.getI());
            fini = false;
          }
        }
        --taille;
      }
    }
  }

  /**
   * Méthode permettant d’échanger deux éléments d’un tableau d’objets `Int`
   * @param tab une tableau de Int a trier
   */
  public static void sortSwitchInt(Int[] tab) {
    if (tab.length > 0) {
      boolean fini = false;
      int taille = tab.length;

      while (!fini) {
        fini = true;
        for (int i = 0; i < taille - 1; ++i) {
          Int tmp;
          if (tab[i].getI() > tab[i + 1].getI()) {
            tmp = tab[i];
            tab[i] = tab[i + 1];
            tab[i + 1] = tmp;
            fini = false;
          }
        }
        --taille;
      }
    }
  }

  /**
   * Fonction qui utilise une méthode dans la classe `Int` permettant
   * d’échanger la valeur de l’objet courant avec celle d’un
   * autre objet `Int'
   * @param tab une tableau de Int a trier
   */
  public static void sortEchange(Int[] tab) {
    if (tab.length > 0) {
      boolean fini = false;
      int taille = tab.length;

      while (!fini) {
        fini = true;
        for (int i = 0; i < taille - 1; ++i) {
          if (tab[i].getI() > tab[i + 1].getI()) {
            tab[i].exchange(tab[i + 1]);
            fini = false;
          }
        }
        --taille;
      }
    }
  }

  public static void main(String[] args) {

    if (args.length == 0) {
      return;
    }

    Int[] tab = new Int[args.length];

    for (int i = 0; i < args.length; ++i) {
      String s = args[i];
      int nombre = 0;
      s = s.replaceAll("[^0-9-+]", "");
      for (int j = 0; j < s.length(); ++j) {

        int addNombre =
            Character.getNumericValue(s.charAt(j)) * (int) Math.pow(10, (s.length() - (j + 1)));
        if (s.charAt(0) == '-' && j != 0) {
          nombre -= addNombre;
        } else if (s.charAt(0) != '-') {
          nombre += addNombre;
        }
      }
      tab[i] = new Int(nombre);
    }

    for (Int j : tab) {
      System.out.print(j.getI() + " ");
    }

    sortInt(tab);
    sortSwitchInt(tab);
    sortEchange(tab);

    System.out.print("\n");
    for (Int j : tab) {
      System.out.print(j.getI() + " ");
    }
  }
}
