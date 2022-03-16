public class Vendeur extends Employer{

    Manager manager;

    public Vendeur(Manager man , String nom){
        super(nom);
        manager = man ;
    }

    @Override
    public String toString() {
        String managerName = manager != null ? " " + manager : "";
        return super.toString() + managerName;
    }

    public void definirManager(Manager man){
        this.manager = man ;
    }
}
