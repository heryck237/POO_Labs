public class Chien extends Animal{

    private String nom;
    private Personne proprietaire;
    private String abouament;

    public Chien(String nom, Personne proprietaire) {
        super(nom);
        this.proprietaire = proprietaire;
        abouament = " ouaf ouaf ouaf ";
    }

    public Chien(String nom, Personne proprietaire, String abouament) {
        super(nom);
        this.proprietaire = proprietaire;
        this.abouament = abouament;
    }


    @Override
    public String type() {
        return "Le chien ";
    }

    public String info(){

        return " de " + proprietaire.getNom() + super.info();
    }

    @Override
    public String bruit() {
        return abouament;
    }
}
