import java.util.Iterator;

public class DequeConstraint1 implements Iterable {
    private final Object[] array;
    int index = 0;

    public DequeConstraint1(int taille) {
        array = new Object[taille];
    }

    public Object add(Object o) {
        Object data = array[index];
        array[index] = o;
        index = (index + 1) % array.length;
        return data;
    }

    public String toString() {
        String s = "[ ";
        for (Object o : this) 
            s += o + " ";
        return s + "]";
    }

    public DequeInterator iterator() {
      return new DequeInterator(array, index);
    }

    public static void main(String...args) {
        DequeConstraint1 dc = new DequeConstraint1(3);

        System.out.println(dc);
        dc.add(1);

        System.out.println(dc);
        dc.add(2);
        System.out.println(dc);
        dc.add(3);
        System.out.println(dc);
        dc.add(4);
        System.out.println(dc);

        System.out.println("-- Affichage avec boucle for simplifiee (Iterable)");
        for (Object o: dc)
            System.out.println(o); 
    }
}


// Implantation de l'interface Iterable  
class DequeInterator implements Iterator {
    private int currentIndex; 
    private boolean firstEl = true;

    private final int startIndex;
    private final Object[] array;

    public DequeInterator(Object[] array, int index) {
      this.array = array;
      this.currentIndex = index;
      this.startIndex = index;
    }

    // Implantation de l'interface Iterator
    public boolean hasNext() {
      if (!firstEl)
        return currentIndex != startIndex;
      firstEl = false;
      return true;
    }

    public Object next() {
      currentIndex = Math.floorMod(currentIndex-1, array.length);
      return array[currentIndex];
    }
}
 
