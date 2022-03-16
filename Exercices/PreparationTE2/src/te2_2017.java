/*
// ----------------------------------------------------------------------------
// Nom, Prénom:    Nanchen Lionel
// ----------------------------------------------------------------------------

import java.util.*;

interface Util {
    public static final Random random = new Random(0x42);
}

class Poule {} // Ne pas modifier


abstract class Oeuf {
    private int id;

    public Oeuf(int id) {
        this.id = id;
    }

    public int id() {
        return id;
    }

    public String nom() {
        return "l'oeuf de " + type() + " #" + id;
    }

    public abstract Object eclore();

    public abstract String type();
}

class OeufDePoule extends Oeuf {

    public OeufDePoule(int id) {
        super(id);
    }

    public String type() {
        return "poule";
    }

    public Poule eclore() {
        System.out.println("Une nouvelle poule sort de " + nom());
        return new Poule();
    }
}

enum Element {
    Feu, Glace, Tempete, Pierre;

    static public int count() {
        return values().length;
    }

    static public Element random() {
        return values()[Util.random.nextInt(count())];
    }
}

class Dragon {
    private int id;
    private int pontes;
    static private int[] count = new int[Element.count()];
    private Element element;
    private Dragon parent;

    public Dragon() {
        element = Element.random();
        id = ++count[element.ordinal()];
    }

    public Dragon(Dragon parent) {
        this();
        this.parent = parent;
    }

    public Dragon parent() {
        return parent;
    }

    public String nom() {
        return String.format("Dragon de %s #%d", element, id);
    }

    public Oeuf pondre() {
        Oeuf oeuf = new Oeuf(++pontes) {
            final private String type = "dragon";

            public String nom() {
                return super.nom() + " de " + Dragon.this.nom();
            }

            public String type() {
                return "dragon";
            }

            public Dragon eclore() {
                Dragon bebe = new Dragon(Dragon.this);
                System.out.println("Flap! " + bebe.nom() + " sort de " + nom());
                return bebe;
            }
        };
        System.out.println("Ponte de " + oeuf.nom());
        return oeuf;
    }

    public boolean equals(Object o) {
        return o.getClass() == getClass() && ((Dragon) o).element == element;
    }

    static public int[] count() {
        return count;
    }

}

class TE2_2017 {
    public static void main(String... args) {
        // Poules
        Oeuf oeuf = new OeufDePoule(1);
        System.out.println(oeuf.nom());
        Poule p = (Poule) oeuf.eclore();

        // Dragons
        LinkedList dragons = new LinkedList();
        Dragon first = new Dragon();
        dragons.add(first);

        for (int siecle = 1; siecle <= 5; siecle++) {
            LinkedList oeufs = new LinkedList();

            System.out.println("\n+++ Siecle: " + siecle);

            System.out.println("--- Pontes");
            for (Object d : dragons) {
                if (Util.random.nextBoolean())
                    oeufs.add(((Dragon) d).pondre());
            }

            System.out.println("--- Eclosions");
            for (Object o : oeufs)
                dragons.add(((Oeuf) o).eclore());
        }

        System.out.println("\n--- Dragons egaux au premier dragon");
        for (Object d : dragons)
            if (d != first && d.equals(first))
                System.out.println(((Dragon) d).nom() + ", fils de " + ((Dragon) d).parent().nom());
    }
}

*/
