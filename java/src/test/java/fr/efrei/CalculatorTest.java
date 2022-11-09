package fr.efrei;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CustomAuth implements Authorizer {

  @Override
  public boolean authorize() {
    // TODO Auto-generated method stub
    return true;
  }

}

public class CalculatorTest {
  @Test
  void should_throw_when_not_authorized() {
    // TODO: trigger the bug in Calculator.divide() by implementing the Authorizer interface
    Calculator calc = new Calculator(new CustomAuth());
    assertEquals(3, calc.divide(6, 2));
  }
}
