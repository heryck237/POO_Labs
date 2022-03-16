package ch.heigvd.app;

/**
 * Auteurs: Akoumba Erica Ludivine, Pontarolo Stefano
 *
 */

public abstract class Personne {

  private final String nom;
  private final String prenom;

  public Personne(String nom, String prenom) {
    this.nom = nom;
    this.prenom = prenom;
  }

  @Override
  public abstract String toString();

  public String getNom() {
    return nom;
  }

  public String getPrenom() {
    return prenom;
  }
}
