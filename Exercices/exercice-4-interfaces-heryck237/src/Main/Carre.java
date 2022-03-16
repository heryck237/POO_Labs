package Main;

public class Carre implements Enceinte {

  double width;

  public Carre(double width) {
    this.width = width;
  }

  @Override
  public double perimetre() {
    return 4 * width;
  }

  @Override
  public double surface() {
    return width * width;
  }

  @Override
  public String toString() {
    return "Carre{" +
            "width=" + width +
            '}';
  }
}
