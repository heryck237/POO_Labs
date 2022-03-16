import java.util.ArrayList;
import java.util.List;

abstract class Entity{
    private Location location ;
    static List<Entity> entities = new ArrayList<>();

    public Entity(Location location){
        this.location = location;
        entities.add(this);
    }

    void speak(){
        System.out.println(name() + " says " + words());
    }

    void move(Location location){
        this.location = location;
        System.out.println(name() + " move to " + location.name());
    }
    static void printEntities(){
        for(Entity e : entities){
            System.out.println(e.name());
        }

    }

    public Location getLocation() {
        return location;
    }

    abstract String name();
    abstract String words();
}

enum Location{
    //  List<Entity> entities = new ArrayList<>();
    Lorien(Race.elfe),
    Mordor(Race.orcs),
    Rohan(Race.humains),
    Gondor(Race.humains);

    private final Race race;
    Location(Race race) {
        this.race = race;
    }

    public Race getRace() {
        return race;
    }
}

class Bird extends Entity{
    private final int id;
    private static int count = 0;

    public Bird(Location location){
        super(location);
        this.id = count++;

    }

    @Override
    String name() {
        return "Bird #" + id;
    }

    @Override
    String words() {
        return " 'Chirp'";
    }
}

enum Race{
    elfe,
    orcs,
    humains
}

class Wizard extends Entity{

    private final String name;

    public Wizard(String name, Location location){
        super(location);
        this.name = name;
    }

    @Override
    String name() {
        return name;
    }


    Bird invokeBird(){
        Bird b = new Bird(getLocation()){
            String words(){
                return "'I see " + getLocation().getRace().name() + "'";
            }

            void move(Location location){
                super.move(location);
                super.speak();
                if(location == Wizard.this.getLocation()){
                    System.out.println(name() + " has found its master "
                            + Wizard.this.name + " !");
                }
            }

        };

        System.out.println(name() + " invokes " + b.name());
        return b;
    }
    @Override
    String words() {
        return "I'm " + name + " the wise";
    }
}
class LotR{

    public static void main(String[] args) {


        System.out.println("-- Standard bird");
        Bird b1 = new Bird(Location.Lorien);
        b1.speak();
        b1.move(Location.Mordor);
        System.out.println("\n-- Gandalf");
        Wizard gandalf = new Wizard("Gandalf", Location.Lorien);
        gandalf.speak();
        Bird b2 = gandalf.invokeBird();
        b2.move(Location.Rohan);
        System.out.println("\n-- Saruman");
        Wizard saruman = new Wizard("Saruman", Location.Rohan);
        saruman.speak();
        Bird b3 = saruman.invokeBird();
        b3.move(Location.Lorien);
        saruman.move(Location.Gondor);
        b3.move(Location.Gondor);
        System.out.println("\n-- Existing entities");
        Entity.printEntities();
    }
}
