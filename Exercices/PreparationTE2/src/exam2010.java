import java.util.ArrayList;

interface Solfegiste{
}
class GenreMusical{
    private String nom;
    private GenreMusical origine;
    private GenreMusical(String nom, GenreMusical origine){
        this.nom = nom;
        this.origine = origine;
    }

    public String getNom() {
        return nom;
    }

    public GenreMusical getOrigine() {
        return origine;
    }
    public final static GenreMusical CLASSIQUE = new GenreMusical("classique",null);
    public final static GenreMusical BAROQUE = new GenreMusical("baroque",null);
    public final static GenreMusical BLUES = new GenreMusical("blues",null);
    public final static GenreMusical JAZZ = new GenreMusical("jazz",BLUES);
    public final static GenreMusical ROCK = new GenreMusical("rock",BLUES);
    public final static GenreMusical HARD_ROCK = new GenreMusical("hard rock",ROCK);
    public final static GenreMusical METAL = new GenreMusical("Metal",HARD_ROCK);

    public final static GenreMusical[] STYLES = {
            CLASSIQUE, BAROQUE,  BLUES, JAZZ, ROCK,
            HARD_ROCK, METAL
    };

}

abstract class Musicien {
    private String nom;

    public Musicien(String nom){
        this.nom = nom;
    }
    @Override
    public String toString() {
        return "Hello je m'appelle "+ nom + " Je suis un : " +
                this.getClass().getName();
    }

    public abstract String specialite();
    public abstract boolean solgegiste();
    public abstract boolean douePour(GenreMusical g);
    public abstract String asperge();

}
class Rocker extends Musicien{

    private GenreMusical genreMusical;
    public Rocker(String nom, GenreMusical genreMusical) {
        super(nom);
        this.genreMusical = genreMusical;
    }

    @Override
    public String toString() {
        super.toString();
        return  " de specialite " + genreMusical.getNom();
    }

    @Override
    public String specialite() {
        return genreMusical.getNom();
    }

    @Override
    public boolean solgegiste() {
        return false;
    }

    @Override
    public boolean douePour(GenreMusical g) {
        if(g ==  genreMusical || g == genreMusical.getOrigine()){
            return true;
        }
        return false;
    }

    @Override
    public String asperge() {
        return "Waouh cool";
    }
}

class MusicienClassique extends Musicien implements Solfegiste{

    public MusicienClassique(String nom) {
        super(nom);
    }

    @Override
    public String specialite() {
        return "Classique";
    }

    @Override
    public boolean solgegiste() {
        return true;
    }

    @Override
    public boolean douePour(GenreMusical g) {
        return false;
    }

    @Override
    public String asperge() {
        return "Do mi sol do";
    }

    @Override
    public String toString() {
        super.toString();
        return " de specialite Classique";
    }
}

class MusicienBaroque extends MusicienClassique{

    public MusicienBaroque(String nom) {
        super(nom);
    }

    @Override
    public String asperge() {
        return "Do Fami lasol do";
    }

    @Override
    public String toString() {
        super.toString();
        return " Je suis un : " +
                this.getClass().getName() + " de specialite Baroque";
    }
}

class exam2010 {

    public static void main(String args[]){
  Musicien m1 = new MusicienBaroque("Charles");
  Musicien m2 = new MusicienClassique("Anatole");
  Musicien m3 = new Rocker("Bob", GenreMusical.METAL);
  Musicien m4 = new Rocker("Sam", GenreMusical.JAZZ);
  Musicien[] ms = {m1,m2,m3,m4};

  for(Musicien m : ms){

      System.out.println(m);
      System.out.println(" Je connais mes gammes : " + m.solgegiste() );
      System.out.println("Mon asperge : " + m.asperge());
      System.out.println("Genres musicaux --");
      for(GenreMusical genre : GenreMusical.STYLES){
          if(m.douePour(genre))
              System.out.println("Je joue du : " + genre.getNom());
      }

      System.out.println();
  }
    }
}
