package length;

public enum Unit {
  KM(1000 * 1000),
  M(1000),
  MM(1);

  private int size;

  Unit(int size) {
    this.size = size;
  }

  public int getBaseUnit() {
    return size;
  }
}
