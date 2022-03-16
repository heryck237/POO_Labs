package ch.heigvd.app;

/**
 * Auteurs: Akoumba Erica Ludivine, Pontarolo Stefano
 *
 */

import java.util.ArrayList;
import java.util.List;

public class Groupe {

    private final int numero;
    private final String orientation;
    private final int trimestre;
    public List<Lecon> lecon = new ArrayList<>();
    public List<Etudiant> etudiants = new ArrayList<>();

    /**
     *
     * @param numero        numero du groupe
     * @param orientation   orientation du groupe
     * @param trimestre     trimestre du groupe
     */
    public Groupe(int numero, String orientation, int trimestre){
        this.numero = numero;
        this.orientation = orientation;
        this.trimestre = trimestre;
    }

    /**
     * Fonction pour imprimer l'horaire d'un groupe
     * @return  un string qui repèresent l'horaire du groupe
     */
    public String horaire(){
        String str = "";
        for(Lecon lecons : lecon){
            str=Lecon.horaire(lecons);
        }
        return str;
    }

    /**
     * Fonction pour avoir le nom du groupe dans le bon format
     * @return      string qui represent le nom du groupe
     */
    public String nom(){
        return orientation + numero + "-" + trimestre;
    }

    /**
     * Fonction pour compter le nombre d'etudiantes dans un groupe
     * @return      le nombre d'etudiantes
     */
    public int nombreEtudiant(){
        if(etudiants.isEmpty()){
            return 0;
        }else {
            int cnt = 0;
            for (Etudiant e : etudiants) {
                cnt++;
            }
            return cnt;
        }
    }

    /**
     * Fonction qui ajoute une lecon au groupe
     * @param newLecon      nouvelle lecon à ajouter
     */
    public void definirLecon(Lecon newLecon){
        if(!lecon.contains(newLecon)){
            lecon.add(newLecon);
        }
    }

    /**
     * Fonction pour ajouter un etudiant au groupe
     * @param etudiant      nouvel etudiant à ajouter
     */
    public void setEtudiants(Etudiant etudiant) {
        if(!etudiants.contains(etudiant)){
            etudiants.add(etudiant);

        }
    }
}
