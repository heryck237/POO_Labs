package ch.heigvd.app;

import org.junit.Test;
import static org.junit.Assert.*;

/** Unit test for simple App. */
public class AppTest {
  /** Rigorous Test :-) */
  @Test
  public void shouldAnswerWithTrue() {
    assertTrue(true);
  }

  /**
   * Test pour le constructeur aleatoire Verifie que les valeurs sont strictement inferieures au
   * modulo
   */
  @Test
  public void shouldHaveValuesLessThanModulus() {
    Matrix m = new Matrix(4, 6, 5);
    for (int i = 0; i < m.getRow(); ++i) {
      for (int j = 0; j < m.getCol(); ++j) {
        assertTrue(m.getIndex(i, j) < 5);
      }
    }
  }
    /**
     * Test pour le constructeur prenant un tableau en parametre
     * Verifie que les valeurs sont strictement inferieures au
     * modulo
     */
    @Test
    public void ValuesshouldBeLessThanModulus() {
        int[][] tab = {{6,4,8},{1,2,7},{5,7,9}} ;
        int modulo = 5;

        Matrix m = new Matrix(tab,modulo);
        for (int i = 0; i < m.getRow(); ++i) {
            for (int j = 0; j < m.getCol(); ++j) {
                assertTrue(m.getIndex(i, j) < 5);
            }
        }
    }
  /**
   * Test pour l'addition de deux matrices construis deux matrices a l'aide de 2 tableaux fais leur
   * somme construis une 3 ieme matrice avec le resultat connu compare les resultats
   */
  @Test
  public void shouldAddTwoMatrix() {
    int[][] tab1 = {{1, 3, 1, 1}, {3, 2, 4, 2}, {1, 0, 1, 0}};
    int[][] tab2 = {{1, 4, 2, 3, 2}, {0, 1, 0, 4, 2}, {0, 0, 2, 0, 2}};
    Matrix matrix1 = new Matrix(tab1, 5);
    Matrix matrix2 = new Matrix(tab2, 5);

    int[][] tab3 = {{2, 2, 3, 4, 2}, {3, 3, 4, 1, 2}, {1, 0, 3, 0, 2}};
    Matrix matrix3 = new Matrix(tab3, 5);
    Matrix result = matrix1.add(matrix2);

    for (int i = 0; i < result.getRow(); ++i) {
      for (int j = 0; j < result.getCol(); ++j) {
        assertEquals(matrix3.getIndex(i, j), result.getIndex(i, j));
      }
    }
  }
  /**
   * Test pour la multiplication de deux matrices construis deux matrices a l'aide de 2 tableaux
   * fais leur produit construis une 3 ieme matrice avec le resultat connu compare les resultats
   */
  @Test
  public void shouldMultiplyTwoMatrix() {
    int[][] tab1 = {{1, 3, 1, 1}, {3, 2, 4, 2}, {1, 0, 1, 0}};
    int[][] tab2 = {{1, 4, 2, 3, 2}, {0, 1, 0, 4, 2}, {0, 0, 2, 0, 2}};
    Matrix matrix1 = new Matrix(tab1, 5);
    Matrix matrix2 = new Matrix(tab2, 5);

    int[][] tab3 = {{1, 2, 2, 3, 0}, {0, 2, 0, 3, 0}, {0, 0, 2, 0, 0}};
    Matrix matrix3 = new Matrix(tab3, 5);
    Matrix result = matrix1.multiply(matrix2);
    for (int i = 0; i < result.getRow(); ++i) {
      for (int j = 0; j < result.getCol(); ++j) {
        assertEquals(matrix3.getIndex(i, j), result.getIndex(i, j));
      }
    }
  }
  /**
   * Test pour la soustraction de deux matrices construis deux matrices a l'aide de 2 tableaux fais
   * la soustraction construis une 3 ieme matrice avec le resultat connu compare les resultats
   */
  @Test
  public void shouldSubstractTwoMatrix() {
    int[][] tab1 = {{1, 3, 1, 1}, {3, 2, 4, 2}, {1, 0, 1, 0}};
    int[][] tab2 = {{1, 4, 2, 3, 2}, {0, 1, 0, 4, 2}, {0, 0, 2, 0, 2}};
    Matrix matrix1 = new Matrix(tab1, 5);
    Matrix matrix2 = new Matrix(tab2, 5);

    int[][] tab3 = {{0, 4, 4, 3, 3}, {3, 1, 4, 3, 3}, {1, 0, 4, 0, 3}};
    Matrix matrix3 = new Matrix(tab3, 5);
    Matrix result = matrix1.substract(matrix2);
    for (int i = 0; i < result.getRow(); ++i) {
      for (int j = 0; j < result.getCol(); ++j) {
        assertEquals(matrix3.getIndex(i, j), result.getIndex(i, j));
      }
    }
  }
}
