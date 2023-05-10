package co.com.jcd.apirestbooks.backend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import co.com.jcd.apirestbooks.backend.model.Categoria;
import co.com.jcd.apirestbooks.backend.model.dao.ICategoriaDao;
import co.com.jcd.apirestbooks.backend.response.CategoriaResponseRest;

public class CategoriaServiceImplTest {
	
	@InjectMocks // inyectar los mocks sobre el objeto de tipo CategoriaServiceImpl
	CategoriaServiceImpl service;
	
	@Mock // para usar el mock de la dependencia de la clase CategoriaServiceImpl
 	ICategoriaDao categoriaDao;
	
	List<Categoria> listCategoria = new ArrayList<>();
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this); // para usar los mocks
		this.cargarCategorias();
	}
	
	@Test
	public void buscarCategoriasTest() {
		when(categoriaDao.findAll()).thenReturn(listCategoria);
		ResponseEntity<CategoriaResponseRest> response = service.buscarCategorias();
		assertEquals(3, response.getBody().getCategoriaResponse().getCategoria().size());
		verify(categoriaDao, times(1)).findAll(); // para verificar que el findAll solo se ha llamado una vez
	} 
	
	public void cargarCategorias() {		
		Categoria catUno = new Categoria();
		catUno.setId(1L);
		catUno.setNombre("misterio");
		catUno.setDescripcion("libros de misterio");
		listCategoria.add(catUno);
		Categoria catDos = new Categoria();
		catUno.setId(2L);
		catUno.setNombre("fantasia");
		catUno.setDescripcion("libros de fantasia");
		listCategoria.add(catDos);
		Categoria catTres = new Categoria();
		catUno.setId(3L);
		catUno.setNombre("novela");
		catUno.setDescripcion("novelas");
		listCategoria.add(catTres);
	}
}
