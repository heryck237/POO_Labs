public class Champignons {
    public static void main(String ... args) {
        Champignon amtm = new AmaniteTuMouches();
        ChampignonComestible cdp = new ChampignonDeParis(new Provenance("France"));
        amtm.cueillir();
        cdp.cueillir();
    }
}

abstract class Champignon {
    private boolean estPoison = true;

    public void cueillir() {
        ramasser();
        if (estPoison) {
            System.out.println("Je ricane doucement");
        }
        stocker();
        cuisiner();
        manger();
    }

    public Champignon() {}

   // public Champignon(boolean estPoison) {
   //     this.estPoison = estPoison;
   // }

    public void setEstPoison(boolean b){
        estPoison = b;
    }

    abstract public void stocker();

    public void ramasser() {
        System.out.println("Je suis rammassé(e)");
    }

    public void cuisiner() {
        System.out.println("Je suis cuisiné(e)");
    }

    public void manger() {
        System.out.println("Tu es mort(e)");
    }
}

class AmaniteTuMouches extends Champignon {
    public void stocker() { System.out.println("J'attends mon heure"); }
}

abstract class ChampignonComestible extends Champignon {
  //  public ChampignonComestible() {
  //      super(false);
  //  }

    private Provenance provenance;
  public ChampignonComestible(Provenance provenance){
      this.provenance = provenance;
      super.setEstPoison(false);
  }
    public void ramasser() {
        super.ramasser();
        System.out.println("Ma provenance : " + provenance.getPays());
    }

    public void manger() {
        System.out.println("Je suis un bon champignon!");
    }
}

class ChampignonDeParis extends ChampignonComestible {
    public void stocker() { System.out.println("Je suis mis au frais"); }

    Provenance provenance;

    public ChampignonDeParis(Provenance provenance) {
        super(provenance);
    }

}

class Provenance {
    private final String pays;
    public String getPays() { return pays; }

    public Provenance(String pays) {
        this.pays = pays;
    }
}