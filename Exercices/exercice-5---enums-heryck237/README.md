#### Objectifs pédagogiques

* Se familiariser avec les types énumérés sûrs

* Savoir réutiliser toutes les méthodes offertes pour éviter la duplication de fonctionnalités

#### Description

Représenter un jeu de cartes dans un programme Java. Un [jeu de cartes français de 52 cartes](https://fr.wikipedia.org/wiki/Jeu_de_cartes_français)
est organisé en

* quatre _enseignes_: pique, coeur, carreau, trèfle; et 
* treize _valeurs_: deux, trois, ..., dix, valet, dame, roi, as

(La valeur de l'as diffère selon le jeu, ici on suppose que les as
sont plus forts que les rois.)

* Écire une classe `Carte` qui permet de représenter avec une instance
  une carte du jeu. Utiliser les types énumérés sûrs en réutilisant au
  maximum leurs fonctionnalités.

* Écrire un programme de test qui crée un jeu de cartes complet et
  affiche les cartes. 

        Jeu de 52 cartes:
        DEUX de PIQUE
        TROIS de PIQUE
        QUATRE de PIQUE
        [...]
        ROI de PIQUE
        AS de PIQUE
        DEUX de COEUR
        TROIS de COEUR
        QUATRE de COEUR
        [...]

* Modifier la classe `Carte` pour ajouter une méthode qui calcule la
  valeur d'une "main" (les cartes en possession d'un joueur). Passer
  la main dans une collection (laquelle est la mieux adaptée?).

    * deux vaut 2
    * trois vaut 3
    * ...
    * valet vaut 11
    * ...
    * as vaut 14
