package ObjectList;

/** A class that is akin to an iterator. */
class Examinator {

    Element current;

    Examinator(Element current){
        this.current = current ;
    }

    /** @return true if there are more elements to examinate */
    boolean hasNext() {
        //throw new RuntimeException("Not implemented");
    return current.next != null ;

    }

    /** @return the next element */
    Object next() throws IndexOutOfBoundsException {
      //  RuntimeException("Not implemented");

        if(hasNext()){
            Element e = current.next;
            current = current.next;
            return e.data;
        }
    throw new IndexOutOfBoundsException();
    }
}
