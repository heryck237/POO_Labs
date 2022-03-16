package util;

/* Auteurs: Akoumba Erica Ludivine, Pontarolo Stefano */

/**
 * Classe qui représente un element et l'element qui le suive
 */
public class Element {
  Object data;
  Element next;

  Element(Object data) {
    this.data = data;
  }

  Element(Object data, Element next) {
    this.data = data;
    this.next = next;
  }
}
