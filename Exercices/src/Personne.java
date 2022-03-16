public class Personne extends Animal{

    public Personne(String nom ){
        super(nom);

    }

    @Override
    public String type() {
        return "La personne ";
    }

    @Override
    public String bruit() {
        return " bonjour ";
    }

}
