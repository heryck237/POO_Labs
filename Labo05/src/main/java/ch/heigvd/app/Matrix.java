package ch.heigvd.app;

import java.lang.Math;

/**
 * classe Matrix ayant deux attributs prives modulo et matrix, 2 constructeurs publics 1 prive et
 * implementant les methodes getCol, getRow, getIndex, matrixCompute, matrixCheck et fournissant les
 * operations add , substract, multiply
 */
public class Matrix {
  private final int modulo;
  private final int[][] matrix;

  /**
   * constructeur prive qui factorise le code lie aux deux constructeurs
   *
   * @param randomValues un booleen qui est a 1 si la construction doit se faire avec des valeurs
   *     aleatoires et a 0 si la construction se fait a l'aide d'un tableau passe en parametre
   * @param modulo le modulo de la matrice que l'on construit
   * @param tab le tableau par lequel la matrice est construite
   */
  private Matrix(boolean randomValues, int modulo, int[][] tab) {

    if (tab.length != 0 && tab[0].length != 0 && modulo != 0) {
      this.modulo = modulo;
      matrix = new int[tab.length][tab[0].length];
      if (randomValues) {
        for (int i = 0; i < tab.length; ++i) {
          for (int j = 0; j < tab[0].length; ++j) {
            matrix[i][j] = (int) (Math.random() * modulo);
          }
        }
      } else {
        for (int i = 0; i < tab.length; ++i) {
          for (int j = 0; j < tab[0].length; ++j) {
            matrix[i][j] = Math.floorMod(tab[i][j], modulo);
          }
        }
      }
    } else {
      throw new RuntimeException("wrong parameters");
    }
  }

  /**
   * constructeur initialisant le tableau avec des valeurs aleatoires
   *
   * @param row nombre de lignes du tableau de la matrix qu'on souhaite construire
   * @param col nombre de colonnes du tableau de la matrix qu'on souhaite construire
   * @param modulo valeur strictement superieure a toutes les valeurs du tableau
   */
  public Matrix(int row, int col, int modulo) {
    this(true, modulo, new int[row][col]);
  }

  /**
   * Constructeur prenant en parametre un tableau et le modulo pour construire un objet matrix
   *
   * @param tab tableau
   * @param modulo valeur strictement superieure a toutes les valeurs du tableau
   */
  public Matrix(int[][] tab, int modulo) {
    this(false, modulo, tab);
  }

  /**
   * Methode permettant de recuperer le nombre de lignes du tableau contenu dans l'objet this
   *
   * @return le nombre de lignes
   */
  public int getRow() {
    return matrix.length;
  }

  /**
   * Methode permettant de recuperer le nombre de colonnes du tableau contenu dans l'objet this
   *
   * @return le nombre de colonnes
   */
  public int getCol() {
    return matrix[0].length;
  }

  /**
   * @param i numero de la ligne
   * @param j numero de la colonne
   * @return l'index a la position [i,j]
   */
  public int getIndex(int i, int j) {
    return matrix[i][j];
  }

  /**
   * Méthode pour controller si on peut faire des operations sur les matrices
   *
   * @param m2 matrice
   * @return tableau avec le dimension égal aux max entre les deux matrices
   */
  private int[][] matrixCheck(Matrix m2) {
    if (m2 == null) {
      throw new RuntimeException("Matrix arguments don't exist");
    }
    if (modulo != m2.modulo) {
      throw new RuntimeException("Different modulos");
    }

    return new int[Math.max(matrix.length, m2.matrix.length)]
            [Math.max(this.matrix[0].length, m2.matrix[0].length)];
  }

  /**
   * Methode permettant d'effectuer une operation entre deux objets de type matrix
   *
   * @param m2 deuxieme operande
   * @param operation l'operation a effectuer
   * @return unr matrix resultat de l'operation
   */
  private Matrix matrixCompute(Matrix m2, Operation operation) {

    int[][] result = matrixCheck(m2);
    int operand1, operand2;

    for (int i = 0; i < result.length; ++i) {
      for (int j = 0; j < result[i].length; ++j) {
        operand1 = (i < matrix.length && j < matrix[0].length) ? matrix[i][j] : 0;
        operand2 = (i < m2.matrix.length && j < m2.matrix[0].length) ? m2.matrix[i][j] : 0;
        result[i][j] = Math.floorMod(operation.operation(operand1, operand2), modulo);
      }
    }
    return new Matrix(result, modulo);
  }

  /**
   * Méthode permettant l'addition de deux Objects de type Matrix
   *
   * @param m2 matrix à additionner
   * @return une nouvelle Matrix resultat de l'addition
   */
  public Matrix add(Matrix m2) {
    Addition addition = new Addition();
    return matrixCompute(m2, addition);
  }

  /**
   * Methode permettant la multiplication de deux Objects de type Matrix
   *
   * @param m2 matrix à multiplier
   * @return une nouvelle matrix resultat de la multiplication
   */
  public Matrix multiply(Matrix m2) {
    Multiplication multiplication = new Multiplication();
    return matrixCompute(m2, multiplication);
  }

  /**
   * Methode permettant la soustraction de deux Objects de type Matrix
   *
   * @param m2 matrix à soustraire
   * @return une nouvelle matrix resultat de la soustraction
   */
  public Matrix substract(Matrix m2) {
    Substraction substraction = new Substraction();
    return matrixCompute(m2, substraction);
  }

  /**
   * Redefinition de la methode toString pour afficher une matrice
   *
   * @return une string representant la matrice
   */
  @Override
  public String toString() {
    StringBuilder out = new StringBuilder();
    out.append("\n");
    for (int[] ints : matrix) {
      for (int j = 0; j < matrix[0].length; ++j) {
        out.append(ints[j]).append(" ");
      }
      out.append("\n");
    }
    return out.toString();
  }
}
