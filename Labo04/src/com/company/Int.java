/*
 * Auteurs: Akoumba Erica Ludivine, Stefano Pontarolo
 */
package com.company;

public class Int {

  private int i;

  public Int(int i) {
    this.i = i;
  }

  public int getI() {
    return i;
  }

  public void setI(int i) {
    this.i = i;
  }

  /**
   * Méthode qui échange la valeur de l'object Int avec celle de l'object passé en paramètre
   *
   * @param nombre Object Int qui va echanger la valeur avec l'object où la méthode va être appelée
   */
  public void exchange(Int nombre) {
    var tmp = this.i;
    this.i = nombre.i;
    nombre.i = tmp;
  }

  @Override
  public String toString() {
    return Integer.toString(i);
  }
}
