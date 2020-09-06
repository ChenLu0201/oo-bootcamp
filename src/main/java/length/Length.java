package length;

public class Length {

  private int length;
  private Unit unit;

  public Length(int length) {
    this.length = length;
    this.unit = Unit.M;
  }

  public Length(int length, Unit unit) {
    this.length = length;
    this.unit = unit;
  }

  public int getLength() {
    return length * unit.getBaseUnit();
  }

  public int compare(Length targetLength) {

    return Integer.compare(targetLength.getLength(), getLength());
  }
}
