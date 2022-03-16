package ch.heigvd.app;

/**
 * Auteurs: Akoumba Erica Ludivine, Pontarolo Stefano
 *
 * <p>ce Programme prend en argument N1, M1, N2, M2, n ces valeurs sont utilisees pour construire
 * deux objets Matrix Les opérations add , substract, et Multiply sont appliquées aux deux matrices
 * et le resultat est affiche dans la console.
 *
 * <p>Pour le tester il faudrait passer 5 valeurs en argument ie : 4 5 3 4 5
 */
public class App {
  public static void main(String[] args) {
    int[] data = new int[5];
    for (int i = 0; i < 5; ++i) {
      data[i] = Integer.parseInt(args[i]);
    }
    System.out.println("The modulus is " + data[4]);
    Matrix matrix1 = new Matrix(data[0], data[1], data[4]);
    Matrix matrix2 = new Matrix(data[2], data[3], data[4]);

    System.out.println("one:" + matrix1);
    System.out.println("two:" + matrix2);
    System.out.println("one + two:" + matrix1.add(matrix2).toString());
    System.out.println("one - two:" + matrix1.substract(matrix2).toString());
    System.out.println("one x two:" + matrix1.multiply(matrix2).toString());
  }
}
