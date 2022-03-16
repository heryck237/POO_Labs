public class NouvelleStar
{
 public static void main(String[] args)
 {

  final int NBR_VOTES = 150;
  final int POURCENTAGE_MAX = 100;
  final String ZERO_CANDIDAT = "Il n'existe pas de candidats !";
  final String FORMATAGE     = ".............................." +
                               ".............................." +
                               ".........................\n"    +
                               ".............................." +
                               "...................................\n";

  java.util.Random random = new java.util.Random(0);
  int nbrCandidats = 0;
  int tmp = 0; // Valeur temporaire qui sera utilisee dans le calcul des pourcentages

  if (args.length == 0)
   System.out.println(ZERO_CANDIDAT);
  else {
   nbrCandidats = args.length;
   System.out.println("Candidat" + (nbrCandidats < 2 ? "" : "s:"));

   for (int i = 0; i < nbrCandidats; ++i)
   {
    System.out.println("#" + i + " " + args[i]);
   }

   System.out.println( "\n" + NBR_VOTES +  " votes");
   System.out.println(FORMATAGE);

   System.out.println("Résultats:");

   int votesParCandidat[] = new int[nbrCandidats];

   for (int i = 0; i < NBR_VOTES ; ++i)
   {
    tmp = random.nextInt(nbrCandidats);
    ++votesParCandidat[tmp];
   }

   int pourcentage = 0;
   for (int i = 0; i < nbrCandidats ; ++i)
   {
    pourcentage = votesParCandidat[i] * POURCENTAGE_MAX / NBR_VOTES ;
    System.out.println( pourcentage + "%" + " " + args[i]);
   }
  }
 }
}

/*
 On peut donc en déduire que le paramètre args qui est transmis à la méthode main
 est un tableau de string contenant les arguments de la ligne de commande.
*/
