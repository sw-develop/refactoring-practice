package me.whiteship.refactoring._23_change_reference_to_value;

import static org.junit.jupiter.api.Assertions.assertEquals;

import me.whiteship.refactoring._06_mutable_data._23_change_reference_to_value.TelephoneNumber;
import org.junit.jupiter.api.Test;

public class TelephoneNumberTest {

  @Test
  void testEquals() {
    TelephoneNumber number1 = new TelephoneNumber("123", "1234");
    TelephoneNumber number2 = new TelephoneNumber("123", "1234");
    assertEquals(number1, number2);
  }
}
