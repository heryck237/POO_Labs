 
class Test {
    Personne paul;
    Personne ringo;
    Voiture fiat;
    Voiture audi;
    Voiture bmw;

    private void creerObjets() {
        paul = new Personne("Paul");
        ringo = new Personne("Ringo");
        fiat = new Voiture("Fiat");
        audi = new Voiture("Audi");
        bmw = new Voiture("BMW");
    }

    private void creerAssociations() {
        // Paul possède une Fiat
        paul.ajouterVoiture(fiat);
        // Paul possède une Audi
        paul.ajouterVoiture(audi);
        // Ringo possède une BMW
        ringo.ajouterVoiture(bmw);
    }

    private void afficherEtat() {
        System.out.println(paul);
        System.out.println(ringo);
        System.out.println(fiat);
        System.out.println(audi);
        System.out.println(bmw);
    }

    void testPersonneVoiture() {
        System.out.println("Création des objets et associations");
        creerObjets();
        creerAssociations();
        afficherEtat();
        // Ringo vend sa BMW à Paul
        System.out.println("Ringo vend sa BMW à Paul (ajouterVoiture)");
        paul.ajouterVoiture(bmw);
        afficherEtat();
        // Paul abandonne la Fiat
        System.out.println("Paul abandonne la Fiat (enleverVoiture)");
        paul.enleverVoiture(fiat);
        afficherEtat();
    }

    void testVoiturePersonne() {
        System.out.println("Création des objets et associations");
        creerObjets();
        creerAssociations();
        afficherEtat();
        // Ringo vend sa BMW à Paul
        System.out.println("Ringo vend sa BMW à Paul (definirProprietaire)");
        bmw.setProprietaire(paul);
        afficherEtat();
        // Paul abandonne la Fiat
        System.out.println("Paul abandonne la Fiat (definirProprietaire)");
        fiat.setProprietaire(null);
        afficherEtat();
    }

    void test() {
        testPersonneVoiture();
        testVoiturePersonne();
    }

    public static void main(String[] args) {
        new Test().test();
    }
}
