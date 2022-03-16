import java.util.*;

enum Element { //TO COMPLETE
    FIRE("FIRE", "flame"),
    ELECTRIC("ELECTRIC", "Sparks"),
    WATER("WATER","Water");

    String name, element;
    Element(String name, String m) {
        this.name = name;
        this.element = m;
    }

        Ring getRing(){

            return new Ring(name) {
                @Override
                void activate() {
                    System.out.println("the ring " + name+ " is shooting " + element);
                }
            };
        }
    }


class Person {
    private String name;
    private Land land;
    private List<Ring> rings = new ArrayList<>();
    int numberOfRing;
    //TO COMPLETE

    public Person(String name, Land land){
        this.name = name;
        this.land = land;
        numberOfRing = 0;

    }
    public void travel(Land land){//TO COMPLETE
        if(land == this.land){
            System.out.println("No travel, You are already here ");
        }else{
            this.land = land;
            System.out.println(name + " travels to: " + land.getName()
           + "("+ land.getType().name() +")");
        }
    }


    public void getRing(){//TO COMPLETE
        ++numberOfRing;
       rings.add(land.getRing());
        System.out.println(name + " gets the ring " + land.getType().getRing() + numberOfRing );
    }

    public void attack(){//TO COMPLETE
        System.out.println(name + " attacks!");
        if(rings.size() == 0)
            return;
        if(numberOfRing < 6) {
            for (Ring r : rings) {
                r.activate();
            }
        }else {
            System.out.println("You are all mighty");
        }


    }

    String displayRings(){
        String str = "";
        int i = 0;
        for(Ring r : rings){
          str += " "+  r.toString() + ++i ;
        }
        return str;
    }


    @Override
    public String toString() {
        if(numberOfRing == 6){
            return name + name + ", in " + land.getName() + ", possesses: " + "MightyRing";
        }
        return name + ", in " + land.getName() + ", possesses: "
                + (numberOfRing == 0 ? "no rings " : ((numberOfRing > 4) ? displayRings() :numberOfRing)); //TO CHANGE
    }
}

class Land{ //DO NOT MODIFY THIS CLASS
    private String name;
    private Element type;

    public Land(String name, Element type){
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Element getType() {
        return type;
    }

    public Ring getRing(){
        return this.type.getRing();
    }

    @Override
    public String toString() {
        return name+"("+type+")";
    }
}

abstract class Ring { //DO NOT MODIFY THIS CLASS
    private String name;

    public Ring(String name){
        this.name = name;
    }


    public Element element(){
        return null;
    }

    abstract void activate();


    @Override
    public String toString() {
        return name;
    }
}



class Test { //DO NOT MODIFY THIS CLASS
    public static void main(String[] args) {
        //Definition of lands
        Land volcano = new Land("volcano", Element.FIRE);
        Land ocean = new Land("ocean", Element.WATER);
        Land powerplant = new Land("powerplant", Element.ELECTRIC);
        Land lake = new Land("lake", Element.WATER);

        //Creation of person
        Person gandalf = new Person("Gandalf", lake);
        System.out.println(gandalf);
        System.out.println("******************");
        //Gandalf travels
        gandalf.travel(volcano);
        gandalf.getRing();
        gandalf.travel(volcano);//We travel to the same place.
        gandalf.getRing();
        gandalf.travel(ocean);
        gandalf.getRing();
        gandalf.travel(lake);
        gandalf.getRing();

        System.out.println("******************");
        //Testing attack
        gandalf.attack();

        System.out.println("******************");
        //Gandalf travels more
        gandalf.travel(powerplant);
        gandalf.getRing();
        System.out.println(gandalf);

        System.out.println("******************");
        //Trying again to get the mighty ring
        gandalf.getRing();
        System.out.println(gandalf);

        System.out.println("******************");
        //Testing attack
        gandalf.attack();


    }

}
