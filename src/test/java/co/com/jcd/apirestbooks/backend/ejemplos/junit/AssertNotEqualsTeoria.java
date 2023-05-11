package co.com.jcd.apirestbooks.backend.ejemplos.junit;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class AssertNotEqualsTeoria {
	
	@Test
	void miTest() {
		assertNotEquals(2, 1); // el valor esperado debe ser diferente al valor enviado.
		// assertNotEquals(2,2); prueba fallida
	}

}
