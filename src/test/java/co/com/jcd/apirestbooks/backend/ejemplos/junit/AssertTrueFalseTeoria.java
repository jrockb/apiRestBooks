package co.com.jcd.apirestbooks.backend.ejemplos.junit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AssertTrueFalseTeoria {
	
	@Test
	public void test1() {
		assertTrue(true);
		assertFalse(false);
	}
	
	@Test
	public void Test2() {
		boolean expresion = 4 == 4;
		boolean expresion2 = 3 == 4;
		assertTrue(expresion);
		assertFalse(expresion2);
	}

}
