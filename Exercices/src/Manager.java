import java.util.ArrayList;
import java.util.List;

public class Manager extends Employer{

    List<Vendeur> vendeurs = new ArrayList<Vendeur>();

    public Manager(String nom){
        super(nom);
    }

    public Manager() {

        System.out.println("Manager()");
    }
    public void addVendeur(Vendeur v){
        if(!vendeurs.contains(v))
            vendeurs.add(v);
    }
    public void vendeur(){

        for(Vendeur e :vendeurs ){
            System.out.println(e.getClass().getName());
        }

    }


}
