package co.com.jcd.apirestbooks.backend.ejemplos.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AssertEqualsTeoria {
	
	@Test
	public void miTest() {
		assertEquals(1, 1); // el valor esperado debe ser igual al valor enviado
		// assertEquals(1, 2); prueba fallida
	}

}
