public class Employer {

    private String nom;

    public void definirNom(String nom){
        this.nom = nom;
    }

    public Employer(String s){
        definirNom(s);
        System.out.println("Employe(String)");
    }

    public Employer(){
        this("?");
        System.out.println("Employe()");
    }

    @Override
    public String toString() {
        return getClass().getName() + " " + nom;
    }
}
