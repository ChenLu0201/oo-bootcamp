package length;

public class Rectangle implements CaculateAreaAble {

  int width;
  int length;

  @Override
  public int getArea() {
    return width * length;
  }
}
