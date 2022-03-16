package ch.heigvd.app;

/**
 * Auteurs: Akoumba Erica Ludivine, Pontarolo Stefano
 *
 */

public class Etudiant extends Personne {

  private final int matricule;

  public Etudiant(String nom, String prenom, int matricule) {
    super(nom,prenom);
    this.matricule = matricule;
  }

  @Override
  public String toString() {
    return "Etud. " + getPrenom() + " " + getNom()  + " " + "(#" + matricule + ")";
  }
}
