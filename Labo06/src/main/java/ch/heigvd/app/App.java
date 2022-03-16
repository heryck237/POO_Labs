package ch.heigvd.app;

/**
 * Auteurs: Akoumba Erica Ludivine, Pontarolo Stefano
 *
 */
public class App
{
    public static void main( String[] args )
    {


        Professeur p1 = new Professeur("Donini" , "Pier", "PDO");
        Professeur p2 = new Professeur("Evequoz" , "Claude", "CEZ");

        // Définir les trois leçons du cours de POO1 (PDO), la leçon du cours PLP (CEZ) ainsi qu’une leçon TIC (projet non encadré).

        Lecon l1 = new Lecon("POO1", 3,3,2, "G02", p1);
        Lecon l2 = new Lecon("POO1", 3,6,2, "H01", p1);
        Lecon l3 = new Lecon("POO1", 4,3,2, "G03", p1);

        p1.setLecons(l1);
        p1.setLecons(l2);
        p1.setLecons(l3);

        Lecon l4 = new Lecon("PLP", 4,9,3, "H01", p2);
        p2.setLecons(l4);
        Lecon l5 = new Lecon("TIC", 2,10,1, "F06");

        Etudiant e1 = new Etudiant("Lennon","John",1234);
        Etudiant e2 = new Etudiant("Mc Cartney","Paul",2341);
        Etudiant e3 = new Etudiant("Starr","Ringo",3241);
        Etudiant e4 = new Etudiant("Harisson","George",4321);
        Etudiant e5 = new Etudiant("Waters","Roger",1324);
        Etudiant e6 = new Etudiant("Gilmour","David",4312);


        Groupe g1 = new Groupe(6,"IL", 1);
        Groupe g2 = new Groupe(6,"TS", 1);

        g1.setEtudiants(e1);
        g1.setEtudiants(e2);
        g1.setEtudiants(e3);
        g1.setEtudiants(e4);
        g2.setEtudiants(e5);
        g2.setEtudiants(e6);

        g1.definirLecon(l1);
        g1.definirLecon(l2);
        g1.definirLecon(l3);
        g1.definirLecon(l4);
        g1.definirLecon(l5);

        g2.definirLecon(l1);
        g2.definirLecon(l2);
        g2.definirLecon(l3);


        Personne[] personnes = {p1,p2,e1,e2,e3,e4,e5,e6} ;
        for(Personne p : personnes){
            System.out.println(p);
        }

        System.out.println("-- Horaire du groupe " + g1.nom() + " ( " + g1.nombreEtudiant() + " ) etudiants \n" + g1.horaire());

        System.out.println("-- Horaire Prof. " + p1 + "\n" + p1.horaire());


    }
}
