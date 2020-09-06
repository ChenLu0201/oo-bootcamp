package length;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LengthTest {

  @Test
  void shouldReturn1WhenCompareWithGivenTargetGreaterThanBase() {
    Length length = new Length(5);
    assertEquals(1, length.compare(new Length(6)));
  }

  @Test
  void shouldReturnMinus1WhenCompare4GivenTargetLessThanBase() {
    Length length = new Length(5);
    assertEquals(-1, length.compare(new Length(4)));
  }

  @Test
  void ShouldReturn0WhenCompareGivenTargetEqualsBase() {
    Length length = new Length(5);
    assertEquals(0, length.compare(new Length(5)));
  }

  @Test
  void shouldReturn1WhenCompareGivenTargetKmAndBaseM() {
    Length length = new Length(1, Unit.M);
    assertEquals(1, length.compare(new Length(1, Unit.KM)));
  }
}
