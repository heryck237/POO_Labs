# Exercice 3: ObjectList


Implémentation (purement académique) d’une classe ObjectList définissant une liste générique, simplement chaînée d’Object et offrant les méthodes:

    boolean isEmpty()
    int size()
    void insert(Object o)
    void append(Object o)
    void remove(Object o)
    Object get(int index)
    String toString()
    Examinator examinator()

Examinator est une classe iterateur simplifiée offrant les méthodes:

    boolean hasNext()
    Object next()

Ne pas laisser transparaître les détails d’implémentation (encapsulation): définir un module et des attributs privés.

Liste: référence sur le premier élément. 
Chaque élément contient une donnée et une référence sur l’élément suivant.

	class Element 
    {
        Object data;
        Element next;
    }
	public class ObjectList 
    {
        private Element head;
    }
	public class Examinator
    {
        private Element current;
    }

