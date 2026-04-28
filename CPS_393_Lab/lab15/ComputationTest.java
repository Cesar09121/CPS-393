package lab15;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ComputationTest {
	
	@Test
	void testFibonacci() {
		assertEquals(0,Computations.fibonacci(0));
	}
	
	@Test
	void testIsPrime() {
		assertTrue(Computations.isPrime(7));
	}
	
	@Test
	void testIsEven() {
		assertTrue(Computations.isEven(6));
	}
	
	@Test 
	void testIsOdd() {
		assertTrue(Computations.isOdd(7));
	}
	
	@Test
	void testToCelcius() {
		Computations.toCelsius(86);
		assertEquals(30,Computations.toCelsius(86));
	}
	
	@Test
	void testToFahrenheit() {
		Computations.toFahrenheit(0);
		assertEquals(32,Computations.toFahrenheit(0));
	}
}
