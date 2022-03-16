# Exercice 4: Interfaces

Étant donné une interface `Main.Enceinte` et deux classes `Main.Cercle` et `Main.Carre`:

    interface Main.Enceinte {
        double perimetre();
        double surface();
    }

    class Main.Cercle {
        double rayon;
        Main.Cercle(double rayon) {
            this.rayon = rayon;
        }
    }

    class Main.Carre {
        double width;
        Main.Carre(double width) {
            this.width = width;
        }
    }

1. Étendre les classes pour qu'elles implémentent l'interface
   `Main.Enceinte`. Utiliser le programme de test ci-après pour s'assurer que l'implémentation est bonne:

        class TestEnceinte {

            Main.Enceinte[] enceintes = new Main.Enceinte[] {
                    new Main.Cercle(5.0),
                    new Main.Carre(10.0)
            };

            void test() {
                for (Main.Enceinte e : enceintes)
                    System.out.println("surface = " +
                            e.surface() +", périmètre = " +
                            e.perimetre());

            }
            public static void main(String[] args) {
                new TestEnceinte().test();
            }
        }

2. Ajouter à `TestEnceinte` une méthode `Main.Enceinte minPerParSurf(Main.Enceinte[] a)` qui retourne l'enceinte avec le
   périmètre minimal par rapport à la surface (minimum de périmètre / surface). Ajouter du code qui teste cette méthode.

        Main.Enceinte minPerParSurf(Main.Enceinte[] enceintes) {
                double min = Double.MAX_VALUE;
                Main.Enceinte minE = null;
                for (Main.Enceinte e : enceintes) {
                        double perParSurf = e.perimetre() / e.surface();
                        if (perParSurf < min) {
                                min = perParSurf;
                                vminE = e;
                        }
                }
                return minE;
        }
