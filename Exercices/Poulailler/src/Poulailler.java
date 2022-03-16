import java.util.*;

interface Oeuf { // Un oeuf (générique) peut eclore et
    Poule eclore(); // faire naître une nouvelle entité
}

class Poule
{
    private String nom; // Nom de la poule
    private Integer nbPontes = 0; // Nombre d’oeufs pondus
    public Poule(String s) {
        nom = s;
    }
    public Oeuf pondre() { // Ponte d’un oeuf (de Poule)
        int pontes = ++nbPontes;
        System.out.println(nom + " pond son oeuf " + nbPontes);

        return new Oeuf(){
            public Poule eclore(){
                Poule poussin = new Poule(nom + pontes);
                System.out.println(poussin + " sort de l'oeuf #" + pontes + " de " + nom);
                return poussin;
            }
        };
    }
    public String toString() {
        return nom ;
    }
}

public class Poulailler
{
    private int tour; // Numéro de tour dans la simulation
    private LinkedList<Poule> poules = new LinkedList<Poule>(); // Poules du poulailler
    private Random random = new Random(); // Générateur aléatoire
    public void ajouter(Poule p) { // Ajout d’une poule dans le poulailler
        poules.add(p);
    }
    public void tourSuivant() { // Nouveau tour (ponte + eclosion)

        LinkedList<Oeuf> oeufs = new LinkedList<>();
        for (Poule p : poules)
            for (int i = random.nextInt(2); i < 2; ++i)
                oeufs.add(p.pondre());

        for (Oeuf oeuf : oeufs)
            poules.add(oeuf.eclore());
    }

    public String toString() {
        StringBuilder bs = new StringBuilder();
        for (Poule p : poules)
            bs.append(p).append('\n');
        return bs.toString();
    }

    public static void main(String[] args) { // Démarrer la simulation
        Poulailler p = new Poulailler(); // d’un poulailler
        p.ajouter(new Poule("Cocotte")); // possédeant au départ 2 poules
        p.ajouter(new Poule("Rosette"));
        System.out.println("Condition initiale:");
        System.out.println(p);
        for (int i = 0; i < 4; i++) // sur 10 tours
        {
            System.out.println();
            System.out.println("========== Tour suivant, itération: " + i + "...");
            p.tourSuivant();
        }
    }
}
