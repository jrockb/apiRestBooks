package co.com.jcd.apirestbooks.backend.ejemplos.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {
	
	Calculadora cal;
	
	@BeforeAll // el metodo es el primero que se ejecuta y solo una vez cuando se inicia la prueba unitaria
	public static void primero() {
		System.out.println("primero");
	}
	
	@AfterAll // el metodo es el ultimo que se ejecuta y solo una vez cuando finaliza la prueba unitaria
	public static void ultimo() {
		System.out.println("ultimo");
	}
	
	@BeforeEach // el metodo se va ejecutar antes de cada metodo de prueba unitaria
	public void instanciaObjeto() { // se puede usar para abrir conexiones p.e. a bases de datos o instanciar objetos
		System.out.println("@BeforeEach");	
		cal = new Calculadora();
	}
	
	@AfterEach // el metodo se va ejecutar despues que termine cada metodo de prueba unitaria
	public void despuesTest() { // se puede usar para cerrar conexiones p.e. a bases de datos
		System.out.println("@AfterEach");
	}
	
	@Test
	@DisplayName("prueba que ocupa assertEqual") // para colcoar una descripcion de la prueba unitaria
	@Disabled("La prueba no se ejecutará") // permite deshabilitar la pruab unitaria
	void calculadoraTestAssertEqualTest() {
		System.out.println("calculadoraTestAssertEqualTest");		
		assertEquals(2, cal.sumar(1, 1));
		assertEquals(3, cal.restar(4, 1));
		assertEquals(9, cal.multiplicar(3, 3));
		assertEquals(2, cal.dividir(4, 2));
	}
	
	@Test
	void calculadoraTrueFalse() {
		System.out.println("calculadoraTrueFalse");
		assertTrue(cal.sumar(1, 1) == 2);
		assertTrue(cal.restar(4, 1) == 3);
		assertFalse(cal.multiplicar(3, 3) == 8);
		assertFalse(cal.multiplicar(4, 2) == 1);
		
	}
	
	

}
