
interface Nageur{
    void nager();
}
class Chat{
    public void nager(){
        System.out.println("je sais nager");
    }
    public void attraperunpoisson(Poisson p){
        poursuivre(p);
        p.croquer();
    }

    public void poursuivre(Nageur n){
        n.nager();
        this.nager();
    }

    public void saccoquineravec(PoissonChat pc){
        pc.chatouillerBarbouillon();

    }
}

class Poisson implements Nageur{

    @Override
    public void nager() {
        System.out.println("comme un poisson dans l'eau");
    }

    public void croquer(){
        System.out.println("attention aux arrêtes");
    }
}

class PoissonChat extends Poisson{

    public void croquer(){
        System.out.println("je suis fait");
    }
    public void chatouillerBarbouillon(){
        System.out.println("Miaouuuu");
    }
}

class testInstanceOf {

    public static void main(String args[]){

        Chat c1 = new Chat();
        Chat c2 = new Chat();
        Poisson p = new Poisson();
        PoissonChat pc = new PoissonChat();


        c1.attraperunpoisson(pc);
    //     c1.poursuivre(c2);  erreur de compilation
   //     c1.saccoquineravec((PoissonChat)p);
        System.out.println(c1.getClass().getName());

    }


}
