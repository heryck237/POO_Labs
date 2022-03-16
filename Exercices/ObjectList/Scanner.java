package list;

// ----------------------------------------------------------------------------
// Classe Scanner (publique)
// ----------------------------------------------------------------------------

public class Scanner
{
  private Element current;
  
  // Constructeur de visibilite package seulement.
  // Positionnement de l'element courant _avant_ l'element reference.

  Scanner(Element e)
  {
    current = new Element(null, e);
  }

  public boolean hasNext()
  {
    return current.next != null;
  }
     
  public Object next()
  {
    current = current.next;
    return current.data;
  }
}

