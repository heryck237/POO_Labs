package ch.heigvd.app;

/**
 * Auteurs: Akoumba Erica Ludivine, Pontarolo Stefano
 *
 */

import java.util.List;
import java.util.ArrayList;

public class Professeur extends Personne {

  private final String abreviation;
  public List<Lecon> lecons = new ArrayList<>();

  public Professeur(String nom, String prenom,String abreviation) {
    super(nom, prenom);
    this.abreviation = abreviation;
  }

  public String getAbreviation() {
    if(abreviation != null){
      return abreviation;
    }
    return "";
  }

  @Override
  public String toString() {
    return "Prof. " + getPrenom()  + " " + getNom() + " "  + "(" + abreviation + ")" ;
  }

  public String horaire() {
    String out = "";
    for(Lecon lecon : lecons){
      out = Lecon.horaire(lecon);
    }
    return out;
  }

  public void setLecons(Lecon lecon) {
    if(!lecons.contains(lecon)){
      lecons.add(lecon);
    }
  }
}
