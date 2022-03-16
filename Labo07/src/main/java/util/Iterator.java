package util;

/* Auteurs: Akoumba Erica Ludivine, Pontarolo Stefano */

/**
 * Classe qui modelise le comportement d'un itérateur sur un element de type Element
 */
public class Iterator {

  Element current;

  public Iterator(Element current) {
    this.current = current;
  }

  /**
   *
   * @return true si l'element current a un element qui le suive
   */
  public boolean hasNext() {
    return current.next != null;
  }

  /**
   *
   * @return le prochaine objet par rapport à l'element current
   */
  public Object next() {
    current = current.next;
    return current.data;
  }
}
