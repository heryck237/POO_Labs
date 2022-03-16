package ObjectList;

/** An implementation of untyped list of objects */
class ObjectList {
    Element head;



    /**
     * Check if the list is empty
     *
     * @return true iff the list is empty
     */
    boolean isEmpty() {
       // throw new RuntimeException("Not implemented");
        return head == null;
    }

    /**
     * Get the number of elements in the list
     *
     * @return Number of elements in the list
     */

    int size() {
        //throw new RuntimeException("Not implemented");
        int cpt = 0 ;
        Element current = head ;

        while (current.next != null) {
            current = current.next;
            cpt++;
        }

      return cpt ;
    }


    /**
     * Insert an object at the start of the list
     *
     * @param o the object to insert
     */
    void insert(Object o) {
        //throw new RuntimeException("Not implemented");
        Element start = new Element(o);

        start.next = head.next.next ;
        head.next = start;

    }

    /**
     * Insert an object at the end of the list
     *
     * @param o the object to insert
     */

    void append(Object o) {
        //throw new RuntimeException("Not implemented");
        Element nextElt = new Element(o) ;
        Element current = head.next ;

        for(int i = 0 ; i < size() ; ++i) {

            if (current != null) {
                current = current.next;
            }else{
                break;
            }
        }

            nextElt.next = current.next;
            current.next = nextElt ;


    }


    /**
     * Remove an object from the list
     *
     * @param o the object to remove
     */

    void remove(Object o) {
     //   throw new RuntimeException("Not implemented");
        Element beforeCurrent = null ;
        Element current = head ;

        int i = 0 ;
        while (i < size() && current.next.data != o) {
            beforeCurrent = current ;
            current = current.next ;
            ++i ;
        }
        beforeCurrent.next = current ;

    }


    /**
     * Return the object at the specified index
     *
     * @param index the zero-based index of the object.
     * @throws IndexOutOfBoundsException if the index is out of bound
     */
    Object get(int index) throws IndexOutOfBoundsException {
       // throw new RuntimeException("Not implemented");

      int i = 0 ;

      Element beforeCurrent = null;
      Element current = head;

      while (i != index && current.next != null) {
          beforeCurrent = current ;
          current = current.next ;
          ++i ;
      }


      return beforeCurrent.data ;

    }

    /** Return a string containing all elements of the list
     * @return "" if the list is empty else the string representations of all elements separated by a space eg: "1 2 3" for a list containing 1,2 and 3.
     */

    public String toString() {
       // throw new RuntimeException("Not implemented");
        String s = "";
        Element current = head;
        int i = 0;
        while (i < size() && current.next != null){
            s = current.next.data.toString() + (i == size() -1 ? "" : " ");
            current = current.next ;
            ++i;
        }

        return s ;
    }


    /** @return an examinator for this list */
     Examinator examinator() {

         return new Examinator(head);

        //throw new RuntimeException("Not implemented");
    }
}
