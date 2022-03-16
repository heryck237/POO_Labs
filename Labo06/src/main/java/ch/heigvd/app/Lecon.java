package ch.heigvd.app;

/**
 * Auteurs: Akoumba Erica Ludivine, Pontarolo Stefano
 *
 */

public class Lecon {

    private final String matiere;
    private final int jourSemaine;
    private final int periodDebut;
    private final int duree;
    private final String salle;
    private final static int ROW = 24;
    private final static int COL = 6;
    private static String[][] semaine = new String[ROW][COL];
    private Professeur professeur;

    private static final String separateur = "-------------|";
    private static final String sepVide    = "             |";
    private enum Jour { Lun, Mar, Mer, Jeu, Ven }
    private enum Period{
        premiere("8:30"),
        deuxieme("9:15"),
        troisieme("10:25"),
        quatrieme("11:15"),
        cinquime("12:00"),
        sixieme("13:15"),
        septieme("14:00"),
        huitieme("14:55"),
        neuveieme("15:45"),
        dixieme("16:35"),
        onzieme("17:20");

        private final String heure;

        Period(String heure) {
            this.heure = heure;
        }

        public String getHeure() {
            return heure;
        }

    }
    // définition de base du tableaux contenant les horaire
    static {
        for(int row = 0; row < ROW; row++){
            for(int col = 0; col < COL; col++){
                if(col == 0 && (row == 0 || row%2 !=0)){
                    semaine[row][col] = String.format("%7s", "|");
                }else if(row == 0){
                    for(Jour jour : Jour.values()){
                        semaine[row][col++] = String.format("%4s %9s", jour, "|");
                    }
                }else if(col == 0){
                    int j = 2;
                    for(Period period: Period.values()){
                        semaine[j][0] = String.format("%5s %s", period.getHeure(), "|");
                        j += 2;
                    }
                }else if(row%2 != 0){
                    semaine[row][col] = separateur;
                }else{
                    semaine[row][col] = sepVide;
                }
            }
        }
    }

    /**
     * Constructeur avec touts les parametres
     * @param matiere       nom de la matiere
     * @param jourSemaine   nombre de la semaine (lun = 1)
     * @param periodDebut   nombre du period de debut de la lecon (8:30 = 1)
     * @param duree         nombre des periodes
     * @param salle         nom de la salle
     * @param professeur    professeur qui donne la lecon
     */
    public Lecon(String matiere, int jourSemaine, int periodDebut, int duree, String salle, Professeur professeur){
        this.matiere = matiere;
        this.jourSemaine = jourSemaine;
        this.periodDebut = periodDebut;
        this.duree = duree;
        this.salle = salle;
        this.professeur = professeur;

    }

    /**
     * Constructeur sans professeur
     * @param matiere       nom de la matiere
     * @param jourSemaine   nombre de la semaine (lun = 1)
     * @param periodDebut   nombre du period de debut de la lecon (8:30 = 1)
     * @param duree         nombre des periodes
     * @param salle         nom de la salle
     */
    public Lecon(String matiere, int jourSemaine, int periodDebut, int duree, String salle){
        this(matiere, jourSemaine, periodDebut, duree, salle, null);

    }

    /**
     * Fonction dedié à populer le tableau avec le lecons
     * @param lecon     une lecon à ajouter au tableau
     * @return          une string qui represent le tableau des lecon dans le bonne format
     */
    public static String horaire(Lecon lecon){

        // on commence avec la ligne 2 et colonne 1 parce que les deux primieres lignes e la priemere colonne sont dèjà definit staticment
        for(int row = 2; row < 24; ++row){
            for(int col = 1; col < 6; ++col){
                if(row%2 != 0){
                    if(col == lecon.jourSemaine){
                        if(row > lecon.periodDebut * 2 && row <= lecon.periodDebut * 2 + lecon.duree) {
                            semaine[row][col] = sepVide;
                        }
                    }
                }else{
                    if(lecon.periodDebut * 2 == row){
                        if(col == lecon.jourSemaine) {
                            if (lecon.professeur != null) {
                                semaine[row][col] = String.format("%4S %3S %3S %1s", lecon.matiere, lecon.salle, lecon.professeur.getAbreviation(), "|");
                            } else {
                                semaine[row][col] = String.format("%4S %3S %3S %1s", lecon.matiere, lecon.salle, "", "|");
                            }
                        }
                    }
                }
            }
        }
        // maintenant que on a le tableau complet on peut le transformer en string pour faire le return
        StringBuilder out = new StringBuilder("");
        for (String[] strings : semaine) {
            for (String string : strings) {
                out.append(string);
            }
            out.append("\n");
        }
        return out.toString();
    }
}
