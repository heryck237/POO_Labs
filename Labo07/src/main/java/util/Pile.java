package util;

/* Auteurs: Akoumba Erica Ludivine, Pontarolo Stefano */

/**
 * Classe qui permet de représenter une pile générique
 * (capable de stocker un nombre quelconque d’objets)
 */
public class Pile {

  private Element head;
  private int size;

  /**
   * Insere un objet eu debut d'une pile
   * @param o   Objet a inserer dans la pile
   */
  public void push(Object o) {
    size++;
    if (isEmpty()) {
      head = new Element(o);
    } else {
      head = new Element(o, head);
    }
  }

  /**
   * Supprime le premier element de la pile
   * @return l'element supprimé ou null si la pile est vide
   */
  public Object pop() {

    if (head != null) {
      Object o = head.data;
      head = head.next;
      size--;
      return o;
    }
    return null;
  }

  /**
   * Crée un tableau d'objets représentant l’état actuel de la pile
   * @return un tableau d’objets
   */
  public Object[] getPile() {

    Object[] objects = new Object[size];
    Element tmp = head;

    for (int i = 0; i < size; ++i) {
      objects[i] = tmp.data;
      tmp = tmp.next;
    }
    return objects;
  }

  /**
   * Crée un iterateur sur le premier element de la pile
   * @return un new Iterateur sur la pile
   */
  public Iterator iterator() {
    return new Iterator(head);
  }

  /**
   * Crée un string contenant les elements de la pile.
   * @return un string contenant les elements de la pile entre des crochets,
   *         "[]" si la liste est vide.
   */
  public String toString() {

    if(this.isEmpty()){
      return "";
    }
    StringBuilder s = new StringBuilder("[ ");

    for (Element e = head; e != null; e = e.next) s.append("<").append(e.data).append("> ");
    return s + "]";
  }

  /**
   * Vérifie si la pile est vide
   * @return vrai si la pile est vide, faux si non
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Retourne la taille de la pile
   * @return la taille de la pile
   */
  public int size() {
    return size;
  }
}
