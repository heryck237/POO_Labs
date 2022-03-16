public abstract class Animal {
    private String nom;
    public abstract String type();
    public abstract String bruit();

    public String info(){
        return " s'exprime ";
    }

    public Animal(String nom){this.nom = nom;}

    public String getNom() {
        return nom;
    }

    public String parler(){
        return type() + nom + info() + bruit();
    }


}
