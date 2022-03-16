
import java.util.ArrayList;

public class Detecteurs {
    public static void main(String ... args) {
        // Partie 1
        /*
        Detecteur d = new Detecteur("HEIG-VD", Incident.Incendie);
        System.out.println(d);
        d.signalerIncident();
        */


        // Partie 2
        Centrale
                police = new Centrale("Police"),
                securitas = new Centrale("Securitas");

        Detecteur
                d1 = police.installerDetecteur("Immeuble", Incident.Panne),
                d2 = police.installerDetecteur("Immeuble", Incident.Incendie),
                d3 = police.installerDetecteur("Stade", Incident.Incendie),
                d4 = police.installerDetecteur("Stade", Incident.Innondation),
                d5 = securitas.installerDetecteur("Maison", Incident.Intrusion),
                d6 = securitas.installerDetecteur("Immeuble", Incident.Intrusion);

        d1.signalerIncident();
        d5.signalerIncident();
        d4.signalerIncident();

        police.afficher();
        securitas.afficher();
    }
}

enum Incident { Incendie, Panne, Innondation, Intrusion }

class Detecteur {
    // Fourni
    private int numéro;
    private String lieu;
    private Incident type;

    public void signalerIncident() {
        System.out.println("Beep! Alarme du " + this + ".");
    }

    // Ajout
    private static int prochainNuméro = 1;

    public Detecteur(String lieu, Incident type) {
        this.lieu = lieu;
        this.type = type;
        this.numéro = prochainNuméro++;
    }

    public String toString() {
        return "détecteur #" + numéro + " (" + lieu + "), type: " + type;
    }
}

class Centrale {
    // Fourni
    private String nom;

    public Centrale(String nom) {
        this.nom = nom;
    }

    // Ajout
    private ArrayList<Detecteur> alarmed = new ArrayList<>();

    public Detecteur installerDetecteur(String lieu, Incident type) {
        return new DetecteurCentrale(lieu, type, this);
    }

    public void afficher() {
        System.out.println("Alarmes de la centrale " + nom);

        for (Detecteur detecteur: alarmed) {
            System.out.println("- " + detecteur);
        }
    }

    public void nouvelIncident(Detecteur detecteur) {
        System.out.println("Centrale " + nom + ": alerte du détecteur " + detecteur + " enregistrée.");
        alarmed.add(detecteur);
    }
}

class DetecteurCentrale extends Detecteur {
    Centrale centrale;

    public DetecteurCentrale(String lieu, Incident type, Centrale centrale) {
        super(lieu, type);
        this.centrale = centrale;
    }

    public void signalerIncident() {
        super.signalerIncident();
        centrale.nouvelIncident(this);
    }
}