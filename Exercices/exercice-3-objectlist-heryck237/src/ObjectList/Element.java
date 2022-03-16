package ObjectList;

class Element {
    Object data;
    Element next;

    Element(Object data) {
        this.data = data;
    }

    Element(Object data, Element next) {
        this.data = data;
        this.next = next;
    }


}
