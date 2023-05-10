package co.com.jcd.apirestbooks.backend.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import co.com.jcd.apirestbooks.backend.controller.CategoriaRestController;
import co.com.jcd.apirestbooks.backend.model.Categoria;
import co.com.jcd.apirestbooks.backend.response.CategoriaResponseRest;
import co.com.jcd.apirestbooks.backend.service.ICategoriaService;

public class CategoriaControllerTest {
	
	@InjectMocks
	CategoriaRestController categoriaController;
	
	@Mock
	private ICategoriaService service;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void crearTest() {
		MockHttpServletRequest request = new MockHttpServletRequest(); // para hacer mock del request
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request)); // para hacer el mock del contexto de la solicitud
		Categoria categoria = new Categoria(Long.valueOf(1), "Clasicos", "libros clasicos de literatura moderna"); // objeto mock que simula el request
		// cuando se llame al metodo service.crear con un parametro de tipo Categoria y se devuelva una respuesta 200
		when(service.crear(any(Categoria.class)))
			.thenReturn(new ResponseEntity<CategoriaResponseRest>(HttpStatus.OK));
		// llamado al metodo para prueba
		ResponseEntity<CategoriaResponseRest> respuesta = categoriaController.crear(categoria);
		// se valida si el codigo de status es OK (200)
		assertThat(respuesta.getStatusCodeValue()).isEqualTo(200);
	}
	
}
