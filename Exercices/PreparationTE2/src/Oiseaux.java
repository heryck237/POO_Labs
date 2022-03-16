interface Volant{
    void voler();
}

interface Predateur{
    void attaquer();
}
class Oiseau implements Volant{
public String type(){
    return "je suis de type " + getClass().getName();
}
    @Override
    public void voler() {
        System.out.println("je vole");
    }
}

class Rapace extends Oiseau implements Predateur{
    public void attaquer(){
        System.out.println("sus a l'ennemie");
    }

    public void attaquer(Predateur autre){
        attaquer();
        autre.attaquer();
    }
    public void volerAvec(Rapace autre){
        voler();
        autre.voler();
    }

}

class Aigle extends Rapace{
    public void attaquer(){
        System.out.println("A attaque");
    }
}

class Faucon extends Rapace{
    public void attaquer(){
        System.out.println("Ca plane pour moi");
    }
}
class ExoOiseaux {
    public static void main(String args[]){

        Rapace rapace = new Rapace();
        Aigle aigle = new Aigle();
        Faucon faucon = new Faucon();


        Oiseau o = (Rapace)faucon;
        System.out.println(o.type()); // je suis du type Faucon

        Volant v = faucon;
        v.voler();  // je vole

        faucon.volerAvec(aigle);
       // ((Oiseau) rapace).attaquer(); // Erreur à la compilation attaquer pas défini dans Oiseau

        Oiseau oi = faucon;
        //   rapace = oi;  // erreur de compilation
        //  System.out.println(rapace.type());

      //  oi = rapace;
      //  System.out.println(oi.type()); // je suis de type Rapace

       faucon.attaquer((Rapace)aigle);  // Ca plane pour moi
                                        // A attaque
      //  faucon.volerAvec((Faucon)rapace); // CLASSCAST Exception
      //  rapace.attaquer((Oiseau)aigle);  // Erreur à la compilation  un oiseau n'est pas un prédateur


        // NB : un objet de la classe fille peut être caster en objet de la classe parente mais pas l'inverse



    }
}
