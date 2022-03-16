# Observer

Le code suivant réalise une source d'événements selon le pattern _Observer_. 
Elle envoie des événements (des strings) à des observateurs qui s'abonnent à elle.

```java
import java.util.*;

public interface Observer {
    void update(String event);
}

public class EventSource {
    private final Set<Observer> observers = new HashSet<>();

    private void notifyObservers(String event) {
        for (Observer o : observers) 
            o.update(event);
    }

    public void addObserver(Observer observer) {
        if (!observers.contains(observer)) 
            observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        if (observer != null)
            observers.remove(observer);
    }

    public void scanSystemIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Text: ");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            notifyObservers(line);
        }
    }
}
```

Le code suivant utilise la source d'événements et crée deux
observateurs qui s'abonnent à elle.

```java
class FirstObserver implements Observer {
    FirstObserver(EventSource eventSource) {
        eventSource.addObserver(this); 
    }

    public void update(String event) {
        System.out.println("FirstObserver received event: " + event);
    }
}

class SecondObserver implements Observer {
    SecondObserver(EventSource eventSource) {
        eventSource.addObserver(this);
    }

    public void update(String event) {
        System.out.println("SecondObserver received event: " + event);
    }
}

class ObserverDemo {
    public static void main(String[] args) {
        EventSource eventSource = new EventSource();

        new FirstObserver(eventSource);
        new SecondObserver(eventSource);

        eventSource.scanSystemIn();
    }
}
```

1. Ajouter une classe `ThirdObserver` qui est instanciée dans la
   méthode `main()` avec `new ThirdObserver(eventSource);` et qui
   reçoit et affiche des événements d'`EventSource` sans implémenter
   directement l'interface `Observer`.

2. Refactoriser le code d'`EventSource` dans deux classes pour séparer
   la gestion des observateurs de la génération d'événements. Le but
   est de rendre la gestion des observateurs réutilisable.

    * Convertir `EventSource` en classe abstraite qui gère les
      observateurs: leur abonnement / désabonnement et leur
      notification.
    * Ajouter une classe concrète `SystemInScanner` qui héberge la
      méthode `scanSystemIn()` et qui a les fonctionnalités d'une
      source d'événements.

   Modifier l'application où nécessaire.

3. Ajouter une classe `FourthObserver` qui reçoit des événements et
   qui réalise un chaînage en passant les événements à un autre
   observateur (en devenant elle-même une source d'événements).

   Instancier dans `main()` une instance de `FourthObserver` qui
   s'abonne à `SystemInScanner` et passe des événements à une instance
   de `FirstObserver`.
