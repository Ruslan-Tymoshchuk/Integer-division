package ua.com.rtim.integerdivision;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class IntegerDivisionTest {

	private IntegerDivision integerDivision = new IntegerDivision();

	@Test
	void givenDividendAndDivisor_whenDivide_thenNewEqualObject() {
		List<DivisionStep> steps = new ArrayList<>();
		steps.add(new DivisionStep(7, 4));
		steps.add(new DivisionStep(38, 36));
		steps.add(new DivisionStep(29, 28));
		steps.add(new DivisionStep(14, 12));
		steps.add(new DivisionStep(25, 24));
		DivisionResult expected = new DivisionResult(78945, 4, 19736, 1, steps);
		assertEquals(expected, integerDivision.divide(78945, 4));
	}

	@Test
	void givenNegativeDividend_whenDivide_thenExeption() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> integerDivision.divide(-1, 1));
		assertEquals("Dividend must not be negative", exception.getMessage());
	}

	@Test
	void givenDivisorZero_whenDivide_thenExeption() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> integerDivision.divide(1, 0));
		assertEquals("Divisor must be more than 0", exception.getMessage());
	}
}
