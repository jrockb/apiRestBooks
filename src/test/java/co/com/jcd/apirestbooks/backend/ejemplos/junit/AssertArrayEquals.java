package co.com.jcd.apirestbooks.backend.ejemplos.junit;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class AssertArrayEquals {
	
	@Test
	public void pruebaArregloIguales() {
		String[] arre1 = {"a", "b"};
		String[] arre2 = {"a", "b"};
		String[] arre3 = {"a", "b", "c"};
		assertArrayEquals(arre1, arre2); // comparar si dos arreglos son iguales
		//assertArrayEquals(arre1, arre3);
		//assertArrayEquals(arre2, arre3);
		
	}

}
