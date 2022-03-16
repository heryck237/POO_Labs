import java.security.PublicKey;

enum Direction {
    LEFT, RIGHT
}

/**
 * Interface indicating that an element can move on a map.
 */
interface Movable {
    /**
     * @return the speed of the vehicle.
     */
    int speed();
}

/**
 * Interface indicating that an element can shoot other Movable elements
 */
interface CanShoot {
    /**
     * @return the number of targets that can be destroyed by the tank
     */
    int numberTargets();
}

class Map {

    //TODO attributes
    Movable[] map = new Movable[100];

    /**
     * Adds an element to the map
     *
     * @param movable  the Movable to add
     * @param position the new position of the movable.
     * @return true if the position is valid and empty. False otherwise.
     */
    boolean addElement(Movable movable, int position) {
        //TODO
        if(position > map.length || map[position] != null){
            return false;
        }
       map[position] = movable;
        return true;
    }
    
    /**
     * Move an element from a source position in a given direction
     * The source has to be non-empty and the destination empty and valid.
     *
     * @param from      The source position
     * @param direction The direction in which to move
     * @return True if the movement was valid.
     */
    boolean moveElement(int from, Direction direction) {
       //TODO
        if(direction == Direction.LEFT){
            return addElement(map[from],from - map[from].speed());
        }else {
            return addElement(map[from],from + map[from].speed());
        }
    }

    /**
     * Tries to shoot the targets with the element at the given position
     * @param position the position of the element trying to shoot
     * @param targets the targets to shoot
     * @return true if the element can shoot the targets (not too many, correct element), false otherwise
     */
    boolean shoot(int position, Movable... targets) {
       //TODO
         if(map[position] != null){
            for(int i= 0; i < targets.length ; ++i) {
                if (map[position] == targets[i] && targets.length < 2) {
                    map[position] = null;
                }
            }

        return true;
        }
        return false;
    }

    //TODO other methods if necessary


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Map containing:");
        for (int i = 0; i < map.length; ++i) {
            if (map[i] != null) {
                sb.append("\n");
                sb.append(map[i].getClass().getName()).append("#" + Vehicule.getId()).append(" with speed ").
                        append(map[i].speed());
                if(map[i].getClass() == Tank.class || map[i].getClass() == Canon.class){
                        sb.append(" being able to shoot " +
                                (map[i].getClass() == Tank.class ? 1 : 2) + " targets ");
                }

            sb.append(" at position ").append(i);
            }
        }
        return sb.toString();
    }
}

//TODO other classes

abstract class Vehicule implements Movable{
    private static int numero;
    private static int id = 0;
    public Vehicule(){
        this.id = numero++;
    }

    public static int getId() {
        return id;
    }

    public abstract int speed();
}

class Car extends Vehicule{

    public Car(){
        super();
    }
    @Override
    public int speed() {
        return 10;
    }
}

class Tank extends Vehicule implements CanShoot{
    @Override
    public int speed() {
        return 5;
    }

    @Override
    public int numberTargets() {
        return 1;
    }
}
class Canon extends Vehicule implements CanShoot{

    @Override
    public int speed() {
        return 1;
    }

    @Override
    public int numberTargets() {
        return 2;
    }
}
class TE2 {
    public static void main(String[] args) {
        Map map = new Map();
        Canon canon = new Canon();
        Tank tank = new Tank();
        Car car = new Car();
        Movable otherCar = new Car();
        map.addElement(canon, 3); 
        map.addElement(tank, 8);
        map.addElement(car, 59);
        map.addElement(otherCar, 99);
        System.out.println(map);
        System.out.println("*****");
        System.out.println("Moving otherCar to the right: " + map.moveElement(99, Direction.RIGHT));
        System.out.println("Moving otherCar to the left: " + map.moveElement(99, Direction.LEFT));
        System.out.println("Moving tank to the left: " + map.moveElement(8, Direction.LEFT));
        System.out.println(map);
        System.out.println("*****");
        System.out.println("Tank shooting cars");
        System.out.println("Success: " + map.shoot(8, car, otherCar));
        System.out.println("Canon shooting cars");
        System.out.println("Success: " + map.shoot(3, car, otherCar));
        System.out.println(map);
    }
}