import java.util.HashSet;
import java.util.Set;

enum TypeCarte{
    PIQUE,
    COEUR,
    CARREAU,
    TREFLE
}
enum Valeur{
    DEUX(2), TROIS(3), QUATRE(4), CINQ(5), SIX(6), SEPT(7),
    HUIT(8), NEUF(9), DIX(10), VALET(11), REINE(12), ROI(13), AS(14);
    private final int v;
    Valeur(int v) { this.v = v; }
    int getV() { return v; }
}

class Carte {
    TypeCarte typeCarte;
    Valeur valeur;

    public Carte(TypeCarte typeCarte, Valeur valeur){
        this.typeCarte = typeCarte;
        this.valeur = valeur;
    }
    public Valeur getValeur() {
        return valeur;
    }

    public String toString(){
        return valeur+ " de " + typeCarte;
    }
    public static int valeurMain(Set<Carte> main) {
        int valeur = 0;
        for (Carte carte : main) {
            valeur += carte.getValeur().getV();
        }
        return valeur;
    }
}

class jeu{
    public static void main(String[] args){

        Carte[] cartes = new Carte[TypeCarte.values().length * Valeur.values().length];
        int i = 0;
        for (TypeCarte t : TypeCarte.values()) {
            for (Valeur v : Valeur.values()) {
                cartes[i++] = new Carte(t, v);
            }
        }
        System.out.println("Jeu de " + cartes.length + " cartes:");
        for (Carte carte : cartes) {
            System.out.println(carte);
        }

        Set<Carte> main = new HashSet<>();
        main.add(new Carte(TypeCarte.PIQUE,Valeur.AS));
        main.add(new Carte(TypeCarte.CARREAU,Valeur.DIX));
        System.out.println(Carte.valeurMain(main));
    }
}
